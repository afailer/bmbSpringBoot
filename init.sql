drop database bmb;
create database bmb;
use bmb;
drop table if exists users;
drop table if exists content;
drop table if exists files;
drop table if exists talking;
drop table if exists message;
drop table if exists orders;

create table if not exists users(
    id bigint not null primary key auto_increment,
    phone_num varchar (20) not null UNIQUE,
    password varchar (20) not null,
    user_level int,
    email varchar(30),
    user_name varchar (30),
    wechat_id varchar (50),
    sex int(1),
    idcard_num varchar (20),
    img varchar (100)
);

create table if not exists content(
    id bigint not null primary key auto_increment,
    user_id bigint ,
    title varchar(30),
    content_type varchar(10),
    icon varchar(100),
    content text,
    btn_info varchar(100),
    create_time bigint,
    update_time bigint
);

create table if not exists files(
    id bigint not null primary key auto_increment,
    file_type varchar(6),
    file_name varchar(50),
    content_id bigint,
    user_id bigint
);

create table if not exists talking(
    id bigint not null primary key auto_increment,
    content_id bigint,
    content_user_id bigint,
    user_id bigint,
    detail_info varchar(100),
    send_time bigint
);

create table if not exists message(
    id bigint not null primary key auto_increment,
    content_id bigint,
    content_user_id bigint,
    user_id bigint,
    detail_info varchar (100),
    send_time bigint
);

create table if not exists orders(
    id bigint not null primary key auto_increment,
    content_id bigint not null,
    onwer_user_id bigint,
    customer_user_id bigint
);

insert into users(phone_num, password, user_level, email, user_name, idcard_num) values ('18601302047','lt19900728',0,'18601302047@163.com','andy','142733199007280359')