# Phone Shop API

1. [About](#about)
2. [Prerequisites](#prerequisites)
3. [Install Dependencies](#dependencies)
4. [API Documentation](#documentation)
5. [Tech Stack](#techstack)

## About<a name="about"></a>

RESTful API that enables a mobile phone e-shop to upload products to their warehouse.

This project was built as a part of [Cleevio](https://www.cleevio.com/)'s backend Java developer interview process. 

## Prerequisites<a name="prerequisites"></a>
* Java 17
* MySQL

## Install Dependencies<a name="dependencies"></a>
```shell
mvn install
```

### Run and Test the Application
As MySQL is not Dockerized yet, change credentials in the **application.properties** file to your username and password so that you can connect to the MySQL server. Then run the application with the following command:

```shell
mvn spring-boot:run
```

To test the application, open the Postman app on your machine, paste the JSON sample data below to the request body and send POST request to **localhost:8080/phones**
```json
{
  "brand": "Samsung",
  "operating_system": "Android",
  "model": "Galaxy S23 Ultra",
  "price": "30000",
  "image": "R0lGODlhAQABAIAAAAUEBA"
}
```

## Documentation<a name="documentation"></a>
To view API documentation, run the app locally and navigate to **http://localhost:8080/swagger-ui/index.html#/**


## Tech Stack and Tools Used<a name="techstack"></a>
### Tech Stack
* Java 17
* Spring Boot 3
* Maven
* Spring Data JPA
* Hibernate
* Jakarta Bean Validation API
* MySQL
* Swagger

### Tools
* MySQLWorkbench
* Postman
* Git
* GitHub
