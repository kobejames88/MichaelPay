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
/*
* MichaelOu
* */

@RestController
@Validated
public class TradeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeController.class);
    @Autowired
    TradeService tradeService;
    @Autowired
    private MoneyTradeMapper moneyTradeMapper;

    /**
     * Check the balance
     */
    @ApiOperation(value = "Query transfer balance", notes = "Check the balance")
    @RequestMapping(value = "/queryMoney", method = RequestMethod.POST)

    public JsonResultCom queryMoney(@RequestParam(value = "userName") @Pattern(regexp = "^[\\u4e00-\\u9fa5a-zA-Z]+$", message = "Account must be in English or Chinese") String userName, @RequestParam(value = "userNo") @Pattern(regexp = "^\\d{6}$", message = "User number must be 6 digits") String userNo) {
        JsonResultCom result = new JsonResultCom();//Format return data
        Map<String, Object> data = new HashMap<>();
//        try {
            List<Money> userList = moneyTradeMapper.findMoneyListAND(userName, userNo);

            if (userList.size() == 0) {
                data.put("status", 403);
                //data.put("result","No match user");
                result.setMsg("No match user");

            }
            if (userList.size() > 0) {
                for (Money mon : userList) {
                    result.setMoney(mon.getMoney());
                }
                result.setCode(200);
                result.setMsg("SUCCESS");
                result.setData(data);
                result.setUserName(userName);
                result.setUserNo(userNo);
            }
            result.setData(data);
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
        return result;
    }


    /**
     * Amount transfer
     * /**
     *
     * @param
     * @return
     */
    @ApiOperation(value = "Transaction tradeMoney and validation ", notes = "Transaction tradeMoney and validation")
    @RequestMapping(value = "/tradeMoney", method = RequestMethod.POST)
    @ResponseBody
    public JsonResultFormat transMoney(@RequestParam(value = "outer") @Pattern(regexp = "^[\\u4e00-\\u9fa5a-zA-Z]+$", message = "Transfer account must be in English letters or Chinese characters") String outer, @RequestParam(value = "outerNo") @Pattern(regexp = "^\\d{6}$", message = "Transfer account number must be 6 digits") String outerNo, @RequestParam(value = "inner") @Pattern(regexp = "^[\\u4e00-\\u9fa5a-zA-Z]+$", message = "Collection account is in English or Chinese") String inner, @RequestParam(value = "innerNo") @Pattern(regexp = "^\\d{6}$", message = "Transfer account number must be 6 digits") String innerNo, @RequestParam(value = "money") @Pattern(regexp = "^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$", message = "The entered amount rule is illegal. The amount must be an integer greater than zero or two decimal places greater than zero") String strMoney) {
        JsonResultFormat resultFormat = new JsonResultFormat();
        BigDecimal money = new BigDecimal(strMoney);

        Map<String, Object> data = new HashMap<>();

        Map<String, Object> obj = new HashMap<>();

        List<BigDecimal> outerName = moneyTradeMapper.findMoneAND(outer, outerNo);//select the outer money
        List<BigDecimal> innerName = moneyTradeMapper.findMoneAND(inner, innerNo);//select the inner money
//        try {
            resultFormat.setInner(inner);
            resultFormat.setOuter(outer);
            resultFormat.setInnerno(innerNo);
            resultFormat.setOuterno(outerNo);
            resultFormat.setTrademoney(money);

            if (outerName.size() == 0) {
                resultFormat.setCode(402);
                resultFormat.setMsg("Transaction failed, please confirm the transfer information is correct before submitting");
                resultFormat.setData(data);

            }
            if (outerName.size() > 0) {
                for (BigDecimal out : outerName) {
                    resultFormat.setData(obj);
                    int compare = out.compareTo(money);//Comparison between the transfer amount and the amount of the transferor
                    if (compare >= 0 && out.signum() >= 0) {
                        tradeService.tradeMoney(money, outer, outerNo, inner, innerNo);
                        List<BigDecimal> outName = moneyTradeMapper.findMoneAND(outer, outerNo);//outer amount after transfer
                        List<BigDecimal> inName = moneyTradeMapper.findMoneAND(inner, innerNo);//inner amount after transfer
                        resultFormat.setCode(200);
                        resultFormat.setMsg("Transfer succeeded!");
                        for (BigDecimal outMoney : outName) {
                            obj.put(outer, outMoney);
                            obj.put("outMoney", outMoney);
                        }
                        for (BigDecimal inMoney : inName) {
                            obj.put(inner, inMoney);
                            obj.put("inMoney", inMoney);
                        }
                        resultFormat.setData(obj);
                    } else {
                        resultFormat.setCode(403);
                        resultFormat.setMsg("Your account balance is insufficient!");
                        resultFormat.setData(data);
                    }
                }
            }
            if (innerName.size() == 0) {
                resultFormat.setCode(402);
                resultFormat.setMsg("Transaction failed, please confirm that the collection information is correct before submitting!");
                resultFormat.setData(data);
            }
            if (outerName.size() == 0 && innerName.size() == 0) {
                resultFormat.setCode(402);
                resultFormat.setMsg("Transaction failed, the information matching between both parties is invalid, please confirm and submit again!");
                resultFormat.setData(data);
            }

            if(outerNo.equals(innerNo)&&outerName.equals(innerName)){
                resultFormat.setCode(402);
                resultFormat.setMsg("Transaction failed, Duplicate userNo and userName!");
                resultFormat.setData(data);
            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return resultFormat;

    }
}