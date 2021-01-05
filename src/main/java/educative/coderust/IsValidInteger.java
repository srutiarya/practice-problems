package educative.coderust;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsValidInteger {

    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine
        String input = reader.readLine();
        String[] inputStrings = new String[Integer.parseInt(input)];
        for(int i = 0; i < inputStrings.length; i++) {
            inputStrings[i] = reader.readLine();
        }

        for (String in : inputStrings) {
            try {
                if (isValid(in)) {
                    System.out.println("Valid Format");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }

    public static boolean isValid(String input) {

        int stringCount = 0;
        int digitCount = 0;
        for(int i = 0; i < input.length(); i++) {
            if ((input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') || (input.charAt(i) >= 'a' && input.charAt(i) <= 'z')) {
                stringCount++;
            } else if (input.charAt(i) >= '1' && input.charAt(i) <= '9') {
                digitCount++;
            }
        }

        if (digitCount == input.length()) {
            return true;
        } else if (stringCount == input.length()) {
            throw new StringException();
        } else if (stringCount + digitCount == input.length()) {
            throw new AlphaNumericException();
        }

        return false;
    }

}

class AlphaNumericException extends RuntimeException {

    AlphaNumericException() {
        super("Its an AlphaNumeric");
    }

}

class StringException extends RuntimeException {

    StringException() {
        super("Its a String");
    }
}