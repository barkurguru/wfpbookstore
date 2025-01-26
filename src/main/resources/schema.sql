
create table IF NOT EXISTS roles (
    id int  AUTO_INCREMENT PRIMARY KEY , 
    name varchar(255) check (name in ('ROLE_USER','ROLE_MODERATOR','ROLE_ADMIN')) ,
    primary key (id)
);


CREATE TABLE IF NOT EXISTS book (
    id int  AUTO_INCREMENT PRIMARY KEY ,
    title VARCHAR(255) NOT NULL,
    description  VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    price DECFLOAT ,
    coverimage VARCHAR(255)
);