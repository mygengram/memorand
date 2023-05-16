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
    imgUsuario blob,
    fechaNac date
);

create table PendientesP
(
	idPendP int primary key not null,
    nomPendP varchar(20),
    subPendP varchar(30),
    descPendP longtext,
    fechaPendP datetime,
    imgPendP blob,
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

create table PendEtiqP
(
	idPendP int,
    idEtiquetaP int,
    foreign key (idPendP) references PendientesP (idPendP),
    foreign key (idEtiquetaP) references EtiquetasP (idEtiquetaP)
);

create table Roles
(
	idRol int primary key not null,
    nomRol varchar(20)
);

create table Favoritos
(
	idFavorito int primary key not null,
    estadoFavorito varchar(10)
);

create table PendientesC
(
	idPendC int primary key not null,
    nomPendC varchar(20),
    subPendC varchar(30),
    descPendC longtext,
    fechaPendC datetime,
    imgPendC blob,
    colorPendC varchar(6),
    completadoC boolean
);

create table Autores
(
	idAutor int primary key not null,
    estadoAutor varchar(15)
);

create table AgendasC
(
	idAgenda int primary key not null,
    nomAgenda varchar(20),
    descAgenda text,
    iconoAgenda blob,
    colorAgenda varchar(6)
);

create table EtiquetasC
(
	idEtiquetaC int primary key not null,
    nomEtiquetaC varchar(15)
);

create table Llevan
(
	idUsuario int,
    idAgenda int,
    idRol int,
    idFavorito int,
    foreign key (idUsuario) references Usuarios (idUsuario),
    foreign key (idAgenda) references AgendasC (idAgenda),
    foreign key (idRol) references Roles (idRol),
    foreign key (idFavorito) references Favoritos (idFavorito)
);

create table Tienen
(
	idUsuario int,
    idAgenda int,
    idPendC int,
    idAutor int,
    foreign key (idUsuario) references Usuarios (idUsuario),
    foreign key (idAgenda) references AgendasC (idAgenda),
    foreign key (idPendC) references PendientesC (idPendC),
    foreign key (idAutor) references Autores (idAutor)
);

create table AgendaEtiqC
(
	idAgenda int,
    idEtiquetaC int,
    foreign key (idAgenda) references AgendasC (idAgenda),
    foreign key (idEtiquetaC) references EtiquetasC (idEtiquetaC)
);
