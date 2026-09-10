# Experiment 2.1.1: RESTful APIs with Spring Boot

A layered Spring Boot REST API demonstrating CRUD operations, Bean Validation, standardized responses, and secure CORS configuration.

## Requirements

- JDK 17+
- Maven 3.9+

## Run

```bash
mvn spring-boot:run
```

The API starts at `http://localhost:8080`.

## API endpoints

### Posts

- `GET /api/posts`
- `GET /api/posts/{id}`
- `POST /api/posts`
- `PUT /api/posts/{id}`
- `DELETE /api/posts/{id}`

Example request body:

```json
{
  "title": "My first post",
  "content": "Learning REST API design with Spring Boot.",
  "author": "Student"
}
```

### Schedules

- `GET /api/schedules`
- `GET /api/schedules/{id}`
- `POST /api/schedules`
- `PUT /api/schedules/{id}`
- `DELETE /api/schedules/{id}`

Example request body:

```json
{
  "title": "API lab",
  "description": "Demonstrate the completed API",
  "scheduledAt": "2026-09-15T10:30:00",
  "status": "PLANNED"
}
```

Every response uses `{ success, message, data, timestamp }`. Invalid request data returns HTTP 400 with field-level errors. Unknown resource IDs return HTTP 404.

CORS is enabled for local frontend origins `http://localhost:3000` and `http://localhost:5173` on `/api/**`.

## H2 console

Open `http://localhost:8080/h2-console` while the app is running.

- JDBC URL: `jdbc:h2:mem:exp211db`
- User: `sa`
- Password: empty
