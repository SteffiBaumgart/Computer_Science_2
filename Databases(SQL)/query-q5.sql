
--contains an SQL query for determining departments
--that have made more than 3000 through student payments.
--The department code and amount should be displayed in each case.

SELECT Department_Code, SUM(Amount_Paid)
FROM Student_Table
GROUP BY Department_Code HAVING SUM(Amount_Paid)>3000;