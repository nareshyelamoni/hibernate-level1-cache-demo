# Hibernate Level 1 Cache Demo

A Java Hibernate project demonstrating core Hibernate concepts including entity mapping, CRUD basics, proxy objects, and Level 1 Cache behavior using MySQL.

## 🚀 Features

* Hibernate Configuration using Annotations
* Entity Mapping with `@Entity`
* Primary Key Mapping with `@Id`
* Non-persistent Fields using `@Transient`
* Insert Operation using `persist()`
* Select Operation using `get()`
* Session Management
* Transaction Management
* Proxy Object Concepts
* Hibernate Level 1 Cache Demonstration
* MySQL Database Integration
* Maven Build Management

## 🛠 Technologies Used

* Java
* Hibernate ORM
* MySQL
* Maven
* Eclipse IDE

## 📂 Project Structure

```text
src/main/java
│
├── com.nareshTechs.model
│   └── Employee.java
│
└── com.nareshTechs.app
    ├── SelectOperation.java
    ├── SelectOperation2.java
    └── Level1Caching.java
```

## 📌 Concepts Demonstrated

### Insert Operation

Stores Employee records into the database using Hibernate Session and Transaction.

### Select Operation

Retrieves Employee records using Hibernate Session API.

### Proxy Objects

Understanding lazy loading behavior through Hibernate proxy objects.

### Level 1 Cache

Demonstrates that Hibernate maintains a cache per Session.

* First fetch → Database hit
* Subsequent fetches in the same Session → Cache hit
* Different Session → Database hit again

## Database Configuration

Update the Hibernate configuration with your own database credentials before running the project.

```xml
<property name="hibernate.connection.url">
    jdbc:mysql://localhost:3307/telusko_db
</property>

<property name="hibernate.connection.username">
    YOUR_USERNAME
</property>

<property name="hibernate.connection.password">
    YOUR_PASSWORD
</property>
```

## ▶️ How to Run

1. Clone the repository
2. Configure MySQL database
3. Update Hibernate configuration
4. Build the project

```bash
mvn clean install
```

5. Run the desired Java class:

   * SelectOperation
   * SelectOperation2
   * Level1Caching

## 📖 Learning Outcomes

This project helps understand:

* Hibernate Architecture
* SessionFactory and Session
* Transactions
* Entity Lifecycle Basics
* Proxy Objects
* Level 1 Cache
* Hibernate CRUD Fundamentals

## 👨‍💻 Author

Naresh Yelamoni

GitHub: https://github.com/nareshyelamoni
