drop table if exists company;
drop table if exists category;
drop table if exists description;
drop table if exists location;
drop table if exists product;
drop table if exists provider;
drop table if exists stock;
drop table if exists productname;

create table location (location_id int not null auto_increment,
                       address_line_A varchar(150) not null,
                       address_line_B varchar(150) not null,
                       city varchar(150) not null,
                       country varchar(150) not null,
                       primary key (location_id)
);

create table company(company_id int not null auto_increment,
                     company_name varchar(150) not null,
                     market_cap int not null,
                     company_website varchar(200) not null,
                     location_id int not null ,
                     primary key (company_id),
                     foreign key(location_id) references location(location_id)
);

create table description(description_id int not null auto_increment,
                     text varchar(350) not null,
                     primary key (description_id)

);




create table category(category_id int not null auto_increment,
                     category_name varchar(150) not null,
                     description_id int not null,
                     primary key (category_id),
                     foreign key(description_id) references description(description_id)
);

create table productname(productname_id int not null auto_increment,
                     company_name varchar(150) not null,
                     product varchar(150) not null,
                     primary key (productname_id)

);

create table stock(stock_id int not null auto_increment,
                     stock_marketcap int not null,
                     stock_number int not null,
                     primary key (stock_id)


);

create table provider(provider_id int not null auto_increment,
                     provider_name varchar(150) not null,
                     location_id int not null,
                     description_id int not null,
                     primary key (provider_id),
                    foreign key(description_id) references description(description_id),
                    foreign key(location_id) references location(location_id)

);



create table product(product_id int not null auto_increment,
                     productname_id int not null,
                     stock_id int not null ,
                     description_id int not null ,
                     quantity varchar (100) not null,
                     primary key (product_id),
                     foreign key(productname_id) references productname(productname_id),
                     foreign key(stock_id) references stock(stock_id),
                     foreign key(description_id) references description(description_id)
);