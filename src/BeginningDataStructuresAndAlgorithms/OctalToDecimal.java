package BeginningDataStructuresAndAlgorithms;

public class OctalToDecimal {
    public static void main(String[] args) {

        System.out.println(convertToDecimal("17"));
        System.out.println(convertToDecimal2("17"));
    }

    /**
     * Convert octal to decimal
     * Start decimal result at 0
     * First take the leftmost digit from the number and add it to the result
     * If all octal digits were removed then stop, done
     * Otherwise multiply by 8 the result variable
     * Go step 2
     *
     * @param octal the octal number
     * @return decimal value of octal input
     */
    private static int convertToDecimal(String octal) {
        int result = 0;

        for (int i = 0; i < octal.length() ; i++) {
            result += Integer.valueOf(String.valueOf(octal.charAt(i)));
            if(i != octal.length()-1)
                result *= 8;
        }

        return result;
    }

    private static int convertToDecimal2(String oct) {
        int result = 0;
        for (int i = 1; i <= oct.length(); i++) {
            int octDigit = Integer.parseInt(oct.charAt(oct.length() - i) + "");
            result += Math.pow(8, i - 1) * octDigit;
        }
        return result;
    }
}
