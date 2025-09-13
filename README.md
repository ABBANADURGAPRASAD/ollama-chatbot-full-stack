# ollama-chatbot-full-stack
Ollama Chat is a full-stack AI chat app with Spring Boot and Angular. It runs with Ollama locally, so no external API keys are needed. The backend manages chat requests while the frontend offers a clean, user-friendly interface to start new chats, search history, and interact with AI.



# Ollama Full Stack Chat Application

A modern full-stack chat application that integrates with Ollama's local AI models, featuring a Spring Boot backend and Angular frontend. This application allows users to interact with various AI models (like Llama2, Llama3) running locally through Ollama.

## 🚀 Features

- **Real-time Chat Interface**: Clean, responsive chat UI with message history
- **Ollama Integration**: Seamless communication with local Ollama AI models
- **Model Selection**: Support for different AI models (Llama2, Llama3, etc.)
- **Asynchronous Processing**: Non-blocking backend with DeferredResult for long-running AI responses
- **CORS Support**: Properly configured for frontend-backend communication
- **Responsive Design**: Modern UI with collapsible sidebar and clean message layout
- **Error Handling**: Comprehensive error handling for both frontend and backend

## 🏗️ Architecture

This project follows a clean separation of concerns with:

- **Backend**: Spring Boot REST API with WebFlux for reactive programming
- **Frontend**: Angular 11 application with TypeScript
- **Communication**: HTTP REST API with JSON payloads
- **AI Integration**: Direct communication with Ollama's local API

## 📁 Project Structure

```
ollama-chat/
├── ollama-backend/                    # Spring Boot Backend
│   ├── src/main/java/com/example/ollamachat/
│   │   ├── OllamaChatApplication.java  # Main Spring Boot application
│   │   ├── controller/
│   │   │   └── ChatController.java     # REST API endpoints
│   │   ├── model/
│   │   │   ├── ChatMessage.java        # Request model
│   │   │   └── ChatResponse.java       # Response model
│   │   └── service/
│   │       └── OllamaService.java      # Ollama integration service
│   ├── src/main/resources/
│   │   └── application.properties      # Configuration
│   └── pom.xml                         # Maven dependencies
│
└── ollama-chat-ui/                     # Angular Frontend
    ├── src/app/
    │   ├── app.component.*             # Main app component
    │   ├── app.module.ts               # Angular module configuration
    │   └── chat/
    │       ├── chat.component.*         # Chat interface component
    │       └── chat.service.ts         # HTTP service for backend communication
    ├── src/environments/               # Environment configurations
    ├── package.json                    # Node.js dependencies
    └── angular.json                    # Angular CLI configuration
```


## 🛠️ Prerequisites

Before running this application, ensure you have the following installed:

### Backend Requirements
- **Java 17** or higher
- **Maven 3.6+**
- **Ollama** installed and running locally

### Frontend Requirements
- **Node.js 14+** and **npm**
- **Angular CLI 11+**

