package com.michael.pay.controller;


import com.michael.pay.entity.JsonResultCom;
import com.michael.pay.entity.JsonResultFormat;
import com.michael.pay.entity.Money;

import com.michael.pay.service.MoneyTradeMapper;
import com.michael.pay.service.TradeService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@Validated
public class TradeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeController.class);
    @Autowired
    TradeService tradeService;
    @Autowired
    private MoneyTradeMapper moneyTradeMapper;

    /**
     * 查询余额
     */
    @ApiOperation(value = "查询转账余额", notes = "查询余额")
    @RequestMapping(value = "/queryMoney", method = RequestMethod.POST)

    public JsonResultCom queryMoney(@RequestParam(value = "userName") @Pattern(regexp = "^[\\u4e00-\\u9fa5a-zA-Z]+$", message = "转账户必须为英文字母或汉字") String userName, @RequestParam(value = "userNo") @Pattern(regexp = "^\\d{6}$", message = "用户编号必须为6位纯数字") String userNo) {
        JsonResultCom result = new JsonResultCom();
        Map<String, Object> data = new HashMap<>();
//        try {
            List<Money> userList = moneyTradeMapper.findMoneyListAND(userName, userNo);
            for(Money mon:userList){
                result.setMoney(mon.getMoney());
            }
            data.put("status", "SUCCESS");
          //data.put("result", userList);
          result.setData(data);
          result.setUserName(userName);
          result.setUserNo(userNo);

//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
        return result;
    }


    /**
     * 金额转账
     * /**
     * 用于测试
     *
     * @param @RequestParam类型的参数需要在Controller上增加@Validated
     * @return
     */
    @ApiOperation(value = "Pay", notes = "Pay")
    @RequestMapping(value = "/tradeMoney", method = RequestMethod.POST)
    @ResponseBody
    public JsonResultFormat transMoney(@RequestParam(value = "outer") @Pattern(regexp = "^[\\u4e00-\\u9fa5a-zA-Z]+$", message = "转账户必须为英文字母或汉字") String outer, @RequestParam(value = "outerNo") @Pattern(regexp = "^\\d{6}$", message = "转账户编号必须为6位纯数字") String outerNo, @RequestParam(value = "inner") @Pattern(regexp = "^[\\u4e00-\\u9fa5a-zA-Z]+$", message = "收账户为英文字母或汉字") String inner, @RequestParam(value = "innerNo") @Pattern(regexp = "^\\d{6}$", message = "转账户编号必须为6位数字") String innerNo, @RequestParam(value = "money") @Pattern(regexp = "^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$", message = "输入金额规则不合法,金额必须为大于零的整数或大于零的两位小数") String strMoney) {
        JsonResultFormat resultFormat = new JsonResultFormat();
        BigDecimal money = new BigDecimal(strMoney);

        Map<String, Object> data = new HashMap<>();

        Map<String, Object> obj = new HashMap<>();

        List<BigDecimal> outerName = moneyTradeMapper.findMoneAND(outer, outerNo);
        List<BigDecimal> innerName = moneyTradeMapper.findMoneAND(inner, innerNo);

        resultFormat.setInner(inner);
        resultFormat.setOuter(outer);
        resultFormat.setInnerno(innerNo);
        resultFormat.setOuterno(outerNo);
        resultFormat.setTrademoney(money);

        if (outerName.size() == 0) {
            data.put("status", 402);
            data.put("result", "交易失败，请确认转账信息无误后再提交");
            resultFormat.setData(data);

        }
        if (outerName.size() > 0) {
            for (BigDecimal out : outerName) {
                resultFormat.setData(obj);
                int compare = out.compareTo(money);// 转账金额与转账人金额大小比较
                if (compare >= 0 && out.signum() >= 0) {
                    tradeService.tradeMoney(money, outer, outerNo, inner, innerNo);
                    List<BigDecimal> outName = moneyTradeMapper.findMoneAND(outer, outerNo);
                    List<BigDecimal> inName = moneyTradeMapper.findMoneAND(inner, innerNo);
                    obj.put("status", 200);
                    obj.put("result", "转账成功");
                    for (BigDecimal outMoney : outName) {
                        obj.put(outer, outMoney);
                        obj.put("outMoney", outMoney);
                    }
                    for (BigDecimal inMoney : inName) {
                        obj.put(inner, inMoney);
                        obj.put("inMoney", inMoney);
                    }
                    resultFormat.setData(obj);
                }
                else {
                    data.put("result", "你的账户余额不足!");
                    data.put("status", 403);
                    resultFormat.setData(data);
                }
            }
        }
        if (innerName.size() == 0) {
            data.put("status", 402);
            data.put("result", "交易失败，请确认收账信息无误后再提交!");
            resultFormat.setData(data);
        }
        if (outerName.size() == 0 && innerName.size() == 0) {
            data.put("status", 402);
            data.put("result", "交易失败，双方信息匹配无效,请确认后再提交!");
            resultFormat.setData(data);
        }

            return resultFormat;
        }
    }