package com.michael.pay.service.impl;

import com.michael.pay.service.AccountService;
import com.michael.pay.service.MoneyTradeMapper;
import com.michael.pay.service.TradeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class TradeServiceImpl implements TradeService {

//    @Resource
////    private AccountService accountService ;

    @Resource
    private MoneyTradeMapper moneyTradeMapper;
//    @Resource
//    private TransactionTemplate transactionTemplate ;

//    @Override
//    public void trade1(String outer, String inner, BigDecimal money) {
//        accountService.out(outer, money);
//        // 抛出异常
//        //int i = 1/0;
//        accountService.in(inner, money);
//    }
//
//    @Override
//    public void trade2(String outer, String inner, BigDecimal money) {
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            public void doInTransactionWithoutResult(TransactionStatus arg0) {
//                accountService.out(outer, money);
//                // 抛出异常
//                //int i = 1/0;
//                accountService.in(inner, money);
//            }
//        });
//    }
    @Transactional(value="transactionManager",propagation= Propagation.REQUIRED)
    @Override
    public void tradeMoney(BigDecimal money,String outer, String outerNo,String inner,String innerNo) {
        moneyTradeMapper.out(money,outer, outerNo);
        //Power failure test
        int i = 1/0;
        moneyTradeMapper.in( money,inner,innerNo);
    }
}
