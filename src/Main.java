import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> possibleCodes = new ArrayList<>();
        ArrayList<String> validCodes = new ArrayList<>();

        String generatedNumber;
        String zero = "0";
        int n = (int) Math.pow(2, 7);
        int l;

        for(int i = 0; i < n; i++) {
            generatedNumber = Integer.toBinaryString(i);

            if(generatedNumber.length() < 7) {
                l  = 7 - generatedNumber.length();
                generatedNumber = zero.repeat(l) + generatedNumber;
            }

            possibleCodes.add(generatedNumber);
        }

        for(int i = 0; i < n; i++) {
            generatedNumber = possibleCodes.get(i);

            int condition1 = generatedNumber.charAt(0) ^ generatedNumber.charAt(2) ^ generatedNumber.charAt(4) ^ generatedNumber.charAt(6);
            int condition2 = generatedNumber.charAt(1) ^ generatedNumber.charAt(2) ^ generatedNumber.charAt(5) ^ generatedNumber.charAt(6);
            int condition3 = generatedNumber.charAt(3) ^ generatedNumber.charAt(4) ^ generatedNumber.charAt(5) ^ generatedNumber.charAt(6);

            if(condition1 == 0 && condition2 == 0 && condition3 == 0) {
                validCodes.add(generatedNumber);
            }
        }

        System.out.println("Valid codes:");

        for(String s : validCodes) {
            System.out.println(s);
        }
    }
}
