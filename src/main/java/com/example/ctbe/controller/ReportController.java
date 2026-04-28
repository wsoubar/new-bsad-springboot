package com.example.ctbe.controller;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.HashMap;

@RestController
public class ReportController {

    @GetMapping("/report/hello.pdf")
    public void helloReport(HttpServletResponse response) throws Exception {
        try (InputStream is = getClass().getResourceAsStream("/reports/hello.jrxml")) {
            JasperReport jasper = JasperCompileManager.compileReport(is);
            JasperPrint print = JasperFillManager.fillReport(jasper, new HashMap<String, Object>() {{
                put("title", "Hello JasperReports on Spring Boot 3");
            }}, new JREmptyDataSource());
            response.setContentType("application/pdf");
            JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
        }
    }
}
