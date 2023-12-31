# Client Info REST service
### *(Spring Boot + Data JPA + PostgreSQL + OpenApi)*

<br/>
Программа представляет собой серверную часть приложения (без UI части) по работе с клиентами и их контактами(email, номер телефона).
API обеспечивает следующие функции:

  * Добавление нового клиента
 * Добавление нового контакта клиента (телефон или email)
 * Получение списка клиентов
 * Получение информации по заданному клиенту (по id)
 * Получение списка контактов заданного клиента
 * Получение списка контактов заданного типа заданного клиента


Документация к работе сервиса оформлена с помощью OpenApi(Swagger) и доступна во время работы программы по адресу 
[swagger-ui.html](http://localhost:8080/swagger-ui.html/).
<br/>

<br/>


## Запуск приложения
1. Git [clone](https://github.com/Laboulaye/clients-info.git)
2. Создать базу данных *postgres*.
3. В файле *resources/application.properties* изменить данные *username/password* на свои.

## Работа приложения
Во время запуска приложения в базе данных создаются три связанные таблицы: "clients", "client_email", "client_phones". Также во время запуска выполняется sql-скрипт, наполняя базу данных некоторыми начальными значениями.<br/>
Функционал Rest Api описан в документации с помощью Swagger. При попытке обратиться в url-адресе к несуществующим Клиентам программа показывает соответствующее сообщение.<br/>
После завершения работы приложения таблицы удаляются из БД.

<br/>
<br/>

![image1](ClientsInfo/src/main/resources/static/7.jpg)

<br/>

![image2](ClientsInfo/src/main/resources/static/1.jpg)

<br/>

![image3](ClientsInfo/src/main/resources/static/2.jpg)
<br/>

![image4](ClientsInfo/src/main/resources/static/3.jpg)
<br/>

![image5](ClientsInfo/src/main/resources/static/4.jpg)
<br/>

![image6](ClientsInfo/src/main/resources/static/5.jpg)
<br/>

![image7](ClientsInfo/src/main/resources/static/6.jpg)
<br/>

![image8](ClientsInfo/src/main/resources/static/8.jpg)
