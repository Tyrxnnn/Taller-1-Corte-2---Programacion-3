public class Ejercicio10_5 {

    public static class BicolaCircular {
        private char[] array;
        private int frente;
        private int fin;
        private int capacidad;
        private int numElementos;

        public BicolaCircular(int capacidad, int frenteInicial, int finInicial, char[] elementosIniciales) {
            this.capacidad = capacidad;
            this.array = new char[capacidad];
            this.frente = frenteInicial;
            this.fin = finInicial;
            this.numElementos = elementosIniciales.length;
            
            int idx = frente;
            for (char c : elementosIniciales) {
                array[idx] = c;
                idx = (idx + 1) % capacidad;
            }
        }

        public void ponerFin(char c) {
            fin = (fin + 1) % capacidad;
            array[fin] = c;
            numElementos++;
        }

        public void ponerFrente(char c) {
            frente = (frente - 1 + capacidad) % capacidad;
            array[frente] = c;
            numElementos++;
        }

        public char quitarFrente() {
            char c = array[frente];
            frente = (frente + 1) % capacidad;
            numElementos--;
            return c;
        }

        public void imprimirEstado(String descripcionAccion) {
            System.out.println("Acción: " + descripcionAccion);
            System.out.println("  Extremos -> frente = " + frente + ", fin = " + fin);
            System.out.print("  Bicola: ");
            if (numElementos == 0) {
                System.out.println("(vacía)");
            } else {
                int idx = frente;
                for (int i = 0; i < numElementos; i++) {
                    System.out.print(array[idx] + (i < numElementos - 1 ? ", " : ""));
                    idx = (idx + 1) % capacidad;
                }
                System.out.println("\n");
            }
        }
    }

    public static void main(String[] args) {
        char[] iniciales = {'A', 'C', 'E'};
        BicolaCircular bicola = new BicolaCircular(9, 5, 7, iniciales);
        
        bicola.imprimirEstado("Estado inicial");

        bicola.ponerFin('F');
        bicola.ponerFin('K');
        bicola.imprimirEstado("Añadir los elementos F y K por el final");

        bicola.ponerFrente('R');
        bicola.ponerFrente('W');
        bicola.ponerFrente('V');
        bicola.imprimirEstado("Añadir los elementos R, W y V por el frente");

        bicola.ponerFin('M');
        bicola.imprimirEstado("Añadir el elemento M por el final");

        bicola.quitarFrente();
        bicola.quitarFrente();
        bicola.imprimirEstado("Eliminar dos caracteres por el frente");

        bicola.ponerFin('K');
        bicola.ponerFin('L');
        bicola.imprimirEstado("Añadir los elementos K y L por el final");

        bicola.ponerFrente('S');
        bicola.imprimirEstado("Añadir el elemento S por el frente");
    }
}