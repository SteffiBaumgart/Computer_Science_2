
--contains an SQL query that shows the students who have paid more
--than the average of the total amount paid by all students.

SELECT fName, lName, SUM(Amount_Paid)
FROM Student_Table
GROUP BY fName, lName
HAVING SUM(Amount_Paid)>(SELECT AVG(Amount_Paid) FROM Student_Table) ;
