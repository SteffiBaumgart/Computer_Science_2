
--contains an SQL query that shows department codes
--and how much money each department code has made through student payments.

SELECT Department_Code, SUM(Amount_Paid)
FROM Student_Table
GROUP BY Department ;