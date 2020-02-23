CREATE TABLE funcionarios(
	id BIGINT auto_increment NOT NULL,
	nome VARCHAR(20) NOT NULL,
	sobrenome VARCHAR(20) NOT NULL,
	data_contratacao VARCHAR(20) NOT NULL,
	tipo VARCHAR(15) NOT NULL,
	local_de_trabalho VARCHAR(20) NOT NULL,
	
	PRIMARY KEY(id)

);