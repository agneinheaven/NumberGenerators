package numberGenerator;

import numberGeneratorInterface.NumberGeneratorInterface;

public class NumberGenerator implements NumberGeneratorInterface {

    public static void performOperations(long numberGeneratorA, long numberGeneratorB){

        int sumOfEqualLastEightBinaries = 0;
        for(int i = 0; i < 1000000;i++) {
            long resultA = calculateResult(numberGeneratorA, COEFFICIENT_A);
            numberGeneratorA = resultA;
            String lastEightBinaryDigitsFromA = convertBinaryNumberToString(resultA);
            long resultB = calculateResult(numberGeneratorB, COEFFICIENT_B);
            numberGeneratorB = resultB;
            String binLastEightBinaryDigitsFromB = convertBinaryNumberToString(resultB);
            if (lastEightBinaryDigitsFromA.equals(binLastEightBinaryDigitsFromB)) {
                sumOfEqualLastEightBinaries++;
            }
        }
        System.out.println("Sum of equal eight last binary digits: " + sumOfEqualLastEightBinaries);

    }

    public static long calculateResult(long numberGeneratorA, final int COEFFICIENT_A){

        return numberGeneratorA * COEFFICIENT_A % NUMBER_TO_MULTIPLY;
    }

    public static String convertBinaryNumberToString(long resultA){

        String numberToString = String.format("%32s", Long.toBinaryString(resultA)).replace(' ', '0');
        String substringOfLastEightBinaryDigits = numberToString.substring(24, 32);
        return substringOfLastEightBinaryDigits;
    }

    public static void main(String[] args){

        performOperations(635, 12);
        performOperations(65, 8921);
    }
}