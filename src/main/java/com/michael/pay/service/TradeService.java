package com.michael.pay.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface TradeService {
//
//    /**
//     * Transfer transaction: no transaction management
//     */
//    void trade1(String outer, String inner, BigDecimal money);
//    /**
//     * Transfer transaction: manual transaction management
//     */
//    void trade2(String outer, String inner, BigDecimal money);
    /**
     * Transfer transaction: notes management
     */
    void tradeMoney( BigDecimal money,String outer, String outerNo, String inner, String innerNo);
}
