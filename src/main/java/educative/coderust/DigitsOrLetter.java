package educative.coderust;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitsOrLetter {

    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine
        String input = reader.readLine();

        int digitCount = 0;
        int letterCount = 0;

        for(int i = 0; i < input.length(); i++) {
            if ((input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') || (input.charAt(i) >= 'a' && input.charAt(i) <= 'z')) {
                letterCount++;
            } else if (input.charAt(i) >= '1' && input.charAt(i) <= '9') {
                digitCount++;
            }
        }

        System.out.println(letterCount);
        System.out.println(digitCount);

    }

}
