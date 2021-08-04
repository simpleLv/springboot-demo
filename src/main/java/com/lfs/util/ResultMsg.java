package com.lfs.util;

import javax.servlet.Servlet;

/**
 * 返回数据信息
 * @author SimpleLv
 */
public class ResultMsg<T> {

    int status;
    String errorCode;
    String message;
    T data;


    public ResultMsg(int status, String errorCode, String message, T data) {

        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public ResultMsg() {

        super();
    }
    /**
     * 成功返回结果 附带数据
     *
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultMsg<T> success(String message, T data) {
        Servlet
        return new ResultMsg(ResultCode.SUCCESS.getStatus(), "", message, data);
    }

    /**
     * 成功返回结果 不带数据
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResultMsg<T> success(String message) {

        return success(message,null);
    }

    /**
     * 失败返回结果
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResultMsg<T> failed(String message) {

        return new ResultMsg(ResultCode.FAIL.getStatus(), ResultCode.FAIL.getCode() + "", message, null);
    }

    /**
     * 没有权限返回结果
     *
     * @param <T>
     * @return
     */
    public static <T> ResultMsg<T> unauthorized() {

        return new ResultMsg(ResultCode.UNAUTHORIZED.getStatus(), ResultCode.FAIL.getCode() + "", ResultCode.UNAUTHORIZED.getMessage(), null);
    }







    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
