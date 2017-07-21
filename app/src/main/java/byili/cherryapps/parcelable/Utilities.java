package byili.cherryapps.parcelable;

/**
 * Created by anelelizabethcervantes on 7/21/17.
 */

public class Utilities {

    public static boolean validateEmpty(String a, String b){
        if (a.isEmpty()){
            return false;
        }else if (b.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public static boolean validatePar(int number){
        if (number%2==0) {
            return true;
        } else {
            return false;
        }
    }
}
