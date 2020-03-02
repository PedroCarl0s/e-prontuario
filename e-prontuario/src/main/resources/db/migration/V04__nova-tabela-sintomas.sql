CREATE TABLE sintomas(
    id BIGINT auto_increment NOT NULL,
    geral VARCHAR(150) NOT NULL DEFAULT '',
    pele VARCHAR(150) NOT NULL DEFAULT '',
    cabeca_e_pescoco VARCHAR(150) NOT NULL DEFAULT '',
    face_olhos_ouvidos_boca VARCHAR(350) NOT NULL DEFAULT '',
    ap_cardiovascular VARCHAR(350) NOT NULL DEFAULT '',
    ap_respiratorio VARCHAR(350) NOT NULL DEFAULT '',
    ap_digestivo VARCHAR(350) NOT NULL DEFAULT '',
    ap_genito_urinario VARCHAR(350) NOT NULL DEFAULT '',
    ap_musculo_esqueletico VARCHAR(350) NOT NULL DEFAULT '',
    ap_sist_nervoso_psiquismo VARCHAR(350) NOT NULL DEFAULT '',

    PRIMARY KEY(id)
);