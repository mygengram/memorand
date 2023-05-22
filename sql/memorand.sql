-- Memorand database
create database Memorand;
use Memorand;

create table Usuarios
(
	idUsuario int primary key not null,
    usuario varchar(20),
    contrasena varchar(20),
    nomUsuario varchar(30),
    apellidoPat varchar(20),
    apellidoMat varchar(20),
    fechaNac date
);

create table Roles
(
	rolUsuario varchar(20) primary key not null,
    descripcion varchar(20)
);

create table Rol_Usuario
(
	idUsuario int not null,
	rolUsuario varchar(20) not null,
    PRIMARY KEY (idUsuario, rolUsuario),
    INDEX `fk_Roles_has_Usuarios_idUsuario_idx` (`idUsuario` ASC) VISIBLE,
    INDEX `fk_Roles_has_Usuarios_rolUsuario_idx` (`rolUsuario` ASC) VISIBLE,
	CONSTRAINT `fk_Roles_has_Usuarios_rolUsuario`
		FOREIGN KEY (`rolUsuario`)
		REFERENCES `Memorand`.`Roles` (`rolUsuario`)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT,
	CONSTRAINT `fk_Roles_has_Usuarios_idUsuario`
		FOREIGN KEY (`idUsuario`)
		REFERENCES `Memorand`.`Usuarios` (`idUsuario`)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT
);
create table PendientesP
(
	idPendP int primary key not null,
    nomPendP varchar(20),
    subPendP varchar(30),
    descPendP longtext,
    fechaInicioP datetime,
    fechaFinalP datetime,
    colorPendP varchar(6),
    completadoP boolean
);

create table EtiquetasP
(
	idEtiquetaP int primary key not null,
    nomEtiquetaP varchar(15)
);

create table UsuariosPendientes
(
	idUsuario int,
    idPendP int,
    foreign key (idUsuario) references Usuarios (idUsuario),
    foreign key (idPendP) references PendientesP (idPendP)
);

create table UsuariosEtiquetas
(
	idUsuario int,
    idEtiquetaP int,
    foreign key (idUsuario) references Usuarios (idUsuario),
    foreign key (idEtiquetaP) references EtiquetasP (idEtiquetaP)
);

create table PendientesC
(
	idPendC int primary key not null,
    nomPendC varchar(20),
    subPendC varchar(30),
    descPendC longtext,
    fechaInicioC datetime,
    fechaFinalC datetime,
    colorPendC varchar(6),
    completadoC boolean
);

create table AgendasC
(
	idAgenda int primary key not null,
    nomAgenda varchar(20),
    descAgenda text,
    colorAgenda varchar(6),
    codigoAgenda varchar(6)
);

create table EtiquetasC
(
	idEtiquetaC int primary key not null,
    nomEtiquetaC varchar(15)
);

create table Llevan
(
	idLlevan int primary key not null,
	idUsuario int,
    idAgenda int,
    rolAgenda varchar(20),
    favorito boolean,
    foreign key (idUsuario) references Usuarios (idUsuario),
    foreign key (idAgenda) references AgendasC (idAgenda)
);

create table Tienen
(
	idTienen int primary key not null,
	idUsuario int,
    idAgenda int,
    idPendC int,
    autor varchar(20),
    foreign key (idUsuario) references Usuarios (idUsuario),
    foreign key (idAgenda) references AgendasC (idAgenda),
    foreign key (idPendC) references PendientesC (idPendC)
);

create table AgendaEtiquetas
(
	idAgenda int,
    idEtiquetaC int,
    foreign key (idAgenda) references AgendasC (idAgenda),
    foreign key (idEtiquetaC) references EtiquetasC (idEtiquetaC)
);
