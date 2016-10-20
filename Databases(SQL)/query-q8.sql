
--that contains an SQL query that shows all the students
--whose first name contains the letter ‘i’.

SELECT fName, lName
FROM Student_Table
WHERE fName LIKE '%i%' ;