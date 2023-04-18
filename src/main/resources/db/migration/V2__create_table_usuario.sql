create table usuario(
    id BIGSERIAL PRIMARY KEY,
    nome varchar(50) not null,
    email varchar(50) not null
);

insert into usuario (nome, email) values('Romão', 'romao@gmail.com');