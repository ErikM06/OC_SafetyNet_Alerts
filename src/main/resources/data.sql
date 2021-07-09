CREATE TABLE `persons` (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  address VARCHAR(250) DEFAULT NULL,
  city VARCHAR (250) DEFAULT NULL);
 
INSERT INTO persons ( id, name, last_name, address, city)
 VALUES (1,'John','doe','avenue perdu', 'caracelle');