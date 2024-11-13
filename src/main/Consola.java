public class Consola {
    private Consola() {
    }
    public static void mostrarMenu() {
        System.out.println("1. Crear dama por defecto");
        System.out.println("2. Crear dama eligiendo el color");
        System.out.println("3. Mover");
        System.out.println("4. Salir");
    }
    public static int elegirOpcionMenu() {
        int opcion;
        do {
            System.out.print("Elige una opción del menú: ");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 4);
        return opcion;

        public static Color elegirColor() {
            int opcion;
            do {
                System.out.println("1. Blanco");
                System.out.println("2. Negro");
                System.out.print("Elige un color: ");
                opcion = Entrada.entero();
            } while (opcion < 1 || opcion > 2);
            return (opcion == 1) ? Color.BLANCO : Color.NEGRO;
        }
        public static void mostrarMenuDirecciones() {
            System.out.println("1. Noreste");
            System.out.println("2. Noroeste");
            System.out.println("3. Sureste");
            System.out.println("4. Suroeste");
        }
        public static Direccion elegirDireccion() {
            int opcion;
            do {
                mostrarMenuDirecciones();
                System.out.print("Elige una dirección: ");
                opcion = Entrada.entero();
            } while (opcion < 1 || opcion > 4);
            switch (opcion) {
                case 1: return Direccion.NORESTE;
                case 2: return Direccion.NOROESTE;
                case 3: return Direccion.SURESTE;
                case 4: return Direccion.SUROESTE;
                default: System.out.println("Opción no válida");
            }
        }
        public static int elegirPasos() {
            int pasos;
            do {
                System.out.print("Introduce el número de casillas a mover (mínimo 1): ");
                pasos = Entrada.entero();
            } while (pasos < 1);
            return pasos;

            public static void despedirse() {
                System.out.println("¡Hasta luego!!!");
            }
}
