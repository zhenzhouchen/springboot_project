package com.cskaoyan.sb.springboot_project.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * —— int数组 -> String 转换器 ——
 *  1、输入：int -> String
 *  2、输出：String -> int
 */
@MappedTypes(int[].class)
public class IntArray2StringHandler implements TypeHandler<int[]> {
    /**
     *  —— 输入映射 ——
     *  将 int 数组转换成 String
     *  直接用 ObjectMapper 即可
     *  将 int write 成 String，然后传入相应的参数
     *
     *
     */
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, int[] ints, JdbcType jdbcType) throws SQLException {
        ObjectMapper objectMapper = new ObjectMapper();
        String transfered = null;
        try {
            transfered = objectMapper.writeValueAsString(ints);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        preparedStatement.setString(i,transfered);
    }


    /**
     * —— 输出映射 ——
     * 1、String 转换成 int[]
     * 2、根据列名获取内容
     * 3、使用 ObjectMapper 转换成 nt[]
     */
    @Override
    public int[] getResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return String2int(string);
    }

    @Override
    public int[] getResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return String2int(string);
    }

    @Override
    public int[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return String2int(string);
    }

    private int[] String2int(String s){
        ObjectMapper objectMapper = new ObjectMapper();
        int[] ints = new int[0];
        try {
            ints = objectMapper.readValue(s, int[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ints;
    }

}
