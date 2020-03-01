CREATE TABLE prontuarios (
	id BIGINT auto_increment NOT NULL,
	data VARCHAR(10) NOT NULL,
	queixa_principal VARCHAR(30) NOT NULL,
	historia_doenca_atual VARCHAR(40) NOT NULL,
	exame_fisico VARCHAR(70) NOT NULL,
	evolucoes VARCHAR(50) NOT NULL,
	
	PRIMARY KEY(id)
);