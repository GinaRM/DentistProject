# Dentist Project

This repository contains the source code for a Dentist Management System. The project is designed to streamline the operations of a dental clinic, including appointment scheduling, patient management, and treatment tracking.

## Features
- **Patient Management:** Add, update, and view patient records.
- **Appointment Scheduling:** Manage appointment bookings and view schedules.
- **Treatment Records:** Track and update patient treatments.
- **User Roles:** Secure access with roles for administrators, dentists, and receptionists.

## Technologies Used
### Backend
- **Language:** Java
- **Framework:** Spring Boot
- **Database:** MySQL
- **Other Tools:** Hibernate, JPA, Spring Security

## Prerequisites
To run this project, ensure you have the following installed:
- Java 15 or later
- MySQL Server

## Installation and Setup

### Backend Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/GinaRM/DentistProject.git
   cd DentistProject/backend
   ```
2. Configure the database:
   - Create a MySQL database named `dentist_management`.
   - Update the database connection properties in `application.properties`.

3. Build and run the backend:
   ```bash
   ./mvnw spring-boot:run
   ```

The application should now be accessible at `http://localhost:8080`.

## Usage
1. Access the API or integrate it with a compatible client application.
2. Use the available endpoints to manage patient records, appointments, and treatments.

## Testing
- Run backend tests:
  ```bash
  ./mvnw test
  ```

## Contributing
1. Fork the repository.
2. Create a new branch for your feature:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes and push the branch:
   ```bash
   git commit -m "Description of changes"
   git push origin feature-name
   ```
4. Open a pull request.


## Contact
For questions or suggestions, please contact [Gina Rodríguez](https://github.com/GinaRM).

