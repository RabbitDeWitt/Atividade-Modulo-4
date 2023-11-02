
CREATE TABLE Cliente (
idCliente int primary key not null auto_increment,
Nome varchar(50),
dataNasc datetime,
telefone varchar(20),
numPassaporte varchar(8)
);

CREATE TABLE Destino (
idDestino int primary key not null auto_increment,
nome varchar(50),
valor float(7),
estado varchar(2),
pais varchar(30)
);

CREATE TABLE Pacote (
idPacote int primary key not null auto_increment,
nome varchar(50),
valorPacote float(7)
);

CREATE TABLE Contato (
idContato int primary key not null auto_increment,
mensagem varchar(150),
email varchar(50),
nome varchar(50)
);

CREATE TABLE Reserva (
idReserva int primary key not null auto_increment,
idPacote int,
idCliente int,
idDestino int,
dataPartida datetime,
dataRetorno datetime,
valorTotal float(7),
FOREIGN KEY(idPacote) REFERENCES Pacote (idPacote),
FOREIGN KEY(idCliente) REFERENCES Cliente (idCliente),
FOREIGN KEY(idDestino) REFERENCES Destino (idDestino)
);


ALTER TABLE `daviagens`.`reserva` 
DROP FOREIGN KEY `reserva_ibfk_1`,
DROP FOREIGN KEY `reserva_ibfk_2`,
DROP FOREIGN KEY `reserva_ibfk_3`;
ALTER TABLE `daviagens`.`reserva` 
ADD CONSTRAINT `reserva_ibfk_1`
  FOREIGN KEY (`idPacote`)
  REFERENCES `daviagens`.`pacote` (`idPacote`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `reserva_ibfk_2`
  FOREIGN KEY (`idCliente`)
  REFERENCES `daviagens`.`cliente` (`idCliente`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `reserva_ibfk_3`
  FOREIGN KEY (`idDestino`)
  REFERENCES `daviagens`.`destino` (`idDestino`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

INSERT INTO cliente(nome, dataNasc, telefone, numPassaporte) VALUES ("Monkey D. Luffy", "1996-12-25", "(11)1234-5678", "BR000001");
INSERT INTO cliente(nome, dataNasc, telefone, numPassaporte) VALUES ("Naruto Uzumaki", "1990-04-01", "(11)1234-5678", "BR000002");
INSERT INTO cliente(nome, dataNasc, telefone, numPassaporte) VALUES ("Tajiro Kamada", "1998-10-21", "(11)1234-5678", "BR000003");
INSERT INTO cliente(nome, dataNasc, telefone, numPassaporte) VALUES ("Yusuke Urameshi", "1987-01-31", "(11)1234-5678", "BR000004");
INSERT INTO cliente(nome, dataNasc, telefone, numPassaporte) VALUES ("Kagome Higurashi", "1996-11-24", "(11)1234-5678", "BR000005");

INSERT INTO destino(nome, valor, estado, pais) VALUES ("Rio de Janeiro", 707, "RJ", "Brasil");
INSERT INTO destino(nome, valor, estado, pais) VALUES ("Bahia", 1100, "BA", "Brasil");
INSERT INTO destino(nome, valor, estado, pais) VALUES ("Rio Grande do Sul", 850, "RS", "Brasil");
INSERT INTO destino(nome, valor, estado, pais) VALUES ("Amazonas", 1600, "AM", "Brasil");
INSERT INTO destino(nome, valor, estado, pais) VALUES ("Goiânia", 452, "GO", "Brasil");

INSERT INTO Pacote(nome, valorPacote) VALUES ("Economica", 0);
INSERT INTO Pacote(nome, valorPacote) VALUES ("Economica Premium", 400);
INSERT INTO Pacote(nome, valorPacote) VALUES ("Executiva", 1500);
INSERT INTO Pacote(nome, valorPacote) VALUES ("Primeira classe", 5000);