package AdventiunParty.color;


/**
 * Vorgegebene Klasse, hier drin wird nichts bewertet !!!
 * <p>
 * Bitte nicht verändern !!
 */
public class IntMath {
    private IntMath() {

    }

    public static int round(int n){
        if(n % 10 >= 5){
            return n - n % 10 + 10;
        }
        else{
            return n - n % 10;
        }
    }

    public static int powerOfTwo(int exponent) {
        if (exponent > 31)
            ExceptionUtil.unsupportedOperation("exponent too large: " + exponent);
        if (exponent < 0)
            ExceptionUtil.unsupportedOperation("exponent cannot be negative: " + exponent);
        return 1 << exponent;
    }
}
