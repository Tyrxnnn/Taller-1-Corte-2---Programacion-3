import java.util.Stack;

public class Ejercicio95 {

  
    private static int precedencia(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infijaAPrefija(String expresionInfija) {
        
        StringBuilder invertida = new StringBuilder();
        for (int i = expresionInfija.length() - 1; i >= 0; i--) {
            char c = expresionInfija.charAt(i);
            if (c == '(') {
                invertida.append(')');
            } else if (c == ')') {
                invertida.append('(');
            } else {
                invertida.append(c);
            }
        }

       
        StringBuilder postfijaTemp = new StringBuilder();
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < invertida.length(); i++) {
            char c = invertida.charAt(i);

            
            if (Character.isLetterOrDigit(c)) {
                postfijaTemp.append(c);
            } 
            
            else if (c == '(') {
                pila.push(c);
            } 
          
            else if (c == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    postfijaTemp.append(pila.pop());
                }
                if (!pila.isEmpty()) pila.pop(); 
            } 
           
            else {
                while (!pila.isEmpty() && precedencia(c) < precedencia(pila.peek())) {
                    postfijaTemp.append(pila.pop());
                }
                pila.push(c);
            }
        }

        
        while (!pila.isEmpty()) {
            postfijaTemp.append(pila.pop());
        }

       
        return postfijaTemp.reverse().toString();
    }

    public static void main(String[] args) {
        String expresion = "(x-y)/(z+w)-(z+y)^x";
        String prefija = infijaAPrefija(expresion);
        System.out.println("Expresión Infija: " + expresion);
        System.out.println("Expresión Prefija: " + prefija);
    }
}