# Vehicle Registration

This project is a simple REST API built with Java and Spring Boot for registering vehicles. It includes functionalities to filter and save vehicles based on certain criteria.

## Table of Contents
- [Requirements](#requirements)
- [Project Setup](#project-setup)
- [API Endpoints](#api-endpoints)
- [Running Tests](#running-tests)
- [Project Structure](#project-structure)
- [Additional Information](#additional-information)


## Requirements

- Java 17
- Maven 3.6+
- Git

## Project Setup

1. **Clone the repository:**
    ```sh
    git clone https://github.com/yourusername/vehicleregistration.git
    cd vehicleregistration
    ```

2. **Build the project:**
    ```sh
    mvn clean install
    ```

3. **Run the application:**
    ```sh
    mvn spring-boot:run
    ```

## API Endpoints

### Register Vehicles

- **URL:** `/v1/vehicles`
- **Method:** `POST`
- **Content-Type:** `application/json`
- **Request Body:**
    ```json
    {
        "vehicles": [
            {
                "VIN": "1324",
                "manufacturer": "Ford",
                "bay_number": 50
            },
            {
                "VIN": "324",
                "manufacturer": "GM",
                "bay_number": 20
            }
        ]
    }
    ```
- **Response Codes:**
    - `201 Created` if the request is successful.
    - `400 Bad Request` if the request is invalid.

### Link to open H2Console
```
http://localhost:8080/vehicle-registration/h2-console
```
## Running Tests

To run the tests, execute the following command in the project's root directory:

```sh
mvn test
```

## Project Structure
- `src/main/java/com/self/vehicleregistration`: Main application source files
- `api`: REST API controllers
```
VehicleRegistrationController.java
```
- `model`: Data Transfer Objects (DTOs), entities, and enums 
```
dto/VehicleDto.java
dto/Vehicles.java
entity/Vehicle.java
enums/Manufacturer.java
mapper/VehicleMapper.java
```
- `repository`: Spring Data JPA repositories
```
VehicleRegistrationRepository.java
```
- `service`: Business logic services
```
VehicleRegistrationService.java
```
- `src/test/java/com/self/vehicleregistration`: Test source files
- `api`: Controller tests
```
VehicleRegistrationControllerTest.java
```
- `service`: Service tests
```
VehicleRegistrationServiceTest.java
```


## Additional Information
Vehicle Registration Service
The service processes a list of vehicles provided in the request body and saves only those that meet the following criteria:
```
Only vehicles from Ford and GM are saved.
Vehicles from VW are ignored.
Vehicles with a bay_number greater than 100 are not saved.
Vehicles without a bay_number are saved.
```

## Testing
The project includes unit tests for both the controller and the service layer using Spring Boot's test framework and Mockito for mocking dependencies.

