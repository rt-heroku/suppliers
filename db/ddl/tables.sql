-- public.account definition

-- Drop table

-- DROP TABLE public.account;

CREATE TABLE public.account (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	taxid varchar NOT NULL,
	address varchar NULL,
	address2 varchar NULL,
	city varchar NULL,
	state varchar NULL,
	country_id int4 NULL,
	zip varchar NULL,
	phone varchar NULL,
	mobile varchar NULL,
	email varchar NULL,
	website varchar NULL,
	account_type int4 NOT NULL,
	created_date varchar NOT NULL,
	status int4 NOT NULL,
	notes varchar NULL
);


-- public.bank definition

-- Drop table

-- DROP TABLE public.bank;

CREATE TABLE public.bank (
	id serial4 NOT NULL,
	banco varchar NOT NULL,
	"name" varchar NOT NULL,
	initial_date date NULL,
	end_date date NULL
);


-- public.bank_info definition

-- Drop table

-- DROP TABLE public.bank_info;

CREATE TABLE public.bank_info (
	id serial4 NOT NULL,
	bank_id int4 NOT NULL,
	"name" varchar NOT NULL,
	description varchar NULL,
	routing varchar NULL,
	account varchar NOT NULL,
	active bool NOT NULL,
	max_amount float8 NOT NULL,
	country int4 NOT NULL,
	is_clabe bool NULL,
	account_id int4 NOT NULL
);


-- public.contact definition

-- Drop table

-- DROP TABLE public.contact;

CREATE TABLE public.contact (
	id serial4 NOT NULL,
	account_id int4 NOT NULL,
	first_name varchar NOT NULL,
	last_name varchar NOT NULL,
	birthday date NOT NULL,
	taxid varchar NULL,
	email varchar NOT NULL,
	phone varchar NOT NULL,
	contact_type int4 NOT NULL,
	"name" varchar(50) NULL,
	"last name" varchar(50) NULL,
	address varchar(50) NULL,
	address2 varchar(50) NULL,
	city varchar(50) NULL,
	state varchar(50) NULL,
	country_id int4 NULL,
	zip int4 NULL,
	mobile varchar(50) NULL,
	website varchar(50) NULL,
	account_type int4 NULL
);


-- public.country definition

-- Drop table

-- DROP TABLE public.country;

CREATE TABLE public.country (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	code varchar NOT NULL,
	phone_code int4 NOT NULL
);


-- public.payments definition

-- Drop table

-- DROP TABLE public.payments;

CREATE TABLE public.payments (
	id serial4 NOT NULL,
	reference varchar NOT NULL,
	status int4 NOT NULL,
	amount float8 NOT NULL,
	created_date date NOT NULL,
	payment_date date NOT NULL,
	bank_info_id int4 NOT NULL,
	account_id int4 NOT NULL
);


-- public.salesmen definition

-- Drop table

-- DROP TABLE public.salesmen;

CREATE TABLE public.salesmen (
	id serial4 NOT NULL,
	first_name varchar NOT NULL,
	last_name varchar NULL,
	notes varchar NULL,
	city varchar NULL,
	state varchar NULL,
	email varchar NOT NULL,
	phone varchar NOT NULL,
	active bool NOT NULL DEFAULT true,
	CONSTRAINT salesmen_pk PRIMARY KEY (id)
);


-- public."types" definition

-- Drop table

-- DROP TABLE public."types";

CREATE TABLE public."types" (
	id int4 NOT NULL,
	"type" varchar NOT NULL,
	"name" varchar NOT NULL,
	description varchar NULL
);