DROP PROCEDURE IF EXISTS LISTAR_AREAS_TODAS; 
DROP PROCEDURE IF EXISTS INSERTAR_AREA; 
DROP PROCEDURE IF EXISTS MODIFICAR_AREA; 
DROP PROCEDURE IF EXISTS ELIMINAR_AREA; 
DROP PROCEDURE IF EXISTS BUSCAR_AREA_POR_ID; 
DROP PROCEDURE IF EXISTS INSERTAR_EMPLEADO ; 
DELIMITER $
CREATE PROCEDURE LISTAR_AREAS_TODAS()
BEGIN 
	SELECT id_area, nombre from area WHERE activo = 1 ; 
END$
CREATE PROCEDURE INSERTAR_AREA(out _id_area int , in _nombre varchar(50))
begin 
	insert into area (nombre , activo) values (_nombre , 1 ) ; 
    SET _id_area = @@last_insert_id ; 
end$


CREATE PROCEDURE MODIFICAR_AREA(in _id_area INT, in _nombre VARCHAR(50)) 
BEGIN
	UPDATE area SET nombre = _nombre WHERE id_area = _id_area  ; 
END$	

CREATE PROCEDURE ELIMINAR_AREA(in _id_area INT )
BEGIN 
	update area SET activo = 0 WHERE id_area = _id_area ; 
END$

CREATE PROCEDURE BUSCAR_AREA_POR_ID(in _id_area int )
BEGIN 
	SELECT nombre FROM area where id_area = _id_area and activo = 1 ;
END$
##############################################################################################################
CREATE PROCEDURE INSERTAR_EMPLEADO(out _id_persona int , in _fid_area int , in _fid_cuenta_usuario int 
									, in _DNI varchar(20) , in _nombre varchar(50) ,in _apellido_paterno varchar(50) , in _genero char 
                                    , in _fecha_nacimiento date , in _cargo varchar(50) , in _sueldo double) 
begin 
	insert into persona (dni , nombre , apellido_paterno, genero ,fecha_nacimiento) values (_DNI , _nombre,  _apellido_paterno ,
																				_genero , _fecha_nacimiento) ; 
	set _id_persona = @@last_insert_id ; 
    insert into empleado(id_empleado,fid_area , fid_cuenta_usuario , cargo , sueldo , activo) values (_id_persona,_fid_area, _fid_cuenta_usuario , _cargo,
																			_sueldo , 1);
end$

