create sequence hibernate_sequence start 1 increment 1;
create table score (id int8 not null, author varchar(255) not null, date_str timestamp not null, score int8 not null, primary key (id));
