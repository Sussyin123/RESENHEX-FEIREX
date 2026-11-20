-- Tabela para a entidade Pessoas
CREATE TABLE pessoas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    data_nascimento DATE,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
