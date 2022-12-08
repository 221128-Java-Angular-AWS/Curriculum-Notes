/* At the top of this script I am dropping the tables if they exist, 
 * so the rest of the script can re-create them. The opposite of IF EXISTS
 * works as well, as seen below.
 */

DROP TABLE IF EXISTS members;
DROP TABLE IF EXISTS songs;
DROP TABLE IF EXISTS artists;

/* Here are the CREATE TABLE statements. These are all DDL, "Data Definition Language", the expressions
 * which define the schema for the database, the shape the data will take.
 * Here we have a SERIAL data type which is PostgreSQL's implementation of an auto incrementing
 * value. Not all SQL flavors implement it in this way (as it's own data type).
 */
CREATE TABLE IF NOT EXISTS artists (
	id SERIAL PRIMARY KEY,
	artist VARCHAR(200)
);

/* All tables have a PRIMARY KEY. This implies UNIQUE and NOT NULL. If we don't specify one, 
 * the database engine probably assigns a PRIMARY KEY which is a composite key of all columns.
 * Note that in this example we add the words PRIMARY KEY to a column in order ot set that column 
 * as the PK. This is a shortcut. We can also write out the entire constraint like this:
 * 		CONSTRAINT pk_songs PRIMARY KEY (id)
 * This would be done after all of the column definitions. We can also make a composite key, 
 * a PRIMARY KEY made up of multiple columns, like this:
 * 		CONSTRAINT pk_songs PRIMARY KEY (id, artist)
 * 
 * Below we also have a FOREIGN KEY constraint. This creates a reference from this table to another
 * table. This enforces "referental integrity". We can still do UNION and/or JOIN without a FOREIGN
 * KEY. The FK will enforce the references, meaning if we try to remove something pointed at by an FK
 * we will get an error. Conversely, if we tried to add an entry to a table that would point at
 * something in another table, that referenced entry must already exist.
 * 
 */
CREATE TABLE IF NOT EXISTS songs (
	id SERIAL PRIMARY KEY,
	artist_id INT,
	title VARCHAR(200) NOT NULL,
	album VARCHAR(200) NOT NULL,
	CONSTRAINT fk_songs_artists FOREIGN KEY (artist_id) REFERENCES artists (id)
);

/* We have seen several data types so far, INT, SERIAL, and VARCHAR. There are many others, and
 * different versions of SQL will implement different data types. Some common data types which 
 * you are likely to see include: 
 * 
 * INT - Integer - whole numbers
 * DECIMAL - decimal values (fractions of whole numbers), written DECIMAL(A,B) 
 * 			 where A is the number of digits, and B is the number of decimal places.
 * FLOAT - Floating point value (similar to decimal, but floats are represented in their own way)
 * DOUBLE PRECISION - Another floating point type with increased precision compared to FLOAT
 * CHAR - String of 0 or more characters. Written "CHAR(X) where X is the length of the strings. 
 * 	 	  Any unused space remains allocated and empty.
 * VARCHAR - String of 0 or more characters. Written "VARCHAR(X) where X is the maximum length of
 * 			 the strings. Unlike CHAR varchar will re-allocate empty space.
 * BLOB - Binary Large OBject. A data type to hold large amounds of binary, for instance to store
 * 		  an image or other serialized complex object.
 * 
 */

CREATE TABLE members (
	id SERIAL PRIMARY KEY,
	artist_id INT,
	"member" VARCHAR(1000),
	CONSTRAINT fk_members_artists FOREIGN KEY (artist_id) REFERENCES artists (id)
);
/* Seen above, double quotes are used in SQL to quote a literal identifier. MEMBER is a SQL keyword,
 * so you can't use it as the name for a table or column unless you "quote" it. When we want to
 * have a string literal that is data in a table, we would use 'single quotes'. 
 * Double quotes for schema, single quotes for data.
 */

/* Below we are inserting data into our tables. Everything above this point is DDL, defining tables,
 * constraints, and relations. The INSERT statements below are DML, Data Manipulation Language. DDL
 * defines schema. Now we use DML to manipulate data.
 */
INSERT INTO artists (artist) VALUES ('Led Zeppelin');
INSERT INTO artists (artist) VALUES ('The Eagles');
INSERT INTO artists (artist) VALUES ('Taylor Swift');
INSERT INTO artists (artist) VALUES ('Disturbed');
INSERT INTO artists (artist) VALUES ('Tool');

INSERT INTO songs (artist_id, title, album) VALUES (4, 'Stupify', 'The Sickness');
INSERT INTO songs (artist_id, title, album) VALUES (4, '10,000 Fists', 'AlbumName');
INSERT INTO songs (artist_id, title, album) VALUES (3, 'Love Story', 'Fearless');
INSERT INTO songs (artist_id, title, album) VALUES (1, 'Kashmir', 'Physical Grafitti');
INSERT INTO songs (artist_id, title, album) VALUES (1, 'D''yer Mak''er', 'Houses of the Holy');

