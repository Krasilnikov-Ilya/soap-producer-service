# Создание веб-службы SOAP

Проект является демонстрационным вариантом создания веб-службы SOAP при помощи
**Java 8** и фреймворка **Spring** и **Apache Maven**.

## Зависимости

| №   | Название (ссылка)                                                                                                    | Версия                                                                                                | Описание                                                                                                                                                 |
|-----|----------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1   | [Spring Boot Starter Parent](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent) | [2.6.4](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent/2.6.4) | Родительский pom, обеспечивающий управление зависимостями и плагинами для приложений, созданных с помощью Maven.                                         |
| 2   | [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)       | [2.6.4](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web/2.6.4)    | Стартер для создания веб-приложений, в том числе RESTful, с использованием Spring MVC. Использует Tomcat в качестве встроенного контейнера по умолчанию. |
| 3   | [Spring Web Services](https://mvnrepository.com/artifact/org.springframework.ws/spring-ws/)                          | [3.1.2](https://mvnrepository.com/artifact/org.springframework.ws/spring-ws/3.1.2)                    | Поддержка веб-сервисов на основе Spring                                                                                                                  |
| 4   | [Spring Boot Starter Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test/)    | [2.6.4](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test/2.6.4)   | Стартер для тестирования приложений Spring Boot с библиотеками, включая JUnit Jupiter, Hamcrest и Mockito.                                               |
| 5   | [Spring WS Core](https://mvnrepository.com/artifact/org.springframework.ws/spring-ws-core/)                          | [3.1.2](https://mvnrepository.com/artifact/org.springframework.ws/spring-ws-core/3.1.2)               | Ядро Spring WS                                                                                                                                           |
| 6   | [WSDL4J](https://mvnrepository.com/artifact/wsdl4j/wsdl4j/)                                                          | [1.6.3](https://mvnrepository.com/artifact/wsdl4j/wsdl4j/1.6.3)                                       | Генератор заглушек Java для WSDL                                                                                                                         |
| 7   | [JavaBeans(TM) Activation Framework](https://mvnrepository.com/artifact/javax.activation/activation/)                | [1.1.1](https://mvnrepository.com/artifact/javax.activation/activation/1.1.1)                         | Предоставляет API для создания и сборки сообщений SOAP.                                                                                                  |
| 8   | [JAXB API](https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api/)                                              | [2.3.1](https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api/2.3.1)                             | JAXB предоставляет две основные возможности: маршаллирование Java объектов в XML и наоборот, то есть демаршализация из XML обратно в Java объект.        |
| 9   | [JAXB Runtime](https://mvnrepository.com/artifact/org.glassfish.jaxb/jaxb-runtime/)                                  | [3.0.2](https://mvnrepository.com/artifact/org.glassfish.jaxb/jaxb-runtime/3.0.2)                     | JAXB (JSR 222) Эталонная реализация                                                                                                                      |

## Плагины

| №   | Название (ссылка)                                                                              | Версия                                                                                 | Описание                                                                                                                                                       |
|-----|------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1   | [JAXB 2 Maven Plugin](https://mvnrepository.com/artifact/org.codehaus.mojo/jaxb2-maven-plugin) | [2.5.0](https://mvnrepository.com/artifact/org.codehaus.mojo/jaxb2-maven-plugin/2.5.0) | Плагин Mojo JAXB-2 Maven используется для создания графа объектов из XSD на основе реализации JAXB 2.x и для создания XSD из аннотированных классов Java JAXB. |

## Тестирование

```bash
# Получить файл wsdl
http://localhost:8080/ws/countries.wsdl

# Use data from file
curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws

# Use inline XML data
curl <<-EOF -fsSL -H "content-type: text/xml" -d @- http://localhost:8080/ws \
  > target/response.xml && xmllint --format target/response.xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                                  xmlns:gs="http://spring.io/guides/gs-producing-web-service">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getCountryRequest>
         <gs:name>Spain</gs:name>
      </gs:getCountryRequest>
   </soapenv:Body>
</soapenv:Envelope>

EOF
```

## Инструкция по развертыванию (Деплой)

```bash
# Сохранить образ в Linux архив
docker save soap_image -o soap_image.tar

# Загрузить образ в Docker
docker load -i soap_image.tar

# Запустить контейнер на основе докер образа
docker run --name soap_container -p 80:8080 -d soap_image
```



