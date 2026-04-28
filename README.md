
# CTBE Open Framework 2.0 (Spring Boot 3.5.6, Java 21)

Projeto base modernizado para substituir Struts2 + JSP por Spring MVC + Thymeleaf
e consolidar CXF (SOAP), JasperReports, Ehcache 3 e JPA com MySQL.

## Como executar
1. Configure o banco (ou use H2 mudando as deps):
   - Ajuste `spring.datasource.*` no `application.yml`.
2. Compile e rode:
   ```bash
   mvn clean package
   java -jar target/ctbe-open-framework-2.0.0.jar
   ```
   Ou durante o dev:
   ```bash
   mvn spring-boot:run
   ```
3. Endpoints principais:
   - Web MVC: http://localhost:8080/
   - REST:    GET http://localhost:8080/api/products
   - SOAP:    WSDL em http://localhost:8080/services/hello?wsdl
   - Report:  http://localhost:8080/report/hello.pdf

## Notas
- Segurança está liberada para endpoints básicos no `SecurityConfig` (ajuste para produção).
- Cache configurado via Ehcache 3 (JSR-107) em `ehcache.xml`.
- Para trocar MySQL por H2, remova o connector e adicione `com.h2database:h2` (scope runtime)
  e `spring.datasource.url=jdbc:h2:mem:testdb` no `application.yml`.