### Ollama Setup
1. Install Ollama from [ollama.ai](https://ollama.ai)
2. Pull a model (e.g., `ollama pull llama2` or `ollama pull llama3`)
3. Ensure Ollama is running on `http://localhost:11434`

## 🚀 Installation & Setup

### 1. Clone the Repository
```bash
git clone <your-repository-url>
cd ollama-chat
```

### 2. Backend Setup (Spring Boot)

Navigate to the backend directory:
```bash
cd ollama-backend
```

Install dependencies and build:
```bash
mvn clean install
```

Run the Spring Boot application:
```bash
mvn spring-boot:run
```

The backend will start on `http://localhost:8080`

### 3. Frontend Setup (Angular)

Navigate to the frontend directory:
```bash
cd ollama-chat-ui
```

Install dependencies:
```bash
npm install
```

Start the development server:
```bash
npm start
```

The frontend will start on `http://localhost:4200`

## 🔧 Configuration

### Backend Configuration (`application.properties`)
```properties
server.port=8080
ollama.url=http://localhost:11434/api/generate

# Extended timeout settings for AI responses
spring.mvc.async.request-timeout=300000
server.tomcat.connection-timeout=300000
```

### Frontend Configuration
The frontend is configured to communicate with the backend at `http://localhost:8080/api/chat`.

## 📡 API Endpoints

### POST `/api/chat`
Send a message to the AI model.

**Request Body:**
```json
{
  "prompt": "Your message here",
  "model": "llama2:latest"
}
```

**Response:**
```json
{
  "message": "AI response here"
}
```

## 🎯 Usage

1. **Start Ollama**: Ensure Ollama is running with at least one model pulled
2. **Start Backend**: Run the Spring Boot application
3. **Start Frontend**: Run the Angular development server
4. **Open Browser**: Navigate to `http://localhost:4200`
5. **Start Chatting**: Type your message and press Send

## 🔍 Key Components Explained

### Backend Components

#### `ChatController.java`
- Handles HTTP requests from the frontend
- Uses `DeferredResult` for asynchronous processing
- Implements CORS for cross-origin requests
- Provides 5-minute timeout for AI responses

#### `OllamaService.java`
- Manages communication with Ollama API
- Uses `RestTemplate` with extended timeouts
- Handles JSON request/response parsing
- Implements reactive programming with `Mono`

#### `ChatMessage.java` & `ChatResponse.java`
- Data models for API communication
- Support for different AI models
- Clean separation of request and response structures

### Frontend Components

#### `ChatComponent`
- Main chat interface component
- Manages message history and UI state
- Handles user input and message sending
- Implements sidebar toggle functionality

#### `ChatService`
- HTTP service for backend communication
- Uses Angular's `HttpClient` for API calls
- Implements proper error handling
- TypeScript interfaces for type safety

## 🎨 UI Features

- **Responsive Design**: Works on desktop and mobile devices
- **Collapsible Sidebar**: Toggle sidebar for more chat space
- **Message History**: Persistent conversation history
- **Clean Interface**: Modern, ChatGPT-inspired design
- **Real-time Updates**: Immediate message display and AI responses

## 📸 Screenshots & Images

To add screenshots and images to your GitHub repository:


<img width="1440" height="900" alt="Screenshot 2025-09-13 at 7 23 19 PM" src="https://github.com/user-attachments/assets/ab8f792d-d978-4eda-8706-e7133fef1e21" />

### 1. Create Images Directory
```bash
mkdir images
```

### 2. Add Screenshots
Place your application screenshots in the `images/` directory:
- `images/app-screenshot.png` - Main application interface
- `images/chat-interface.png` - Chat functionality
- `images/sidebar.png` - Sidebar navigation
- `images/mobile-view.png` - Mobile responsive design

### 3. Display Images in README
Add image references in your README:

```markdown
## 📸 Application Screenshots

### Main Interface
![Main Application Interface](images/app-screenshot.png)

### Chat Functionality
![Chat Interface](images/chat-interface.png)

### Mobile View
![Mobile Responsive Design](images/mobile-view.png)

### Architecture Diagram
![System Architecture](images/architecture-diagram.png)
```

### 4. Recommended Screenshots to Include
- **Main Application Interface**: Show the full chat interface
- **Chat in Action**: Demonstrate a conversation with AI
- **Sidebar Navigation**: Show the collapsible sidebar
- **Mobile View**: Demonstrate responsive design
- **System Architecture**: Visual representation of the full-stack setup
- **Ollama Integration**: Show Ollama running with models

### 5. Image Optimization Tips
- Use PNG for screenshots with text
- Compress images to reduce file size
- Keep images under 1MB each
- Use descriptive filenames
- Consider creating a GIF for demo purposes

## 🔧 Development Commands

### Backend Commands
```bash
# Clean and compile
mvn clean compile

# Run tests
mvn test

# Package application
mvn package

# Run with specific profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### Frontend Commands
```bash
# Start development server
npm start

# Build for production
npm run build

# Run tests
npm test

# Run linting
npm run lint

# Run end-to-end tests
npm run e2e
```

## 🐛 Troubleshooting

### Common Issues

1. **Ollama Connection Error**
   - Ensure Ollama is running: `ollama serve`
   - Check if model is pulled: `ollama list`
   - Verify Ollama URL in `application.properties`

2. **CORS Issues**
   - Backend is configured for `http://localhost:4200`
   - Ensure frontend is running on the correct port

3. **Timeout Issues**
   - AI responses can take time; timeout is set to 5 minutes
   - Check Ollama logs for model loading issues

4. **Port Conflicts**
   - Backend runs on port 8080
   - Frontend runs on port 4200
   - Ollama runs on port 11434

## 🔮 Future Enhancements

- [ ] Model selection dropdown in UI
- [ ] Chat history persistence
- [ ] User authentication
- [ ] Multiple chat sessions
- [ ] File upload support
- [ ] Streaming responses
- [ ] Dark mode theme
- [ ] Mobile app version

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- [Ollama](https://ollama.ai) for providing local AI model hosting
- [Spring Boot](https://spring.io/projects/spring-boot) for the robust backend framework
- [Angular](https://angular.io) for the modern frontend framework
- The open-source community for inspiration and tools

## 📞 Support

If you encounter any issues or have questions:

1. Check the troubleshooting section above
2. Review the [Ollama documentation](https://github.com/ollama/ollama)
3. Open an issue in this repository
4. Check existing issues for similar problems

---

**Happy Chatting with AI! 🤖💬**
