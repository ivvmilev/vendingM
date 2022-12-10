**Vending machine application**

Requirements
For building and running the application you need:

JDK 1.8
Maven 3
Running the application locally
There are several ways to run a Spring Boot application on your local machine.
One way is to execute the main method in src/main/java/com/example/vendingm/VendingMApplication.java class from your
IDE.

Alternatively you can use the Spring Boot Maven plugin like so:
mvn spring-boot:run

**Create example products**
POST /examples

**Get products**
GET /product

**Create a product resource**
PUT /product
Accept: application/json
Content-Type: application/json

{
"name": "Mars",
"price": 150,
"quantity": 5
}

**Update a product resource**
POST /product/1
Accept: application/json
Content-Type: application/json

{
"name": "Mars",
"price": 120,
"quantity": 1
}

**Delete product**
DELETE /product/1

**Buy a product**
POST /vending/buy/1

**Reset coins**
DELETE /vending/reset

**Insert coins to buy a product**
POST /vending/insertCoin
