CREATE TABLE role(
    id BIGSERIAL PRIMARY KEY,
    nome varchar(50) not null
);

INSERT INTO role(nome) VALUES('LEITURA_ESCRITA');