INSERT INTO members (artist_id, "member") VALUES (1, 'Jimmy Page');
INSERT INTO members (artist_id, "member") VALUES (1, 'Robert Plant');
INSERT INTO members (artist_id, "member") VALUES (3, 'Taylor Swift');


/* This next statement is a query, which is DQL - Data Query Language. All queries start with
 * SELECT and produce a "results set". Queries can be very complex, and can pull data from multiple
 * tables if needed. Note that two tables do not have to have a FOREIGN KEY relation to be JOINed
 * as part of a SELECT.
 * 
 */
SELECT * FROM artists
INNER JOIN songs ON songs.artist_id = artists.id
/* Joining is an INTERSECT operation. An INNER JOIN is equivelant to INTERSECT. A JOIN clause always 
 * includes ON. ON tells the databse engine what criteria to use in order to link the two tables 
 * together. There are also other types of JOIN besides INNER.
 * 
 * FULL OUTER JOIN - Selects data from both tables, regardless of the link between them. Missing data 
 * 					 will be shown as NULL.
 * 
 * LEFT JOIN - Selects data from one table, and all linked data in the other table. Data missing from
 * 			   the other table will be shown as NULL.
 * 
 * RIGHT JOIN - Similar to LEFT JOIN, but reversed. All data from the joined table will be shown in
 * 			    the results set. Missing data from the original table will be NULL.
 * 
 * There are also "exclusive joins" which aren't done with their own keyword. You can join a table
 * and then use WHERE clauses to filter what is included. If you wanted to see only the data which
 * is not linked by some JOIN ON criteria, this would be called an exclusive outer join, and could
 * be done like this:
 * 		SELECT * FROM tableA A
 * 		JOIN tableB B ON A.pk = B.pk
 * 		WHERE B.pk IS NULL
 * 		OR B.pk IS NULL
 * Any entry in one table without a corresponding entry in the other table is shown in the results set.
 * Those entries which are linked are excluded.
 */


/* We can use foreign keys to enforce referential integrity so that we have relationships between tables.
 * There are three types of this relationship that can be implemented depending on how you define the
 * tables and constraints.
 * One-to-One - foreign key constraint where the foreign key column is unique.
 * One-to-many - foreign key constraint where the foreign key is not unique, 
 * 		so that we could have many entries in one table referencing a single entry in another table
 * Many-to-many - relation between tables often requiring a junction table, a third table just to 
 * 		link entries in either of the other two tables
 * 
 * Above we have seen examples of one-to-many relationships, like one artist having written many songs.
 * Below is an example of three tables which form a many-to-many relationship.
 */
DROP TABLE IF EXISTS teachers_students;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS teachers;

CREATE TABLE students (
	student_id SERIAL PRIMARY KEY,
	"student_name" VARCHAR(200)
);

CREATE TABLE teachers (
	teacher_id SERIAL PRIMARY KEY,
	"teacher_name" VARCHAR(200)
);

CREATE TABLE teachers_students (
	id SERIAL PRIMARY KEY,
	teacher_id INT,
	student_id INT,
	CONSTRAINT fk_teachers_students_teachers FOREIGN KEY (teacher_id) REFERENCES teachers (teacher_id),
	CONSTRAINT fk_teachers_students_students FOREIGN KEY (student_id) REFERENCES students (student_id)
);
/* These two foreign key constraints link the other two tables together, using this table
 * as a "middle-man" to establish links between entries in both tables. Note that the junction
 * table is dependent on entries in the other two tables. We can't add a link to this table unless
 * there are corresponding entries in the other two.
 * 
 */


INSERT INTO students (student_name) VALUES ('Gimli');
INSERT INTO students (student_name) VALUES ('Legolas');
INSERT INTO students (student_name) VALUES ('Bilbo');
INSERT INTO students (student_name) VALUES ('Faramir');
INSERT INTO students (student_name) VALUES ('Samwise');
INSERT INTO students (student_name) VALUES ('Frodo');
INSERT INTO students (student_name) VALUES ('Boromir');

INSERT INTO teachers (teacher_name) VALUES ('Gandalf');
INSERT INTO teachers (teacher_name) VALUES ('Saruman');
INSERT INTO teachers (teacher_name) VALUES ('Aragorn');

INSERT INTO teachers_students (teacher_id, student_id) VALUES (1, 2);
INSERT INTO teachers_students (teacher_id, student_id) VALUES (1, 3);
INSERT INTO teachers_students (teacher_id, student_id) VALUES (1, 5);
INSERT INTO teachers_students (teacher_id, student_id) VALUES (2, 2);
INSERT INTO teachers_students (teacher_id, student_id) VALUES (2, 4);
INSERT INTO teachers_students (teacher_id, student_id) VALUES (2, 5);
INSERT INTO teachers_students (teacher_id, student_id) VALUES (3, 1);





/* We can join these tables without the FOREIGN KEY references, those just enforce the relationship
 * so the link between the tables is always valid. 
 */
SELECT teacher_name, student_name FROM teachers T
JOIN teachers_students TS ON T.teacher_id = TS.teacher_id
JOIN students s ON TS.student_id = S.student_id


