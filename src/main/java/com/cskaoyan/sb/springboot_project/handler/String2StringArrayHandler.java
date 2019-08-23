package com.cskaoyan.sb.springboot_project.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 查询order_goods的list时需要将specification字符串转换为String[]的形式
 */
@MappedTypes(String[].class)
public class String2StringArrayHandler implements TypeHandler<String[]> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : strings) {
            stringBuffer.append(string).append(",");
        }
        String substring = null;
        if(stringBuffer.length() > 0) {
            substring = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
        }
        preparedStatement.setString(i, substring);
    }

    @Override
    public String[] getResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return transString2StringArray(string);
    }

    @Override
    public String[] getResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return transString2StringArray(string);
    }

    @Override
    public String[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return transString2StringArray(string);
    }

    private String[] transString2StringArray(String string) {
        String str = string;
        if("".equals(str) || str == null) {
            return new String[]{""};
        }
        if(str.charAt(0) == '[') {
            str = str.substring(1);
        }
        if(str.charAt(str.length() - 1) == ']') {
            str = str.substring(0, str.length() - 1);
        }
        str = str.replace("\"", "");
        str = str.replace(" ", "");
        String[] stringArray = str.split(",");
        return stringArray;
    }
}
