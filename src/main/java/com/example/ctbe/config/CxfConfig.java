package com.example.ctbe.config;

import com.example.ctbe.soap.HelloServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {

    @Bean
    public EndpointImpl helloEndpoint(Bus bus, HelloServiceImpl impl) {
        EndpointImpl endpoint = new EndpointImpl(bus, impl);
        endpoint.publish("/hello"); // SOAP endpoint at /services/hello via CXF default path
        return endpoint;
    }
}
