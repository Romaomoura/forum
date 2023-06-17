create table aplicacao(
    id BIGSERIAL PRIMARY KEY,
    nome varchar(50) not null,
    categoria varchar(50) not null
);

insert into aplicacao (nome, categoria) values('Avante', 'TIMEOUT');