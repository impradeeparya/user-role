start transaction;

insert into page_master(code, description) values('Users', 'Users');
insert into page_master(code, description) values('User', 'User');
insert into page_master(code, description) values('Add_User', 'Add User');
insert into page_master(code, description) values('Edit_User', 'Edit User');

insert into page_master(code, description) values('Roles', 'Roles');
insert into page_master(code, description) values('Role', 'Role');
insert into page_master(code, description) values('Add_Role', 'Add Role');
insert into page_master(code, description) values('Edit_Role', 'Edit Role');

insert into module_master(code, description) values('Users', 'Users');
insert into module_master(code, description) values('Profiles', 'Profiles');

insert into module_page(module_id, page_id) values('Users', 'Users');
insert into module_page(module_id, page_id) values('Users', 'User');
insert into module_page(module_id, page_id) values('Users', 'Add_User');
insert into module_page(module_id, page_id) values('Users', 'Edit_User');

insert into module_page(module_id, page_id) values('Profiles', 'Roles');
insert into module_page(module_id, page_id) values('Profiles', 'Role');
insert into module_page(module_id, page_id) values('Profiles', 'Add_Role');
insert into module_page(module_id, page_id) values('Profiles', 'Edit_Role');

commit;
