package com.example.bsad.soap;

import jakarta.jws.WebService;
import org.springframework.stereotype.Service;

@Service
@WebService(endpointInterface = "com.example.bsad.soap.HelloService")
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello, " + name + " (from SOAP)";
    }
}
