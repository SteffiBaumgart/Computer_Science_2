
--contains an SQL query for determining how many students
--belong to the department of computer science.

SELECT COUNT(*)
FROM Student_Table a JOIN Department_Table b ON a.Department_Code = b.Department_Code
WHERE b.Name = "Computer Science" ;