
-- -----------------------------------------------------
-- Table `scoadb`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pessoa` (
  `id` INTEGER PRIMARY KEY ,
  `cpf` VARCHAR(12) NULL DEFAULT NULL,
  `data_nascimento` DATE NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `endereco` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL );

-- -----------------------------------------------------
-- Table `scoadb`.`Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Aluno` (
  `pessoa_id` INT(11) NOT NULL,
  PRIMARY KEY (`pessoa_id`),
  CONSTRAINT `FKdhmnlbjhg21llgs46ekorgswx`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `Pessoa` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `scoadb`.`Disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Disciplina` (
  `id` INTEGER PRIMARY KEY,
  `descricao` VARCHAR(2555) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL);


-- -----------------------------------------------------
-- Table `scoadb`.`Professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Professor` (
  `pessoa_id` INT(11) NOT NULL,
  PRIMARY KEY (`pessoa_id`),
  CONSTRAINT `FKhdx7tr0f98w7q50nwskcakga2`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `Pessoa` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);