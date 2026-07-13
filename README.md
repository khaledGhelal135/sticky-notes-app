# Sticky Notes App 📝

A web-based **Sticky Notes** application built with **Spring Boot**, **Thymeleaf**, and **Spring Security**, where users can create sticky notes and add threaded notes/comments to each one.

---

## ✨ Features

- View all sticky notes on a dashboard (`/`)
- Create a new sticky note
- Edit an existing sticky note
- View a sticky note's details along with its notes/comments
- Add and delete notes attached to a sticky note
- Role-based access control (`ADMIN` / `USER`) via Spring Security
- User management page restricted to `ADMIN` role
- Server-side rendering with Thymeleaf + a shared layout template
- H2 file-based database with data seeded on startup

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 4.0.6**
    - Spring Web (MVC)
    - Spring Data JPA
    - Spring Security
    - Thymeleaf (with `thymeleaf-layout-dialect` and `thymeleaf-extras-springsecurity6`)
- **H2 Database** (file-based, embedded)
- **MapStruct** (entity ↔ DTO mapping)
- **Lombok**
- **Maven**

---

## 📁 Project Structure

```text
src/main/java/com/springmvcproject/stickynotes/
├── StickynotesApplication.java
├── advice/              # Global controller advice
├── config/              # Security config, custom UserDetails/UserDetailsService
├── controller/          # StickyNotesController, NoteController, UserController, OtherController
├── filters/              # AuditFilter
├── model/
│   ├── dto/             # Request/response DTOs
│   ├── entity/          # JPA entities: UserEntity, StickyNoteEntity, NoteEntity
│   ├── enums/            # StickyNoteStatus (ACTIVE / DISABLED)
│   └── mapper/           # MapStruct mappers
├── repository/            # Spring Data JPA repositories
└── service/               # Business logic (StickyNoteService, NoteService)

src/main/resources/
├── templates/            # home, sticky-note, edit-sticky-note, my-notes, users, about
├── static/css/            # Stylesheets
├── application.properties
└── data.sql               # Seeded users
```

---

## 🔐 Authentication & Authorization

Authentication is handled by **Spring Security** with a custom `UserDetailsService` that loads users from the database (`UserEntity` / `users` table).

- `/about`, `/css/**`, `/h2-console/**` → public
- `/`, `/note/**`, `/my-notes/**`, `/save/**` → require authentication
- `/users/**` → requires the `ADMIN` role

There is no self-registration flow — users are seeded directly in the database via `data.sql`:

| Username | Password | Role  |
|----------|----------|-------|
| khaled   | 12345    | ADMIN |
| Ahmed    | 13725    | USER  |

> ⚠️ Passwords are stored and compared in **plain text** (`NoOpPasswordEncoder`) and CSRF/CORS/security headers are disabled in `SecurityConfig`. This setup is fine for local learning/demo purposes but **not suitable for production** as-is.

A separate Spring Boot "default" admin user is also configured in `application.properties` (`spring.security.user.name=admin` / password `1234`), used for basic auth.

---

## 🗂️ Data Model

- **UserEntity**: `id`, `username`, `password`, `name`, `role`, timestamps.
- **StickyNoteEntity**: `id`, `name`, `description`, `status` (`ACTIVE`/`DISABLED`), `color`, timestamps.
- **NoteEntity**: `id`, `note`, `stickyNoteId`, timestamps — represents a comment/note attached to a sticky note.

---

## 📄 Pages / Routes

| Method | Path                          | Description                              | Access        |
|--------|-------------------------------|--------------------------------------------|---------------|
| GET    | `/`                            | Dashboard — list of all sticky notes        | Authenticated |
| GET    | `/sticky-note/{id}`             | View a sticky note and its notes            | Authenticated |
| GET    | `/edit-sticky-note/{id}`        | Edit form for a sticky note                 | Authenticated |
| POST   | `/save`                         | Create a new sticky note                    | Authenticated |
| POST   | `/update/{id}`                  | Update an existing sticky note              | Authenticated |
| GET    | `/note`                        | List all notes ("My Notes" view)            | Authenticated |
| POST   | `/note/add/{stickyNoteId}`      | Add a note to a sticky note                 | Authenticated |
| GET    | `/note/delete/{noteId}/{stickyNoteId}` | Delete a note                        | Authenticated |
| GET    | `/users`                        | User management page                        | ADMIN only    |
| GET    | `/about`                        | About page                                  | Public        |

---

## 🚀 Running the Project

### 1. Clone the repository

```bash
git clone https://github.com/khaledGhelal135/sticky-notes-app.git
cd sticky-notes-app
```

### 2. Database

No external database setup is required — the app uses an embedded, file-based **H2** database configured in `application.properties`:

```properties
spring.datasource.url=jdbc:h2:file:/database/sticky_notes
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

The database file is created automatically at `/database/sticky_notes` on first run, and seed data comes from `src/main/resources/data.sql`.

### 3. Run the application

```bash
./mvnw spring-boot:run
```

The app will start on:

```text
http://localhost:9090
```

Log in with one of the seeded users (e.g. `khaled` / `12345` for admin access).

---

## ✍️ Author

**Khaled Gaber Helal**
Backend Developer | Computer Science Student

- GitHub: [khaledGhelal135](https://github.com/khaledGhelal135)
- Email: [khaledhelal135@gmail.com](mailto:khaledhelal135@gmail.com)
