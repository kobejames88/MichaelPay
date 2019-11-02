package com.michael.pay.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

//import javax.persistence.*;
//
//@Table(name = "account")
//@Entity
@Data
public class Money  {

   // private  Integer id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
    @ApiModelProperty(name = "outer",value = "{}",required = true,example = "jack")
    private String username;
    @ApiModelProperty(name = "outer",value = "{}",required = true,example = "jack")
    private String userNo;
    @ApiModelProperty(name = "outer",value = "{}",required = true,example = "jack")
    private BigDecimal money;


}
