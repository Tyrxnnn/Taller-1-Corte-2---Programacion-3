import java.util.Stack;

public class Ejercicio92 {

    public static void mostrarPila(Stack<String> pilaOriginal) {
        Stack<String> pilaAuxiliar = new Stack<>();

        System.out.println("--- Contenido de la pila (desde la cima hasta la base) ---");

        while (!pilaOriginal.isEmpty()) {
            String elemento = pilaOriginal.pop();
            System.out.println(elemento);
            pilaAuxiliar.push(elemento);
        }

        while (!pilaAuxiliar.isEmpty()) {
            pilaOriginal.push(pilaAuxiliar.pop());
        }
    }
}