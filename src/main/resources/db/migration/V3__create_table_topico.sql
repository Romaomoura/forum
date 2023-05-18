CREATE TABLE topico (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(50) NOT NULL,
    mensagem VARCHAR(50) NOT NULL,
    criado_em TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL,
    aplicacao_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,
    FOREIGN KEY (aplicacao_id) REFERENCES aplicacao (id),
    FOREIGN KEY (autor_id) REFERENCES usuario (id)
);