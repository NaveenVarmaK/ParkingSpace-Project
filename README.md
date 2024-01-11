Parking Management System

A comprehensive Parking Management System built with Spring Boot for the backend and Vue.js for the frontend, backend by PostgreSQL[^1^][1].

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Introduction

The Parking Management System is a robust solution for efficiently managing parking slots and user bookings. It seamlessly integrates a Spring Boot backend with a Vue.js frontend to provide a comprehensive user experience[^2^][2]. The backend uses PostgreSQL as the database[^3^][3].


**Additional Notes:**

    * The Vue.js frontend is designed mainly based on the assignment for Cours Dev Web TP 4 - VueJS. I implemented the tasks in my front-end.
    * Implemented Junit testing and API Integration testing for the backend Spring boot.
    * For the backend of the project, I used PostgreSQL and Spring Boot. There might be a chance that the database is empty when it reaches your system, but I am sure that all the APIs and the functions are working.

## Features

### Backend (Spring Boot)[^4^][4]

- Retrieve a list of parking slots[^5^][5].
- Create, update, and delete parking slots[^6^][6].
- Retrieve a list of users and their bookings[^7^][7][^8^][8].
- Create, update, and delete users and bookings[^9^][9].

### Frontend (Vue.js)[^5^][5]

- View a list of parking slots.
- Create, update, and delete parking slots[^6^][6].
- View a list of users and their bookings[^8^][8][^7^][7].
- Create, update, and delete users and bookings[^9^][9].

## Getting Started

### Prerequisites

#### Backend

- Java 17
- Maven
- PostgreSQL (for database)[^3^][3]

#### Frontend

- Node.js
- npm

### Installation

Clone the repository:

```bash
git clone https://github.com/NaveenVarmaK/ParkingSpace-Project.git
```

## Usage

### Frontend & Backend

Run with Docker

To run the Spring Boot backend and frontend VueJS application with Docker:

```bash
sudo docker compose up --build
```


### Backend

Run with Docker

To run the Spring Boot application with Docker:

```bash
sudo docker compose up backend
```

Build for Production

To build the SpringBoot application for production:

```bash
sudo docker compose build backend
```

### Frontend

Run with Docker

To run the Vue.js application with Docker:

```bash
sudo docker compose up frontend
```

Build for Production

To build the Vue.js application for production:

```bash
sudo docker compose build frontend
```

The services will be accessible at:

- Backend: http://localhost:8084/swagger-ui/index.html#/
- Frontend: http://localhost:8080


## Clever Cloud Deployment

### Backend

```Link To Clever Cloud Backend
http://app-5096ec83-dfe7-4bc8-8f43-59f96c0d12f7.cleverapps.io/swagger-ui/index.html#/
```

**Note:**

    * I started building this project using Docker, but when I tried to implement the Docker backend to the Clever Cloud, I found out that Docker is not yet completely supported on Clever Cloud, or Compose OS sort. Therefore, I implemented my backend separately in a different Git repository, which is not yet linked to this project, but it is the same backend with the name “CleverCloud-Backend” (app_5096ec83-dfe7-4bc8-8f43-59f96c0d12f7).


```Link To See CleverCloud Documentation
https://developers.clever-cloud.com/doc/applications/docker/
```

```Link To See Backend Repository for the CleverCloud Deployment
https://github.com/NaveenVarmaK/CleverCloud-Backend.git
```

## To Activate checkstyle-profile

```bash
cd parking_backend
```

```bash
mvn clean validate -Pcheckstyle-profile
```

## In Order To Run Junit Testing and API Integration Testing In The BackEnd Please modify the below line

/parking_backend/src/main/resources/application.properties

spring.datasource.url=jdbc:postgresql://postgres:5432/postgres

spring.datasource.url=jdbc:postgresql://localhost:5432/postgres


![Screenshot from 2024-01-11 18-08-18](https://github.com/NaveenVarmaK/ParkingSpace-Project/assets/64104378/52133e22-c174-4ffd-a4f8-7010cba093b7)

![Screenshot from 2024-01-05 20-45-29](https://github.com/NaveenVarmaK/ParkingSpace-Project/assets/64104378/c15ed63c-e4e4-4ac2-a48e-0917214f9f00)


## Mobile App Development

```Link to the Mobile App Development Repository
https://github.com/NaveenVarmaK/ParkingSpace-Mobile-App.git
```

**Note:**

    * The Mobile App for this Project is not completely Developed


## Contributing

Contributions are welcome![^10^][10] Please follow the [Contribution Guidelines](CONTRIBUTING.md)[^11^][11].

## License

This project is licensed under the [GNU General Public License v3.0](LICENSE)[^12^][12].

## Acknowledgments

Special thanks to the Spring Boot and Vue.js communities for their support[^13^][13]."
