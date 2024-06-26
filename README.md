# 🚀 Kanban System for Project Management

This project is a web-based Kanban system for project management. It allows users to manage projects, organize tasks into different stages, and track the progress of tasks.

## Demo Video
<img width="787" alt="Screenshot 2024-04-29 at 11 17 36 PM" src="https://github.com/Pezcue/SpringBootRest/assets/88043734/04364ba1-039f-45c1-bb7e-091d9e46689f">

[![Watch the video here](https://img.youtube.com/vi/YOUTUBE_VIDEO_ID_HERE/0.jpg)](https://www.youtube.com/watch?v=zOBW5pRutWQ)

## Diagrams

### 📊 UML Diagram
<img width="891" alt="Diagrama_UML" src="https://github.com/Pezcue/SpringBootRest/assets/88043734/c2e96e00-8215-4ea2-8da4-944893f78d58">


### 🔄 Entity-Relationship Diagram
<img width="698" alt="Diagrama_DER" src="https://github.com/Pezcue/SpringBootRest/assets/88043734/ef014a87-4bab-42f6-808c-5af79ca42587">


## Technologies Used

- ☕ Java
- 🚀 Spring Boot
- 💾 Spring Data JPA
- 🛠️ Hibernate
- 🗃️ MySQL
- 🔐 JWT (JSON Web Tokens)
- 📝 Swagger UI
- 📦 Maven

## Configuration and Usage

1. **Clone the repository:** `git clone https://github.com/Pezcue/SpringBootRest.git`
2. **Configure the MySQL database:** Update the `application.properties` file with your database configuration.
3. **Compile and run the application:** `mvn spring-boot:run`
4. **Access the application:** Open your browser and go to `http://localhost:8080`
5. **Explore the API:** Use Swagger UI to explore and test the API endpoints at `http://localhost:8080/swagger-ui.html`

## Main Endpoints

### Project Endpoints

- ✨ `POST /v1/projects/`: Create a new project.
- ✏️ `PUT /v1/projects/{id}`: Edit an existing project.
- ❌ `DELETE /v1/projects/{id}`: Delete a project.
- 📝 `GET /v1/projects/{id}`: Get a project by its ID.
- 📊 `GET /v1/projects/{id}/board`: Get all tasks of a project grouped by status.
- ⏰ `GET /v1/projects/{id}/due-task`: Get overdue tasks of a project.

### Task Endpoints
- ✨ `POST /v1/task/project/{1id}`: Create a new Task.
- ✏️ `GET /v1/task/{id}`: Edit an existing Task.
- ❌ `DELETE /v1/task/{id}`: Delete a Task.
- 🔧 `PATCH /v1/task/{id}`: Update the status of a task.

## Authentication and Authorization

The API uses JWT (JSON Web Tokens) for user authentication and authorization. To obtain an access token, follow these steps:

1. **Authenticate:** Send a POST request to `/auth/login` with valid credentials in the request body.
2. **Receive Token:** If the credentials are correct, you will receive an access token in the response.
3. **Include Token:** Include the access token in the `Authorization` header of subsequent requests to protected endpoints.

## Error Handling

The API handles errors and returns appropriate responses for invalid requests or resources not found. Error messages are included in the response body with an appropriate HTTP status code.

## Testing

Unit and integration tests have been implemented to ensure the proper functioning of the application. You can run the tests using the following command:

```bash
mvn test

Contribution
If you wish to contribute to this project, please follow these steps:

Fork the repository.
Create a new branch: For your feature or bug fix.
Make Changes: Make necessary changes and ensure that tests pass.
Submit a Pull Request: Describe your changes and submit a pull request.
Contact
If you have any questions or suggestions about this project, feel free to contact us at [insert your contact information here].
