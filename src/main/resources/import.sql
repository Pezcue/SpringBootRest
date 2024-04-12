INSERT INTO Proyecto (nombre, descripcion, status, fecha_creacion, fecha_actualizacion) VALUES ('Proyecto de Matemáticas', 'Desarrollar un programa para resolver ecuaciones', 'ACTIVE', '2024-04-01 10:00:00', '2024-04-01 10:00:00');
INSERT INTO Proyecto (nombre, descripcion, status, fecha_creacion, fecha_actualizacion) VALUES ('Arreglar el Jardín', 'Limpiar el jardín y plantar nuevas flores', 'INACTIVE', '2024-04-02 11:00:00', '2024-04-02 11:00:00');
INSERT INTO Proyecto (nombre, descripcion, status, fecha_creacion, fecha_actualizacion) VALUES ('Preparar Presentación de Ventas', 'Crear una presentación para la reunión de ventas', 'PAUSED', '2024-04-03 12:00:00', '2024-04-03 12:00:00');
INSERT INTO Proyecto (nombre, descripcion, status, fecha_creacion, fecha_actualizacion) VALUES ('Proyecto de Investigación Histórica', 'Investigar eventos históricos para un artículo', 'ACTIVE', '2024-04-04 13:00:00', '2024-04-04 13:00:00');
INSERT INTO Proyecto (nombre, descripcion, status, fecha_creacion, fecha_actualizacion) VALUES ('Reorganizar el Armario', 'Clasificar la ropa y deshacerse de lo que ya no se usa', 'INACTIVE', '2024-04-05 14:00:00', '2024-04-05 14:00:00');
INSERT INTO Proyecto (nombre, descripcion, status, fecha_creacion, fecha_actualizacion) VALUES ('Proyecto de Desarrollo de Software', 'Desarrollar una nueva aplicación móvil', 'PAUSED', '2024-04-06 15:00:00', '2024-04-06 15:00:00');
INSERT INTO Proyecto (nombre, descripcion, status, fecha_creacion, fecha_actualizacion) VALUES ('Planificar el Viaje de Vacaciones', 'Organizar itinerario y reservas para las vacaciones', 'ACTIVE', '2024-04-07 16:00:00', '2024-04-07 16:00:00');
INSERT INTO Proyecto (nombre, descripcion, status, fecha_creacion, fecha_actualizacion) VALUES ('Decorar la Sala de Estar', 'Comprar muebles y decorar la sala de estar', 'INACTIVE', '2024-04-08 17:00:00', '2024-04-08 17:00:00');
INSERT INTO Proyecto (nombre, descripcion, status, fecha_creacion, fecha_actualizacion) VALUES ('Estudiar para el Examen Final', 'Repasar material y hacer ejercicios de práctica', 'PAUSED', '2024-04-09 18:00:00', '2024-04-09 18:00:00');
INSERT INTO Proyecto (nombre, descripcion, status, fecha_creacion, fecha_actualizacion) VALUES ('Proyecto de Mejora de Procesos', 'Analizar procesos y proponer mejoras para la eficiencia', 'ACTIVE', '2024-04-10 19:00:00', '2024-04-10 19:00:00');

INSERT INTO tarea (nombre, descripcion, status, tipo, fecha_inicio, fecha_entrega, fecha_creacion, fecha_actualizacion, id_proyecto)
VALUES ('Investigar métodos de resolución de ecuaciones', 'Investigar y documentar diferentes métodos matemáticos para resolver ecuaciones', 'Pendiente', 'Investigación', '2024-04-01', '2024-04-20', '2024-04-01', '2024-04-10 19:38:56', 1);

INSERT INTO tarea (nombre, descripcion, status, tipo, fecha_inicio, fecha_entrega, fecha_creacion, fecha_actualizacion, id_proyecto)
VALUES ('Limpiar área del jardín', 'Limpiar el área designada del jardín y prepararla para plantar', 'Pendiente', 'Tareas Domésticas', '2024-04-02', '2024-04-15', '2024-04-02', '2024-04-10 19:38:56', 2);

INSERT INTO tarea (nombre, descripcion, status, tipo, fecha_inicio, fecha_entrega, fecha_creacion, fecha_actualizacion, id_proyecto)
VALUES ('Preparar diapositivas de la presentación', 'Diseñar y preparar las diapositivas para la presentación de ventas', 'Pendiente', 'Presentación', '2024-04-03', '2024-04-25', '2024-04-03', '2024-04-10 19:38:56', 3);

INSERT INTO tarea (nombre, descripcion, status, tipo, fecha_inicio, fecha_entrega, fecha_creacion, fecha_actualizacion, id_proyecto)
VALUES ('Investigar eventos históricos relevantes', 'Realizar investigación en fuentes históricas para recopilar información', 'Pendiente', 'Investigación', '2024-04-04', '2024-05-01', '2024-04-04', '2024-04-10 19:38:56', 4);

INSERT INTO tarea (nombre, descripcion, status, tipo, fecha_inicio, fecha_entrega, fecha_creacion, fecha_actualizacion, id_proyecto)
VALUES ('Clasificar prendas de vestir', 'Clasificar la ropa por tipo y temporada en el armario', 'Pendiente', 'Organización', '2024-04-05', '2024-04-18', '2024-04-05', '2024-04-10 19:38:56', 5);

INSERT INTO tarea (nombre, descripcion, status, tipo, fecha_inicio, fecha_entrega, fecha_creacion, fecha_actualizacion, id_proyecto)
VALUES ('Analizar requisitos de la aplicación', 'Revisar y analizar los requisitos del proyecto de desarrollo de software', 'Pendiente', 'Análisis', '2024-04-06', '2024-04-30', '2024-04-06', '2024-04-10 19:38:56', 6);

INSERT INTO tarea (nombre, descripcion, status, tipo, fecha_inicio, fecha_entrega, fecha_creacion, fecha_actualizacion, id_proyecto)
VALUES ('Investigar destinos de vacaciones', 'Investigar destinos y opciones de alojamiento para el viaje de vacaciones', 'Pendiente', 'Investigación', '2024-04-07', '2024-04-22', '2024-04-07', '2024-04-10 19:38:56', 7);

INSERT INTO tarea (nombre, descripcion, status, tipo, fecha_inicio, fecha_entrega, fecha_creacion, fecha_actualizacion, id_proyecto)
VALUES ('Comprar muebles para la sala de estar', 'Buscar y comprar muebles para renovar la sala de estar', 'Pendiente', 'Compras', '2024-04-08', '2024-04-28', '2024-04-08', '2024-04-10 19:38:56', 8);

INSERT INTO tarea (nombre, descripcion, status, tipo, fecha_inicio, fecha_entrega, fecha_creacion, fecha_actualizacion, id_proyecto)
VALUES ('Estudiar tema por tema para el examen', 'Dedicar tiempo a estudiar cada tema del examen final', 'Pendiente', 'Estudio', '2024-04-09', '2024-05-05', '2024-04-09', '2024-04-10 19:38:56', 9);

INSERT INTO tarea (nombre, descripcion, status, tipo, fecha_inicio, fecha_entrega, fecha_creacion, fecha_actualizacion, id_proyecto)
VALUES ('Realizar análisis de procesos actuales', 'Analizar procesos existentes y buscar áreas de mejora para el proyecto', 'Pendiente', 'Análisis', '2024-04-10', '2024-05-10', '2024-04-10', '2024-04-10 19:38:56', 10);
