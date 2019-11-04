package com.michael.pay.service;

import com.michael.pay.entity.Money;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MoneyTradeMapper {

    @Select("SELECT username,userNo,money FROM account WHERE username=#{username} AND userNo=#{userNo}")
    List<Money> findMoneyListAND(@Param("username")String username, @Param("userNo")String userNo);
    @Select("SELECT money FROM account WHERE username=#{userAny} OR userNo=#{userAny}")

    List<BigDecimal> findMoneyListOr(@Param("userAny")String userAny);
    @Select("SELECT money FROM account  WHERE username=#{username} AND userNo=#{userNo}")

     List<BigDecimal> findMoneAND(@Param("username")String username, @Param("userNo")String userNo);
    @Select("SELECT username,userNo,money FROM account WHERE username=#{userAny} OR userNo=#{userAny}")
    Money findMoneyOr(@Param("userAny")String userAny);
    /**
     * Remittance
     */
    @Update("update account set money = money - #{money} where username = #{outer} and userNo = #{outerNo}")
    void out(@Param("money")BigDecimal money,@Param("outer")String outer, @Param("outerNo")String outerNo);
    /**
     * Receivables
     */
    @Update("update account set money = money + #{money} where username = #{inner} and userNo = #{interNo} ")
    void in( @Param("money")BigDecimal money,@Param("inner")String inner, @Param("interNo")String interNo);

    /**
     *
     * Check the balance
     */
    @Select("SELECT username,userNo,money FROM account")
    List<Money> MoneyList();


}
