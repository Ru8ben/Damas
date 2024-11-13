public class MainApp {
    private static Dama dama;

    public static void main(String[] args) {
        int opcion;
        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcionMenu();
            ejecutarOpcion(opcion);
        } while (opcion != 4);
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> crearDamaDefecto();
            case 2 -> crearDamaColor();
            case 3 -> mover();
            case 4 -> Consola.despedirse();
            default -> System.out.println("Opción no válida");
        }
    }

    private static void crearDamaDefecto() {
        dama = new Dama();
        System.out.println("Dama creada por defecto.");
        mostrarDama();
    }

    private static void crearDamaColor() {
        Color color = Consola.elegirColor();
        dama = new Dama(color);
        System.out.println("Dama creada con color elegido.");
        mostrarDama();
    }

    private static void mover() {
        if (dama == null) {
            System.out.println("No hay dama creada. Crea una dama primero.");
            return;
        }

        Direccion direccion = Consola.elegirDireccion();
        int pasos = 1;
        if (dama.isEsDamaEspecial()) {
            pasos = Consola.elegirPasos();
        }

        try {
            dama.mover(direccion, pasos);
            System.out.println("Dama movida con éxito.");
            mostrarDama();
        } catch (OperationNotSupportedException e) {
            System.out.println("Error al mover la dama: " + e.getMessage());
        }
    }

    private static void mostrarDama() {
        if (dama != null) {
            System.out.println(dama);
        } else {
            System.out.println("No hay dama creada.");
        }
    }
}
