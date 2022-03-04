package com.secondconsuming;


import lombok.Data;

import java.util.List;

@Data
public class OuterStatus {
    private String status;
    private List<Value> data;
    private String message;

    public OuterStatus() {
        super();
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public List<Value> getData() {
        return data;
    }
    public void setData(List<Value> data) {
        this.data = data;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "OuterStatus {status=" + status + ", data=" + data + ", message=" + message + "}";
    }
}
