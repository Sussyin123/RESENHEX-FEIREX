CREATE TABLE IF NOT EXISTS pessoas (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    tipo TEXT NOT NULL, -- 'ALUNO', 'PROFESSOR' ou 'COMERCIANTE'
    nome TEXT NOT NULL,
    idade INTEGER NOT NULL,
    altura REAL NOT NULL,
    matricula TEXT,     -- Específico de Aluno
    disciplina TEXT,    -- Específico de Professor
    numero_banca TEXT,  -- Específico de Comerciante
    setor_feira TEXT    -- Específico de Comerciante
);
