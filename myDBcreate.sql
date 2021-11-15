create table F21_S003_7_Person (
fname varchar(20) not null ,lname varchar(20) not null ,dob date, address varchar(50) not null,
primary key (fname, lname));

create table F21_S003_7_Customer (customerid int, orderid int, fname varchar(20) not null ,lname varchar(20) not null ,
primary key (customerid) ,
foreign key(fname,lname) references F21_S003_7_Person(fname,lname) on delete cascade);

create table F21_S003_7_Department (deptid int  not null, deptname varchar(20) not null, branchname varchar(20) not null, managerid int not null,
primary key (deptid));

create table F21_S003_7_RestaurantBranch ( branchid int not null, name varchar(20) not null, location varchar(20) not null, noofchair int not null, tableid int not null,
primary key(branchid));

create table F21_S003_7_Dishes ( dishid int not null,  dishname varchar(30) not null , receipe varchar(1500) not null, creationdate date,
primary key(dishid));

create table F21_S003_7_Person_email ( fname varchar(20) not null ,lname varchar(20) not null, email varchar(20) not null ,
primary key(fname, lname, email),
foreign key(fname,lname) references F21_S003_7_Person(fname,lname) on delete cascade);

create table F21_S003_7_Person_Phonenumber ( fname varchar(20) not null ,lname varchar(20) not null, phonenumber varchar(20) not null,
primary key(fname, lname, phonenumber),
foreign key(fname,lname) references F21_S003_7_Person(fname,lname) on delete cascade);

create table F21_S003_7_Employee ( empid int not null, ssn int not null,fname varchar(20) not null ,lname varchar(20) not null ,sex char(1),  role varchar(20) not null,
salary int not null, branchid int not null, managerid int not null, deptid int not null,
primary key(empid),
foreign key(deptid) references F21_S003_7_Department (deptid) on delete cascade,
foreign key(fname,lname) references F21_S003_7_Person(fname,lname) on delete cascade);

create table F21_S003_7_Dishes_Ingredients ( dishid int not null,  ingredients varchar(1500) not null,
primary key(dishid, ingredients),
foreign key(dishid) references F21_S003_7_Dishes(dishid) on delete cascade);

create table F21_S003_7_Expenses ( expid int not null,  branchid int not null, cost int not null, name varchar(20) not null, expensedate date,
primary key(expid, branchid),
foreign key(branchid) references F21_S003_7_RestaurantBranch(branchid) on delete cascade);

create table F21_S003_7_Customer_Dishes (customerid int not null, dishid int not null,  price int not null, orderid int not null, orderdate date, weekday varchar(20) not null,
time varchar(20) not null,
primary key(customerid , dishid),
foreign key(customerid) references F21_S003_7_Customer(customerid) on delete cascade, foreign key (dishid) references F21_S003_7_Dishes(dishid) on delete cascade);

create table F21_S003_7_Customer_RestaurantBranch(customerid int not null, branchid int not null, tax int not null, modeofpayment varchar(10) not null, transactionid int not null,
primary key(transactionid),
foreign key(customerid) references F21_S003_7_Customer (customerid) on delete cascade,
foreign key(branchid) references F21_S003_7_RestaurantBranch (branchid) on delete cascade);


create table F21_S003_7_RestaurantBranch_Dishes (branchid int not null, dishid int not null,
primary key(branchid,dishid),
foreign key(branchid) references F21_S003_7_RestaurantBranch (branchid) on delete cascade, foreign key (dishid) references F21_S003_7_Dishes(dishid) on delete cascade);
