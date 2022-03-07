DROP DATABASE IF EXISTS employees;
CREATE DATABASE employees;
USE employees;


INSERT INTO `employee` (`name`, `phone`, `email`) VALUES
('Abdellah', '602569854', 'abdell@random.com'),
('Juan Carlos', '656965235', 'carlos@gmail.com'),
('Pedro', '689543123', 'pedro@gmail.com'),
('Equisde', '689543123', 'equisde@gmail.com'),
('Susana', '689983123', 'sasana997@gmail.com'),
('Helena', '681243123', 'helen@gmail.com'),
('Alberto', '689543128', 'equisde@gmail.com');

SHOW DATABASES;
SELECT * FROM employee;
