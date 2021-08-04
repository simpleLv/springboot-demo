package com.lfs.util;


/**
 * 返回数据状态
 * @author SimpleLv
 * 2020.8.28
 */
public enum ResultCode implements ReturnInfo{


    SUCCESS(200,1, "操作成功"),
    FAIL(500, 0,"操作失败"),
    UNAUTHORIZED(401, -1,"没有权限");


    private long code;
    private int status;
    private String message;


     ResultCode(long code, int status,String message) {
        this.code = code;
        this.status=status;
        this.message = message;


    }

    public int getStatus() {
        return status;
    }



    public long getCode() {
        return code;
    }



    public String getMessage() {
        return message;
    }




}
