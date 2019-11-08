
-- -----------------------------------------------------
-- Table `scoadb`.`Pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Pessoa`;
CREATE TABLE IF NOT EXISTS `Pessoa` (
  `id` INTEGER PRIMARY KEY ,
  `cpf` VARCHAR(12) NULL DEFAULT NULL,
  `data_nascimento` DATE NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `endereco` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL
);

-- -----------------------------------------------------
-- Table `scoadb`.`Aluno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Aluno`;
CREATE TABLE IF NOT EXISTS `Aluno` (
  `pessoa_id` INT(11) NOT NULL,
  PRIMARY KEY (`pessoa_id`),
  CONSTRAINT `FKdhmnlbjhg21llgs46ekorgswx`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `Pessoa` (`id`)
    ON DELETE CASCADE
);


-- -----------------------------------------------------
-- Table `scoadb`.`Disciplina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Disciplina`;
CREATE TABLE IF NOT EXISTS `Disciplina` (
  `id` INTEGER PRIMARY KEY,
  `descricao` VARCHAR(2555) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL
);


DROP TABLE IF EXISTS `Sala`;
CREATE TABLE IF NOT EXISTS `Sala` (
  `id` INT(11) PRIMARY KEY,
  `codLocalizacao` VARCHAR(9) NULL UNIQUE DEFAULT NULL
);

DROP TABLE IF EXISTS `SalasTurmas`;
CREATE TABLE IF NOT EXISTS `SalasTurmas` (
  `hora` VARCHAR(11) NOT NULL,
  `turma_id` INT(11) NOT NULL,
  `sala_id` INT(11) NOT NULL,
  PRIMARY KEY (`turma_id`,`sala_id`,`hora`),
  CONSTRAINT `FKhvgeircm0e3lc9l0j323ihpmy` FOREIGN KEY (`sala_id`) REFERENCES `Sala` (`id`),
  CONSTRAINT `FKjyqiulyydpfi2upry95n43gsa` FOREIGN KEY (`turma_id`) REFERENCES `Turma` (`id`)
);

DROP TABLE IF EXISTS `Turma`;
CREATE TABLE IF NOT EXISTS `Turma` (
  `id` INT(11) NOT NULL,
  `disciplina_id` INT(11) DEFAULT NULL,
  `professor_pessoa_id` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK8046jn01khei22nwsvj86kmfr` FOREIGN KEY (`disciplina_id`) REFERENCES `Disciplina` (`id`),
  CONSTRAINT `FKnjm31k1lt87dcdblg36jwwd6l` FOREIGN KEY (`professor_pessoa_id`) REFERENCES `Professor` (`pessoa_id`)
);

DROP TABLE IF EXISTS `TurmasAlunos`;
CREATE TABLE IF NOT EXISTS `TurmasAlunos` (
  `turma_id` INT(11) NOT NULL,
  `pessoa_id` INT(11) NOT NULL,
  PRIMARY KEY (`turma_id`,`pessoa_id`),
  CONSTRAINT `FK5l8bfnsjnhf2e7nsimx10xyqk` FOREIGN KEY (`turma_id`) REFERENCES `Turma` (`id`),
  CONSTRAINT `FKqwjxhlvi7j2tycwp7dlc7hw6u` FOREIGN KEY (`pessoa_id`) REFERENCES `Pessoa` (`id`)
);

-- -----------------------------------------------------
-- Table `scoadb`.`Professor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Professor`;
CREATE TABLE IF NOT EXISTS `Professor` (
  `pessoa_id` INT(11) NOT NULL,
  PRIMARY KEY (`pessoa_id`),
  CONSTRAINT `FKhdx7tr0f98w7q50nwskcakga2`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `Pessoa` (`id`)
    ON DELETE CASCADE
);

INSERT INTO Pessoa (`id`,`cpf`,`data_nascimento`,`email`,`endereco`,`nome`) VALUES (1,'01111111111',1570417200000,'1@aluno.com','Rua 1','Aluno 1');
INSERT INTO Aluno VALUES (1);
INSERT INTO Pessoa (`id`,`cpf`,`data_nascimento`,`email`,`endereco`,`nome`) VALUES (2,'21111111111',1570417200000,'2@aluno.com','Rua 2','Aluno 2');
INSERT INTO Aluno VALUES (2);
INSERT INTO Pessoa (`id`,`cpf`,`data_nascimento`,`email`,`endereco`,`nome`) VALUES (3,'31111111111',1570417200000,'3@professor.com','Rua 3','Professor 1');
INSERT INTO Professor VALUES (3);
INSERT INTO Pessoa (`id`,`cpf`,`data_nascimento`,`email`,`endereco`,`nome`) VALUES (4,'41111111111',1570417200000,'4@professor.com','Rua 4','Professor 2');
INSERT INTO Professor VALUES (4);
INSERT INTO Disciplina (`id`,`nome`,`descricao`) VALUES (1,'Disciplina 1','Descricao Disciplina 1');
INSERT INTO Disciplina (`nome`,`descricao`) VALUES ('Disciplina 2','Descricao Disciplina 2');
INSERT INTO Disciplina (`nome`,`descricao`) VALUES ('Disciplina 3','Descricao Disciplina 3');
INSERT INTO Turma (`id`,`disciplina_id`,`professor_pessoa_id`) VALUES (1,1,3);
INSERT INTO Sala (`id`,`codLocalizacao`) VALUES (1,'CCMNF0101');
INSERT INTO SalasTurmas (`sala_id`,`turma_id`,`hora`) VALUES (1,1,'H0');