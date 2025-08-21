create table course
(
    id bigint not null auto_increment,
    name varchar(255) not null,
    description varchar(500),
    primary key (id)
);