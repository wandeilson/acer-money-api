CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	ativo boolean NOT NULL,
	logradouro VARCHAR(30),
	numero VARCHAR(10),
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(20),
	cidade VARCHAR(30),
	estado VARCHAR(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('Wandeilson', true, 'Rua x Alves', '222', 'Casa','Centro','56600-000','Sertânia','Pernambuco');

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('André', false, 'Rua dos santos', '46', 'Apt','Favela','56600-000','Sertânia','Pernambuco');

INSERT INTO pessoa (nome, ativo, logradouro, cep, cidade, estado) 
VALUES ('Fulano Silva', true, 'Rua', '5555555','São Paulo','São Paulo');

INSERT INTO pessoa (nome, ativo, logradouro, cep, cidade, estado) 
VALUES ('Maria Santana', false, 'Rua x', '56600-000','Sertânia','Minas Gerais');

INSERT INTO pessoa (nome, ativo, logradouro, cep, cidade, estado) 
VALUES ('Kuririn', true, 'Meio do mar', '77777','XXX','XXX');

INSERT INTO pessoa (nome, ativo, logradouro, cep, cidade, estado) 
VALUES ('Maria Marta', true, 'Rua L', '44444-000','Belo horizonte','Minas Gerais');

INSERT INTO pessoa (nome, ativo, logradouro, cep, cidade, estado) 
VALUES ('Jonas', true, 'Rua', '3333-000','Viden','Russia');

INSERT INTO pessoa (nome, ativo, logradouro, cep, cidade, estado) 
VALUES ('Pedro', false, 'Pedrosa', '44322-000','Pedra','Pernambuco');

INSERT INTO pessoa (nome, ativo, logradouro, cep, cidade, estado) 
VALUES ('Bill', false, 'Sítio', '56600-000','Sertânia','Pernambuco');