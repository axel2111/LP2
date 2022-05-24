DROP TABLE IF EXISTS linea_orden_venta;
DROP TABLE IF EXISTS orden_venta;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS empleado;
DROP TABLE IF EXISTS area;
DROP TABLE IF EXISTS cuenta_usuario;
DROP TABLE IF EXISTS persona;
DROP TABLE IF EXISTS producto;
CREATE TABLE area(
	id_area INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    fecha_registro DATETIME,
    ultima_modificacion DATETIME,
    activo TINYINT,
    PRIMARY KEY(id_area)
)ENGINE=InnoDB;
CREATE TABLE persona(
	id_persona INT NOT NULL AUTO_INCREMENT,
    DNI VARCHAR(8) NULL,
    nombre VARCHAR(50) NULL,
    apellido_paterno VARCHAR(50) NULL,
    genero CHAR NULL,
    fecha_nacimiento DATE NULL,
    PRIMARY KEY (id_persona))
ENGINE = InnoDB;
CREATE TABLE cuenta_usuario(
	id_cuenta_usuario INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50),
    activo TINYINT
)ENGINE = InnoDB;
CREATE TABLE empleado(
	id_empleado INT,
    fid_area INT,
    fid_cuenta_usuario INT UNIQUE,
    cargo VARCHAR(50),
    sueldo DECIMAL(10,2),
    activo TINYINT,
    PRIMARY KEY(id_empleado),
    FOREIGN KEY(id_empleado) REFERENCES persona(id_persona),
    FOREIGN KEY(fid_area) REFERENCES area(id_area),
    FOREIGN KEY(fid_cuenta_usuario) REFERENCES cuenta_usuario(id_cuenta_usuario)
)ENGINE = InnoDB;
CREATE TABLE cliente(
	id_cliente INT,
    linea_credito DECIMAL(10,2),
    categoria VARCHAR(50),
    activo TINYINT,
    PRIMARY KEY(id_cliente),
    FOREIGN KEY(id_cliente) REFERENCES persona(id_persona)
)ENGINE = InnoDB;
CREATE TABLE producto(
	id_producto INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    unidad_medida VARCHAR(50),
    precio DECIMAL(10,2),
    activo TINYINT,
    PRIMARY KEY(id_producto)
)ENGINE = InnoDB;
CREATE TABLE orden_venta(
	id_orden_venta INT AUTO_INCREMENT,
    fid_cliente INT,
    fid_empleado INT,
    total DECIMAL(10,2),
    fecha_hora_registro DATETIME,
    activo TINYINT,
    PRIMARY KEY(id_orden_venta),
    FOREIGN KEY(fid_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY(fid_empleado) REFERENCES empleado(id_empleado)
)ENGINE = InnoDB;
CREATE TABLE linea_orden_venta(
	id_linea_orden_venta INT AUTO_INCREMENT,
    fid_orden_venta INT,
    fid_producto INT,
    cantidad INT,
    subtotal DECIMAL(10,2),
    fecha_hora_registro DATETIME,
    activo TINYINT,
    PRIMARY KEY(id_linea_orden_venta),
    FOREIGN KEY (fid_orden_venta) REFERENCES orden_venta(id_orden_venta),
    FOREIGN KEY (fid_producto) REFERENCES producto(id_producto)
)ENGINE = InnoDB;
-- Borramos procedimientos almacenados
DROP PROCEDURE IF EXISTS LISTAR_AREAS_TODAS;
DROP PROCEDURE IF EXISTS INSERTAR_AREA;
DROP PROCEDURE IF EXISTS MODIFICAR_AREA;
DROP PROCEDURE IF EXISTS ELIMINAR_AREA;
DROP PROCEDURE IF EXISTS BUSCAR_AREA_POR_ID;
DROP PROCEDURE IF EXISTS INSERTAR_EMPLEADO;
DROP PROCEDURE IF EXISTS MODIFICAR_EMPLEADO;
DROP PROCEDURE IF EXISTS ELIMINAR_EMPLEADO;
DROP PROCEDURE IF EXISTS LISTAR_EMPLEADOS_TODOS;
DROP PROCEDURE IF EXISTS INSERTAR_CUENTA_USUARIO;
DROP PROCEDURE IF EXISTS LISTAR_EMPLEADOS_X_NOMBRE;
DROP PROCEDURE IF EXISTS INSERTAR_CLIENTE;
DROP PROCEDURE IF EXISTS INSERTAR_PRODUCTO;
DROP PROCEDURE IF EXISTS LISTAR_ORDENES_VENTA_X_ID_NOMBRE_DNI_CLIENTE;
DROP PROCEDURE IF EXISTS LISTAR_CLIENTES_X_NOMBREDNI;
DROP PROCEDURE IF EXISTS LISTAR_PRODUCTOS_X_NOMBRE;
DROP PROCEDURE IF EXISTS INSERTAR_ORDEN_VENTA;
DROP PROCEDURE IF EXISTS INSERTAR_LINEA_ORDEN_VENTA;
DROP PROCEDURE IF EXISTS LISTAR_LINEAS_ORDEN_VENTA_X_ID_ORDEN_VENTA;
DROP PROCEDURE IF EXISTS MODIFICAR_ORDEN_VENTA;
DROP PROCEDURE IF EXISTS ELIMINAR_ORDEN_VENTA;
DELIMITER $
CREATE PROCEDURE LISTAR_AREAS_TODAS()
BEGIN
	SELECT id_area, nombre FROM area WHERE activo = 1;
END$
CREATE PROCEDURE INSERTAR_AREA(
	OUT _id_area INT,
    IN _nombre VARCHAR(50)
)
BEGIN
	INSERT INTO area(nombre,fecha_registro,ultima_modificacion,activo) VALUES(_nombre,(now()- INTERVAL 5 HOUR),(now() - INTERVAL 5 HOUR),1);
    SET _id_area = @@last_insert_id;
END$
CREATE PROCEDURE MODIFICAR_AREA(
	IN _id_area INT,
    IN _nombre VARCHAR(50)
)
BEGIN
	UPDATE area SET nombre = _nombre, ultima_modificacion = (now() - INTERVAL 5 HOUR) WHERE id_area = _id_area;
END$
CREATE PROCEDURE ELIMINAR_AREA(
	IN _id_area INT
)
BEGIN
	UPDATE area SET activo = 0, ultima_modificacion = (now() - INTERVAL 5 HOUR) where id_area = _id_area;
END$
CREATE PROCEDURE BUSCAR_AREA_POR_ID(
	IN _id_area INT
)
BEGIN
	SELECT nombre FROM area WHERE id_area = _id_area and activo = 1;
END$
CREATE PROCEDURE INSERTAR_EMPLEADO(
	OUT _id_persona INT,
	IN _fid_area INT,
    IN _fid_cuenta_usuario INT,
    IN _DNI VARCHAR(8), 
    IN _nombre VARCHAR(50), 
    IN _apellido_paterno VARCHAR(50), 
    IN _genero CHAR(1),
    IN _fecha_nacimiento DATE,
    IN _cargo VARCHAR(50),
    IN _sueldo DECIMAL(10,2)
)
BEGIN
	INSERT INTO persona
    (DNI,nombre,apellido_paterno,genero,fecha_nacimiento) VALUES(_DNI,_nombre,_apellido_paterno,_genero,_fecha_nacimiento);
    SET _id_persona = @@last_insert_id;
    INSERT INTO empleado(id_empleado,fid_area,fid_cuenta_usuario,cargo,sueldo,activo) VALUES(_id_persona,_fid_area,_fid_cuenta_usuario,_cargo,_sueldo,1);
END$
CREATE PROCEDURE MODIFICAR_EMPLEADO(
	IN _id_persona INT,
	IN _fid_area INT,
    IN _fid_cuenta_usuario INT,
    IN _DNI VARCHAR(8), 
    IN _nombre VARCHAR(50), 
    IN _apellido_paterno VARCHAR(50), 
    IN _genero CHAR(1),
    IN _fecha_nacimiento DATE,
    IN _cargo VARCHAR(50),
    IN _sueldo DECIMAL(10,2)
)
BEGIN
	UPDATE persona SET DNI = _DNI, nombre = _nombre, apellido_paterno = _apellido_paterno, genero = _genero, fecha_nacimiento = _fecha_nacimiento WHERE id_persona = _id_persona;
    UPDATE empleado SET fid_area = _fid_area, fid_cuenta_usuario = _fid_cuenta_usuario, cargo = _cargo, sueldo = _sueldo WHERE id_empleado = _id_persona;
END$
CREATE PROCEDURE ELIMINAR_EMPLEADO(
	IN _id_persona INT
)
BEGIN
	UPDATE empleado SET activo = 0 WHERE id_empleado = _id_persona;
END$
CREATE PROCEDURE LISTAR_EMPLEADOS_TODOS()
BEGIN
	SELECT p.id_persona, p.DNI, p.nombre, p.apellido_paterno, p.genero, p.fecha_nacimiento, e.cargo, e.sueldo, a.id_area, a.nombre as nombre_area, cu.id_cuenta_usuario, cu.username, cu.password FROM persona p INNER JOIN empleado e ON p.id_persona = e.id_empleado INNER JOIN area a ON e.fid_area = a.id_area INNER JOIN cuenta_usuario cu ON cu.id_cuenta_usuario = e.fid_cuenta_usuario WHERE e.activo = 1;
END$
CREATE PROCEDURE INSERTAR_CUENTA_USUARIO(
	OUT _id_cuenta_usuario INT,
    IN _username VARCHAR(50),
    IN _password VARCHAR(50)
)
BEGIN
	INSERT INTO cuenta_usuario(username,password,activo) VALUES(_username,_password,1);
    SET _id_cuenta_usuario = @@last_insert_id;
END$
DELIMITER $
CREATE PROCEDURE LISTAR_EMPLEADOS_X_NOMBRE(
	IN _nombre VARCHAR(100)
)
BEGIN
	SELECT p.id_persona, p.DNI, p.nombre, p.apellido_paterno, p.genero, p.fecha_nacimiento, e.cargo, e.sueldo, a.id_area, a.nombre as nombre_area, cu.id_cuenta_usuario, cu.username, cu.password FROM persona p INNER JOIN empleado e ON p.id_persona = e.id_empleado INNER JOIN area a ON e.fid_area = a.id_area INNER JOIN cuenta_usuario cu ON cu.id_cuenta_usuario = e.fid_cuenta_usuario WHERE e.activo = 1 
    AND CONCAT(p.nombre,' ',p.apellido_paterno) LIKE CONCAT('%',_nombre,'%');
END$
CREATE PROCEDURE INSERTAR_CLIENTE(
	OUT _id_persona INT,
    IN _DNI VARCHAR(8), 
    IN _nombre VARCHAR(50), 
    IN _apellido_paterno VARCHAR(50), 
    IN _genero CHAR(1),
    IN _fecha_nacimiento DATE,
    IN _linea_credito DECIMAL(10,2),
    IN _categoria VARCHAR(50)
)
BEGIN
	INSERT INTO persona
    (DNI,nombre,apellido_paterno,genero,fecha_nacimiento) VALUES(_DNI,_nombre,_apellido_paterno,_genero,_fecha_nacimiento);
    SET _id_persona = @@last_insert_id;
    INSERT INTO cliente(id_cliente,linea_credito,categoria,activo) VALUES(_id_persona,_linea_credito,_categoria,1);
END$
CREATE PROCEDURE INSERTAR_PRODUCTO(
	OUT _id_producto INT,
    IN _nombre VARCHAR(100),
    IN _unidad_medida VARCHAR(50),
    IN _precio DECIMAL(10,2)
)
BEGIN
	INSERT INTO producto(nombre,unidad_medida,precio,activo) values(_nombre,_unidad_medida,_precio,1);
    SET _id_producto = @@last_insert_id;
END$
CREATE PROCEDURE LISTAR_ORDENES_VENTA_X_ID_NOMBRE_DNI_CLIENTE(
	IN _idDniNombreCliente VARCHAR(150)
)
BEGIN
	SELECT ov.id_orden_venta, c.id_cliente, p.DNI, p.nombre, p.apellido_paterno, ov.fecha_hora_registro, ov.total FROM orden_venta ov INNER JOIN cliente c ON ov.fid_cliente = c.id_cliente INNER JOIN persona p ON c.id_cliente = p.id_persona WHERE ((p.DNI LIKE CONCAT('%',_idDniNombreCliente,'%')) OR (CONCAT(p.nombre,' ',p.apellido_paterno) LIKE CONCAT('%',_idDniNombreCliente,'%')) OR (CONVERT(ov.id_orden_venta,CHAR(150)) LIKE _idDniNombreCliente)) AND (ov.activo = 1);
END$
CREATE PROCEDURE LISTAR_CLIENTES_X_NOMBREDNI(
	IN _nombreDNI VARCHAR(50)
)
BEGIN
	SELECT p.id_persona, p.DNI, p.nombre, p.apellido_paterno, p.genero, p.fecha_nacimiento, c.categoria, c.linea_credito FROM persona p INNER JOIN cliente c ON p.id_persona = c.id_cliente WHERE ((p.DNI LIKE CONCAT('%',_nombreDNI,'%')) OR (CONCAT(p.nombre,' ',p.apellido_paterno) LIKE CONCAT('%',_nombreDNI,'%'))) and c.activo = 1;
END$
CREATE PROCEDURE LISTAR_PRODUCTOS_X_NOMBRE(
	IN _nombre VARCHAR(100)
)
BEGIN
	SELECT id_producto, nombre, unidad_medida, precio FROM producto WHERE activo = 1 AND 
    nombre LIKE CONCAT('%',_nombre,'%');
END$
CREATE PROCEDURE INSERTAR_ORDEN_VENTA(
	OUT _id_orden_venta INT,
    IN _fid_cliente INT,
    IN _fid_empleado INT,
    IN _total DECIMAL(10,2)
)
BEGIN
	INSERT INTO orden_venta(fid_cliente,fid_empleado,total,fecha_hora_registro,activo) VALUES(_fid_cliente,_fid_empleado,_total,(now() - INTERVAL 5 HOUR),1);
    SET _id_orden_venta = @@last_insert_id;
END$
CREATE PROCEDURE INSERTAR_LINEA_ORDEN_VENTA(
	OUT _id_linea_orden_venta INT,
    IN _fid_orden_venta INT,
    IN _fid_producto INT,
    IN _cantidad INT,
    IN _subtotal DECIMAL(10,2)
)
BEGIN
	INSERT INTO linea_orden_venta(fid_orden_venta,fid_producto,cantidad,subtotal,fecha_hora_registro,activo) VALUES(_fid_orden_venta,_fid_producto,_cantidad,_subtotal,(now() - INTERVAL 5 HOUR),1);
    SET _id_linea_orden_venta = @@last_insert_id;
END$
CREATE PROCEDURE LISTAR_LINEAS_ORDEN_VENTA_X_ID_ORDEN_VENTA(
	IN _id_orden_venta INT
)
BEGIN
	SELECT lov.id_linea_orden_venta, p.id_producto, p.nombre, p.unidad_medida, p.precio, lov.cantidad, lov.subtotal FROM linea_orden_venta lov INNER JOIN producto p ON lov.fid_producto = p.id_producto WHERE lov.fid_orden_venta = _id_orden_venta and lov.activo = 1;
END$
CREATE PROCEDURE MODIFICAR_ORDEN_VENTA(
	IN _id_orden_venta INT,
    IN _fid_cliente INT,
    IN _fid_empleado INT,
    IN _total DECIMAL(10,2)
)
BEGIN
	UPDATE orden_venta SET fid_cliente = _fid_cliente, fid_empleado = _fid_empleado, total = _total WHERE id_orden_venta = _id_orden_venta;
    UPDATE linea_orden_venta SET activo = 0 WHERE fid_orden_venta = _id_orden_venta;
END$
CREATE PROCEDURE ELIMINAR_ORDEN_VENTA(
	IN _id_orden_venta INT
)
BEGIN
	UPDATE orden_venta SET activo = 0 WHERE id_orden_venta = _id_orden_venta;
    UPDATE linea_orden_venta SET activo = 0 WHERE fid_orden_venta = _id_orden_venta;
END$
-- Insertando algunos registros
DELIMITER ;
-- Insertamos las áreas
CALL INSERTAR_AREA(@id_area1,'VENTAS');
CALL INSERTAR_AREA(@id_area2,'FINANZAS');
CALL INSERTAR_AREA(@id_area3,'GERENCIA');
-- Insertamos cuentas de usuario
CALL INSERTAR_CUENTA_USUARIO(@id_cuenta_usuario1,'mrodriguez','123456');
CALL INSERTAR_CUENTA_USUARIO(@id_cuenta_usuario2,'jperez','123456');
CALL INSERTAR_CUENTA_USUARIO(@id_cuenta_usuario3,'kcordova','123456');
-- Insertamos empleados
CALL INSERTAR_EMPLEADO(@id_empleado1,@id_area1,@id_cuenta_usuario1,'10383702','MARIA','RODRIGUEZ','F','1990-05-10','CAJERA',2200.00);
CALL INSERTAR_EMPLEADO(@id_empleado2,@id_area1,@id_cuenta_usuario2,'18727702','JUAN','PEREZ','M','1987-10-10','VENDEDOR',2000.00);
CALL INSERTAR_EMPLEADO(@id_empleado3,@id_area2,@id_cuenta_usuario3,'19380031','KARLA','CORDOVA','F','1982-03-29','CONTADORA',3500.00);
-- Insertamos clientes
CALL INSERTAR_CLIENTE(@id_cliente1,'39871002','HUGO','VALDIVIA','M','1992-03-03',2000.00,'Clasico');
CALL INSERTAR_CLIENTE(@id_cliente2,'28709982','OSCAR','CARRANZA','M','1993-10-30',2000.00,'VIP');
CALL INSERTAR_CLIENTE(@id_cliente3,'10920091','ANGELA','GUEVARA','F','1988-03-13',3000.00,'Platinum');
CALL INSERTAR_CLIENTE(@idCliente3,'33620929','JUAN','ARENAS','M','1984-10-09',3700.00,'VIP');
CALL INSERTAR_CLIENTE(@idCliente4,'17200928','CARMEN','GAVIDIA','F','1981-02-15',1430.00,'Clasico');
CALL INSERTAR_CLIENTE(@idCliente5,'28779283','PIERINA','RUIZ','F','1984-11-23',3345.00,'VIP');
-- Insertamos productos
CALL INSERTAR_PRODUCTO(@id_producto1,'GASEOSA INKA KOLA','500 ML',2.70);
CALL INSERTAR_PRODUCTO(@id_producto2,'GASEOSA COCA COLA','1.5 LT',5.90);
CALL INSERTAR_PRODUCTO(@id_producto3,'DETERGENTE LIQUIDO BOLIVAR','940 ML',16.00);
CALL INSERTAR_PRODUCTO(@id_producto4,'LAVAVAJILLAS EN PASTA LIMON SAPOLIO','900 GR',6.10);