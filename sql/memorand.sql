-- memorand database --
drop database if exists memorand;
create database memorand;
use memorand;

create table usuarios (
    usuario varchar(20) primary key not null,
    contrasena varchar(20),
    nomusuario varchar(40),
    apellidopat varchar(20),
    apellidomat varchar(20),
    fechanac varchar(10)
);

create table roles (
	rolusuario varchar(20) primary key not null
);

create table rolusuarios (
	usuario varchar(20) not null,
	rolusuario varchar(20) not null,
    primary key (usuario, rolusuario),
    index `fk_roles_has_usuarios_usuario_idx` (`usuario` asc),
    index `fk_roles_has_usuarios_rolusuario_idx` (`rolusuario` asc),
	constraint `fk_roles_has_usuarios_rolusuario`
		foreign key (`rolusuario`)
		references `memorand`.`roles` (`rolusuario`)
		on delete restrict on update restrict,
	constraint `fk_roles_has_usuarios_usuario`
		foreign key (`usuario`)
		references `memorand`.`usuarios` (`usuario`)
		on delete restrict on update restrict
);

create table pendientesp (
	idpendp varchar(12) primary key not null,
    nompendp varchar(20),
    subpendp varchar(30),
    descpendp longtext,
    fechafinalp varchar(10),
    completadop varchar(2)
);

create table etiquetasp (
	idetiquetap varchar(12) primary key not null,
    nometiquetap varchar(15)
);

create table usuariospendientesp (
	usuario varchar(20),
    idpendp varchar(12),
    foreign key (usuario) references usuarios (usuario),
    foreign key (idpendp) references pendientesp (idpendp)
);

create table usuariosetiquetasp (
	usuario varchar(20),
    idetiquetap varchar(12),
    foreign key (usuario) references usuarios (usuario),
    foreign key (idetiquetap) references etiquetasP (idetiquetap)
);

create table pendientesc (
	idpendc varchar(12) primary key not null,
    nompendc varchar(20),
    subpendc varchar(30),
    descpendc longtext,
    fechafinalc varchar(10),
    completadoc varchar(2)
);

create table agendasc (
	idagenda varchar(12) primary key not null,
    nomagenda varchar(20),
    descagenda text,
    codigoagenda varchar(6)
);

create table etiquetasc (
	idetiquetac varchar(12) primary key not null,
    nometiquetac varchar(15)
);

create table llevan (
	idllevan varchar(12) primary key not null,
	usuario varchar(20),
    idagenda varchar(12),
    rolagenda varchar(20),
    favorito varchar(2),
    foreign key (usuario) references usuarios (usuario),
    foreign key (idagenda) references agendasc (idagenda)
);

create table tienen (
	idtienen varchar(12) primary key not null,
	usuario varchar(20),
    idagenda varchar(12),
    idpendc varchar(12),
    autor varchar(20),
    foreign key (usuario) references usuarios (usuario),
    foreign key (idagenda) references agendasc (idagenda),
    foreign key (idpendc) references pendientesc (idpendc)
);

create table agendaetiquetas (
	idagenda varchar(12),
    idetiquetac varchar(12),
    foreign key (idagenda) references agendasc (idagenda),
    foreign key (idetiquetac) references etiquetasc (idetiquetac)
);
