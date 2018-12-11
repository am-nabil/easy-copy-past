DROP TABLE IF EXISTS copy;

CREATE TABLE copy (
  ID IDENTITY PRIMARY KEY,
  MACHINE_IP VARCHAR (20) NOT NULL,
  CONTENT VARCHAR(255) NOT NULL,
  USER_ID VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS users;

create table users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
);
create table roles (
	username varchar(50) not null,
	role varchar(50) not null,
	constraint fk_roles_users foreign key(username) references users(username)
);
create unique index ix_role_username on roles (username,role);