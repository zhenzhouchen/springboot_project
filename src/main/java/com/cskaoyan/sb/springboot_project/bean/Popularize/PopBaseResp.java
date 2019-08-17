package com.cskaoyan.sb.springboot_project.bean.Popularize;

import java.util.List;

public class PopBaseResp<T> {

    private T Data;
    private String errmsg;
    private int errno;

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }
}
