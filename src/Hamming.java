import java.util.ArrayList;

public class Hamming {
    private ArrayList<String> possibleCodes;
    private ArrayList<String> validCodes;
    private int n;

    public Hamming(int n) {
        this.possibleCodes = new ArrayList<>();
        this.validCodes  = new ArrayList<>();
        this.n = (int) Math.pow(2, n);
    }

    public void generate() {
        String generatedNumber;
        int l, condition1, condition2, condition3;

        for(int i = 0; i < n; i++) {
            generatedNumber = Integer.toBinaryString(i);

            if(generatedNumber.length() < 7) {
                l = 7 - generatedNumber.length();
                generatedNumber = "0".repeat(l) + generatedNumber;
            }

            possibleCodes.add(generatedNumber);
        }

        for(int i = 0; i < n; i++) {
            generatedNumber = possibleCodes.get(i);

            condition1 = generatedNumber.charAt(0) ^ generatedNumber.charAt(2) ^ generatedNumber.charAt(4) ^ generatedNumber.charAt(6);
            condition2 = generatedNumber.charAt(1) ^ generatedNumber.charAt(2) ^ generatedNumber.charAt(5) ^ generatedNumber.charAt(6);
            condition3 = generatedNumber.charAt(3) ^ generatedNumber.charAt(4) ^ generatedNumber.charAt(5) ^ generatedNumber.charAt(6);

            if(condition1 == 0 && condition2 == 0 && condition3 == 0) {
                validCodes.add(generatedNumber);
            }
        }

        System.out.println("Valid codes:");

        for(String s : validCodes) {
            System.out.println(s);
        }
    }

    public int distance(String c1, String c2) {
        int d = 0;

        for(int i = 0; i < c1.length(); i++) {
            d += c1.charAt(i) ^ c2.charAt(i);
        }

        return d;
    }

    public int minDistance() {
        int d;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < validCodes.size() - 1; i++) {
            for(int j = i +1; j < validCodes.size(); j++) {
                d = distance(validCodes.get(i), validCodes.get(j));

                if(d < min) {
                    min = d;
                }
            }
        }

        return min;
    }

    public String correct(String c) {
        int d;
        int min = Integer.MAX_VALUE;
        String correctedCode = "";

        for (String validCode : validCodes) {
            d = distance(c, validCode);

            if (d < min) {
                min = d;
                correctedCode = validCode;
            }
        }

        return correctedCode;
    }
}
