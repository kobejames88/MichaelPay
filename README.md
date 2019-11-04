# Project introduction

Use restapi format
````
{
  "code": 200,
  "msg": "SUCCESS",
  "data": {},
  "userName": "jack",
  "userNo": "300123",
  "money": 14095.8
}
````
Spring boot is the implementation of the service layer,

Mybatis is the data interaction layer,

Maven is built as a project,

Lombok is injected as a pojog construction parameter,

Fastjson is the format returned by JSON,

Swagger2 is the test case of the interface,

Hibernate validator and ExceptionInterceptor is used as the validation of the incoming parameter

With the ExceptionInterceptor the try catch method don't need anymore.

### Technology selection
###
````
Springboot+mybatis+maven+lombok+fastjson+swagger2+hibernate-validator
````

Project framework

```
MichaelPay
├── config 
├── controller 
├── entity
├── interceptor 
├── service 
```

How to Use 

***
git clone https://github.com/kobejames88/MichaelPay.git

import project from idea ,if your idea don't have the lombok plugin the project maybe error.
The soluation is setting-->plugins-->lombok check it out wheather the lombok install or not.

Then you can start the project with idea.Run the url 
"http://localhost:8080/swagger-ui.html#!" in the google browser

There are two RestApi is the Swagger.

The first is Check the banlence in real time.

You must type the param userName and userNo follow below: 

example:

``````````
username:jack

userNo：300123

``````````
Type the param into swagger follow below：

``````
{
  "userName": "{jack,sun,marin,mary，levis，bean,kris,anderson,michael,jack,张三,李四}",
  "userNo": "{300123,300124,300125,300126,300127,300128,300129,300130,300131,300132,600123,600124}"
}
``````
if you type the right param the feedback json is :

````
{
  "code": 200,
  "msg": "SUCCESS",
  "data": {},
  "userName": "jack",
  "userNo": "300123",
  "money": 14095.8
}
````

if you type the wrong param the feelback json is :
````
{
  "code": 0,
  "msg": "No match user",
  "data": {
    "status": 403
  },
  "userName": null,
  "userNo": null,
  "money": null
}
````

I also use the Hibernate validator and ExceptionInterceptor to validated the param
if you type the param illegal, 
```
userName："#!@#!2",
userNo:""1232131",
```

the json feekback is:
```
{"code":1,"
data":{},
"msg":"queryMoney.userNo: User number must be 6 digits,
 queryMoney.userName: Account must be in English or Chinese"
}
```

The Second is tranfer the money with Transaction validation.

Type the param into swagger follow below：
```
{
  "inner": "{jack,sun,marin,mary，levis，bean,kris,anderson,michael,jack,张三,李四}",
  "innerno": "{300123,300124,300125,300126,300127,300128,300129,300130,300131,300132,600123,600124}",
  "outer": "{jack,sun,marin,mary，levis，bean,kris,anderson,michael,jack,张三,李四}",
  "outerno": "{300123,300124,300125,300126,300127,300128,300129,300130,300131,300132,600123,600124}",
  "trademoney": 1000...
}

```

if you type the right param the feedback json is :

````````
{
  "code": 200,
  "msg": "Transfer succeeded!",
  "data": {
    "outMoney": 14065.8,
    "sun": 13923.09,
    "jack": 14065.8,
    "inMoney": 13923.09
  },
  "outer": "jack",
  "outerno": "300123",
  "inner": "sun",
  "innerno": "300124",
  "trademoney": 10
}
````````
if you type the wrong param the json feedback below:
```
{
  "code": 402,
  "msg": "Transaction failed, please confirm the transfer information is correct before submitting",
  "data": {},
  "outer": "jacks",
  "outerno": "300123",
  "inner": "sun",
  "innerno": "300124",
  "trademoney": 10
}
```
`````
{
       "code": 402,
       "msg": "Transaction failed, please confirm that the collection information is correct before submitting!",
       "data": {},
       "outer": "jack",
       "outerno": "300123",
       "inner": "suns",
       "innerno": "300124",
       "trademoney": 10
     }
`````

``````
{
  "code": 402,
  "msg": "Transaction failed, the information matching between both parties is invalid, please confirm and submit again!",
  "data": {},
  "outer": "jacks",
  "outerno": "300123",
  "inner": "suns",
  "innerno": "300124",
  "trademoney": 10
}
``````

if  you type the param illegal,the json feedback below:

````
{
  "inner": "#!@#!@",
  "innerno": "1&^*%",
  "outer": "12@#$@",
  "outerno": "213123",
  "trademoney": !#!@#!
}
````

````
{"code":1,"
data":{},
"msg":"transMoney.innerNo: Transfer account number must be 6 digits,
 transMoney.strMoney: The entered amount rule is illegal. The amount must be an integer greater than zero or two decimal places greater than zero, 
 transMoney.outer: Transfer account must be in English letters or Chinese characters,
  transMoney.outerNo: Transfer account number must be 6 digits, 
  transMoney.inner: Collection account is in English or Chinese"}
````
if I simulate the transfer exception,the ExceptionHandler can catch the exception from the backend to the frontend,
and the data will not be change.
`````````
{"code":13,
"data":{},
"msg":"/ by zero"}
`````````
 