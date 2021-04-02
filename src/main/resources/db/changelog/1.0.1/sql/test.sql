-- тут лежат запросы для тестирования и копирования в myBatis
drop table departments cascade;
drop table locations cascade;
drop table job_history cascade;
drop table jobs cascade;
drop table employees cascade;

select department_name, first_name, last_name, employee_id, city, street_address
from employees
         inner join
     departments d on employees.employee_id = d.manager_id
         inner join locations l on l.location_id = d.location_id
where d.department_id = 1;

select department_name, first_name, last_name, employee_id, city, street_address
from departments
         inner join employees e on departments.manager_id = e.employee_id
         inner join locations l on l.location_id = departments.location_id
where last_name = 'Peshnin';

select department_name, first_name, last_name, employee_id, city, street_address
from departments
         inner join employees e on departments.manager_id = e.employee_id
         inner join locations l on l.location_id = departments.location_id
where department_name = 'IT'

select department_name, first_name, last_name, employee_id, city, street_address
from departments
         inner join employees e on departments.manager_id = e.employee_id
         inner join locations l on l.location_id = departments.location_id;


insert into departments(department_id, department_name, manager_id, location_id)
VALUES ()

UPDATE departments
SET department_name = value1,
    manager_id      = value2,
    location_id     = value3
WHERE department_id = value4;

select jh.employee_id,
       first_name,
       last_name,
       email,
       phone_number,
       hire_date,
       employees.job_id,
       salary,
       d.department_id,
       department_name,
       start_date,
       end_date

from employees
         inner join departments d on d.department_id = employees.department_id
         inner join locations l on l.location_id = d.location_id
         inner join job_history jh on employees.employee_id = jh.employee_id
where employees.employee_id = 1;

insert into employees(employee_id, first_name, last_name,
                      email, phone_number, hire_date,
                      job_id, salary, manager_id, department_id)
VALUES (7, 'a', 'b', 'c', 'd', '2020-01-01', null, 10000, 1, 1);

insert into jobs(job_id, job_title, min_salary, max_salary)
VALUES ( 'CLEAN','Cleaner',10000,20000
       );

select * from jobs where job_id = 'HR';
select * from job_history;
update employees set first_name = #{}, last_name = #{}, email = #{},
    phone_number = #{}, hire_date= #{}, job_id = #{}, salary = #{},
    manager_id #{}, department_id = #{} where employee_id = #{id};


insert into job_history(employee_id, start_date, end_date, job_id, department_id) VALUES (
1, hireDate, current_date, 'HR', 1
                                                                                         )

     select distinct on (employees.employee_id) employees.employee_id, first_name, last_name,
                    email, phone_number, hire_date,       
                    employees.job_id, salary, d.department_id,       
                    department_name,
                                                start_date,
                                                end_date
             from employees       
                      inner join departments d on d.department_id = employees.department_id       
                      inner join locations l on l.location_id = d.location_id
                        left join job_history jh on employees.employee_id = jh.employee_id
             ;

select distinct on (employees.employee_id) employees.employee_id, first_name, last_name,
                                           email, phone_number, hire_date,
                                           employees.job_id, salary, d.department_id,
                                           department_name,
                                           start_date,
                                           end_date
from employees
         inner join departments d on d.department_id = employees.department_id
         inner join locations l on l.location_id = d.location_id
         left join job_history jh on employees.employee_id = jh.employee_id
where email = 'string';
;

