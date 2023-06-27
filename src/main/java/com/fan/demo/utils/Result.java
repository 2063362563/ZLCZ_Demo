package com.fan.demo.utils;

import lombok.Data;

@Data
public class Result {

    private Object data;

    private Integer code;

    private String message;

    public Result (){}

    public Result(Object data, Integer code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public static Result success (Object data){
        return new Result(data,200,"成功");
    }

    public static Result success (Object data,String message){
        return new Result(data,200,message);
    }


    public static Result error (Integer code,String message){
        return new Result(null,code,message);
    }

    public static Result error (String message){
        return new Result(null,-1,message);
    }
}
