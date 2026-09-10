# Experiment 2.1.2: Global Exception Handling and Structured Logging

## Aim
Implement global exception handling, request logging, and correlation IDs in a Spring Boot REST API.

## Features
- Centralized errors using `@RestControllerAdvice`.
- Custom `ResourceNotFoundException`.
- `OncePerRequestFilter` for request start/end logs and execution time.
- MDC correlation ID propagated in logs and the `X-Correlation-ID` response header.
- Consistent `ApiError` response structure.

## Run
Prerequisites: JDK 17+ and Maven 3.9+.

```bash
mvn spring-boot:run
```

## Test with Postman or curl

Success:

```bash
curl -i http://localhost:8080/api/products/1
```

Error path:

```bash
curl -i -H "X-Correlation-ID: demo-trace-001" http://localhost:8080/api/products/99
```

The error response includes `timestamp`, `status`, `error`, `message`, `path`, and `correlationId`. Console logs contain the same correlation ID, making one request traceable end to end.

## Expected error response

```json
{
  "timestamp": "2026-09-10T10:15:30Z",
  "status": 404,
  "error": "Not Found",
  "message": "Product not found with id: 99",
  "path": "/api/products/99",
  "correlationId": "demo-trace-001"
}
```
