### Project introduction
***
````
Use restapi format

{
  "code": 200,
  "msg": "SUCCESS",
  "data": {},
  "userName": "jack",
  "userNo": "300123",
  "money": 14095.8
}

Spring boot is the implementation of the service layer,

Mybatis is the data interaction layer,

Maven is built as a project,

Lombok is injected as a pojog construction parameter,

Fastjson is the format returned by JSON,

Swagger2 is the test case of the interface,

Hibernate validator is used as the validation of the incoming parameter.

### Technology selection
````
***
````
Springboot+mybatis+maven+lombok+fastjson+swagger2+hibernate-validator
````

#Project framework
```
MichaelPay
├── config 
├── controller 
├── entity
├── interceptor 
├── service 
```

#How to Use 
***
git clone https://github.com/kobejames88/MichaelPay.git

import project from idea ,if your idea don't have the lombok plugin the project maybe error.
The soluation is setting-->plugins-->lombok check it out wheather the lombok install or not.

Then you can start the project with idea.Run the url 
"http://localhost:8080/swagger-ui.html#!" in the google browser

There are two RestApi is the Swagger.

The first is Check the banlence in real time.


The Second is tranfer the money with validation.





# MichaelPay
