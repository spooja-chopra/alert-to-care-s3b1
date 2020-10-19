# Alert-To-Care-API

The Alert-To-Care System takes patient's vital signs as input from patient-monitoring device. When a parameter goes out-of-range, an alert is generated displaying either or low vital.

## Index

1. [Prerequisites](#Prerequisites)
2. [Executions](#Executions)
3. [APIs Created](#ApiCreated)

## Prerequisites

The target system must have Java (>=8) installed and available in the system path.
The project makes use of Maven as the build tool and hence, Maven must also be in the system path.
The project makes use of Mysql Workbench hence, system must have this software installed in it. Also we have to start mysql server through command prompt.

## Executions

Firstly, start mysql workbench and run the alert_to_care.sql script file after logging in to user in mysql.

To start your mysql server through command prompt 

```
mysql -u root -p
```
After this command we will be asked to enter root password. This will  start mysql server.

## APIs Created

### Bed Service API

| HTTP Mehtod | API URL        | Description                                                                | Success Response                                 | Failure Response  |
|-------------|----------------|----------------------------------------------------------------------------|--------------------------------------------------|-------------------|
| POST        | "/beds"      | This adds a new bed to the system with is available status as "yes" | 201 status code with "CREATED"    | -- |
| GET         | "/beds"      | Fetches list of all beds in the system along with their status          | 200 status code   'OK'                 | --                |
| GET         | "/beds/{bedid}" | Fetches the details of bed with the BedID = "bedid"                                   | 200 Status code 'OK' | 404 status code 'Not Found'     |
| GET         | "/beds/available/{availability}" | Fetches the details of bed on the basis of availability  | 200 Status code 'OK' | 404 status code 'Not Found'     |
| DELETE      | "/beds/{bedid}"  | Deletes specified record of bed with the BedID = "bedid"                                                   | 204 status code 'NO CONTENT'                                   | 400 status code 'BAD REQUEST'     |

### Patient Service API

| HTTP Mehtod | API URL        | Description                                                                | Success Response                                 | Failure Response  |
|-------------|----------------|----------------------------------------------------------------------------|--------------------------------------------------|-------------------|
| POST        | "/patients"      | This adds a new patient to the system | 201 status code 'CREATED'  | 400 status code 'BAD REQUEST' |
| GET         | "/patients"      | Fetches list of all patient along with their details in the system              | 200 status code 'OK'                   | --                |
| GET         | "/patients/{pid}" | Fetches the details of the particular patient with the pid = "id"                                   | status code 200 with 'NO CONTENT'  | status code 404 'NOT FOUND'    |
| DELETE      | "/patients/{pid}"  | Deletes specific  record of the patient                                                   | status code 204 with 'NO CONTENT'                                   | status code 404 'NOT FOUND'     |

### Vital Moniter Service API

| HTTP Mehtod | API URL        | Description                                                                | Success Response                                 | Failure Response  |
|-------------|----------------|----------------------------------------------------------------------------|--------------------------------------------------|-------------------|
| POST        | "/monitor/bpm/{pid}"      | This API gives the vital status of the patient with pid who is on bed          | 200 status code 'OK'     |    status code 404 'NOT FOUND'     |
| POST        | "/monitor/spo2/{pid}"      | This API gives the vital status of the patient with pid who is on bed          | 200 status code 'OK'     |    status code 404 'NOT FOUND'     |
| POST        | "/monitor/respRate/{pid}"      | This API gives the vital status of the patient with pid who is on bed          | 200 status code 'OK'     |    status code 404 'NOT FOUND'     |
