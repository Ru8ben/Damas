public class Dama {
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color == null) {
            System.out.println ("Tiene que haber color");
        }
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            System.out.println ("Tiene que haber posición");
        }
        this.posicion = posicion;
    }

    public boolean isEsDamaEspecial() {
        return esDamaEspecial;
    }

    public void setEsDamaEspecial(boolean esDamaEspecial) {
        this.esDamaEspecial = esDamaEspecial;
    }
    public Dama(Color color) {
        setColor(color);
        this.posicion = crearPosicionInicial(color == Color.BLANCO);
        this.esDamaEspecial = false;
    }

    private Posicion crearPosicionInicial(boolean esBlanca) {
        int fila = esBlanca ? Entrada.entero(1, 3) : Entrada.entero(6, 8);
        char columna;
        do {
            columna = (char) Entrada.entero('a', 'h');
        } while ((fila + columna) % 2 == 0);
        return Posicion(fila, columna);
        }
    public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
        validarMovimiento(direccion, pasos);

        Posicion nuevaPosicion = calcularNuevaPosicion(direccion, pasos);

        if (!esPosicionValida(nuevaPosicion)) {
            System.out.println ("El movimiento se sale del tablero");
        }

        posicion = nuevaPosicion;
        actualizarEstadoDama();
    }

    private void validarMovimiento(Direccion direccion, int pasos) throws OperationNotSupportedException {
        if (direccion == null) {
            System.out.println ("La dirección no puede ser nula");
        }
        if (pasos < 1) {
            System.out.println ("El número de pasos debe ser positivo");
        }
        if (!esDamaEspecial && pasos != 1) {
            System.out.println ("Una dama no especial solo puede moverse 1 paso");
        }
        if (!esMovimientoValido(direccion)) {
            System.out.println ("Movimiento no válido para esta dama");
        }
    }

    private Posicion calcularNuevaPosicion(Direccion direccion, int pasos) {
        int nuevaFila = posicion.getFila();
        char nuevaColumna = posicion.getColumna();

        switch (direccion) {
            case NORESTE:
                nuevaFila += pasos; nuevaColumna += pasos;
                break;
            case NOROESTE:
                nuevaFila += pasos; nuevaColumna -= pasos;
                break;
            case SURESTE:
                nuevaFila -= pasos; nuevaColumna += pasos;
                break;
            case SUROESTE:
                nuevaFila -= pasos; nuevaColumna -= pasos;
                break;
        }

        return Posicion(nuevaFila, nuevaColumna);
    }

    private boolean esPosicionValida(Posicion posicion) {
        return posicion.getFila() >= 1 && posicion.getFila() <= 8 &&
                posicion.getColumna() >= 'a' && posicion.getColumna() <= 'h';
    }

    private void actualizarEstadoDama() {
        if ((color == Color.BLANCO && posicion.getFila() == 8) ||
                (color == Color.NEGRO && posicion.getFila() == 1)) {
            esDamaEspecial = true;
        }
    }
    private boolean esMovimientoValido(Direccion direccion) {
        if (esDamaEspecial) {
            return true;
        }
        if (color == Color.BLANCO) {
            return direccion == Direccion.NORESTE || direccion == Direccion.NOROESTE;
        } else {
            return direccion == Direccion.SURESTE || direccion == Direccion.SUROESTE;
        }
    }

    @Override
    public String toString() {
        return "Dama{" +
                "color=" + color +
                ", esDamaEspecial=" + esDamaEspecial +
                ", posicion=" + posicion +
                '}';
    }
}
