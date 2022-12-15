# Веб-служба SOAP

Проект является демонстрационным вариантом создания веб-службы SOAP при помощи
**Java 8** и фреймворка **Spring** и **Apache Maven**.

Проект использует для хранения данных базу postgres версии 12. 

Подключение бызы в качестве репозитория происходит посредством **Hibernate** и **Spring Data JPA**

```bash
# Получить файл wsdl
http://localhost:8080/ws/users.wsdl

# Use data from file
curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws

# Use inline XML data
curl <<-EOF -fsSL -H "content-type: text/xml" -d @- http://localhost:8080/ws \
  > target/response.xml && xmllint --format target/response.xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                                  xmlns:gs="http://spring.io/guides/gs-producing-web-service">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getUserRequest>
         <gs:id>1</gs:id>
      </gs:getUserRequest>
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
docker run --name soap_container -p 8080:8080 -d soap_image
```



