
CREATE DATABASE IF NOT EXISTS scsvmv_lab;
USE scsvmv_lab;

CREATE TABLE IF NOT EXISTS student (
    reg_no VARCHAR(10) PRIMARY KEY,
    name VARCHAR(40),
    marks INT
);

INSERT IGNORE INTO student VALUES
('101', 'Aravind', 78),
('102', 'Divya', 91);
