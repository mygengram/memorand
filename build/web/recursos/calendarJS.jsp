<script>
    let meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
    let diasSemana = ["Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb"];
    let hoy = new Date();
    let year = hoy.getFullYear();
    let month = hoy.getMonth();
    let diaActual = hoy.getDate();

    function drawCalendario() {
        let calendarBody = document.getElementById("calendario");
        let firstDay = new Date(year, month, 1);
        let lastDay = new Date(year, month + 1, 0);
        let startingDay = firstDay.getDay();
        let totalDays = lastDay.getDate();
        let date = 1;
        document.getElementById("mesAño").innerText = meses[month] + " " + year;
        calendarBody.innerHTML = "";
        for (let i = 0; date <= totalDays; i++) {
            let semana = document.createElement("tr");
            for (let j = 0; j < 7; j++) {
                let dia = document.createElement("td");
                dia.classList.add("text-center");
                dia.classList.add("fw-bold");
                if (j === 0 || j === 6) {
                    dia.classList.add("text-secondary");
                }
                if (i === 0 && j < startingDay) {
                    dia.innerText = "";
                } else if (date <= totalDays) {
                    dia.innerText = date;
                    if (year === hoy.getFullYear() && month === hoy.getMonth() && date === hoy.getDate()) {
                        dia.classList.add("text-primary");
                    }
                    date++;
                }
                semana.appendChild(dia);
            }
            calendarBody.appendChild(semana);
        }
    }

    function drawMesesSelector() {
        let mesSelectorBody = document.getElementById("meses");
        mesSelectorBody.innerHTML = "";
        for (let i = 0; i < meses.length; i++) {
            let mes = document.createElement("tr");
            let mesName = document.createElement("td");
            mesName.innerText = meses[i];
            mes.appendChild(mesName);
            mes.addEventListener("click", function () {
                month = i;
                drawCalendario();
                document.getElementById("mesSelector").style.display = "none";
            });
            mesSelectorBody.appendChild(mes);
        }
    }

    function drawAñosSelector() {
        let añoSelectorBody = document.getElementById("años");
        añoSelectorBody.innerHTML = "";
        for (let i = year - 10; i <= year + 10; i++) {
            let año = document.createElement("tr");
            let añoNumber = document.createElement("td");
            añoNumber.innerText = i;
            año.appendChild(añoNumber);
            año.addEventListener("click", function () {
                year = i;
                drawCalendario();
                document.getElementById("añoSelector").style.display = "none";
            });
            añoSelectorBody.appendChild(año);
        }
    }

    document.getElementById("btnAnterior").addEventListener("click", function () {
        month--;
        if (month < 0) {
            month = 11;
            year--;
        }
        drawCalendario();
    });

    document.getElementById("btnSiguiente").addEventListener("click", function () {
        month++;
        if (month > 11) {
            month = 0;
            year++;
        }
        drawCalendario();
    });

    document.getElementById("btnElegirMes").addEventListener("click", function () {
        drawMesesSelector();
        document.getElementById("mesSelector").style.display = "block";
        document.getElementById("añoSelector").style.display = "none";
    });

    document.getElementById("btnElegirAño").addEventListener("click", function () {
        drawAñosSelector();
        document.getElementById("añoSelector").style.display = "block";
        document.getElementById("mesSelector").style.display = "none";
    });

    drawCalendario();
</script>
