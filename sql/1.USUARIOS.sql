insert into Usuarios
(usuario, contrasena, nomUsuario, apellidoPat, apellidoMat, fechaNac)
values
("nicojrz","1234","nico","juarez","barrios","2006-07-07"),
("nicotest","1234","nico","juarez","barrios","2006-07-07");

insert into Roles
(rolUsuario)
values
("admin"),
("usuario");

insert into Rol_Usuario
(usuario, rolUsuario)
values
("nicojrz","admin"),
("nicotest","usuario");