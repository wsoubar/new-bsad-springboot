package com.example.bsad.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(serviceName = "HelloService")
public interface HelloService {
    @WebMethod
    String hello(String name);
}
