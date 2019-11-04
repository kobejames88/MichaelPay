package com.michael.pay.service;




import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface AccountService {
    /**
     * Remittance
     */
    void out(String outer, String outerNo, BigDecimal money);
    /**
     * Receivables
     */
    void in(String inner, String interNo, BigDecimal money);

    /**
     * Check the balance
     */
    List<Map<String, Object>> MoneyList();


}
