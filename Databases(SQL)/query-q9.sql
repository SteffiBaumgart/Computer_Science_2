
--contains an SQL query that shows the department
--with the highest number of lecturers.

SELECT Name, Number_of_Lecturers
FROM Department_Table
WHERE Number_of_Lecturers = (SELECT MAX(Number_of_Lecturers) FROM Department_Table_) ;
