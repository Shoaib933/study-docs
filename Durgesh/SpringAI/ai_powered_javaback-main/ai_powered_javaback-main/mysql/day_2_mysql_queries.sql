#using perticular database
use ecom;


#create employee

create table employee (
emp_id int primary key auto_increment,
name varchar(100) not null,
city varchar(100) ,
department varchar(100)
);

#Show all table of the database
show tables;

#select all employees
select * from employee;
select name, department from employee;
select name as "EMP_NAME" , department as "DEPT" from employee;

#inserting employee
insert into employee(name,city,department) values
('Vivek','Banglore','IT'),
('Awdesh','Banglore','IT'),
('Om prakash','Banglore','Mangement')
;

#advance select queries:

#select the emp of IT department
select * from employee where department = 'IT';

#select the emps of it department and living in banglore

select * from employee where department = 'IT' and city ='Banglore';
# =
# >, <, >=, <= 
#salary > 50000 AND dept='IT'
#dept='IT' OR dept='Sales'
#salary BETWEEN 40000 AND 60000
#dept IN ('IT','HR')

