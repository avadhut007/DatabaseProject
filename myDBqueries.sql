
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

