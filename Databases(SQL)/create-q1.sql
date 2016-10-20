
--contains Data Definition SQL commands for creating for the three tables
--For the ‘sex’ field in the Student table, create a domain constraint allows only M and F

CREATE TABLE School_Table
(
School_Code varchar(3),
Name varchar(20),
Description varchar(50),
PRIMARY KEY (School_Code)
);



CREATE TABLE Department_Table
(
Department_Code varchar(6),
Name varchar(20),
Number_of_Lecturers int,
School varchar(3),
PRIMARY KEY (Department_Code),
FOREIGN KEY (School) REFERENCES School_Table (School_Code)
);


CREATE TABLE Student_Table
(
Computer_Number int,
fName varchar(20),
lName varchar(30),
Sex ENUM('M', 'F'),
Amount_Paid int,
Department_Code varchar(6),
PRIMARY KEY (Computer_Number),
FOREIGN KEY (Department_Code) REFERENCES Department_Table(Department_Code)
);