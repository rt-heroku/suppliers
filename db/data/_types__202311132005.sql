INSERT INTO public."types" (id,"type","name",description) VALUES
	 (1,'Account','Proveedor','Proveedores'),
	 (2,'Account','Cliente','Clientes'),
	 (3,'Contact','Representante Legal','Es el representante legal de la empresa?'),
	 (4,'Contact','Otro','Otro tipo de Contacto'),
	 (5,'AccountStatus','Creada','Cuenta creada'),
	 (6,'AccountStatus','Activa','Cuenta activa'),
	 (7,'AccountStatus','En Pausa','Cuenta en pausa y no acepta transacciones'),
	 (8,'AccountStatus','Con Problemas','Cuenta en problemas, no acepta transacciones'),
	 (9,'AccountStatus','Desactivada','Cuenta desactivada'),
	 (10,'Payment','Exitosa','Transaccion Exitosa');
INSERT INTO public."types" (id,"type","name",description) VALUES
	 (11,'Payment','Pendiente','Transaccion Pendiente'),
	 (12,'Payment','Rechazada','Transaccion Rechazada por origen');
