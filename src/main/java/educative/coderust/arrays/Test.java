package educative.coderust.arrays;

import java.util.Arrays;

public class Test {

    public static boolean doesDocumentBelongToHotStorage(String _id) {

        //999864423|0000000001|7077|0|8
        //0|0101300645|3248|2018-01-30|0

        String poId = "999864000";
        String strDate = "2018-01-30";

        String[] idSplit = _id.split("\\|");

        System.out.println(Arrays.toString(idSplit));

        if (idSplit[0].equals("0")) {
            if (idSplit[3].compareTo(strDate) < 0) {
                return false;
            } else {
                return true;
            }
        } else {
            if (idSplit[0].compareTo(poId) < 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(doesDocumentBelongToHotStorage("999864423|0000000001|7077|0|8"));
        System.out.println(doesDocumentBelongToHotStorage("0|0101300645|3248|2017-01-30|0"));
        System.out.println(doesDocumentBelongToHotStorage("988864423|0000000001|7077|0|8"));
        System.out.println(doesDocumentBelongToHotStorage("0|0101300645|3248|2018-02-30|0"));
    }

}
