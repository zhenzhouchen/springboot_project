package com.cskaoyan.sb.springboot_project.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Boolean.class)
public class Int2Boolean implements TypeHandler<Boolean> {


    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {
        Boolean b = aBoolean;
        int value =  b == true ? 1 : 0;
        preparedStatement.setInt(i,value);
    }

    @Override
    public Boolean getResult(ResultSet resultSet, String s) throws SQLException {
        String str = resultSet.getString(s);
        Boolean rt = Boolean.FALSE;
        if (str.equalsIgnoreCase("1")){
            rt = Boolean.TRUE;
        }
        return rt;
    }

    @Override
    public Boolean getResult(ResultSet resultSet, int i) throws SQLException {
        int str = resultSet.getInt(i);
        Boolean rt = Boolean.FALSE;
        if (str==1){
            rt = Boolean.TRUE;
        }
        return rt;
    }

    @Override
    public Boolean getResult(CallableStatement callableStatement, int i) throws SQLException {
        String str = callableStatement.getString(i);
        Boolean rt = Boolean.FALSE;
        if(str=="1"){
            rt = Boolean.TRUE;
        }
        return rt;

    }
}