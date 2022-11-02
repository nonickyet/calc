import java.util.Scanner;

class Main {
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
        String [] arab = {"10","1","2","3","4","5","6","7","8","9"};
        String [] rome = {"X","I","II","III","IV","V","VI","VII","VIII","IX"};
        int operand1 = 0;
        int operand2 = 0;if(romanOrArabic != 2 && romanOrArabic != 0) {
            throw new Exception();
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
        else {
            int x = 0;
            int i = 0;
            while(x < 1){
                if(array[0].equals(rome[i])) {
                    x++;
                    operand1 = Integer.parseInt(arab[i]);
                }
                i++;
            }
            x = 0;
            i = 0;
            while(x < 1){
                if(array[1].equals(rome[i])) {
                    x++;
                    operand2 = Integer.parseInt(arab[i]);
                }
                i++;
            }
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
        int result;
        if(!(inputStr.equals(addStr))) {
            result = (operand1 + operand2);                                      // operation
        } else if(!(inputStr.equals(substractStr))) {
            result = (operand1 - operand2);
        } else if(!(inputStr.equals(multiplyStr))) {
            result = (operand1 * operand2);
        } else if(!(inputStr.equals(divideStr))) {
            result = (operand1 / operand2);
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
                System.out.println("");
            } else {
                String resultRome = "";
                int i = result;
                while (i != 0) {
                    if (i >= 50) {
                        resultRome = resultRome + "L";
                        i = i - 50;
                    } else if (i >= 10) {
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
                 finalResult = resultRome;
            }
        }
        return finalResult;
    }
}