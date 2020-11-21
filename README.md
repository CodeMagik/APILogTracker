# APILogTracker
It is a simple API Key authentication implementation using spring security.

# How to run this
1. git clone git@github.com:CodeMagik/APILogTracker.git
2. ./mvnw clean package
3. ./mvnw spring-boot:run
4. It will start running in port 8080

# How to hit the API
  ``` 
  curl -X GET -H "Authorization: ApiKey demoApiKey" localhost:8080/api/hello 
  hello
  ```
  
