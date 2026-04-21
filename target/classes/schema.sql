CREATE TABLE aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    matricula_aluno INT NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE emprestimo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE,
    aluno_id BIGINT NOT NULL,
    FOREIGN KEY (aluno_id) REFERENCES aluno(id) ON DELETE CASCADE
);
