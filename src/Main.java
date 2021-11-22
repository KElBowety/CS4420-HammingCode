public class Main {
    public static void main(String[] args) {
        Hamming h = new Hamming(7);
        h.generate();
        System.out.println("Minimum Distance = " + h.minDistance());
        String enteredCode = "1110011";
        String correctedCode = h.correct(enteredCode);
        System.out.println("Entered Code = " + enteredCode);
        System.out.println("Corrected code = " + correctedCode);

    }
}
