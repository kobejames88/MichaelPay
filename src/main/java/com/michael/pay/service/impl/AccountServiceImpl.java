package com.michael.pay.service.impl;

import com.michael.pay.service.AccountService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private JdbcTemplate jdbcTemplate ;

    public void out(String outer,String outerNo, BigDecimal money) {
        String sql = "update account set money = money - ? where username = ? and userNo = ?";
        jdbcTemplate.update(sql, money);
    }
    public void in(String inner, String innerNo,BigDecimal money) {
        String sql = "update account set money = money + ? where username = ? and userNo = ?";
        jdbcTemplate.update(sql, money);
    }
    @Override
    public List<Map<String,Object>> MoneyList() {
        String sql="select username,money,userNo from account";
        return jdbcTemplate.queryForList(sql);
    }


    }


