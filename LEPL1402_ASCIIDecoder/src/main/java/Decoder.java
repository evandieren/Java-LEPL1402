import java.util.ArrayList;

public class Decoder {

    public static void main(String[] args) {

    }

    /*
     * Forbidden characters are passed as an array of int.
     * Each element of this array correspond to the decimal ASCII code
     * of a forbidden character OR null if there's no forbidden character
     * If you encounter one of these forbidden character
     * you must ignore it when you translate your sentence.
     *
     * the 2D array "sentences" contain a set of decimal ASCII code we want you
     * to translate. Each sub-element of this array is a different sentence.
     * Ex : if we pass this array : [ ["42", "72", "88"], ["98", "99", "111", "47", "55"]]
     * to your decode method, you should return : [ "*HX", "bco/7" ]
     *
     * You should NEVER return null or an array containing null
     */
    public static String [] decode(int[] forbidden, String[][] sentences){
        String [] result = new String[sentences.length];
        String elem = "";
        for (int i = 0; i < result.length; i++){
            elem = "";
            for (int j = 0; j < sentences[i].length; j++){
                int a = Integer.parseInt(sentences[i][j]);
                boolean ok = true;
                if (forbidden != null){
                    for (int in : forbidden){
                        if (a == in) {
                            ok = false;
                            break;
                        }
                    }
                }
                if (ok){
                    elem = elem.concat(Character.toString((char) a));
                }
            }
            result[i] = elem;
        }
        return result;
    }

}