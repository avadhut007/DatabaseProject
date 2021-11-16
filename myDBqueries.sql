
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



