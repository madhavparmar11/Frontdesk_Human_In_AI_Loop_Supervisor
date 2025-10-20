# AI Receptionist Service - Glamour Cuts

A Spring Boot 3 microservice for handling customer inquiries at Glamour Cuts salon.

## Tech Stack
- Java 23
- Spring Boot 3
- Maven 3.9.9
- MySQL
- Spring Data JPA
- Lombok

## Setup

1. **Database Setup**
   ```sql
   CREATE DATABASE glamour_cuts_db;
   ```

2. **Run Application**
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### POST /api/ask
Ask a question to the AI receptionist.

**Request:**
```json
{
  "customerName": "Alice",
  "question": "What are your working hours?"
}
```

**Response (Known Question):**
```json
{
  "answer": "We are open from 9am to 7pm."
}
```

**Response (Unknown Question):**
```json
{
  "answer": "Let me check with my supervisor and get back to you."
}
```

### GET /api/knowledge/{question}
Get answer directly from knowledge base.

**Example:** `GET /api/knowledge/working hours`

## Postman Test Examples

### Known Question Test
```json
POST http://localhost:8080/api/ask
Content-Type: application/json

{
  "customerName": "Alice",
  "question": "What are your working hours?"
}
```

### Unknown Question Test
```json
POST http://localhost:8080/api/ask
Content-Type: application/json

{
  "customerName": "John",
  "question": "Do you offer pedicures?"
}
```

## Knowledge Base
The service automatically initializes with:
- Working hours: 9am - 7pm
- Services: Haircut, Hair Coloring, Manicure
- Prices: Haircut ($25), Hair Coloring ($50), Manicure ($20)
- Contact: 123-456-7890