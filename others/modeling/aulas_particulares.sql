/* PlanoDeAulaLogico: */
USE aulas_particulares;

CREATE TABLE usuarios (
    usuario_id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    senha VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    tel VARCHAR(45),
    professor BOOLEAN,
    ativo BOOLEAN
);

CREATE TABLE materias (
    materia_id INT PRIMARY KEY AUTO_INCREMENT,
    materia VARCHAR(20) NOT NULL
);

CREATE TABLE agendas (
    agenda_id INT PRIMARY KEY AUTO_INCREMENT,
    ativo BOOLEAN,
    dia_semana VARCHAR(8) NOT NULL,
    hora_inicio VARCHAR(6),
    hora_fim VARCHAR(6)
);

CREATE TABLE aulas (
    aula_id INT PRIMARY KEY AUTO_INCREMENT,
    ativo BOOLEAN,
    usuarios_usuario_id_fk INT,
    materias_materia_id_fk INT,
    agendas_agenda_id_fk INT
);

CREATE TABLE grades (
    grade_id INT PRIMARY KEY AUTO_INCREMENT,
    ativo BOOLEAN,
    usuarios_usuario_id_fk INT,
    aulas_aula_id_fk INT
);
 
ALTER TABLE aulas ADD CONSTRAINT aula_fk_1
    FOREIGN KEY (materias_materia_id_fk)
    REFERENCES materias (materia_id);
 
ALTER TABLE aulas ADD CONSTRAINT aula_fk_2
    FOREIGN KEY (usuarios_usuario_id_fk)
    REFERENCES usuarios (usuario_id);
 
ALTER TABLE aulas ADD CONSTRAINT aula_fk_3
    FOREIGN KEY (agendas_agenda_id_fk)
    REFERENCES agendas (agenda_id);
 
ALTER TABLE grades ADD CONSTRAINT grade_fk_1
    FOREIGN KEY (usuarios_usuario_id_fk)
    REFERENCES usuarios (usuario_id);
 
ALTER TABLE grades ADD CONSTRAINT grade_fk_2
    FOREIGN KEY (aulas_aula_id_fk)
    REFERENCES aulas (aula_id);