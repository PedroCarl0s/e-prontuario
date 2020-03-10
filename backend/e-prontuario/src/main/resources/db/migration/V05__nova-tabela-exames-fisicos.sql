CREATE TABLE exames_fisicos(
    id BIGINT auto_increment NOT NULL,
    peso DOUBLE NOT NULL,
    altura DOUBLE NOT NULL,
    imc VARCHAR(10) NOT NULL,
    pele VARCHAR(150) NOT NULL DEFAULT '',
    ausculta_cardiovascular VARCHAR(150) NOT NULL DEFAULT '',
    ausculta_respiratoria VARCHAR(150) NOT NULL DEFAULT '',
    extremidades VARCHAR(150) NOT NULL DEFAULT '',
    hipotese_diagnostica VARCHAR(150) NOT NULL DEFAULT '',
    conduta VARCHAR(400) NOT NULL,
    evolucoes VARCHAR(700) NOT NULL,

    PRIMARY KEY(id)
);