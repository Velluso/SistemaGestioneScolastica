// FILE DA MODIFICARE + AGGIUNGERE COMMENTI CON SPIEGAZIONE FUNZIONI


var massimaX = document.body.clientWidth;

var massimaY = document.body.clientHeight;

var metaX = massimaX / 2;

var metaY = massimaY / 2;

var canvas = document.createElement("canvas");
document.body.appendChild(canvas);

canvas.width = massimaX;
canvas.height = massimaY;

var context = canvas.getContext("2d");

var conteggioPunti = 200;

var punti = [];


// CREA PUNTI

for (var i = 0; i < conteggioPunti; i++) {
    punti.push(new puntini());
}

// ANIMAZIONE PUNTI

function render() {
    context.fillStyle = "#000000";
    context.fillRect(0, 0, massimaX, massimaY);
    for (var i = 0; i < conteggioPunti; i++) {
        punti[i].draw();
        punti[i].move();
    }
    requestAnimationFrame(render);
}


// CLASSI PUNTI

// @costruttore

function puntini() {

    this.radice_x = 2 * Math.random() * metaX + 1;
    this.radice_y = 1.2 * Math.random() * metaY + 1;
    this.alfa = Math.random() * 360 + 1;
    this.velocita = Math.random() * 100 < 50 ? 1 : -1;
    this.velocita *= 0.1;
    this.dimensione = Math.random() * 5 + 1;
    this.colore = Math.floor(Math.random() * 256);

}

// DISEGNA PUNTO
puntini.prototype.draw = function() {

    // CALCOLO COORDINATE POLARI

    var dx = metaX + this.radice_x * Math.cos(this.alfa / 180 * Math.PI);
    var dy = metaY + this.radice_y * Math.sin(this.alfa / 180 * Math.PI);

    // IMPOSTA COLORE

    context.fillStyle = "rgb(" + this.colore + "," + this.colore + "," + this.colore + ")";

    // DISEGNA PUNTO
    context.fillRect(dx, dy, this.dimensione, this.dimensione);

};

// CALCOLO NUOVA POSIZIONE NELLE COORDINATE POLARI

puntini.prototype.move = function() {

    this.alfa += this.velocita;

    // CAMBIA COLORE

    if (Math.random() * 100 < 50) {
        this.colore += 1;
    } else {
        this.colore -= 1;
    }

};

// INIZIALIZZA ANIMAZIONE
render();