public class Posicion {
    private int fila;
    private char columna;

    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }

    // Métodos get y set anteriores...
}

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        if (fila >= 1 && fila <= 8) {
        } else {
            throw IllegalArgumentException("La fila debe estar entre 1 y 8");
        }
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        if (columna >= 'a' && columna <= 'h') {
        } else {
            throw IllegalArgumentException("La columna debe estar entre 'a' y 'h'");
        }
    }
}