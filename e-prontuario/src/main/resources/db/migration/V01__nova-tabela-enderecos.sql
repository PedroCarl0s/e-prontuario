CREATE TABLE enderecos(
	id BIGINT auto_increment NOT NULL,
	rua VARCHAR(40) NOT NULL,
	bairro VARCHAR(40) NOT NULL,
	numero INT,
	
	PRIMARY KEY(id),
    CHECK (idade > 0)
);