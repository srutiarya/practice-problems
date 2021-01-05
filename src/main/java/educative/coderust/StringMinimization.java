package educative.coderust;

public class StringMinimization {


    public static void main(String[] args) {
        System.out.println(minimize("aabbccbbaa"));
    }

    public static String minimize(String str) {
        return minimize(str, str.length()/2);
    }

    private static String minimize(String str, int mid) {

        int i = 0;
        int j = str.length() - 1;
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            char temp = str.charAt(0);

            for(; i < str.length(); i++) {
                if (str.charAt(i) != temp) {
                    break;
                }
            }

            for(; j >= 0 && i != j+1; j--) {
                if (str.charAt(j) != temp) {
                    break;
                }
            }

            if (i == j+1) {
                return "";
            }

            str = str.substring(mid, j+1) + str.substring(i, mid);

            return minimize(str, str.length()/2);
        }
        else {
            return str;
        }

    }

}
