CREATE TABLE usuario_role(
    id BIGSERIAL PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    FOREIGN KEY(usuario_id) REFERENCES usuario(id),
    FOREIGN KEY(role_id) REFERENCES role(id)
);

INSERT INTO usuario_role(usuario_id, role_id) VALUES (1,1);