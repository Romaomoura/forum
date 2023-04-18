create table curso(
    id BIGSERIAL PRIMARY KEY,
    nome varchar(50) not null,
    categoria varchar(50) not null
);

insert into curso (nome, categoria) values('Kotlin', 'PROGRAMACAO');