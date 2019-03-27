package BeginningDataStructuresAndAlgorithms;

public class BinaryToDecimal {
    public static void main(String[] args) {

        System.out.println(convertToDecimal("10110"));
    }

    /**
     * This method converts a binary number into a decimal one
     * First set the conversion variable to 1 and result to 0
     * Go through the binary string from the end to the beginning
     * If the binary number is 1 then add to result the conversion variable
     * Then multiply the conversion variable by 2
     *
     * @param binary
     * @return
     */
    private static int convertToDecimal(String binary) {
        int conversion = 1;
        int result = 0;

        for (int i = 1; i <= binary.length(); i++) {
            if (binary.charAt(binary.length() - i) == '1')
                result += conversion;
            conversion *= 2;
        }
        return result;
    }
}
