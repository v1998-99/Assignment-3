package com.consume;

import lombok.Data;

@Data
public class OuterStatus {
    private String status;
    private Value data;
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
    public Value getData() {
        return data;
    }
    public void setData(Value data) {
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
