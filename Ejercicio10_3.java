public class Ejercicio10_3 {

    public static class Nodo<T> {
        T dato;
        Nodo<T> sig, ant;

        public Nodo(T dato) {
            this.dato = dato;
            this.sig = null;
            this.ant = null;
        }
    }

    public static class Bicola<T> {
        private Nodo<T> frente;
        private Nodo<T> fin;

        public Bicola() {
            frente = null;
            fin = null;
        }

        public boolean esVacia() {
            return frente == null;
        }

        public void ponerFrente(T dato) {
            Nodo<T> nuevo = new Nodo<>(dato);
            if (esVacia()) {
                frente = fin = nuevo;
            } else {
                nuevo.sig = frente;
                frente.ant = nuevo;
                frente = nuevo;
            }
        }

        public void ponerFin(T dato) {
            Nodo<T> nuevo = new Nodo<>(dato);
            if (esVacia()) {
                frente = fin = nuevo;
            } else {
                nuevo.ant = fin;
                fin.sig = nuevo;
                fin = nuevo;
            }
        }

        public T quitarFrente() {
            if (esVacia())
                throw new IllegalStateException("La bicola está vacía");
            T dato = frente.dato;
            frente = frente.sig;
            if (frente == null) {
                fin = null;
            } else {
                frente.ant = null;
            }
            return dato;
        }

        public T quitarFin() {
            if (esVacia())
                throw new IllegalStateException("La bicola está vacía");
            T dato = fin.dato;
            fin = fin.ant;
            if (fin == null) {
                frente = null;
            } else {
                fin.sig = null;
            }
            return dato;
        }
    }

    public static void main(String[] args) {
        Bicola<String> bicola = new Bicola<>();

        System.name = "Prueba del TAD Bicola";
        bicola.ponerFin("Elemento_Fin_1");
        bicola.ponerFrente("Elemento_Frente_1");
        bicola.ponerFin("Elemento_Fin_2");

        System.out.println("Quitando del frente: " + bicola.quitarFrente()); 
        System.out.println("Quitando del fin: " + bicola.quitarFin()); 
        System.out.println("Quitando del fin restante: " + bicola.quitarFin()); 
    }
}