create table USER
(
	id int auto_increment,
	account_id varchar(100),
	token varchar(36),
	gmt_create bigint,
	gmt_modified bigint,
	bio varchar(256),
	name varchar(50),
	constraint USER_pk
		primary key (id)
);

