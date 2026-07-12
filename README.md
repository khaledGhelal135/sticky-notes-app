#  Sticky Notes Application

A web-based Sticky Notes application built using Spring Boot and Thymeleaf that allows users to create, manage, update, and organize personal notes.

##  Features

* User Registration and Login
* Authentication and Authorization using Spring Security
* Create New Notes
* Edit Existing Notes
* Delete Notes
* View All Notes
* Note Status Management
* Responsive User Interface using Bootstrap
* Server-Side Rendering with Thymeleaf

---

##  Technologies Used

* Java
* Spring Boot
* Spring MVC
* Spring Security
* Spring Data JPA
* Hibernate
* Thymeleaf
* MySQL
* Bootstrap
* Maven

---

##  Project Structure

```text
src/main/java
│
├── controller
├── entity
├── repository
├── service
├── security
├── config
└── exception

src/main/resources
│
├── templates
├── static
└── application.properties
```

---

##  Authentication

The application uses Spring Security for user authentication and authorization.

Users can:

* Register a new account
* Login securely
* Logout safely
* Access personal notes only

---

##  Main Features

### Authentication

* Register
* Login
* Logout

### Notes Management

* Create Note
* Update Note
* Delete Note
* View Notes

### User Features

* Secure access to personal notes
* Session management with Spring Security

---

##  Running the Project

### Clone the repository

```bash
git clone https://github.com/khaledGhelal135/sticky-notes-app.git
```

### Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sticky_notes_db
spring.datasource.username=root
spring.datasource.password=your_password
```

### Run the application

```bash
mvn spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

---

##  Author

**Khaled Gaber Helal**

Backend Developer | Computer Science Student

* GitHub: https://github.com/khaledGhelal135
* Email: [khaledhelal135@gmail.com](mailto:khaledhelal135@gmail.com)
