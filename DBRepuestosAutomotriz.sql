DROP DATABASE IF EXISTS DBRepuestosAutomotriz_in5cm;
CREATE DATABASE DBRepuestosAutomotriz_in5cm;
USE DBRepuestosAutomotriz_in5cm;

CREATE TABLE Empleados( 
id_empleado int auto_increment not null, 
nombre_empleado varchar(60) not null, 
apellido_empleado varchar(60) not null, 
puesto_empleado varchar(20) null, 
email_empleado varchar(100) not null, 
primary key PK_id_empleado(id_empleado) 
);

DELIMITER $$

CREATE PROCEDURE sp_listar_empleados()
BEGIN
    SELECT * FROM Empleados;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE sp_crear_empleado(
    IN p_nombre_empleado VARCHAR(60),
    IN p_apellido_empleado VARCHAR(60),
    IN p_puesto_empleado VARCHAR(20),
    IN p_email_empleado VARCHAR(100)
)
BEGIN
    INSERT INTO Empleados
    (nombre_empleado, apellido_empleado, puesto_empleado, email_empleado)
    VALUES
    (p_nombre_empleado, p_apellido_empleado, p_puesto_empleado, p_email_empleado);
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE sp_actualizar_empleado(
    IN p_id_empleado INT,
    IN p_nombre_empleado VARCHAR(60),
    IN p_apellido_empleado VARCHAR(60),
    IN p_puesto_empleado VARCHAR(20),
    IN p_email_empleado VARCHAR(100)
)
BEGIN
    UPDATE Empleados
    SET nombre_empleado = p_nombre_empleado,
        apellido_empleado = p_apellido_empleado,
        puesto_empleado = p_puesto_empleado,
        email_empleado = p_email_empleado
    WHERE id_empleado = p_id_empleado;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE sp_eliminar_empleado(
    IN p_id_empleado INT
)
BEGIN
    DELETE FROM Empleados
    WHERE id_empleado = p_id_empleado;
END $$

DELIMITER ;

CALL sp_crear_empleado ("Carlos", "Méndez", "Vendedor", "carlos.mendez@empresa.com");
CALL sp_crear_empleado ("Ana", "López", "Cajera", "ana.lopez@empresa.com");
CALL sp_crear_empleado ("Luis", "Hernández", "Bodeguero", "luis.hernandez@empresa.com");
CALL sp_crear_empleado ("María", "García", "Administradora", "maria.garcia@empresa.com");
CALL sp_crear_empleado ("José", "Ramírez", "Vendedor", "jose.ramirez@empresa.com");


CREATE TABLE Proveedores(
    idProveedor INT NOT NULL AUTO_INCREMENT,
    nombreProveedor VARCHAR(100) NOT NULL,
    telefonoProveedor VARCHAR(15) NOT NULL,
    direccionProveedor VARCHAR(200) NOT NULL,
    emailProveedor VARCHAR(100) NOT NULL,
    PRIMARY KEY (idProveedor)
);

DELIMITER $$
CREATE PROCEDURE sp_listar_proveedores()
BEGIN
    SELECT * FROM Proveedores;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_crear_proveedor(
    IN p_nombreProveedor VARCHAR(100),
    IN p_telefonoProveedor VARCHAR(15),
    IN p_direccionProveedor VARCHAR(200),
    IN p_emailProveedor VARCHAR(100)
)
BEGIN
    INSERT INTO Proveedores VALUES (NULL, p_nombreProveedor, p_telefonoProveedor, p_direccionProveedor, p_emailProveedor);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_actualizar_proveedor(
    IN p_idProveedor INT,
    IN p_nombreProveedor VARCHAR(100),
    IN p_telefonoProveedor VARCHAR(15),
    IN p_direccionProveedor VARCHAR(200),
    IN p_emailProveedor VARCHAR(100)
)
BEGIN
    UPDATE Proveedores
    SET nombreProveedor = p_nombreProveedor,
        telefonoProveedor = p_telefonoProveedor,
        direccionProveedor = p_direccionProveedor,
        emailProveedor = p_emailProveedor
    WHERE idProveedor = p_idProveedor;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_eliminar_proveedor(IN p_idProveedor INT)
BEGIN
    DELETE FROM Proveedores WHERE idProveedor = p_idProveedor;
END $$
DELIMITER ;

