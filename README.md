# RetoAutomationQA - Stefanini
#**Test Automation - Screenplay Pattern - Web**

## Pre-requisitos
1. Java 8 o Superior 
2. Gradle 5.2.1 o Superior
3. IDE de desarrollo
	- a) Eclipse 
	- b) IntelliJ

## Descripción

Este proyecto es un reto de automatización de aplicación Web, se encuentra creado bajo el patrón de diseño Screenplay e integra varios frameworks como Serenity y Cucumber dentro del manejador de proyecto Gradle.

Los tests usan tareas (tasks), interacciones (interactions), preguntas (questions), elementos de páginas (userinterface). La estructura completa del proyecto es la siguiente:
```
    + ## exceptions
        Clases que controlan las posibles excepciones técnicas y de negocios que se presentan durante la ejecución de pruebas
    + ## model
        Clases relacionadas con el modelo de dominio y sus respectivos builder cuando es necesario
    + ## tasks
        Clases que representan tareas que realiza el actor a nivel de proceso de negocio
    + ## interactions
        Clases que representan las interacciones directas con la interfaz de usuario
    + ## userinterface
        Page Objects y Page Elements. Mapean los objetos de la interfaz de usuario o aplicacion Web
    + ## questions
        Objetos usados para consultar acerca del estado de la aplicación o verificar el resultado esperado de la ejecución de prueba.
    + ## util
        Clases de utilidad
    + ## runners
        Clases que permiten correr los tests
    + ## step definitions
        Clases que mapean las líneas Gherkin a código java y donde se llaman todas las tareas(tasks) y preguntas(questions) creadas para la ejecución de 
la prueba
    + ## features
        La representación de las historias de usuarios en archivos cucumber o .feature
```


  
Este proyecto cuenta con un feature para la definición de Scenarios: 
  
  - **userRegister.feature**: En este feature se definen los escenarios para probar en la web las diferentes validaciones:	
	
        
	



  ##Escenario:  
        
    
    1.	Cuando doy clic en la opción Registrarse sin haber completado ninguno de los campos, 
		el sistema debe mostrar un mensaje de error por cada uno de los campos no completados. 
		La tabla de usuario no debe cambiarse.

    2.	Cuando hago clic en la opción Registrar y completo el campo Nombre con solo el primer nombre, 
		el sistema debe mostrar el mensaje "Ingrese un nombre completo". 
		para el campo Nombre. La tabla de usuario no debe ser cambiado.

    3.	Cuando activo la opción Registrarme habiendo llenado el campo E-mail con un e-mail inválido, 
		el sistema debería mostrar el mensaje "Ingrese un correo electrónico válido". 
		Para el campo Correo electrónico. La tabla de usuario no debe ser cambió.

    4.	Cuando doy clic en la opción Registrar habiendo llenado el campo Contraseña con menos de 8 caracteres, 
		el sistema debe mostrar el mensaje "La contraseña debe contener al menos 8 caracteres". 
		Para el campo Contraseña. la mesa de los usuarios no deben ser cambiados.

	5.	Cuando hago clic en la opción Registrarse habiendo llenado los campos Nombre, E-mail y Contraseña con datos válidos, 
   		el sistema debe mostrar debajo del formulario una tabla con los datos del usuario previamente ingresados 
		y la opción Eliminar para cada uno de ellos. La tabla debe mostrar los usuarios ordenados por ID, de menor a mayor.

	6.	Cuando activé la opción Eliminar de un elemento de tabla de usuario, el sistema debería eliminar la fila en pregunta, 
  		mostrando la tabla sin interferir con las identificaciones de otros elementos y su orden.



---
  
---
## Instalación

Para instalar el proyecto deben seguir los siguientes pasos:
  
**1. Clonar el proyecto**

```
git clone origin https://github.com/CristianHdezZ/Reto-TesteQA-Stefanini.git
```

**2. Importar el proyecto**
  
Para importar el proyecto debe hacerlo desde el IDE de su preferencia seleccionando la carpeta **"Reto-TesteQA-Stefanini"** como un proyecto Gradle. 
  
  
**3. Ejecutar el proyecto** 

Para ejecutar el proyecto debe hacerlo a través de uno de los siguientes pasos: 
  
**3.1 A través de línea de comando**
  
Si se desea realizar a través de la línea de comando se debe ejecutar desde una consola de comandos (de su preferencia) con el comando: 

```
gradle clean test aggregate --info
```
  
**3.2 A través de IDE** 
  
Si se desea realizar la ejecución a través del IDE de desarrollo, se debe seleccionar la clase **"UserRegisterRunner.class"** y dar clic derecho, seleccionar la opción que permita correr la prueba. 
  
---
  
---
## ️Autores
* **Cristian Hernandez Z.** - [CristianHdezZ](https://github.com/CristianHdezZ/)
---

