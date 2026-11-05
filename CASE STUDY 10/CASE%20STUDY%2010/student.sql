CREATE DATABASE IF NOT EXISTS scsvmv_lab;
USE scsvmv_lab;

CREATE TABLE IF NOT EXISTS student (
    reg_no VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50),
    marks INT
);

INSERT INTO student (reg_no, name, marks)
VALUES ('102', 'Divya', 91);
