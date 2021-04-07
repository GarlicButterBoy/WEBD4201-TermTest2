DROP TABLE IF EXISTS clients;

CREATE TABLE clients(
	firstname VARCHAR(50) NOT  NULL,
	lastname VARCHAR(50) NOT  NULL,
	phoneNumber VARCHAR(20),
	emailAddress VARCHAR(255) NOT  NULL
);
ALTER TABLE clients OWNER TO test2_user;
INSERT INTO clients(firstName, lastName, phoneNumber, emailAddress) VALUES ('Joanie','Sales','905-244-1234', 'joanie.sales@yahoo.com');
INSERT INTO clients(firstName, lastName, phoneNumber, emailAddress) VALUES ('Quentin','Hairfield','416-629-8765', 'quentin.hairfield@gmail.com');
INSERT INTO clients(firstName, lastName, phoneNumber, emailAddress) VALUES ('Robbie','Trenholm','705-432-4567', 'robbie.trenholm@gmail.com');
INSERT INTO clients(firstName, lastName, phoneNumber, emailAddress) VALUES ('Kris','Knighten','905-721-1234', 'kris.knighten@rogers.ca');
INSERT INTO clients(firstName, lastName, phoneNumber, emailAddress) VALUES ('Les','Jara','613-966-5423', 'les.jara@hotmail.com');
SELECT * FROM clients;