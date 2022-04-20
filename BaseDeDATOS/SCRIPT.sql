DROP TABLE IF EXISTS cliente ; 
DROP TABLE IF EXISTS empleado ; 
DROP TABLE IF EXISTS area ; 
DROP TABLE IF EXISTS cuenta_usuario ; 
DROP TABLE IF EXISTS persona ; 
CREATE TABLE area (
	id_area INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    activo TINYINT,
    PRIMARY KEY (id_area) 
		
)ENGINE = InnoDB ;

CREATE TABLE persona (
  idPersona INT NOT NULL AUTO_INCREMENT,
  DNI VARCHAR(8) NULL,
  nombre VARCHAR(50) NULL,
  apellido_paterno VARCHAR(50) NULL,
  genero char NULL, 
  fecha_nacimiento DATE NULL,
  PRIMARY KEY (idPersona))
ENGINE = InnoDB;
CREATE TABLE cuenta_usuario(
	id_cuenta_usuario INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR (50),
    activo TINYINT
)ENGINE = InnoDB ; 
CREATE TABLE empleado (
	id_empleado  INT , 
    fid_area INT ,
    fid_cuenta_usuario INT UNIQUE , 
    cargo VARCHAR (50) , 
    sueldo DECIMAL(10,2),
    activo TINYINT ,
    PRIMARY KEY (id_empleado), 
    FOREIGN KEY (id_empleado) REFERENCES persona (idPersona),
	FOREIGN KEY (fid_area) REFERENCES area(id_area),
    FOREIGN KEY (fid_cuenta_usuario) REFERENCES cuenta_usuario(id_cuenta_usuario)
)ENGINE = InnoDB ; 

CREATE TABLE cliente (
	id_cliente INT PRIMARY KEY , 
    linea_credito DECIMAL(10,2),
    categoria CHAR ,
    FOREIGN KEY (id_cliente) REFERENCES persona(idPersona)
)ENGINE = InnoDB  ; 