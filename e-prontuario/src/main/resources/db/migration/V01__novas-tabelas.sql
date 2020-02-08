CREATE TABLE IF NOT EXISTS pacientes(
	id BIGINT auto_increment NOT NULL,
	nome VARCHAR(20) NOT NULL,
	sobrenome VARCHAR(20) NOT NULL,
	data_nascimento VARCHAR(10) NOT NULL,
	idade INT NOT NULL,
	naturalidade VARCHAR(25) NOT NULL,
	procedencia VARCHAR(30) NOT NULL,
	profissao VARCHAR(30) NOT NULL,
	nome_mae VARCHAR(35) NOT NULL,

	PRIMARY KEY(id),
    CHECK (idade > 0)
);


CREATE TABLE IF NOT EXISTS prontuarios (
	id BIGINT auto_increment NOT NULL,
	nome_paciente VARCHAR(30) NOT NULL,
	data VARCHAR(10) NOT NULL,
	queixa_principal VARCHAR(30) NOT NULL,
	historia_doenca_atual VARCHAR(40) NOT NULL,
	interrogatorio_sintomatoligico VARCHAR(60) NOT NULL,
	exame_fisico VARCHAR(70) NOT NULL,
	evolucoes VARCHAR(50) NOT NULL,
	
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS funcionarios(
	id BIGINT auto_increment NOT NULL,
	nome VARCHAR(20) NOT NULL,
	sobrenome VARCHAR(20) NOT NULL,
	data_contratacao VARCHAR(20) NOT NULL,
	tipo VARCHAR(15) NOT NULL,
	local_de_trabalho VARCHAR(20) NOT NULL,
	
	PRIMARY KEY(id)

);