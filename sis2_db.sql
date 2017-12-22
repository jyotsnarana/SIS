CREATE TABLE dbo.course (
	Id int NOT NULL IDENTITY(1,1),
	CourseId varchar(30) NULL,
	CourseName nchar(50) NULL,
	Semester varchar(30) NULL,
	Professor nchar(30) NULL,
	Time nchar(50) NULL,
	Room nchar(30) NULL,
	Capacity nchar(30) NULL
);

ALTER TABLE dbo.course ADD CONSTRAINT PK__course__3214EC070B50A1D7 PRIMARY KEY (Id);

-- Add 8 rows for course.
SET IDENTITY_INSERT course ON
INSERT INTO course (Id, CourseId, CourseName, Semester, Professor, Time, Room, Capacity) VALUES 
(1,'COMP6311','Software Architecture                             ','Winter18','Relling                       ','Thursday-17:00-20:00                              ','h890                          ','90                            '),
(2,'COMP6322','Machine Learning                                  ','Winter18','Renewit                       ','Friday-17:00-20:00                                ','h890                          ','90                            '),
(3,'SOEN6411','Project Management                                ','Winter18','Renewit                       ','Friday-17:00-20:00                                ','h890                          ','90                            '),
(4,'COMP6333','Image Processing                                  ','Summer18','Relling                       ','Thursday-17:00-20:00                              ','h890                          ','90                            '),
(5,'SOEN6411','Project Management                                ','Summer18','Renewit                       ','Friday-17:00-20:00                                ','h890                          ','90                            '),
(6,'SOEN6411','Project Management                                ','Fall17','Renewit                       ','Friday-17:00-20:00                                ','h890                          ','90                            '),
(7,'COMP6333','Image Processing                                  ','Fall17','Relling                       ','Thursday-17:00-20:00                              ','h890                          ','90                            '),
(8,'INSE6260','Quality Assurance                                 ','Fall17','Dssouli                       ','Friday-17:00-20:00                                ','h890                          ','90                            ');

SET IDENTITY_INSERT course OFF

CREATE TABLE dbo.payment (
	StudentId nchar(10) NULL,
	Paid real(4) NULL
);

-- Add 1 rows for payment.
INSERT INTO payment (StudentId, Paid) VALUES 
('40018903  ',300);

CREATE TABLE dbo.student_course (
	StudentId int NULL,
	CourseId int NULL
);

-- Add 2 rows for student_course.
INSERT INTO student_course (StudentId, CourseId) VALUES 
(40018903,1),
(40018903,2);

CREATE TABLE dbo.student_record (
	StudentId nchar(10) NULL,
	CourseId varchar(30) NULL,
	CourseName nchar(50) NULL,
	Grade nchar(10) NULL,
	point real(4) NULL,
	Semester varchar(30) NULL
);

