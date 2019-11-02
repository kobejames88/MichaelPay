package com.michael.pay.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class CheckParamUtil {

    public static boolean checkUserName(String username){
        String userNameReg="^[A-Za-z]+$";
        Pattern pattern = Pattern.compile(userNameReg, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static boolean checkMoney(String money){
        String moneyReg="^((((?!0)\\d+)|(0{1}))(.\\d{1,2})?)$";
        Pattern pattern = Pattern.compile(moneyReg);
        Matcher matcher = pattern.matcher(money);
        return  matcher.matches();
    }
}
