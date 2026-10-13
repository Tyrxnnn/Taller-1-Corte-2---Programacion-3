import java.util.Scanner;
import java.util.Stack;

public class Ejercicio94 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] arreglo = new double[10];
        Stack<Double> pila = new Stack<>();

   
        System.out.println("Ingrese 10 números reales:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            arreglo[i] = scanner.nextDouble();
            pila.push(arreglo[i]); 
        }

        
        System.out.println("\n--- Secuencia original (Orden de ingreso) ---");
        for (double num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();

       
        System.out.println("\n--- Elementos extraídos de la pila (Orden LIFO) ---");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop() + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}