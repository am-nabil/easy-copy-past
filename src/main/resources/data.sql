/*password : test*/
insert into users(username,password, enabled)
	values('admin','$2a$10$5mRi4Zvjs3mtrUepG5CaxupSeKlwAxjzRcQDeQQm0XKnR2O.juC1K', true);
insert into roles(username,role)
	values('admin','ADMIN');

INSERT INTO copy VALUES (1, '120.10.123.14', 'text to copy test', 'admin');