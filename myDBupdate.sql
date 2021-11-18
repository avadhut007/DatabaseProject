---Goal-1, Goal-2, Goal-3 updated----
update F21_S003_7_Orders set price = 120 where dishid = 1122;
update F21_S003_7_Orders set price = 80 where dishid = 1133;

----Goal-4 updated-----
update F21_S003_7_Orders set time = '18:40' where orderid = 1001;
update F21_S003_7_Orders set time = '18:40' where orderid = 1002;
update F21_S003_7_Orders set time = '18:40' where orderid = 1003;
update F21_S003_7_Orders set time = '18:40' where orderid = 1004;

-----Goal-5 updated-----
update F21_S003_7_Orders set weekday = 'Monday' where orderid = 1003;
update F21_S003_7_Orders set weekday = 'Monday' where orderid = 1004;
update F21_S003_7_Orders set weekday = 'Monday' where orderid = 1013;

-----Goal-6 updated-----
insert into F21_S003_7_Orders (customerid , dishid ,  price , orderid , orderdate, weekday, time) values(515, 1133, 8, 1026, '01-OCT-2020', 'Monday',  '18:40');
insert  into F21_S003_7_Transactions(customerid , branchid , tax , modeofpayment , transactionid) values (515, 40, 4, 'card',   2026);
insert into F21_S003_7_Orders (customerid , dishid ,  price , orderid , orderdate, weekday, time) values(514, 1122, 8, 1027, '01-OCT-2020', 'Monday',  '18:40');
insert  into F21_S003_7_Transactions(customerid , branchid , tax , modeofpayment , transactionid) values (514, 40, 4, 'card',   2027);

-----Goal-7 updated-----
update  F21_S003_7_Expenses set cost = 200 where expid = 25;
