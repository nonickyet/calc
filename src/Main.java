import java.util.Scanner;

class Main {
    static void main(String[] args) throws Exception {   // for tests, just add "public" at the beginning of the line
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        System.out.println(calc(inputStr));
    }
    public static String calc(String inputStr) throws Exception{
        int signCount = 0;
        if(inputStr.length() < 3){
            throw new Exception();
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
        int romanOrArabic = 0;
        if(array[0].contains("I") || array[0].contains("V") || array[0].contains("X") ) {
            romanOrArabic++;
        }
        if(array[1].contains("I") || array[1].contains("V") || array[1].contains("X")) {
            romanOrArabic++;
        }
        int[] operand = orepands(array, romanOrArabic);
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
        int result;
        if(!(inputStr.equals(addStr))) {
            result = (operand[0] + operand[1]);                                      // operation
        } else if(!(inputStr.equals(substractStr))) {
            result = (operand[0] - operand[1]);
        } else if(!(inputStr.equals(multiplyStr))) {
            result = (operand[0] * operand[1]);
        } else if(!(inputStr.equals(divideStr))) {
            result = (operand[0] / operand[1]);
        } else {
            throw new Exception();
        }
        String finalResult = "";
        if(romanOrArabic == 0) {
            finalResult = "" + result;
        }
        else {
            if(result < 0){
                throw new Exception();
            } else if (result < 1) {
                finalResult = "";
            } else {
                String resultRome = "";
                int i = result;
                while (i != 0) {
                    if (i == 100) {
                        resultRome = resultRome + "C";
                        i = i - 100;
                    }else if (i >= 90) {
                        resultRome = resultRome + "XC";
                        i = i - 90;
                    } else if (i >= 50) {
                        resultRome = resultRome + "L";
                        i = i - 50;
                    } else if (i >= 40) {
                        resultRome = resultRome + "XL";
                        i = i - 40;
                    }else if (i >= 10) {
                        resultRome = resultRome + "X";
                        i = i - 10;
                    } else if (i >= 9) {
                        resultRome = resultRome + "IX";
                        i = i - 9;
                    } else if (i >= 5) {
                        resultRome = resultRome + "V";
                        i = i - 5;
                    } else if (i >= 4) {
                        resultRome = resultRome + "IV";
                        i = i - 4;
                    } else if (i >= 1) {
                        resultRome = resultRome + "I";
                        i = i - 1;
                    }
                }
                 finalResult = "" + resultRome;
            }
        }
        return finalResult;
    }
    static int[] orepands(String[] array, int romanOrArabic) throws Exception {
        int[] operand = {0, 0};
        String [] arab = {"10","1","2","3","4","5","6","7","8","9"};
        String [] rome = {"X","I","II","III","IV","V","VI","VII","VIII","IX"};
        if(romanOrArabic != 2 && romanOrArabic != 0) {
            throw new Exception();
        } else if(romanOrArabic == 0) {
            operand[0] = Integer.parseInt(array[0]);                                             // operands
            if (operand[0] > 10) {
                throw new Exception();
            }
            operand[1] = Integer.parseInt(array[1]);
            if (operand[1] > 10) {
                throw new Exception();
            }
        } else {
            int x = 0;
            int i = 0;
            while(x < 1){
                if(array[0].equals(rome[i])) {
                    x++;
                    operand[0] = Integer.parseInt(arab[i]);
                }
                i++;
            }
            x = 0;
            i = 0;
            while(x < 1){
                if(array[1].equals(rome[i])) {
                    x++;
                    operand[1] = Integer.parseInt(arab[i]);
                }
                i++;
            }
        }
        return operand;
    }
}