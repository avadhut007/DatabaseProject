
-- Business Goal 1 --
-- Profit or loss of each branch

select r.name as BranchName, emp.branchid as BranchId, (total_sales - total_salary - total_expense) as profit
from
(select em.branchid,sum(em.salary) as total_salary
from F21_S003_7_Employee em
Group by em.branchid ) emp inner join 
(select ex.branchid , sum(ex.cost) as total_expense
from F21_S003_7_Expenses ex
where ex.expensedate like '%20'
Group by ex.branchid) exp
on emp.branchid = exp.branchid
inner join 
(select t.branchid, sum(price) as total_sales
from F21_S003_7_Orders o , F21_S003_7_Transactions t
where o.customerid = t.customerid
group by t.branchid) or_tr
on or_tr.branchid = exp.branchid
inner join F21_S003_7_RestaurantBranch r
on r.branchid = exp.branchid;


-- Business Goal 2 --
-- Branch with highest Revenue 

select r.name, r.branchid, rev.revenue from F21_S003_7_RestaurantBranch r inner join
(select branchid, sum(price) as revenue
from F21_S003_7_Orders o , F21_S003_7_Transactions t
where o.customerid = t.customerid
group by rollup(branchid)
order by revenue desc) rev
on r.branchid = rev.branchid
fetch first 1 row only;

-- Business Goal 3 --
-- Which Dish makes more Revenue 

select d.dishname,
(select sum(o.price)
from F21_S003_7_Orders o
where d.dishid = o.dishid
group by o.dishid ) as revenue
from F21_S003_7_Dishes d 
order by revenue desc 
fetch first 1 row only;

-- Business Goal 4 --
-- Which time of the day gets more orders (rush hours for restaurants)

select time, count(orderid) as no_of_orders
from F21_S003_7_Orders 
group by time 
having count(orderid) = 
(select max(count(a.orderid)) 
from F21_S003_7_Orders a group by a.time);


-- Business Goal 5 --
-- Which day of the week has less Orders
select count(orderid) as total_orders , weekday
from F21_S003_7_Orders 
group by weekday 
order by count(orderid) asc 
fetch first 1 row only;


-- Business Goal 6 --
-- Which are our regular customers?

select c.fname, c.lname, ord.customerid, ord.No_Of_Orders
from F21_S003_7_Customer c inner join
(select customerid, count(orderid) as No_Of_Orders
from F21_S003_7_Orders
group by rollup(customerid)
having count(orderid) >=2 ) ord
on ord.customerid  = c.customerid;

-- Business Goal 7 --
-- Which branch has more expenses?

select r.name,
(select sum(e.cost)
from F21_S003_7_Expenses e
Where expensedate like '%-20'
and r.branchid = e.branchid
group by e.branchid ) as total_expense
from F21_S003_7_RestaurantBranch r
order by total_expense desc 
fetch first 1 row only;


-- Business Goal 8 --
-- Show running total_sales by date

select orderdate , price as price_per_order , sum(price) over (order by orderdate) as Total_sales 
from F21_S003_7_Orders;


-- Business Goal 9 --
-- Count Number of Employees in Each branch

select r.name as branch_name, e.branchid, count(e.empid) over (partition by e.branchid) as no_of_employees 
from F21_S003_7_Employee e inner join F21_S003_7_RestaurantBranch r 
on r.branchid = e.branchid;

