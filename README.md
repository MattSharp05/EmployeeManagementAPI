# Employee Management API  

## Overview  
This project is a REST API for managing employee records. It provides endpoints to create employees, retrieve employee details, and list all employees.  

## Endpoints  

### `GET /employees`  
- **Description:** Returns a list of all employees.  
  ```json
  [
    {
      "uuid": "123e4567-e89b-12d3-a456-426614174000",
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "jobTitle": "Software Engineer",
      "salary": 75000
    }
  ]


### `POST /employees`  
- **Description:** Creates a new employee.  
- **Request Body:**  
  ```json
    {
      "firstName": "Jane",
      "lastName": "Smith",
      "email": "jane.smith@example.com",
      "jobTitle": "Hardware Engineer",
      "salary": 85000
    }

## Implementation Details

### Architecture and Design

- The project has a layered architecture
- different parts of the application have distinct responsibilities to ensure the codebase is more modular, maintainable and scalable
- The project is seperated into the following layers:
    - Controller Layer (EmployeeController)
        - Defines API endpoints and handles HTTP requests
    - Service Layer (EmployeeService)
        - Contains business logic and acts as an intermediary between the controller and the data layer.
    - Model Layer (Employee and EmployeeImpl)
        - Defines data models, ensuring consistency in how employee data is represented
- Data persistence is simulated using an in-memory store for now

### Why This Approach?
- Using an interface (Employee) allows flexibility for future enhancements, like supporting different employee types.
- The service layer ensures that business logic is separate from the API layer, improving maintainability.
- The UUID identifier provides a unique reference for each employee, making it scalable.


## Calling the API

Here is the working example of this solution.

### Creating an employee

<img width="1035" alt="Screenshot 2025-02-18 at 14 11 26" src="https://github.com/user-attachments/assets/83bfbc76-392d-4543-9a88-62f61e022b62" />


### Fetching all employees

<img width="1032" alt="Screenshot 2025-02-18 at 14 13 10" src="https://github.com/user-attachments/assets/f24bb70c-8c57-41c8-aabc-f6706aae0cb7" />


### Fetching an employee by UUID


<img width="1018" alt="Screenshot 2025-02-18 at 14 14 10" src="https://github.com/user-attachments/assets/3db3b82b-e43b-4464-83f4-64b74b744c30" />


See Challenge Problem Statement below



# ReliaQuest's Entry-Level Java Challenge

Please keep the following in mind while working on this challenge:
* Code implementations will not be graded for **correctness** but rather on practicality
* Articulate clear and concise design methodologies, if necessary
* Use clean coding etiquette
  * E.g. avoid liberal use of new-lines, odd variable and method names, random indentation, etc...
* Test cases are not required

## Problem Statement

Your employer has recently purchased a license to top-tier SaaS platform, Employees-R-US, to off-load all employee management responsibilities.
Unfortunately, your company's product has an existing employee management solution that is tightly coupled to other services and therefore 
cannot be replaced whole-cloth. Product and Development leads in your department have decided it would be best to interface
the existing employee management solution with the commercial offering from Employees-R-US for the time being until all employees can be
migrated to the new SaaS platform.

Your ask is to expose employee information as a protected, secure REST API for consumption by Employees-R-US web hooks.
The initial REST API will consist of 3 endpoints, listed in the following section. If for any reason the implementation 
of an endpoint is problematic, the team lead will accept **pseudo-code** and a pertinent description (e.g. java-doc) of intent.

Good luck!

## Endpoints to implement (API module)

_See `com.challenge.api.controller.EmployeeController` for details._

getAllEmployees()

    output - list of employees
    description - this should return all employees, unfiltered

getEmployeeByUuid(...)

    path variable - employee UUID
    output - employee
    description - this should return a single employee based on the provided employee UUID

createEmployee(...)

    request body - attributes necessary to create an employee
    output - employee
    description - this should return a single employee, if created, otherwise error

## Code Formatting

This project utilizes Gradle plugin [Diffplug Spotless](https://github.com/diffplug/spotless/tree/main/plugin-gradle) to enforce format
and style guidelines with every build.

To format code according to style guidelines, you can run **spotlessApply** task.
`./gradlew spotlessApply`

The spotless plugin will also execute check-and-validation tasks as part of the gradle **build** task.
`./gradlew build`
