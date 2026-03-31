-- Create database
CREATE DATABASE company;

USE company;

-- Create employees table
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    salary DOUBLE
);

-- Insert sample data
INSERT INTO employees (employee_id, name, department, salary) VALUES
(1, 'Rahul', 'IT', 50000),
(2, 'Priya', 'HR', 45000),
(3, 'Amit', 'Finance', 60000),
(4, 'Neha', 'Marketing', 48000),
(5, 'Karan', 'Operations', 52000);
