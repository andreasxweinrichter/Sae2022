package at.ac.fhw.sae.lesson2;

public class Fibonacci {

    public static void main(String[] args) {

    System.out.println(getFibonacci(-3));
    System.out.println(getFibonacciLoop(-3));
    }

    /**
     * Get the value of the Fibonacci row at the place n (by recursion).
     * @param position the position of the Fibonacci row
     * @return the value at this position
     * Max (position) value for this method before stack overflow is 19999 (this was found out by iteration).
     * This method only works correct until the position 46 because there the value is 1836311903.
     * Integer space is only till the value 2147483647; afterwards it starts the space at -2147483647 again.
     * Value of position 47 is 2971215073, which is bigger than 1836311903. This is a so-called variable overflow.
     * If you would take datatype "long", the values would be correct for more positions because this type has a higher precision.
     * But the problem with wrong values would also appear later. This means that this problem can not be avoided to 100%.
     * It depends on the application, which datatype should be taken.
     * This method could only be used for positions >= 0 --> because in both methods (loop and recursive) the loops never start (-position < 0).
     */
    public static long getFibonacci(int position){
        if(position == 0){
            return 0;
        }else if(position == 1){
            return 1;
        }

        return getFibonacci(--position,0, 1);
    }

    private static long getFibonacci(int position,int prev,int prev2 ){
        while(position > 0){
            return getFibonacci(--position, prev + prev2, prev);
        }
        return prev + prev2;
    }

    /**
     * Get the value of the Fibonacci row at the place n (by loop).
     * @param position the position of the Fibonacci row
     * @return the value at this position
     */
    public static long getFibonacciLoop(int position){
        if(position == 0){
            return 0;
        }else if(position == 1){
            return 1;
        }

        int firstTerm = 0;
        int secondTerm = 1;
        int nextTerm = 0;

        for (int i = 1; i < position; i++){
            nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
        return nextTerm;
    }
}
// - weil Variablen overflow. Geht wieder in den Zahlenstrahl von links