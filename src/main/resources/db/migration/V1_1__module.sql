start transaction;

create table if not exists module_master(
    code varchar(20),
    description varchar(255),
    primary key(code)
);


create table if not exists module_page(
    module_id varchar(20),
    page_id varchar(20),
    primary key(module_id, page_id),
    constraint fk_mp_module foreign key (module_id) references module_master(code),
    constraint fk_mp_page foreign key (page_id) references page_master(code)
);
commit;
