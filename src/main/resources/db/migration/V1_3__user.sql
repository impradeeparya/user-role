start transaction;

create table if not exists user_master(
    user_id varchar(50),
    first_name varchar(255),
    last_name varchar(255),
    role_id varchar(20),
    primary key(user_id),
    constraint fk_um_role foreign key (role_id) references role_master(code)
);

commit ;
