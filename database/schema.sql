CREATE TABLE IF NOT EXISTS pessoas (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    tipo TEXT NOT NULL, 
    nome TEXT NOT NULL,
    idade INTEGER NOT NULL,
    altura REAL NOT NULL,
    matricula TEXT,     
    disciplina TEXT,    
    numero_banca TEXT,  
    setor_feira TEXT    
);
