import java.util.Scanner;

public class test3 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        int signCount = 0;
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

        int romanOrArabic = 0;                                                                 // 0 - roman, 2 - arabic
        if(array[0].contains("I") || array[0].contains("V") || array[0].contains("X") ) {
            romanOrArabic++;
            System.out.println(romanOrArabic);
        }
        if(array[1].contains("I") || array[1].contains("V") || array[1].contains("X")) {
            romanOrArabic++;
            System.out.println(romanOrArabic);
        }

        System.out.println(romanOrArabic);

        String [] arab = {"10","1","2","3","4","5","6","7","8","9"};
        String [] rome = {"X","I","II","III","IV","V","VI","VII","VIII","IX"};
        int operand1 = 0;
        int operand2 = 0;
        if(romanOrArabic == 2){
            int x = 0;
            int i = 0;
            while(x < 1){
                if(array[0].contains(rome[i])) {
                    x++;
                    operand1 = Integer.parseInt(arab[i]);
                }
                i++;
            }
            x = 0;
            i = 0;
            while(x < 1){
                if(array[0].contains(rome[i])) {
                    x++;
                    operand2 = Integer.parseInt(arab[i]);
                }
                i++;
            }
        }
        else if(romanOrArabic == 0) {
            operand1 = Integer.parseInt(array[0]);                                             // operands
            if (operand1 > 10) {
                throw new Exception();
            }
            operand2 = Integer.parseInt(array[1]);
            if (operand2 > 10) {
                throw new Exception();
            }
        }
            else if(romanOrArabic != 2 && romanOrArabic != 0) {
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