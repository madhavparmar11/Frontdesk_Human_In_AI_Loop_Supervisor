# AI Voice Receptionist with Learning System 🎤🧠

**Project Type:** AI Receptionist System with Real-time Voice Chat  
**Tech Stack:** Java, Spring Boot 3, LiveKit, MongoDB, Thymeleaf, Maven

## 🌟 Overview
This project implements a complete AI voice receptionist system for "Glamour Cuts" salon with human-in-the-loop learning capabilities.

### 🎯 Key Features
- 🎤 **Real-time Voice Chat** - LiveKit integration for natural conversation
- 🧠 **AI Learning System** - Learns from supervisor responses (40+ pre-programmed answers)
- 📧 **Email Notifications** - Customers get notified when queries are resolved
- 👨💼 **Supervisor Dashboard** - Manage and resolve customer queries
- 🔄 **Automatic Knowledge Updates** - AI remembers new answers for future customers

## 🏗️ System Architecture

- **Receptionist Service** (Port 8080) – AI voice interactions with customers
- **Supervisor Service** (Port 8081) – Management dashboard for pending queries
- **MongoDB Database** – Stores help requests and learned knowledge
- **LiveKit Cloud** – Real-time voice streaming infrastructure
- **Email Service** – Customer notifications via SMTP

## 🚀 Quick Start

### 1. Prerequisites
- Java 17+
- Maven 3.6+
- MongoDB (local or cloud)
- LiveKit Cloud account (optional)

### 2. Clone Repository
```bash
git clone https://github.com/madhavparmar11/Frontdesk_Human_In_AI_Loop_Supervisor.git
cd Frontdesk_Human_In_AI_Loop_Supervisor


Copy
3. Configure MongoDB
Update application.properties in both services:

spring.data.mongodb.uri=mongodb://localhost:27017/human_in_ailoop_db

Copy
properties
4. Run Services
Terminal 1 - Receptionist Service:

mvn spring-boot:run

Copy
bash
Terminal 2 - Supervisor Service:

cd supervisor-service
mvn spring-boot:run

Copy
bash
5. Access Applications
Customer Interface: http://localhost:8080

Supervisor Dashboard: http://localhost:8081

🎤 Voice Chat Usage
Visit http://localhost:8080

Enter your name

Click "🎤 Start Voice Chat"

Speak your questions naturally

Hear AI responses in real-time

🧠 AI Learning Process
Customer asks unknown question → AI says "Let me check with my supervisor"

Email modal appears → Customer provides email for notification

Question goes to supervisor → Visible on dashboard (port 8081)

Supervisor provides answer → Customer gets email notification

AI learns → Next customer asking same question gets instant answer

📧 Email Configuration
Configure email in supervisor-service/application.properties:

Yahoo Mail (Recommended):

spring.mail.host=smtp.mail.yahoo.com
spring.mail.port=587
spring.mail.username=your-email@yahoo.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

Copy
properties
Outlook:

spring.mail.host=smtp-mail.outlook.com
spring.mail.port=587
spring.mail.username=your-email@outlook.com
spring.mail.password=your-password

Copy
properties
🎯 Pre-programmed Knowledge Base
The AI knows about:

Services: Haircut ($25), Hair Coloring ($50), Manicure ($20), Pedicure ($30)

Hours: 9am - 7pm (Monday-Saturday), Closed Sundays

Contact: 123-456-7890

Location: 123 Beauty Street, Downtown

Appointments, Parking, Discounts, Gift Cards, and more...

🔧 API Endpoints
Voice Chat APIs
POST /api/voice/token
Content-Type: application/json

{
  "customerName": "Alice"
}

Copy
http
POST /api/voice/process-speech
Content-Type: application/json

{
  "customerName": "Alice",
  "customerEmail": "alice@email.com",
  "transcript": "What are your working hours?"
}

Copy
http
Knowledge Base API
GET /api/knowledge/{question}

Copy
http
🛠️ Technology Stack
Backend: Spring Boot 3.2.0, Java 17+

Database: MongoDB with Spring Data

Frontend: Thymeleaf, HTML5, CSS3, JavaScript

Voice: LiveKit Cloud, Web Speech API

Email: Spring Mail with SMTP

Build: Maven

Architecture: Microservices

📱 Features Showcase
Voice Interaction
Real-time speech-to-text

Natural language processing

Text-to-speech responses

Continuous conversation

Learning System
Unknown question detection

Email collection modal

Supervisor resolution workflow

Automatic knowledge updates

Management Dashboard
Pending queries view

One-click resolution

Customer email notifications

Request history tracking

🔮 Future Enhancements
 Multi-language support
 Voice activity detection
 Advanced NLP integration
 Mobile app development
 Analytics dashboard
 Integration with booking systems
👨‍💻 Author
Madhav Parmar
📧 Email: mailto:madhavparmar897@gmail.com
🔗 GitHub: @madhavparmar11

📄 License
This project is open source and available under the MIT License.

⭐ Star this repository if you found it helpful!

🎤 Experience the future of AI customer service with voice interaction and continuous learning!
