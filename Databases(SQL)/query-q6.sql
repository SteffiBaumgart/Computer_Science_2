
--contains an SQL query that will show the following results (pdf)

SELECT Department_Code, SUM(Amount_Paid)
FROM Student_Table
GROUP BY Department_Code ;
--ORDER BY Department ASC