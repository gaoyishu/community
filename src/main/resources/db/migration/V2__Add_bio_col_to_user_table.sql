alter table PERSON alter column NAME VARCHAR(50) not null;

alter table PERSON rename to USER;

alter table USER
	add ACCOUT_ID VARCHAR(100);

alter table USER
	add TOKEN VARCHAR(36);

alter table USER
	add GMT_CREATE BIGINT;

alter table USER
	add GMT_MODIFIED BIGINT;

alter table USER
	add BIO VARCHAR(256);

alter table USER
	add constraint USER_pk
		primary key (ID);