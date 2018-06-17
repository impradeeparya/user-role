start transaction;

create table if not exists user_master(
    user_id varchar(50),
    first_name varchar(255),
    last_name varchar(255),
    primary key(user_id)
);

create table if not exists user_role(
    user_id varchar(50),
    role_id varchar(20),
    primary key(user_id, role_id),
    constraint fk_ur_user foreign key (user_id) references user_master(user_id),
    constraint fk_ur_role foreign key (role_id) references role_master(code)
);

commit ;
