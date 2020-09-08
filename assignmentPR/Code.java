/**
 * A class that extracts the mantissa and characteristic from a char[] that is
 * acting to simulate a floating point number
 *
 * Implementation of function F1
 */
class Code {

    /**
     * Method for determining if the 'characteristic' of an inputted pseudo-floating
     * point char array
     * 
     * @param numString input number as a char array
     * @return The value that represents the component. If fail, return -0
     */
    int characteristic(String numString) {
        // Declaring/Initializing variables
        int d = -0;
        try {
            d = (int) Double.parseDouble(numString);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }

        return d;
    }

    /**
     * Method for extracting the mantissa of an inputted pseudo-floating point char
     * array
     * 
     * @param numString input number as char array
     * @return the value that represents the mantissa
     */
    int mantissa(String numString) {

        int mantissa = -0;

        try {
            mantissa = Integer.parseInt(numString.split(".")[1]);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }

        return mantissa;
    }

    public static void main(String[] args) {

        String number = "123.456";

        // convert number into a char[]
        char[] chars = number.toCharArray();

        for (char c : chars){
            if(!Character.isDigit(c)){
                // TODO something if any of the character values are NOT valid numbers
            } else {
                // TODO something if all is okay
            }
        }

        
    }

}
