import java.util.Objects;

public class Posicion {
    private int fila;
    private char columna;

    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
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
    public Posicion(Posicion otraPosicion) {
        this.fila = otraPosicion.fila;
        this.columna = otraPosicion.columna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return fila == posicion.fila && columna == posicion.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    @Override
    public String toString() {
        return "Posicion{" +
                "fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}