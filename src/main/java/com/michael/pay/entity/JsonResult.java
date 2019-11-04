package com.michael.pay.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


@ApiModel(value="transfer model",description="transfer model")
public class JsonResult  {
    @ApiModelProperty(name = "outer",value = "jack or rose",required = true,example = "jack")
    private String outer;
    @ApiModelProperty(name = "inner",value = "jack or rose ",required = true,example = "rose")
    private String inner;
    @ApiModelProperty(name = "money",value = "1000",required = true,example = "1000")
    private BigDecimal trademoney;
    @ApiModelProperty(hidden = true)
    private String status ;
    @ApiModelProperty(hidden = true)
    private Object result ;

    private int code;   //return code

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Object getResult() {
        return result;
    }
    public void setResult(Object result) {
        this.result = result;
    }

    public String getOuter() {
        return outer;
    }

    public String getInner() {
        return inner;
    }

    public void setInner(String inner) {
        this.inner = inner;
    }

    public void setOuter(String outer) {
        this.outer = outer;
    }

    public BigDecimal getTrademoney() {


        return trademoney;
    }

    public void setTrademoney(BigDecimal trademoney) {

        this.trademoney = trademoney;
    }

}
