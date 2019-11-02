package com.michael.pay.service;




import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface AccountService {
    /**
     * 汇款
     */
    void out(String outer, String outerNo, BigDecimal money);
    /**
     * 收款
     */
    void in(String inner, String interNo, BigDecimal money);

    /**
     * 查询余额
     */
    List<Map<String, Object>> MoneyList();


}