CALL sp_crear_proveedor ("Distribuciones El Volante", "3011-2233", "Zona 1, Quetzaltenango", "contacto@elvolante.com");
CALL sp_crear_proveedor ("AutoServicios Mayan", "3022-3344", "Zona 3, Cobán", "ventas@mayanauto.com");
CALL sp_crear_proveedor ("Repuestos El Motor", "3033-4455", "Zona 2, Antigua Guatemala", "info@elmotor.com");
CALL sp_crear_proveedor ("Importadora RPM", "3044-5566", "Zona 9, Guatemala", "rpm@importadora.com");
CALL sp_crear_proveedor ("Autopartes Central", "3055-6677", "Zona 5, Escuintla", "central@autopartes.com");
CALL sp_crear_proveedor ("Repuestos Express", "3066-7788", "Zona 4, Jalapa", "express@repuestos.com");
CALL sp_crear_proveedor ("Motores y Más", "3077-8899", "Zona 6, Guatemala", "ventas@motoresymas.com");
CALL sp_crear_proveedor ("AutoComponentes GT", "3088-9900", "Zona 7, Mixco", "info@autogt.com");
CALL sp_crear_proveedor ("Partes Premium", "3099-1010", "Zona 10, Guatemala", "premium@partes.com");
CALL sp_crear_proveedor ("Repuestos del Sur", "3101-2020", "Zona 1, Mazatenango", "ventas@delsur.com");

CREATE TABLE Categorias(
    idCategoria INT NOT NULL AUTO_INCREMENT,
    nombreCategoria VARCHAR(100) NOT NULL,
    descripcionCategoria TEXT NOT NULL,
    PRIMARY KEY (idCategoria)
);

DELIMITER $$
CREATE PROCEDURE sp_listar_categorias()
BEGIN
    SELECT * FROM Categorias;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_crear_categoria(
    IN c_nombreCategoria VARCHAR(100),
    IN c_descripcionCategoria TEXT
)
BEGIN
    INSERT INTO Categorias VALUES (NULL, c_nombreCategoria, c_descripcionCategoria);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_actualizar_categoria(
    IN c_idCategoria INT,
    IN c_nombreCategoria VARCHAR(100),
    IN c_descripcionCategoria TEXT
)
BEGIN
    UPDATE Categorias
    SET nombreCategoria = c_nombreCategoria,
        descripcionCategoria = c_descripcionCategoria
    WHERE idCategoria = c_idCategoria;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_eliminar_categoria(IN c_idCategoria INT)
BEGIN
    DELETE FROM Categorias WHERE idCategoria = c_idCategoria;
END $$
DELIMITER ;

CALL sp_crear_categoria ("Aceites", "Lubricantes para motor y transmisión");
CALL sp_crear_categoria ("Encendido", "Componentes del sistema de encendido");
CALL sp_crear_categoria ("Carrocería", "Piezas externas del vehículo");
CALL sp_crear_categoria ("Clutch", "Componentes del sistema de embrague");
CALL sp_crear_categoria ("Combustible", "Sistema de alimentación de combustible");
CALL sp_crear_categoria ("Enfriamiento", "Control de temperatura del motor");
CALL sp_crear_categoria ("Rodamiento", "Balineras y rodamientos");
CALL sp_crear_categoria ("Suspensión", "Control de estabilidad del vehículo");
CALL sp_crear_categoria ("Iluminación", "Sistema de luces");
CALL sp_crear_categoria ("Mantenimiento", "Repuestos de servicio básico");


CREATE TABLE Repuestos(
    idRepuesto INT NOT NULL AUTO_INCREMENT,
    nombreRepuesto VARCHAR(100) NOT NULL,
    descripcionRepuesto TEXT NOT NULL,
    precioRepuesto DECIMAL(8,2) NOT NULL,
    stockRepuesto INT NOT NULL,
    idCategoria INT NOT NULL,
    idProveedor INT NOT NULL,
    PRIMARY KEY (idRepuesto),
    FOREIGN KEY (idCategoria) REFERENCES Categorias(idCategoria),
    FOREIGN KEY (idProveedor) REFERENCES Proveedores(idProveedor)
);

DELIMITER $$
CREATE PROCEDURE sp_ListarRepuestos()
BEGIN
    SELECT r.*, c.nombreCategoria, p.nombreProveedor
    FROM Repuestos r
    JOIN Categorias c ON r.idCategoria = c.idCategoria
    JOIN Proveedores p ON r.idProveedor = p.idProveedor;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_CrearRepuesto(
    IN r_nombreRepuesto VARCHAR(100),
    IN r_descripcionRepuesto TEXT,
    IN r_precioRepuesto DECIMAL(8,2),
    IN r_stockRepuesto INT,
    IN r_idCategoria INT,
    IN r_idProveedor INT
)
BEGIN
    INSERT INTO Repuestos VALUES (NULL, r_nombreRepuesto, r_descripcionRepuesto, r_precioRepuesto, r_stockRepuesto, r_idCategoria, r_idProveedor);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_ActualizarRepuesto(
    IN r_idRepuesto INT,
    IN r_nombreRepuesto VARCHAR(100),
    IN r_descripcionRepuesto TEXT,
    IN r_precioRepuesto DECIMAL(8,2),
    IN r_stockRepuesto INT,
    IN r_idCategoria INT,
    IN r_idProveedor INT
)
BEGIN
    UPDATE Repuestos
    SET nombreRepuesto = r_nombreRepuesto,
        descripcionRepuesto = r_descripcionRepuesto,
        precioRepuesto = r_precioRepuesto,
        stockRepuesto = r_stockRepuesto,
        idCategoria = r_idCategoria,
        idProveedor = r_idProveedor
    WHERE idRepuesto = r_idRepuesto;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_EliminarRepuesto(
IN r_idRepuesto INT)
BEGIN
    DELETE FROM Repuestos WHERE idRepuesto = r_idRepuesto;
