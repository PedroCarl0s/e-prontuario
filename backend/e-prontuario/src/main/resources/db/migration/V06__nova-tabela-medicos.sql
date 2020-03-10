CREATE TABLE medicos(
	id BIGINT auto_increment NOT NULL,
	nome VARCHAR(20) NOT NULL,
	sobrenome VARCHAR(20) NOT NULL,
	crm VARCHAR(10) NOT NULL,
    uf CHAR(2) NOT NULL,
    municipio VARCHAR(30) NOT NULL,
    status CHAR(1) NOT NULL,
    
	PRIMARY KEY(id)
);