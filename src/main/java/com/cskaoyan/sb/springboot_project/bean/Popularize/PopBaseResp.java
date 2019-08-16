package com.cskaoyan.sb.springboot_project.bean.Popularize;

public class PopBaseResp<T> {

    private T Data;
    private String errmsg;
    private String errno;

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

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }
}
