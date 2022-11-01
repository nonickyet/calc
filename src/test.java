public class test {
    public static void main(String[] args) {
        String inputStr = "1 + 10";
        String clearedStr = inputStr.replaceAll(" ", "");
        String [] array = clearedStr.split("\\+");
        int operand1 = Integer.parseInt(array[0]);
        int operand2 = Integer.parseInt(array[1]);
        System.out.println(operand1 + operand2);


    }

}
