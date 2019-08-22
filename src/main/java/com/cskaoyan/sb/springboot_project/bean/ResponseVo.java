package com.cskaoyan.sb.springboot_project.bean;


public class ResponseVo<T> {
    private T data;

    private String errmsg;

    private int errno;

    public ResponseVo() {
    }

    public ResponseVo(String errmsg, int errno) {
        this.errmsg = errmsg;
        this.errno = errno;
    }

    public ResponseVo(T data, String errmsg, int errno) {
        this.data = data;
        this.errmsg = errmsg;
        this.errno = errno;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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
