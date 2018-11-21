package com.chen.pojo;

import java.util.HashMap;
import java.util.Map;

public class MSG {
    //状态码 200--成功 500--失败
    private int code;
    //提示信息
    private String msg;
    //用户需要的返回值
    private Map<String,Object> extend = new HashMap<>();

    public static MSG success(){
        MSG msg = new MSG();
        msg.setCode(200);
        msg.setMsg("处理成功！");
        return msg;
    }

    public static MSG fail(){
        MSG msg = new MSG();
        msg.setCode(500);
        msg.setMsg("处理失败");
        return msg;
    }


    public MSG add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }

    public int getCode() {
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

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
