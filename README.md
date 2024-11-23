<h1>Challenge LiterAlura</h1>
    <h3>Desarrollado por Roldán Nicolás</h3>

   <p>Este proyecto consiste en una aplicación de consola desarrollada en Java con el framework <strong>Spring</strong>. La app interactúa con la <strong>API de Gutendex</strong>, consumiendo sus datos para obtener información sobre libros y autores. Posteriormente, guarda estos datos en una base de datos <strong>PostgreSQL</strong>.</p>

  <p>El sistema permite realizar operaciones básicas de manejo de datos relacionados con libros y autores. Aunque la aplicación se desarrolla en una arquitectura Spring típica, su naturaleza de consola limita la implementación de un CRUD completo. Sin embargo, las funcionalidades básicas requeridas por el curso de Alura LATAM han sido implementadas correctamente.</p>

  <h3>Funcionalidades principales:</h3>
    <ul>
        <li><strong>Búsqueda de libros por título</strong>: Consume la API de Gutendex para obtener información sobre libros.</li>
        <li><strong>Registro de libros y autores en la base de datos</strong>: Los libros y autores obtenidos de la API son almacenados en PostgreSQL.</li>
        <li><strong>Listado de libros y autores</strong>: Se pueden listar los libros y autores registrados en la base de datos.</li>
        <li><strong>Filtrado de autores vivos por período de tiempo</strong>: Los autores pueden ser filtrados por su año de nacimiento o fallecimiento.</li>
    </ul>

   <h3>Tecnologías utilizadas:</h3>
    <ul>
        <li><strong>Java 17</strong>: Lenguaje principal del proyecto.</li>
        <li><strong>Spring Framework</strong>: Framework utilizado para gestionar la lógica de la aplicación.</li>
        <li><strong>PostgreSQL</strong>: Base de datos utilizada para almacenar la información de los libros y autores.</li>
        <li><strong>Gutendex API</strong>: API externa para obtener datos de libros y autores.</li>
    </ul>

  <h3>Instalación</h3>
    <p>Para poder ejecutar este proyecto localmente, sigue estos pasos:</p>
    <ol>
        <li><strong>Clonar el repositorio</strong>:
            <pre><code>git clone https://github.com/tu_usuario/tu_repositorio.git</code></pre>
        </li>
        <li><strong>Configurar la base de datos</strong>:
            <ul>
                <li>Asegúrate de tener una instancia de <strong>PostgreSQL</strong> corriendo en tu máquina.</li>
                <li>Crea una base de datos llamada <code>literalura</code> (o el nombre que prefieras).</li>
                <li>Configura las credenciales de conexión en el archivo <code>application.properties</code> de Spring.</li>
            </ul>
        </li>
        <li><strong>Instalar dependencias</strong>:
            <pre><code>mvn install</code></pre>
        </li>
        <li><strong>Ejecutar la aplicación</strong>:
            <pre><code>mvn spring-boot:run</code></pre>
        </li>
    </ol>

   <h3>Uso</h3>
    <p>Una vez ejecutada la aplicación, se mostrará un menú interactivo en la consola donde puedes:</p>
    <ul>
        <li>Buscar y registrar libros por título.</li>
        <li>Listar los libros y autores registrados en la base de datos.</li>
        <li>Filtrar autores vivos en un período de tiempo.</li>
        <li>Listar libros por idioma.</li>
    </ul>
    <p>La aplicación continuará ejecutándose hasta que decidas salir eligiendo la opción correspondiente en el menú.</p>

   <h3>Mejoras posibles</h3>
    <p>Este proyecto está en desarrollo, y algunas mejoras podrían incluir:</p>
    <ul>
        <li><strong>Implementación de un CRUD completo</strong>: Añadir opciones de edición y eliminación de libros y autores en la base de datos.</li>
        <li><strong>Interfaz gráfica de usuario (GUI)</strong>: Desarrollar una versión con interfaz gráfica para facilitar la interacción.</li>
        <li><strong>Mejor manejo de errores y validación de entradas</strong>: Mejorar el manejo de excepciones y la validación de las entradas del usuario.</li>
    </ul>
