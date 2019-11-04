package com.michael.pay.entity;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
@ApiModel(value="check account",description="check account")
public class JsonResultCom {
    @ApiModelProperty(hidden = true)
    private int code;   //return code
    @ApiModelProperty(hidden = true)
    private String msg; //Message hint
    @ApiModelProperty(hidden = true)
    private Map<String, Object> data; //Data returned
    @ApiModelProperty(name = "userName",value = "{jack,sun,marin,mary，levis，bean,kris,anderson,michael,jack,张三,李四}",required = true,example = "{jack,sun,marin,mary，levis，bean,kris,anderson,michael,jack,张三,李四}")
    private String userName;
    @ApiModelProperty(name = "userNo",value = "{300123,300124,300125,300126,300127,300128,300129,300130,300131,300132,600123,600124}",required = true,example = "{300123,300124,300125,300126,300127,300128,300129,300130,300131,300132,600123,600124}")
    private String userNo;
    @ApiModelProperty(hidden = true)
    private BigDecimal money;
    public JsonResultCom(){

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public JsonResultCom(int code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public static String success() {
        return success(new HashMap(0));
    }
    public static String success(Map<String, Object> data) {
        return JSON.toJSONString(new JsonResultFormat(0, "解析成功", data));
    }

    public static String failed() {
        return failed("解析失败");
    }
    public static String failed(String msg) {
        return failed(-1, msg);
    }

    public static String failed(int code, String msg) {
        return  JSON.toJSONString(new JsonResultFormat(code, msg, new HashMap(0)));
    }

}
