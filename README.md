# Transfer Service API

## 📌 Overview
This project is a **RESTful API** built using **Spring Boot** for performing **money transfers between accounts**. The API allows users to:
1. **Create accounts** with unique account numbers.
2. **Retrieve account details** including balance.
3. **Transfer money** between accounts with validation checks.

## 🚀 Tech Stack
- **Java** (Spring Boot)
- **Spring Web** (for RESTful API development)
- **Lombok** (to reduce boilerplate code)
- **JUnit** (for testing)

## 📂 Project Structure
```
transfer-service/
├── src/main/java/com/example/transfer
│   ├── controller/      # REST Controllers
│   ├── service/         # Business Logic
│   ├── model/           # Data Models (Account, Transaction)
│   
│   
├── test/                #Testing
├── pom.xml              # Dependencies (Maven)
└── README.md            # Documentation
```

## 🔹 API Endpoints

### 1️⃣ Create an Account
**Endpoint:** `POST /api/accounts`

**Response Example:**
```json
{
    "accountNumber": "123e4567-e89b-12d3-a456-426614174000",
    "balance": 1000.0
}
```

---

### 2️⃣ Get All Accounts
**Endpoint:** `GET /api/accounts`

**Response Example:**
```json
[
    {
        "accountNumber": "123e4567-e89b-12d3-a456-426614174000",
        "balance": 1000.0
    }
]
```

---

### 3️⃣ Transfer Money
**Endpoint:** `POST /api/transfer?source=<sourceAccount>&destination=<destinationAccount>&amount=<amount>`

**Response Example:**
```json
{
    "sourceAccount": "123e4567-e89b-12d3-a456-426614174000",
    "destinationAccount": "987e6543-b21a-34c5-d678-426614174111",
    "amount": 500.0,
    "timestamp": "2025-03-12T10:30:00"
}
```

## 🔒 Validations & Error Handling
- ✅ **Ensures sufficient balance** before transfer.
- ❌ Returns an error if account numbers are invalid.
- ❌ Prevents transfers of negative or zero amounts.

## 🛠 Running the Project
### **1️⃣ Clone the Repository**
```bash
git clone https://github.com/your-repo/transfer-service.git
cd transfer-service
```
### **2️⃣ Build & Run the Application**
```bash
mvn spring-boot:run
```

### **3️⃣ Test in Postman**
- Use **POST** & **GET** requests to test API endpoints.

## 🧪 Running Tests
Run unit tests using:
```bash
mvn test
```




