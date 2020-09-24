import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private double a;
    private double b;
    private String operator;
    private Scanner scanner = new Scanner(System.in);

    void setA(double a) {
        this.a = a;
    }

    void setB(double b) {
        this.b = b;
    }

    double scan(String var) {
        while (true) {
            try {
                System.out.printf("Zadej číslo %s: ", var);
                return Double.parseDouble(scanner.next());
                //break;
            } catch (NumberFormatException e) {
                System.out.println("Chybný vstup. Zadej desetinné číslo.");
            }
        }

    }

    void setOperator(String operator) {
        this.operator = operator;
    }

    String scanOperator() {
        while (true) {
            try {
                System.out.println("Zadej operátor (+, -, *, /): ");
                operator = scanner.next();
                if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                    return operator;
                } else {
                    System.out.println("Operátor musí být: +, -, * nebo / .");
                }
            } catch (InputMismatchException e) {
                System.out.println("Chybný vstup");
            }
        }
    }

    double compute() {
        Operation operation = null;
        switch (operator) {
            case "+":
                operation = new Addition();
                break;
            case "-":
                operation = new Subtraction();
                break;
            case "*":
                operation = new Multiplication();
                break;
            case "/":
                operation = new Division();
                break;
            default:
                break;
        }
        if (!(operation == null)) {
            return operation.calculate(a, b);
        } else {
            System.out.println("\n!!! Neznámý operátor !!! \n");
            return -1;
        }
    }

    void printResult(double result) {
        System.out.printf("Výsledek: %.2f.  ", result);
    }

    boolean decideIfContinue() {
        System.out.println("Chceš pokračovat ?  ANO / NE ");
        return !scanner.next().toUpperCase().equals("NE");
    }

    public static void main(String[] args) {

        boolean userWantsContinue = true;

//      print introduction
        System.out.println();
        System.out.println("Program Kalkulačka");
        System.out.println("Provádí operace s desetinnými čísly (sčítání, odčítání, násobení, dělení)");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println();

//      make object
        Calculator calculator = new Calculator();

        while (userWantsContinue) {

//          get variables and operator
            calculator.setA(calculator.scan("a"));
            calculator.setB(calculator.scan("b"));
            calculator.setOperator(calculator.scanOperator());

//          perform operation and print result
            calculator.printResult(calculator.compute());

//          decide if continue
            userWantsContinue = calculator.decideIfContinue();
        }
    }
}
