INSERT INTO locations (location_id, street_address, city)
VALUES (1, 'Lenina', 'Moscow'),
       (2, 'Sadovaya', 'Balashikha'),
       (3, 'Solnechnaya', 'Adkarsk'),
       (4, 'Solnechnaya', 'Adkarsk');


INSERT INTO departments (department_id, manager_id, department_name, location_id)
VALUES (1, null, 'IT', 1),
       (2, null, 'HR', 2),
       (3, null, 'RND', 3),
       (4, null, 'Client Serivce', 4);


INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES ('HR', 'HR', 10000, 30000),
       ('DEVJAVA', 'JAVA JUNIOR DEVELOPER', 70000, 120000),
       ('JANITOR', 'JANITOR', 10000, 35000),
       ('OPERATOR', 'CALL OPERATOR', 45000, 55000),
       ('ENG', 'ENGINEER', 45000, 75000);
;
INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                       department_id)
VALUES (1, 'Alex', 'Peshnin', 'c@a', '+79267892323', '2020-10-10', 'HR', 10000, 2, 2),
       (2, 'Nikita', 'Petuhov', 'a@b', '+7926789232', '2020-11-11', 'DEVJAVA', 30000, 1, 1),
       (3, 'Nikolay', 'Denisov', 'd@d', '+7926789211', '2020-12-12', 'JANITOR', 10000, 4, 4),
       (4, 'Anton', 'Gajariga', 'v@d', '+7926789211', '2021-01-01', 'OPERATOR', 25000, 3, 3);
INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                       department_id)
VALUES (5, 'Ploxoy', 'Sotrudnik', 's@d', '+7926723211', '2021-01-01', 'HR', 25000, 1, 1);


INSERT INTO job_history(employee_id, start_date, end_date, job_id, department_id)
VALUES (1, '2020-1-1', '2021-1-1', 'HR', 2),
       (2, '2020-1-1', '2021-1-1', 'DEVJAVA', 1),
       (3, '2020-1-1', '2021-1-1', 'JANITOR', 4),
       (4, '2020-1-1', '2021-1-1', 'OPERATOR', 3);


UPDATE departments
SET manager_id = 1
where location_id = 1;
UPDATE departments
SET manager_id = 2
where location_id = 2;
UPDATE departments
SET manager_id = 3
where location_id = 3;
UPDATE departments
SET manager_id = 4
where location_id = 4;


