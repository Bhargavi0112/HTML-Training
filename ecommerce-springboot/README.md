# Spring Boot E-Commerce Application

Full-stack e-commerce app built with Spring Boot, Spring Data JPA, H2 database and a simple HTML/JS frontend.

## Features
- Product listing, add, update, delete (REST API)
- Shopping cart (add / remove items)
- Checkout and order creation with stock update

## Run
```
mvn spring-boot:run
```
Open http://localhost:8080  |  H2 console: http://localhost:8080/h2-console (jdbc:h2:mem:shopdb)

## API
| Method | URL | Description |
|---|---|---|
| GET | /api/products | List products |
| POST | /api/products | Add product |
| PUT | /api/products/{id} | Update product |
| DELETE | /api/products/{id} | Delete product |
| GET | /api/cart | View cart |
| POST | /api/cart/add/{productId}?qty=1 | Add to cart |
| DELETE | /api/cart/{itemId} | Remove from cart |
| POST | /api/orders/checkout | Place order |
| GET | /api/orders | List orders |
