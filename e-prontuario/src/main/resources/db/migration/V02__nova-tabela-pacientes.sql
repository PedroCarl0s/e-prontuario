CREATE TABLE pacientes(
	id BIGINT auto_increment NOT NULL,
	nome VARCHAR(20) NOT NULL,
	sobrenome VARCHAR(20) NOT NULL,
	data_nascimento VARCHAR(10) NOT NULL,
	idade INT NOT NULL,
	naturalidade VARCHAR(35) NOT NULL,
	procedencia VARCHAR(30) NOT NULL,
	profissao VARCHAR(30) NOT NULL,
	nome_mae VARCHAR(35) NOT NULL,
	id_endereco BIGINT NOT NULL,

	PRIMARY KEY(id),
	FOREIGN KEY (id_endereco) REFERENCES enderecos(id),
    CHECK (idade > 0)
);