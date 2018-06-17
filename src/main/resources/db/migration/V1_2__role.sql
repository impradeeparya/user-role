start transaction;

create table if not exists role_master(
    code varchar(20),
    description varchar(255),
    primary key(code)
);

create table if not exists permission(
    id bigint auto_increment,
    module_id varchar(20),
    page_id varchar(20),
    read_allowed tinyint default 0,
    write_allowed tinyint default 0,
    edit_allowed tinyint default 0,
    delete_allowed tinyint default 0,
    primary key(id),
    constraint fk_rm_module foreign key (module_id) references module_master(code),
    constraint fk_rm_page foreign key (page_id) references page_master(code)
);


create table if not exists role_permission_jn(
    role_id varchar(20),
    permission_id bigint,
    primary key(role_id, permission_id),
    constraint fk_rpjn_role foreign key (role_id) references role_master(code),
    constraint fk_rpjn_module foreign key (permission_id) references permission(id)
);


commit ;
