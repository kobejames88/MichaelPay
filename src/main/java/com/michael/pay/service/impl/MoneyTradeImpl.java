//package com.michael.pay.service.impl;
//
//import com.michael.pay.entity.Money;
//import com.michael.pay.service.MoneyTradeMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@Service
//public class MoneyTradeImpl implements MoneyTradeMapper {
//
//    @Autowired
//    private MoneyTradeMapper moneyTradeMapper ;
//
//
//    @Override
//    public List<Money> findMoneyListAND(String username, String userNo) {
//        return moneyTradeMapper.findMoneyListAND(username,userNo);
//    }
//
//    @Override
//    public List<BigDecimal> findMoneyListOr(String userAny) {
//        return moneyTradeMapper.findMoneyListOr(userAny);
//    }
//
//    @Override
//    public List<BigDecimal> findMoneAND(String username, String userNo) {
//        return moneyTradeMapper. findMoneAND(username, userNo);
//    }
//
//
//    @Override
//    public Money findMoneyOr(String userAny) {
//        return moneyTradeMapper.findMoneyOr(userAny);
//    }
//
//    @Override
//    public void out(BigDecimal money, String outer, String outerNo) {
//        moneyTradeMapper.out(money,outer, outerNo);
//    }
//
//    @Override
//    public void in(BigDecimal money, String inner, String interNo) {
//        moneyTradeMapper.in(money,inner,interNo);
//    }
//
////    @Override
////    public void out(String outer, String outerNo, BigDecimal money) {
////        moneyTradeMapper.out(outer,outerNo,money);
////    }
////
////    @Override
////    public void in(String inner, String interNo, BigDecimal money) {
////        moneyTradeMapper.in(inner,interNo,money);
////    }
//
//
//    @Override
//    public List<Money> MoneyList() {
//        return moneyTradeMapper.MoneyList();
//    }
//
//}
