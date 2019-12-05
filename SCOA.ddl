DELIMITER /
DROP TRIGGER IF EXISTS aloca_turma_pra_sala_test/
DELIMITER ;
DELIMITER /
DROP TRIGGER IF EXISTS aloca_turma_pra_sala_test/
DELIMITER ;
ALTER TABLE aluno DROP FOREIGN KEY fk_pessoa1;
ALTER TABLE equivalencias DROP FOREIGN KEY fk_disciplina1;
ALTER TABLE equivalencias DROP FOREIGN KEY fk_disciplina2;
ALTER TABLE professor DROP FOREIGN KEY fk_pessoa2;
ALTER TABLE alocacao_sala_turma DROP FOREIGN KEY fk_turma3;
ALTER TABLE alocacao_sala_turma DROP FOREIGN KEY fk_sala;
ALTER TABLE alocacao_sala_turma DROP FOREIGN KEY fk_hora;
ALTER TABLE turma DROP FOREIGN KEY fk_turma2;
ALTER TABLE turma DROP FOREIGN KEY fk_professor;
ALTER TABLE inscricao_aluno DROP FOREIGN KEY fk_turma1;
ALTER TABLE inscricao_aluno DROP FOREIGN KEY fk_aluno;
ALTER TABLE prerequisitos DROP FOREIGN KEY fk_disciplina3;
ALTER TABLE prerequisitos DROP FOREIGN KEY fk_prerequisito;
ALTER TABLE professor DROP FOREIGN KEY fk_area1;
ALTER TABLE disciplina DROP FOREIGN KEY fk_area2;
ALTER TABLE inscricao_aluno DROP FOREIGN KEY fk_situacao;
ALTER TABLE disciplina DROP FOREIGN KEY fk_curso2;
ALTER TABLE aluno DROP FOREIGN KEY fk_curso;
ALTER TABLE secretario DROP FOREIGN KEY FKsecretario460290;
ALTER TABLE secretario DROP FOREIGN KEY fk_pessoa3;
ALTER TABLE sysadmins DROP FOREIGN KEY fk_pessoa4;
DROP TABLE IF EXISTS aluno;
DROP TABLE IF EXISTS disciplina;
DROP TABLE IF EXISTS equivalencias;
DROP TABLE IF EXISTS horariodeaula;
DROP TABLE IF EXISTS pessoa;
DROP TABLE IF EXISTS professor;
DROP TABLE IF EXISTS sala;
DROP TABLE IF EXISTS alocacao_sala_turma;
DROP TABLE IF EXISTS turma;
DROP TABLE IF EXISTS inscricao_aluno;
DROP TABLE IF EXISTS prerequisitos;
DROP TABLE IF EXISTS area_disciplina;
DROP TABLE IF EXISTS situacao;
DROP TABLE IF EXISTS curso;
DROP TABLE IF EXISTS secretario;
DROP TABLE IF EXISTS sysadmins;
CREATE TABLE aluno (pessoa_id int(11) NOT NULL, curso_id int(11) NOT NULL, PRIMARY KEY (pessoa_id)) CHARACTER SET UTF8;
CREATE TABLE disciplina (id int(11) NOT NULL AUTO_INCREMENT, area_disciplina_id int(11) NOT NULL, curso_id int(11) NOT NULL, codigo varchar(16) NOT NULL UNIQUE, nome varchar(255) NOT NULL, descricao varchar(255) NOT NULL, PRIMARY KEY (id), INDEX (id)) CHARACTER SET UTF8;
CREATE TABLE equivalencias (disciplina1_id int(11) NOT NULL, disciplina2_id int(11) NOT NULL, PRIMARY KEY (disciplina1_id, disciplina2_id)) CHARACTER SET UTF8;
CREATE TABLE horariodeaula (id int(11) NOT NULL AUTO_INCREMENT, dia varchar(255) NOT NULL, horarioFim time(6) NOT NULL, horarioInicio time(6) NOT NULL, PRIMARY KEY (id), INDEX (id)) CHARACTER SET UTF8;
CREATE TABLE pessoa (id int(11) NOT NULL AUTO_INCREMENT, cpf varchar(12) NOT NULL UNIQUE, data_nascimento date NOT NULL, email varchar(255) NOT NULL, endereco varchar(255) NOT NULL, nome varchar(255) NOT NULL, senha varchar(255) NOT NULL, PRIMARY KEY (id), INDEX (id)) CHARACTER SET UTF8;
CREATE TABLE professor (pessoa_id int(11) NOT NULL, area_disciplina_id int(11) NOT NULL, PRIMARY KEY (pessoa_id)) CHARACTER SET UTF8;
CREATE TABLE sala (id int(11) NOT NULL AUTO_INCREMENT, codLocalizacao varchar(255) NOT NULL UNIQUE, PRIMARY KEY (id), INDEX (id)) CHARACTER SET UTF8;
CREATE TABLE alocacao_sala_turma (turma_id int(11) NOT NULL, sala_id int(11) NOT NULL, hora_id int(11) NOT NULL, PRIMARY KEY (turma_id, sala_id, hora_id)) CHARACTER SET UTF8;
CREATE TABLE turma (id int(11) NOT NULL AUTO_INCREMENT, disciplina_id int(11) NOT NULL, professor_id int(11) NOT NULL, periodo varchar(6) NOT NULL, PRIMARY KEY (id), INDEX (id)) CHARACTER SET UTF8;
CREATE TABLE inscricao_aluno (turma_id int(11) NOT NULL, aluno_id int(11) NOT NULL, nota decimal(4, 2) DEFAULT NULL, situacao_id int(10), PRIMARY KEY (turma_id, aluno_id)) CHARACTER SET UTF8;
CREATE TABLE prerequisitos (disciplina_id int(11) NOT NULL, prerequisito_id int(11) NOT NULL, PRIMARY KEY (disciplina_id, prerequisito_id)) CHARACTER SET UTF8;
CREATE TABLE area_disciplina (id int(11) NOT NULL AUTO_INCREMENT, nome varchar(255) NOT NULL, descricao varchar(255) NOT NULL, PRIMARY KEY (id), INDEX (id)) CHARACTER SET UTF8;
CREATE TABLE situacao (id int(10) NOT NULL AUTO_INCREMENT, nome varchar(255) NOT NULL, PRIMARY KEY (id), INDEX (id)) CHARACTER SET UTF8;
CREATE TABLE curso (id int(11) NOT NULL AUTO_INCREMENT, nome varchar(255) NOT NULL, descricao varchar(255) NOT NULL, PRIMARY KEY (id), INDEX (id)) CHARACTER SET UTF8;
CREATE TABLE secretario (pessoa_id int(11) NOT NULL, curso_id int(11) NOT NULL, PRIMARY KEY (pessoa_id)) CHARACTER SET UTF8;
CREATE TABLE sysadmins (pessoa_id int(11) NOT NULL, PRIMARY KEY (pessoa_id)) CHARACTER SET UTF8;
ALTER TABLE aluno ADD CONSTRAINT fk_pessoa1 FOREIGN KEY (pessoa_id) REFERENCES pessoa (id) ON UPDATE Restrict ON DELETE Restrict;
ALTER TABLE equivalencias ADD CONSTRAINT fk_disciplina1 FOREIGN KEY (disciplina1_id) REFERENCES disciplina (id) ON UPDATE Restrict ON DELETE Restrict;
ALTER TABLE equivalencias ADD CONSTRAINT fk_disciplina2 FOREIGN KEY (disciplina2_id) REFERENCES disciplina (id) ON UPDATE Restrict ON DELETE Restrict;
ALTER TABLE professor ADD CONSTRAINT fk_pessoa2 FOREIGN KEY (pessoa_id) REFERENCES pessoa (id) ON UPDATE Restrict ON DELETE Restrict;
ALTER TABLE alocacao_sala_turma ADD CONSTRAINT fk_turma3 FOREIGN KEY (turma_id) REFERENCES turma (id) ON UPDATE Restrict ON DELETE Restrict;
ALTER TABLE alocacao_sala_turma ADD CONSTRAINT fk_sala FOREIGN KEY (sala_id) REFERENCES sala (id) ON UPDATE Restrict ON DELETE Restrict;
ALTER TABLE alocacao_sala_turma ADD CONSTRAINT fk_hora FOREIGN KEY (hora_id) REFERENCES horariodeaula (id) ON UPDATE Restrict ON DELETE Restrict;
ALTER TABLE turma ADD CONSTRAINT fk_turma2 FOREIGN KEY (disciplina_id) REFERENCES disciplina (id) ON UPDATE Restrict ON DELETE Restrict;
ALTER TABLE turma ADD CONSTRAINT fk_professor FOREIGN KEY (professor_id) REFERENCES professor (pessoa_id) ON UPDATE Restrict ON DELETE Restrict;
ALTER TABLE inscricao_aluno ADD CONSTRAINT fk_turma1 FOREIGN KEY (turma_id) REFERENCES turma (id) ON UPDATE Restrict ON DELETE Restrict;
ALTER TABLE inscricao_aluno ADD CONSTRAINT fk_aluno FOREIGN KEY (aluno_id) REFERENCES aluno (pessoa_id) ON UPDATE Restrict ON DELETE Restrict;
ALTER TABLE prerequisitos ADD CONSTRAINT fk_disciplina3 FOREIGN KEY (disciplina_id) REFERENCES disciplina (id);
ALTER TABLE prerequisitos ADD CONSTRAINT fk_prerequisito FOREIGN KEY (prerequisito_id) REFERENCES disciplina (id);
ALTER TABLE professor ADD CONSTRAINT fk_area1 FOREIGN KEY (area_disciplina_id) REFERENCES area_disciplina (id);
ALTER TABLE disciplina ADD CONSTRAINT fk_area2 FOREIGN KEY (area_disciplina_id) REFERENCES area_disciplina (id);
ALTER TABLE inscricao_aluno ADD CONSTRAINT fk_situacao FOREIGN KEY (situacao_id) REFERENCES situacao (id);
ALTER TABLE disciplina ADD CONSTRAINT fk_curso2 FOREIGN KEY (curso_id) REFERENCES curso (id);
ALTER TABLE aluno ADD CONSTRAINT fk_curso FOREIGN KEY (curso_id) REFERENCES curso (id);
ALTER TABLE secretario ADD CONSTRAINT FKsecretario460290 FOREIGN KEY (pessoa_id) REFERENCES pessoa (id);
ALTER TABLE secretario ADD CONSTRAINT fk_pessoa3 FOREIGN KEY (curso_id) REFERENCES curso (id);
ALTER TABLE sysadmins ADD CONSTRAINT fk_pessoa4 FOREIGN KEY (pessoa_id) REFERENCES pessoa (id);
DELIMITER /
CREATE TRIGGER aloca_turma_pra_sala_test BEFORE INSERT ON alocacao_sala_turma FOR EACH ROW
BEGIN
    DECLARE temp_turmas_count_1 INT;
    DECLARE temp_turmas_count_2 INT;
    DECLARE new_periodo VARCHAR(6);
    DECLARE new_professor_id VARCHAR(6);
    
    CREATE TEMPORARY TABLE temp_turmas_1 (id int);
    CREATE TEMPORARY TABLE temp_turmas_2 (id int);

    SELECT periodo
    INTO new_periodo
    FROM turma WHERE id=new.turma_id;

    SELECT professor_id
    INTO new_professor_id
    FROM turma WHERE id=new.turma_id;
    
    INSERT INTO temp_turmas_1 SELECT turma_id FROM alocacao_sala_turma JOIN turma ON id=turma_id WHERE sala_id = new.sala_id AND hora_id = new.hora_id AND periodo = new_periodo; 
    
    SELECT count(*)
    INTO temp_turmas_count_1
    FROM temp_turmas_1;

    INSERT INTO temp_turmas_2 SELECT turma_id FROM alocacao_sala_turma JOIN turma ON id=turma_id WHERE professor_id = new_professor_id AND hora_id = new.hora_id AND periodo = new_periodo; 
    
    SELECT count(*)
    INTO temp_turmas_count_2
    FROM temp_turmas_2;

    DROP TEMPORARY TABLE temp_turmas_1;
    DROP TEMPORARY TABLE temp_turmas_2;

    IF temp_turmas_count_1 > 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Esta sala já esta ocupada no horario desejado.';
    END IF; 

    IF temp_turmas_count_2 > 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'O professor da disciplina já esta ocupado no horario desejado.';
    END IF; 
END/
DELIMITER ;
