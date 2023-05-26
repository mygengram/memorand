-- Memorand database --
drop database if exists memorand;

create database Memorand;
use Memorand;

create table Usuarios
(
    usuario varchar(20) primary key not null,
    contrasena varchar(20),
    nomUsuario varchar(40),
    apellidoPat varchar(20),
    apellidoMat varchar(20),
    fechaNac varchar(10)
);

create table Roles
(
	rolUsuario varchar(20) primary key not null,
    descripcion varchar(20)
);

create table Rol_Usuario
(
	usuario varchar(20) not null,
	rolUsuario varchar(20) not null,
    primary key (usuario, rolUsuario),
    index `fk_Roles_has_Usuarios_usuario_idx` (`usuario` asc),
    index `fk_Roles_has_Usuarios_rolUsuario_idx` (`rolUsuario` asc),
	constraint `fk_Roles_has_Usuarios_rolUsuario`
		foreign key (`rolUsuario`)
		references `Memorand`.`Roles` (`rolUsuario`)
		on delete restrict
		on update restrict,
	constraint `fk_Roles_has_Usuarios_usuario`
		foreign key (`usuario`)
		references `Memorand`.`Usuarios` (`usuario`)
		on delete restrict
		on update restrict
);

create table PendientesP
(
	idPendP int primary key not null,
    nomPendP varchar(20),
    subPendP varchar(30),
    descPendP longtext null,
    fechaInicioP varchar(10) null,
    fechaFinalP varchar(10) null,
    colorPendP varchar(6) null,
    completadoP varchar(2)
);

create table EtiquetasP
(
	idEtiquetaP int primary key not null,
    nomEtiquetaP varchar(15)
);

create table UsuariosPendientesP
(
	usuario varchar(20),
    idPendP int,
    foreign key (usuario) references Usuarios (usuario),
    foreign key (idPendP) references PendientesP (idPendP)
);

create table UsuariosEtiquetasP
(
	usuario varchar(20),
    idEtiquetaP int,
    foreign key (usuario) references Usuarios (usuario),
    foreign key (idEtiquetaP) references EtiquetasP (idEtiquetaP)
);

create table PendientesC
(
	idPendC int primary key not null,
    nomPendC varchar(20),
    subPendC varchar(30),
    descPendC longtext null,
    fechaInicioC varchar(10) null,
    fechaFinalC varchar(10) null,
    completadoC varchar(2)
);

create table AgendasC
(
	idAgenda int primary key not null,
    nomAgenda varchar(20),
    descAgenda text null,
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
	usuario varchar(20),
    idAgenda int,
    rolAgenda varchar(20),
    favorito varchar(2),
    foreign key (usuario) references Usuarios (usuario),
    foreign key (idAgenda) references AgendasC (idAgenda)
);

create table Tienen
(
	idTienen int primary key not null,
	usuario varchar(20),
    idAgenda int,
    idPendC int,
    autor varchar(20),
    foreign key (usuario) references Usuarios (usuario),
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