END $$
DELIMITER ;

CALL sp_CrearRepuesto ("Aceite_10W40", "Aceite semisintético", 180.00, 50, 1, 1);
CALL sp_CrearRepuesto ("Bobina de Encendido", "Bobina para motor 4 cilindros", 320.00, 25, 2, 2);
CALL sp_CrearRepuesto ("Parachoques Delantero", "Parachoques plástico", 950.00, 10, 3, 3);
CALL sp_CrearRepuesto ("Kit de Clutch", "Clutch completo", 1250.00, 8, 4, 4);
CALL sp_CrearRepuesto ("Bomba de Gasolina", "Bomba eléctrica", 480.00, 20, 5, 5);
CALL sp_CrearRepuesto ("Radiador", "Radiador de aluminio", 1100.00, 7, 6, 6);
CALL sp_CrearRepuesto ("Balineras", "Juego de balineras", 260.00, 40, 7, 7);
CALL sp_CrearRepuesto ("Amortiguador Trasero", "Amortiguador derecho", 720.00, 15, 8, 8);
CALL sp_CrearRepuesto ("Luz Trasera", "Luz LED izquierda", 390.00, 18, 9, 9);
CALL sp_CrearRepuesto ("Filtro de Aire", "Filtro de aire estándar", 85.00, 60, 10, 10);

CREATE TABLE Ventas(
    idVenta INT NOT NULL AUTO_INCREMENT,
    fechaVenta DATE NOT NULL,
    clienteVenta VARCHAR(100) NOT NULL,
    idRepuesto INT NOT NULL,
    cantidadVenta INT NOT NULL,
    totalVenta DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (idVenta),
    FOREIGN KEY (idRepuesto) REFERENCES Repuestos(idRepuesto)
);

DELIMITER $$
CREATE PROCEDURE sp_ListarVentas()
BEGIN
    SELECT * FROM Ventas;
END$$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_CrearVentas(
IN p_fechaVenta DATE,
    IN p_clienteVenta VARCHAR(100),
    IN p_idRepuesto INT,
    IN p_cantidadVenta INT,
    IN p_totalVenta DECIMAL(10,2)
)
BEGIN
    INSERT INTO Ventas (
		fechaVenta,
        clienteVenta,
        idRepuesto,
        cantidadVenta,
        totalVenta
    )
    VALUES (
        p_fechaVenta,
        p_clienteVenta,
        p_idRepuesto,
        p_cantidadVenta,
        p_totalVenta
    );
END$$

DELIMITER ;;

DELIMITER $$
CREATE PROCEDURE sp_ActualizarVentas(
    IN p_idVenta INT,
    IN p_fechaVenta DATE,
    IN p_clienteVenta VARCHAR(100),
    IN p_idRepuesto INT,
    IN p_cantidadVenta INT,
    IN p_totalVenta DECIMAL(10,2)
)
BEGIN
    UPDATE Ventas
    SET
        fechaVenta = p_fechaVenta,
        clienteVenta = p_clienteVenta,
        idRepuesto = p_idRepuesto,
        cantidadVenta = p_cantidadVenta,
        totalVenta = p_totalVenta
    WHERE idVenta = p_idVenta;
END$$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_EliminarVentas(
   IN p_idVenta INT
)
BEGIN
    DELETE FROM Ventas
    WHERE idVenta = p_idVenta;
END$$

DELIMITER ;

CALL sp_CrearVentas("2025-02-01", "Juan Pérez", 1, 2, 360.00);
CALL sp_CrearVentas("2025-02-02", "Laura Gómez", 2, 1, 320.00);
CALL sp_CrearVentas("2025-02-03", "Miguel Soto", 3, 1, 950.00);
CALL sp_CrearVentas("2025-02-04", "Andrea Ruiz", 4, 1, 1250.00);
CALL sp_CrearVentas("2025-02-05", "Fernando León", 5, 2, 960.00);
CALL sp_CrearVentas("2025-02-06", "Paola Jiménez", 6, 1, 1100.00);
CALL sp_CrearVentas("2025-02-07", "Kevin Morales", 7, 3, 780.00);
CALL sp_CrearVentas("2025-02-08", "Daniela Cruz", 8, 1, 720.00);
CALL sp_CrearVentas("2025-02-09", "Óscar Reyes", 9, 2, 780.00);
CALL sp_CrearVentas("2025-02-10", "Marvin López", 10, 4, 340.00);