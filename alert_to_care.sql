DROP DATABASE alert_to_care;

CREATE DATABASE alert_to_care; 
use alert_to_care;

DROP TABLE IF EXISTS `bed_info`;
CREATE TABLE bed_info (
bed_Id int NOT NULL AUTO_INCREMENT,
bed_Serial_Number varchar(10) NOT NULL,
bed_Availability boolean NOT NULL,
icu_Number tinyint NOT NULL,
PRIMARY KEY (bed_Id)
);

DROP TABLE IF EXISTS `patient_info`;
Create table patient_info(
	patient_Id int NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
    age int NOT NULL,
    phone_Number varchar(10),
    bed_Id int NOT NULL,
    PRIMARY KEY (patient_Id),
    FOREIGN KEY (bed_Id) REFERENCES bed_info(bed_Id) 
);

LOCK TABLES `bed_info` WRITE;
INSERT INTO bed_info(bed_Serial_Number, bed_Availability, icu_Number) 
VALUES 
(103, false, 1), 
(104, true, 1),
(108, false,2),
(109, true, 2);
UNLOCK TABLES;

LOCK TABLES `patient_info` WRITE;
INSERT INTO patient_info(age, name, phone_Number, bed_Id)
VALUES
(34, "Shyam Mehta", "5678902312", 1),
(67, "Krishna Manvar", "1543289032", 3);
UNLOCK TABLES;
