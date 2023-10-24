<%-- 
    Document   : cuaderno
    Created on : 24 oct. 2023, 0:51:12
    Author     : zunig
--%>

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <jsp:include page="recursos/import.jsp"/>
</head>
<body>
    <div class="container mt-4">
        <h2>Sencillo Editor de Texto</h2>
        <div class="form-group">
            <textarea class="form-control" rows="10" id="editor"></textarea>
        </div>
        <div class="btn-group" role="group" aria-label="Botones">
            <button type="button" class="btn btn-primary" id="bold-button"><strong>N</strong></button>
            <button type="button" class="btn btn-primary" id="italic-button"><em>I</em></button>
        </div>
        <button type="button" class="btn btn-success" id="save-button">Guardar</button>
    </div>

    <script>
        const editor = document.getElementById("editor");
        const boldButton = document.getElementById("bold-button");
        const italicButton = document.getElementById("italic-button");
        const saveButton = document.getElementById("save-button");

        boldButton.addEventListener("click", () => {
            document.execCommand("bold");
        });

        italicButton.addEventListener("click", () => {
            document.execCommand("italic");
        });

        saveButton.addEventListener("click", () => {
            localStorage.setItem("text", editor.value);
            alert("Texto guardado correctamente.");
        });

        // Cargar el texto guardado (si existe)
        const savedText = localStorage.getItem("text");
        if (savedText) {
            editor.value = savedText;
        }

        // Escuchar eventos de cambio en el editor y guardar el texto
        editor.addEventListener("input", function() {
            const text = editor.value;
            localStorage.setItem("text", text);
        });
    </script>
</body>
</html>
