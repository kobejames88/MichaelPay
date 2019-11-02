package com.michael.pay.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface TradeService {
//
//    /**
//     * 转账交易：没有事务管理
//     */
//    void trade1(String outer, String inner, BigDecimal money);
//    /**
//     * 转账交易：手动管理事务
//     */
//    void trade2(String outer, String inner, BigDecimal money);
    /**
     * 转账交易：注解管理事务
     */
    /**
     * 查询余额
     */
    void tradeMoney( BigDecimal money,String outer, String outerNo, String inner, String innerNo);
}
