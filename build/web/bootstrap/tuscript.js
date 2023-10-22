<%-- 
    Import Memorand by Gengram © 2023
--%>
document.addEventListener("DOMContentLoaded", function() {
    const themeToggle = document.getElementById("theme-toggle");
    const elementsToToggle = document.querySelectorAll('[data-theme]');

    themeToggle.addEventListener("click", function() {
        elementsToToggle.forEach(function(element) {
            if (element.getAttribute("data-theme") === "light") {
                element.setAttribute("data-theme", "dark");
            } else {
                element.setAttribute("data-theme", "light");
            }
        });
    });
});

