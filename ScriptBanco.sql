-- Database: ees2019-api

-- DROP DATABASE "ees2019-api";

CREATE DATABASE "ees2019-api"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.UTF-8'
    LC_CTYPE = 'en_US.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Drop table

-- DROP TABLE public.t_cliente;

CREATE TABLE public.t_cliente (
	id numeric NOT NULL,
	cpf varchar(50) NULL,
	nome varchar(255) NULL,
	sobrenome varchar(255) NULL,
	email varchar(255) NULL,
	senha varchar(255) NULL,
	CONSTRAINT t_cliente_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.t_produto;

CREATE TABLE public.t_produto (
	id numeric NOT NULL,
	nome varchar(255) NULL,
	descricao varchar(8000) NULL,
	CONSTRAINT t_produto_pkey PRIMARY KEY (id)
);


-- Drop table

-- DROP TABLE public.t_pedido;

CREATE TABLE public.t_pedido (
	id numeric NOT NULL,
	"data" timestamp NULL,
	id_cliente numeric NULL,
	CONSTRAINT t_pedido_pkey PRIMARY KEY (id)
);

ALTER TABLE public.t_pedido ADD CONSTRAINT fk_cliente FOREIGN KEY (id_cliente) REFERENCES t_cliente(id);


-- Drop table

-- DROP TABLE public.t_item_pedido;

CREATE TABLE public.t_item_pedido (
	id numeric NOT NULL,
	id_pedido numeric NULL,
	id_produto numeric NULL,
	quantidade numeric NULL,
	CONSTRAINT t_item_pedido_pkey PRIMARY KEY (id)
);

ALTER TABLE public.t_item_pedido ADD CONSTRAINT fk_pedido FOREIGN KEY (id_pedido) REFERENCES t_pedido(id);
ALTER TABLE public.t_item_pedido ADD CONSTRAINT fk_produto FOREIGN KEY (id_produto) REFERENCES t_produto(id);


-- DROP SEQUENCE public.seq_cliente;

CREATE SEQUENCE public.seq_cliente
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 18
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.seq_item_pedido;

CREATE SEQUENCE public.seq_item_pedido
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 10
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.seq_pedido;

CREATE SEQUENCE public.seq_pedido
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 12
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.seq_produto;

CREATE SEQUENCE public.seq_produto
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 5
	CACHE 1
	NO CYCLE;