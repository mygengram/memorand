insert into usuarios
(usuario, contrasena, nomusuario, apellidopat, apellidomat, fechanac)
values
("nicojrz","1234","nico","juarez","barrios","2006-07-07"),
("nicotest","1234","nico","juarez","barrios","2006-07-07");

insert into roles
(rolusuario)
values
("admin"),
("usuario");

insert into rolusuarios
(usuario, rolusuario)
values
("nicojrz","admin"),
("nicotest","usuario");