-- Add 36 rows for student_record.
INSERT INTO student_record (StudentId, CourseId, CourseName, Grade, point, Semester) VALUES 
('40018900  ','COMP6511','Software Design                                   ','DISC      ',0,'Winter17'),
('40018900  ','COMP6522','Artificial Intelligence                           ','B-        ',2.7,'Winter17'),
('40018900  ','SOEN6511','Code Refactoring                                  ','C         ',2,'Summer17'),
('40018900  ','SOEN6522','Software Requirement                              ','A-        ',3.7,'Summer17'),
('40018901  ','COMP6511','Software Design                                   ','A+        ',4.3,'Winter17'),
('40018901  ','COMP6522','Artificial Intelligence                           ','B         ',3,'Winter17'),
('40018901  ','SOEN6511','Code Refactoring                                  ','A         ',4,'Summer17'),
('40018901  ','SOEN6522','Software Requirement                              ','A-        ',3.7,'Summer17'),
('40018902  ','COMP6511','Software Design                                   ','B+        ',3.3,'Winter17'),
('40018902  ','COMP6522','Artificial Intelligence                           ','B-        ',2.7,'Winter17'),
('40018902  ','SOEN6511','Code Refactoring                                  ','A         ',4,'Summer17'),
('40018902  ','SOEN6522','Software Requirement                              ','A-        ',3.7,'Summer17'),
('40018903  ','COMP6511','Software Design                                   ','A+        ',4.3,'Winter17'),
('40018903  ','COMP6522','Artificial Intelligence                           ','B         ',3,'Winter17'),
('40018903  ','SOEN6511','Code Refactoring                                  ','A         ',4,'Summer17'),
('40018903  ','SOEN6522','Software Requirement                              ','A-        ',3.7,'Summer17'),
('40018900  ','SOEN6411','Project Management                                ','DISC      ',0,'Fall17'),
('40018902  ','COMP6311','Software Architecture                             ','NA        ',0,'Winter18'),
('40018900  ','COMP6311','Software Architecture                             ','NA        ',0,'Winter18'),
('40018900  ','COMP6322','Machine Learning                                  ','NA        ',0,'Winter18'),
('40018900  ','SOEN6411','Project Management                                ','DISC      ',0,'Fall17'),
('40018900  ','COMP6333','Image Processing                                  ','NA        ',0,'Summer18'),
('40018903  ','COMP6311','Software Architecture                             ','NA        ',0,'Winter18'),
('40018900  ','COMP6311','Software Architecture                             ','A+        ',4.3,'Winter18'),
('40018900  ','COMP6311','Software Architecture                             ','NA        ',0,'Winter18'),
('40018902  ','SOEN6411','Project Management                                ','NA        ',0,'Fall17'),
('40018900  ','INSE6260','Quality Assurance                                 ','A         ',4,'Fall17'),
('40018900  ','COMP6333','Image Processing                                  ','NA        ',0,'Summer18'),
('40018900  ','SOEN6411','Project Management                                ','DISC      ',0,'Fall17'),
('40018900  ','COMP6333','Image Processing                                  ','DISC      ',0,'Fall17'),
('40018900  ','COMP6333','Image Processing                                  ','DISC      ',0,'Fall17'),
('40018900  ','COMP6311','Software Architecture                             ','NA        ',0,'Winter18'),
('40018900  ','COMP6333','Image Processing                                  ','NA        ',0,'Summer18'),
('40018900  ','SOEN6411','Project Management                                ','NA        ',0,'Winter18'),
('40018900  ','INSE6260','Quality Assurance                                 ','A         ',4,'Fall17'),
('40018903  ','COMP6322','Machine Learning                                  ','DISC      ',0,'Winter18');

CREATE TABLE dbo.students (
	StudentId nchar(10) NULL,
	StrudentName nchar(10) NULL,
	Id int NOT NULL IDENTITY(1,1),
	Password varchar(255) NULL
);

ALTER TABLE dbo.students ADD CONSTRAINT PK_students PRIMARY KEY (Id);

-- Add 8 rows for students.
SET IDENTITY_INSERT students ON
INSERT INTO students (StudentId, StrudentName, Id, Password) VALUES 
('40018900  ','JOLIE     ',1,'1'),
('40018901  ','JANNATAN  ',2,'40018901  '),
('40018902  ','SARAH     ',3,'40018902  '),
('40018903  ','ALEX      ',4,'40018903  '),
('400       ','Relling   ',5,'400'),
('401       ','Renewit   ',6,'401'),
('402       ','Dssouli   ',7,'402'),
('500       ','Adviser   ',8,'500');

SET IDENTITY_INSERT students OFF

CREATE TABLE dbo.tuition (
	StudentId nchar(10) NULL,
	Semester varchar(30) NULL,
	CourseId varchar(30) NULL,
	amount real(4) NULL
);

-- Add 2 rows for tuition.
INSERT INTO tuition (StudentId, Semester, CourseId, amount) VALUES 
('40018903  ','Winter18','1',500),
('40018903  ','Winter18','2',500);

