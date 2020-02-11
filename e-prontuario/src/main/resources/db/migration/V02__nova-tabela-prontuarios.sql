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