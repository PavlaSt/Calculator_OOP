import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorOOP {
    double a;
    double b;
    String operator;
    static boolean checker = true;
    Scanner scanner = new Scanner(System.in);

    void setA(double a) {
        this.a = a;
    }

    void setB(double b){
        this.b = b;
    }

    double scan(String var) {
        while (true) {
            try {
                System.out.printf("Zadej číslo %s: ", var);
                return Double.parseDouble(scanner.next());
                //break;
            } catch (NumberFormatException e) {
                System.out.println("Chybný vstup");
            }
        }

    }

    void setOperator(String operator) {
        this.operator = operator;
    }

    String scanOperator() {
        while (true) {
            try {
                System.out.println("Zadej operátor: ");
                operator = scanner.next();
                if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                    return operator;
                } else {
                    System.out.println("Operátor musí být: +, -, * nebo /.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Chybný vstup");
            }
        }
    }

    double count() {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                try {
                    return a / b;
                } catch (ArithmeticException e) {
                    System.out.println("Nulou dělit nelze! Je nutno zadat jinou hodnotu b nebo jiný operátor.");
                    break;
                }
            default:
                System.out.println("Chybný vstup");
                break;
        }
        return 0;
    }

    void printResult(double result) {
        System.out.printf("Výsledek: %.2f.  ", result);
    }

    void decideIfContinue() {
        System.out.println("Chceš pokračovat ?  ANO / NE ");
        String goOn = scanner.next();

        if (goOn.toUpperCase().equals("NE")) {
            checker = false;
        }
    }

    public static void main(String[] args) {
//      print introduction
        System.out.println("Program Kalkulačka");
        System.out.println();
        System.out.println("Provádí operace s celými čísly (sčítání, odčítání, násobení, dělení");

//      make object
        CalculatorOOP calculator = new CalculatorOOP();

        while (checker) {

//          get variables
            calculator.setA(calculator.scan("a"));
            calculator.setB(calculator.scan("b"));
            calculator.setOperator(calculator.scanOperator());

//          perform operation and print result
            calculator.printResult(calculator.count());


//          decide if continue
            calculator.decideIfContinue();

        }
    }
}
