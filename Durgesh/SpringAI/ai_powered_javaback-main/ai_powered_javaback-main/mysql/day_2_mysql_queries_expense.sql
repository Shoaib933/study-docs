select * from expense;

select * from expense where amount between 40000 and 100000;

#LIKE
#_   : single character 
#%   : zero or more characters
# A%

select * from expense where title LIKE 'm%';
select * from expense where title LIKE '%16';
select * from expense where title LIKE '_a%';

#sorting:
select * from expense order by amount desc;
select * from expense order by title desc;

#pagination
select * from expense;
select * from expense limit 3;
select * from expense limit 3 offset 2;

#operations
#Aggregate functions
#SUM(), COUNT(), MAX(), MIN(), AVG()

select SUM(amount) as "TOTAL EXPENSE" from expense;
select COUNT(amount) as "TOTAL EXPENSE" from expense;

select MAX(amount) from expense;

#advance queries:
select MAX(amount) from expense;
#Nested queries
select * from expense where amount = (select MAX(amount) from expense);

#advance queries:
Select payment_method , SUM(amount) from expense GROUP BY payment_method;
#Payment mehtod wise sum: 
Select payment_method , SUM(amount) 
from expense 
GROUP BY payment_method 
having  SUM(amount) >50000;


#second largest:
select * from expense;
select * from expense order by amount desc limit 1 offset 1;

select * from expense where amount = (select MAX(amount) as second_largest 
from expense
where amount < (select MAX(amount) from expense));

