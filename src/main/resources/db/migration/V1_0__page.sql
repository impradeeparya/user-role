start transaction;

create table if not exists page_master (
    code varchar(20),
    description varchar(255),
    primary key(code)
);

commit;
