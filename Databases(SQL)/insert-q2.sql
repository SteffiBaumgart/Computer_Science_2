
--contains commands to insert the given data in the tables.


 INSERT INTO School_Table
 VALUES ("Edu","Education", "Offers educational programs.");
 INSERT INTO School_Table
 VALUES ("Hum", "Humanities", "Offers business and law programs.");
 INSERT INTO School_Table
 VALUES ("Nat", "Natural Sciences", "Offers science programs.");
 INSERT INTO School_Table
 VALUES ("Eng", "Engineering", "Offers engineering programs.");


 INSERT INTO Department_Table
 VALUES ("000001", "Distance Education", 50, "Edu");
 INSERT INTO Department_Table
 VALUES ("000002", "Civil Engineering", 22, "Eng");
 INSERT INTO Department_Table
 VALUES ("000003", "Special Education", 20, "Edu");
 INSERT INTO Department_Table
 VALUES ("000004", "Geography", 30, "Nat");
 INSERT INTO Department_Table
 VALUES ("000005", "Mass Communication", 20, "Hum");
 INSERT INTO Department_Table
 VALUES ("000006", "Computer Science", 8, "Nat");

 INSERT INTO Student_Table
 VALUES (130000001, "John", "Smith", "M", 4000, 000006);
 INSERT INTO Student_Table
 VALUES (130000002, "Ruth", "Jabulani", "F", 3000, 000006);
 INSERT INTO Student_Table
 VALUES (130000003, "Copper", "Price", "M", 1000, 000001);
 INSERT INTO Student_Table
 VALUES (130000004, "Lucky", "Banda", "M", 300, 000002);
 INSERT INTO Student_Table
 VALUES (130000005, "Kurshed", "Muhammed", "M", 1000, 000003);
 INSERT INTO Student_Table
 VALUES (130000006, "Bertha", "Luliso", "F", 2500, 000001);
 INSERT INTO Student_Table
 VALUES (130000007, "Titan", "Jameson", "F", 500, 000003);
 INSERT INTO Student_Table
 VALUES (130000008, "Precious", "Matima", "F", 100, 000004);
 INSERT INTO Student_Table
 VALUES (130000009, "Luka", "Andrews", "M", 100, 000006);
 INSERT INTO Student_Table
 VALUES (130000010, "Johnathan", "Jackson", "M", 200, 000006);
 INSERT INTO Student_Table
 VALUES (130000011, "Emmanuel", "Cele", "M", 1000, 000004);
 INSERT INTO Student_Table
 VALUES (130000012, "Doris", "Zulu", "F", 3000, 000005);