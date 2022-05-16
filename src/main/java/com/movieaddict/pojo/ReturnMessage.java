package com.movieaddict.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * #Author :Sino
 * #Date   :2022/5/15 12:21
 * #Describe: a wrapper class
 */
public class ReturnMessage {
    /**
     * success: 200,
     * fail: 400
     */
    private Integer status;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public static ReturnMessage success() {
        ReturnMessage message = new ReturnMessage();
        message.setStatus(200);
        message.setMessage("处理成功...");
        return message;
    }

    public static ReturnMessage fail() {
        ReturnMessage message = new ReturnMessage();
        message.setStatus(400);
        message.setMessage("处理失败...");
        return message;
    }

    public ReturnMessage add(String k, Object v) {
        this.getData().put(k, v);
        return this;
    }

    @Override
    public String toString() {
        return "ReturnMessage{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public ReturnMessage() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
