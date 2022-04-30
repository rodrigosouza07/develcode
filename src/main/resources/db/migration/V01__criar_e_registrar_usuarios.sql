CREATE TABLE usuario (
        codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(50) NOT NULL,
        data_nascimento DATE NOT NULL,
        foto VARCHAR(50)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (nome, data_nascimento, foto) values ('João Silva', '2017-06-01', null);
INSERT INTO usuario (nome, data_nascimento, foto) values ('Maria Rita', '2017-06-02', null);
INSERT INTO usuario (nome, data_nascimento, foto) values ('Pedro Santos', '2017-06-13', null);
INSERT INTO usuario (nome, data_nascimento, foto) values ('Ricardo Pereira', '2017-06-14', null);
INSERT INTO usuario (nome, data_nascimento, foto) values ('Josué Mariano', '2017-06-26', null);
INSERT INTO usuario (nome, data_nascimento, foto) values ('Pedro Barbosa', '2017-06-27', null);
INSERT INTO usuario (nome, data_nascimento, foto) values ('Henrique Medeiros', '2017-06-30', null);
INSERT INTO usuario (nome, data_nascimento, foto) values ('Carlos Santana', '2017-06-05', null);
