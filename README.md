# APILogTracker
It is a simple API Key authentication implementation using spring security.

# How to run this
1. git clone git@github.com:CodeMagik/APILogTracker.git
2. ./mvnw clean package
3. ./mvnw spring-boot:run
4. It will start running in port 8080

# How to hit the API
### MessageID and Trace-ID are optional
  ``` 
  curl -X GET -H "Message-ID:6625ef2c-2bd1-11eb-adc1-0242ac120002" -H "Trace-ID:77755632-2bd1-11eb-adc1-0242ac120002" localhost:8080/api/hello
  hello
  ```
  