/* Below we are using a sub-query to find out who else has classes with Bilbo.
 * Queries can use the results of other queries to return complex results sets. Here we
 * are saying we want to select those students who are taught by certain teachers,
 * those that have Bilbo as a student. 
 * 
 * WHERE clauses are predicates, and can be chained together to form compound predicates using
 * the logical operators AND as well as OR. Below, the outer query, filtering to only 
 * select teachers who have Bilbo as a student, is combined with the last line in order to
 * remove Bilbo from the final results. We want to see his classmates, we don't need him in the 
 * results. Note that the two queries are completely separate. One filters in only results where
 * Bilbo is the student, but the other filters him out. Run this query to see that it does work.
 */
SELECT student_name FROM teachers T
JOIN teachers_students TS ON T.teacher_id = TS.teacher_id
JOIN students s ON TS.student_id = S.student_id
WHERE T.teacher_name IN 
(
	SELECT teacher_name FROM teachers T
	JOIN teachers_students TS ON T.teacher_id = TS.teacher_id
	JOIN students s ON TS.student_id = S.student_id
	WHERE S.student_name = 'Bilbo'
)
AND S.student_name != 'Bilbo';





/* Aggregate and scalar funcitons 
 * scalar functions:
 * UCASE() - takes in a string, outputs capital letter version of string
 * LCASE() - takes in a string, outputs lowercase letter version of string
 * TRIM() - takes in a string, outputs string with leading and trailing whitespace removed
 * FLOOR() - rounds a decimal down to lower whole number
 * CEILING() - rounds decimal up to next whole number
 * LEN() - returns the length of a string
 * 
 * aggregate functions:
 * MIN() - takes in many values, outputs the least value among them
 * MAX() - takes in many values, outputs the greatest value among them
 * COUNT() - takes in many values, outputs the count of how many
 * SUM() - takes in many numeric values, outputs the sum of the inputs
 * AVG() - takes in many numeric values, outputs the average value of all inputs
 */


DROP TABLE IF EXISTS employees;
CREATE TABLE employees (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(200),
	last_name VARCHAR(200),
	salary DECIMAL(10,2),
	manager VARCHAR(200)
);


INSERT INTO employees (first_name, last_name, salary, manager) VALUES ('Kyle', 'Plummer', '200.00', 'Carolyn Rehm');
INSERT INTO employees (first_name, last_name, salary, manager) VALUES ('Kevin', 'Childs', '550000.00', 'Carolyn Rehm');
INSERT INTO employees (first_name, last_name, salary, manager) VALUES ('Tiffany', 'Obi', '400000.00', 'Carolyn Rehm');
INSERT INTO employees (first_name, last_name, salary, manager) VALUES ('Henry', 'Heish', '300000.00', 'Andrew Crewelge');
INSERT INTO employees (first_name, last_name, salary, manager) VALUES ('John', 'G', '200000.00', 'Andrew Crewelge');

/* Here we can see an example using the HAVING clause. HAVING is jsut like WHERE, but is done after
 * aggregation of data. WHERE is done before. In this example we use the WHERE clause to filter out
 * the employee with the last name "Plummer". We then GROUP our results based on the "manager" column.
 * After aggregation (which makes changes to our results set) we use HAVING to do filtering
 * based on the newly aggregated data. 
 */

SELECT COUNT(*), manager FROM employees 
WHERE last_name != 'Plummer' 
GROUP BY manager 
HAVING COUNT(*) > 1





/* SQL Views
 * 
 */
CREATE VIEW rich_people AS
SELECT * FROM employees 
WHERE salary > 200000;

INSERT INTO employees (first_name, last_name, salary, manager) VALUES ('Sam', 'Smith', '280000.00', 'Andrew Crewelge');

SELECT * FROM rich_people








/* Set Operations
 * 
 */
DROP TABLE IF EXISTS top_rated_films;
CREATE TABLE top_rated_films (
	film_id SERIAL,
	title VARCHAR(200),
	"year" VARCHAR(4),
	CONSTRAINT pk_top_rated_films PRIMARY KEY (film_id)
);

INSERT INTO top_rated_films (title, "year") VALUES ('The Shawshank Redemption', 1994);
INSERT INTO top_rated_films (title, "year") VALUES ('The Godfather', 1972);
INSERT INTO top_rated_films (title, "year") VALUES ('12 Angry Men', 1957);

DROP TABLE IF EXISTS most_popular_films;
CREATE TABLE most_popular_films (
	film_id SERIAL PRIMARY KEY,
	title VARCHAR(200),
	"year" VARCHAR(4)
);

INSERT INTO most_popular_films (title, "year") VALUES ('An American Pickle', 2020);
INSERT INTO most_popular_films (title, "year") VALUES ('The Godfather', 1972);
INSERT INTO most_popular_films (title, "year") VALUES ('Greyhound', 2020);


/* INTERSECT
 * 
 */
SELECT * FROM top_rated_films 
INTERSECT
SELECT * FROM most_popular_films


/* Union
 * 
 */
SELECT * FROM top_rated_films 
UNION
SELECT * FROM most_popular_films