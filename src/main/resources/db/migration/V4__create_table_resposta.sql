create table resposta(
    id BIGSERIAL PRIMARY KEY,
    mensagem varchar(300) not null,
    criado_em timestamp not null,
    topico_id bigint not null,
    autor_id bigint not null,
    solucao boolean not null,
    foreign key(topico_id) references topico(id),
    foreign key(autor_id) references usuario(id)
);