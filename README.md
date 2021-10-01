# Numeral Converter

This project is a test project implements the simple web server that converts Integer to Roman number. 

Currently, it only supports Roman Numeral Converter functionality.     

Roman numerals: https://en.wikipedia.org/wiki/Roman_numerals


### `Available Scripts`

Under the project directory, there are 3 major components:

#### main/java/com.example/numeral_converter/entity/RomanNumeralConverter.java
   This file stores the major class that contains the algorithm to convert Integer number to Roman number. 
#### main/java/com.example/numeral_converter/external/RomanNumeralConverterException.java
   This file stores the exception class that will be raised 
#### main/java/com.example/numeral_converter/servlet/RomanNumeralServlet.java
   This file stores the class that define the listener endpoint configuration, it specifies the url path, define request body, response format, and the logic to handle request and how to return response.  

### `Install docker`

For installing docker on different os system, go to:
https://docs.docker.com/install/linux/docker-ce/ubuntu.

### `Build application docker image`

Runs the docker built into an image:

```
sudo docker build -t numeral_converter
```

### `Run the application container`

Run the docker image as container and expose port 8080 mapping to your localhost port.     
```
sudo docker images ls
sudo docker run -d -p 8080:8080 numeral_converter
```


### `Try out the service`

Test out the roman converter by sending request with paramter query={integer}
The range for integer input is limited to 1~3999. 

Example: 
```
curl http://localhost/romannumeral?query=99

{"output":"XCIX","input":"99"}
```

### `Test files`

Test files are under directory src/test/java/

### `Logging`

Logging of this project is using java.util.logging

### `Monitoring` 

There are a few options to enable metrics to monitor tomcat server metrics:
1.Tomcat manager
https://dzone.com/articles/a-step-by-step-guide-to-tomcat-performance-monitor

2.datadog agent
https://www.datadoghq.com/blog/analyzing-tomcat-logs-and-metrics-with-datadog/
