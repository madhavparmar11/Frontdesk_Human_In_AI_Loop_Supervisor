# Human-in-the-Loop AI Supervisor

**Project Type:** AI Receptionist System  
**Tech Stack:** Java, Spring Boot 3, Thymeleaf, MongoDB (Compass), Maven

## Overview
This project implements a human-in-the-loop AI receptionist system for a salon called “Glamour Cuts”.

The AI agent:

- Answers customer questions about services, prices, and working hours.
- Escalates questions it cannot answer to a human supervisor.
- Updates its internal knowledge base automatically after supervisor input.

The system includes:

- **Receptionist Service** – Handles AI interactions with customers.
- **Supervisor Service** – Web dashboard for managing pending help requests.
- **MongoDB Database (Compass)** – Stores help requests and learned answers.
- **Thymeleaf Frontend** – Two simple interfaces:
  - Customer interface: Ask questions and view AI responses.
  - Supervisor dashboard: View, resolve, and track help requests.

## Features

- Modular, scalable AI agent system
- Request lifecycle management: `PENDING → RESOLVED / UNRESOLVED`
- Supervisor responses linked to originating requests
- Automatic knowledge base updates
- Simple, professional interfaces built with Thymeleaf

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/madhavparmar/Frontdesk_Human_In_AI_Loop_Supervisor.git
cd Frontdesk_Human_In_AI_Loop_Supervisor
2. Configure MongoDB
Open MongoDB Compass

Connect to your local MongoDB:

Hostname: localhost

Port: 27017

Create a database named: human_in_ailoop_db

Update application.properties in both services with your MongoDB URI:

properties
Copy code
spring.data.mongodb.uri=mongodb://localhost:27017/human_in_ailoop_db
Collections used (auto-created by MongoDB):

HelpRequests → stores customer name, question, status, creation timestamp

KnowledgeBase → stores AI-learned questions and answers

3. Run the Services
Receptionist Service
bash
Copy code
cd receptionist-service
mvn spring-boot:run
Supervisor Service
bash
Copy code
cd supervisor-service
mvn spring-boot:run
4. Access the Interfaces
Customer Interface: http://localhost:8080

Supervisor Dashboard: http://localhost:8081

5. Example Interactions
Customer: "What are your working hours?"
AI: "We are open from 9am to 7pm."

Customer: "Do you offer pedicures?"
AI: "Let me check with my supervisor and get back to you."

Supervisor Responds: "Yes, we offer pedicures for $30."
AI: "Yes, we offer pedicures for $30."

Design Decisions
Modular Microservices: Separate receptionist and supervisor services for scalability.

Database: MongoDB Compass used to persist requests and knowledge base.

Frontend: Thymeleaf chosen for simplicity and seamless integration with Spring Boot.

Request Lifecycle: Ensures PENDING requests are tracked and updated automatically.

Extensibility: Easy to add more AI capabilities or services in the future.

Next Steps / Improvements
Implement live call escalation when a supervisor is available.

Enhance AI knowledge base with NLP capabilities.

Add authentication for supervisor dashboard.

Make the frontend more responsive and modern.

Author
Madhav Parmar
Email: madhavparmar897@gmail.com
