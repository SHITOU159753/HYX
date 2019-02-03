package com.chen.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 *通用返回类
 */
public class MSG {
    //状态码 200--成功 500--失败
    private Integer code;
    //提示信息
    private String msg;
    //用户需要的返回值
    private Object data;

    public MSG(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public MSG( Object data) {
        this.code = 200;
        this.msg = "OK";
        this.data = data;
    }
    public MSG(Throwable e){
        this.setCode(500);
        this.msg = "OK";
        this.data = e.getMessage();
    }
    public MSG() {
    }

    public static MSG success(){
        return new MSG();
    }
    public static MSG success(Object data){
        return new MSG(data);
    }
    public static MSG success(Integer code, String msg, Object data ){
        return new MSG();
    }


    public static MSG fail(String msg){
        MSG mSG = new MSG();
        mSG.setCode(500);
        mSG.setMsg(msg);
        return mSG;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
