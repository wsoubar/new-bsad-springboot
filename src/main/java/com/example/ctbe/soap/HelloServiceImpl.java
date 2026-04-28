package com.example.ctbe.soap;

import jakarta.jws.WebService;
import org.springframework.stereotype.Service;

@Service
@WebService(
        serviceName = "HelloService",
        portName = "HelloPort",
        endpointInterface = "com.example.ctbe.soap.HelloService"
)
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}