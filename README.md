Información General de la App

La Aplicación de Notas desarrollada en este proyecto permite a los usuarios ver una lista de notas previamente guardadas y agregar nuevas notas a través de una interfaz de usuario construida con Jetpack Compose.

Características principales:

Visualización de Notas:

Las notas se muestran en una lista, con cada nota contenida dentro de una tarjeta (ItemNote).
Si no hay notas, se muestra un mensaje indicando que no hay notas disponibles.
Agregar Notas:

Los usuarios pueden agregar nuevas notas al hacer clic en un botón de agregar (IconButton con el ícono de “Agregar nota”).
Al hacer clic en este botón, se muestra un diálogo donde el usuario puede ingresar un título y contenido para la nueva nota.
Una vez que la nota es guardada, se agrega a la lista y se cierra el diálogo.
Navegación:

Aunque el código tiene referencias a la navegación con NavController, la función de navegación está enfocada en la apertura del diálogo para agregar notas, más que en cambiar de pantalla.
Flujo de la Aplicación:

La pantalla principal (ListNotes) muestra las notas en una lista. Si el usuario desea agregar una nueva nota, hace clic en el botón de agregar, lo que activa un diálogo donde puede ingresar los detalles de la nueva nota.
El código está diseñado para ser escalable, permitiendo la expansión con nuevas funcionalidades como edición de notas, categorías, o sincronización con un backend.
Marifer Morillo Gómez
Matricula 2020-0984