
--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
CREATE TABLE `aluno` (
  `pessoa_id` INTEGER PRIMARY KEY NOT NULL,
  CONSTRAINT `FKdhmnlbjhg21llgs46ekorgswx` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`id`)
);

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
CREATE TABLE `disciplina` (
  `id` INTEGER PRIMARY KEY NOT NULL,
  `descricao` varchar(2555) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
);

--
-- Table structure for table `disciplina_disciplina`
--

DROP TABLE IF EXISTS `disciplina_disciplina`;
CREATE TABLE `disciplina_disciplina` (
  `Disciplina_id` int(11) NOT NULL,
  `disciplinasEquivalentes_id` int(11) NOT NULL,
  CONSTRAINT `FK1glklsh670y8oguvd2ghtm4qt` FOREIGN KEY (`disciplinasEquivalentes_id`) REFERENCES `disciplina` (`id`),
  CONSTRAINT `FK4i3h5pre0fksj4jk20j5rimvh` FOREIGN KEY (`Disciplina_id`) REFERENCES `disciplina` (`id`)
);

--
-- Table structure for table `horariodeaula`
--

DROP TABLE IF EXISTS `horariodeaula`;
CREATE TABLE `horariodeaula` (
  `id` INTEGER PRIMARY KEY NOT NULL,
  `dia` varchar(255) DEFAULT NULL,
  `horarioFim` time DEFAULT NULL,
  `horarioInicio` time DEFAULT NULL
);

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE `pessoa` (
  `id` INTEGER PRIMARY KEY NOT NULL,
  `cpf` varchar(12) DEFAULT NULL UNIQUE,
  `data_nascimento` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
);

--
-- Table structure for table `pessoa_aluno`
--

DROP TABLE IF EXISTS `pessoa_aluno`;
CREATE TABLE `pessoa_aluno` (
  `Pessoa_id` int(11) NOT NULL,
  `alunos_pessoa_id` int(11) NOT NULL UNIQUE,
  CONSTRAINT `FK2i302k394eu3co9hmssk0yhwg` FOREIGN KEY (`alunos_pessoa_id`) REFERENCES `aluno` (`pessoa_id`),
  CONSTRAINT `FK9elr4ouwekjjtyq3f28mofanl` FOREIGN KEY (`Pessoa_id`) REFERENCES `pessoa` (`id`)
);

--
-- Table structure for table `pessoa_professor`
--

DROP TABLE IF EXISTS `pessoa_professor`;
CREATE TABLE `pessoa_professor` (
  `Pessoa_id` int(11) NOT NULL,
  `professores_pessoa_id` int(11) NOT NULL UNIQUE,
  CONSTRAINT `FK5ie0byktlrfs4svuojcpse99s` FOREIGN KEY (`Pessoa_id`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `FK5sra737qa7n7bawdk3ya4j07c` FOREIGN KEY (`professores_pessoa_id`) REFERENCES `professor` (`pessoa_id`)
);

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor` (
  `pessoa_id` INTEGER PRIMARY KEY NOT NULL,
  CONSTRAINT `FKhdx7tr0f98w7q50nwskcakga2` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`id`)
);

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
CREATE TABLE `sala` (
  `id` INTEGER PRIMARY KEY NOT NULL,
  `codLocalizacao` varchar(9) DEFAULT NULL UNIQUE
);

--
-- Table structure for table `salasturmas`
--

DROP TABLE IF EXISTS `salasturmas`;
CREATE TABLE `salasturmas` (
  `turma_id` int(11) NOT NULL,
  `sala_id` int(11) NOT NULL,
  `hora_id` int(11) NOT NULL,
  PRIMARY KEY (`turma_id`,`sala_id`,`hora_id`),
  CONSTRAINT `FKhvgeircm0e3lc9l0j323ihpmy` FOREIGN KEY (`sala_id`) REFERENCES `sala` (`id`),
  CONSTRAINT `FKjyqiulyydpfi2upry95n43gsa` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`id`),
  CONSTRAINT `FKrvfa6ushbe6hnk9jq0p8n7i00` FOREIGN KEY (`hora_id`) REFERENCES `horariodeaula` (`id`)
);

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
CREATE TABLE `turma` (
  `id` INTEGER PRIMARY KEY NOT NULL,
  `disciplina_id` int(11) DEFAULT NULL,
  `professor_pessoa_id` int(11) DEFAULT NULL,
  `sala_id` int(11) DEFAULT NULL,
  CONSTRAINT `FK8046jn01khei22nwsvj86kmfr` FOREIGN KEY (`disciplina_id`) REFERENCES `disciplina` (`id`),
  CONSTRAINT `FKn409u60266nbslac2b3t8g8sp` FOREIGN KEY (`sala_id`) REFERENCES `sala` (`id`),
  CONSTRAINT `FKnjm31k1lt87dcdblg36jwwd6l` FOREIGN KEY (`professor_pessoa_id`) REFERENCES `professor` (`pessoa_id`)
);

--
-- Table structure for table `turma_aluno`
--

DROP TABLE IF EXISTS `turma_aluno`;
CREATE TABLE `turma_aluno` (
  `Turma_id` int(11) NOT NULL,
  `aluno_pessoa_id` int(11) NOT NULL,
  CONSTRAINT `FKryjykqkfcc7i9otni80tsve5p` FOREIGN KEY (`Turma_id`) REFERENCES `turma` (`id`),
  CONSTRAINT `FKsfb9mgeklwvi21fder6xqpno9` FOREIGN KEY (`aluno_pessoa_id`) REFERENCES `aluno` (`pessoa_id`)
);

--
-- Table structure for table `turma_horariodeaula`
--

DROP TABLE IF EXISTS `turma_horariodeaula`;
CREATE TABLE `turma_horariodeaula` (
  `Turma_id` int(11) NOT NULL,
  `horario_id` int(11) NOT NULL,
  CONSTRAINT `FK9ffgdiov6ivkeyq7ichvo36yi` FOREIGN KEY (`Turma_id`) REFERENCES `turma` (`id`),
  CONSTRAINT `FKsfx2d6ppdhy16iy3jwvwqlv04` FOREIGN KEY (`horario_id`) REFERENCES `horariodeaula` (`id`)
);

-- Dump completed on 2019-11-08  7:22:51
