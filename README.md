#SPRING-BOOT SPRING-WEB APACHE-CAMEL MYBATIS

##This sample covers below frameworks/Techs:
1-Spring Boot + Spring Web<br>
2-Maven<br>
3-Apache Camel<br>
4-MyBatis<br>
5-HQSLDB + H2 console<br>

##These are the steps, this sample app follows:
1) on a web request, spring web uses producer template and calls apache-camel route.<br>
2) The camel route, starts four database calls and aggregates the Users output<br> 
3) the aggregated Users output, is then sent on HTTP Response as JSON<br>

##Follow below steps to run
1) Download/Clone the Project<br>
2) Setup project as maven project, IDE prefer STS<br>
3) Start Application<br>
4) Launch Postman, paste http://localhost:8080/user<br>
5) The JSON User Data will be displayed   <br>