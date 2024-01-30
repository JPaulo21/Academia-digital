CREATE TABLE ALUNOS (
   id SERIAL NOT NULL ,
   nome VARCHAR(100) not null,
   cpf VARCHAR(14) not null,
   bairro VARCHAR(255),
   data_de_nascimento date not null,
   CONSTRAINT pk_aluno PRIMARY KEY (id)
);

ALTER TABLE ALUNOS ADD CONSTRAINT UNIQUE_ALUNO_CPF UNIQUE (cpf);