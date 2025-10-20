# Supervisor Service - Glamour Cuts

A Spring Boot 3 microservice for managing help requests and updating the knowledge base.

## Tech Stack
- Java 23
- Spring Boot 3
- Maven 3.9.9
- MySQL (shared with AI Receptionist)
- Spring Data JPA
- Lombok

## Setup

1. **Database** - Uses same database as AI Receptionist: `glamour_cuts_db`

2. **Run Application**
   ```bash
   mvn spring-boot:run
   ```
   Service runs on port **8081**

## API Endpoints

### GET /api/requests/pending
View all pending help requests.

**Response:**
```json
[
  {
    "id": 1,
    "customerName": "John",
    "question": "Do you offer pedicures?",
    "status": "PENDING",
    "createdAt": "2024-01-15T10:30:00"
  }
]
```

### POST /api/requests/{id}/resolve
Resolve a help request and add answer to knowledge base.

**Request:**
```json
{
  "answer": "Yes, we offer pedicures for $30"
}
```

**Response:** `"Request resolved successfully"`

**Actions performed:**
- Updates help request status to RESOLVED
- Adds Q&A to knowledge_base table
- Logs notification: `Customer John: Yes, we offer pedicures for $30`

### GET /api/requests/history
View all help requests (resolved and unresolved).

## Postman Test Examples

### View Pending Requests
```
GET http://localhost:8081/api/requests/pending
```

### Resolve Request
```json
POST http://localhost:8081/api/requests/1/resolve
Content-Type: application/json

{
  "answer": "Yes, we offer pedicures for $30"
}
```

### View History
```
GET http://localhost:8081/api/requests/history
```

## Integration
- Shares database with AI Receptionist Service (port 8080)
- Automatically updates knowledge base when resolving requests
- Simulates AI Receptionist notification via console logging