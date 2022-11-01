import java.util.Objects;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        int signCount = 0;
        int romanOrArabic = 0;                                                                 // 0 - roman, 1 - arabic
        if(inputStr.contains("I") || inputStr.contains("V") || inputStr.contains("X")) {
            romanOrArabic++;
        }
        String clearedStr = inputStr.replaceAll(" ", "");
        String[] array = new String[10];
        if(clearedStr.contains("+")) {                                                         // creates array
            array = clearedStr.split("\\+");
        } else if(clearedStr.contains("-")) {
            array = clearedStr.split("-");
        } else if(clearedStr.contains("/")) {
            array = clearedStr.split("/");
        } else if(clearedStr.contains("*")) {
            array = clearedStr.split("\\*");
        }
        int operand1 = Integer.parseInt(array[0]);                                             // operands
        if(operand1 > 10){
            throw new Exception();
        }
        int operand2 = Integer.parseInt(array[1]);
        if(operand2 > 10){
            throw new Exception();
        }
        String addStr = inputStr.replace("+", "");           // dunno, sort of sign(+, -, /, *) counter
        String substractStr = inputStr.replace("-", "");
        String multiplyStr = inputStr.replace("*", "");
        String divideStr = inputStr.replace("/", "");
        signCount = signCount +(inputStr.length() - inputStr.replaceAll("\\+", "").length());
        signCount = signCount +(inputStr.length() - inputStr.replaceAll("-", "").length());
        signCount = signCount +(inputStr.length() - inputStr.replaceAll("\\*", "").length());
        signCount = signCount +(inputStr.length() - inputStr.replaceAll("/", "").length());
        if(signCount != 1) {
            throw new Exception();
        }
        if(!(inputStr.equals(addStr))) {
            System.out.println(operand1 + operand2);    // operation
        } else if(!(inputStr.equals(substractStr))) {
            System.out.println(operand1 - operand2);
        } else if(!(inputStr.equals(multiplyStr))) {
            System.out.println(operand1 * operand2);
        } else if(!(inputStr.equals(divideStr))) {
            System.out.println(operand1 / operand2);
        } else {
            throw new Exception();
        }

    }
}