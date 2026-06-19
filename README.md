# Inventory Management System (Java + JDBC + MySQL)

A command-line Inventory Management System built using Core Java, JDBC, and MySQL.
It allows users to manage products, update stock information, and calculate inventory value directly from the terminal.

## Features

- Add a product
- View all products
- Get product by ID
- Update product quantity
- Update product price
- Delete a product
- View low-stock products
- Calculate total inventory value

## Technologies Used

- Java
- JDBC
- MySQL
- VS Code

## Project Structure

src
├── controller
│   ├── ProductController.java
│   └── Command.java
├── model
│   └── Product.java
├── service
│   └── ProductService.java
├── db
│   └── DBConnection.java
└── Main.java

## Database Schema

CREATE DATABASE inventory_db;

USE inventory_db;

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    quantity INT,
    price DOUBLE
);

## Sample Commands

ADD iPhone 5 70000
ADD Laptop 2 55000
LIST
GET 1
UPDATE_QUANTITY 1 10
UPDATE_PRICE 1 75000
DELETE 2
LOW_STOCK 5
TOTAL_VALUE
EXIT

## Learning Outcomes

- Object-Oriented Programming in Java
- JDBC Connectivity
- CRUD Operations using SQL
- PreparedStatement and ResultSet usage
- Command-line application development
- Database integration with Java
- Data filtering and aggregation queries
- Inventory management concepts

## Author

Adithya K P  
B.Tech CSE (AIML)  
Amity University Bengaluru
