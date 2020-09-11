/**
 * A class that extracts the mantissa and characteristic from a String that is
 * acting to simulate a floating point number
 *
 * Implementation of function F1
 */
class Code {

    /**
     * Method for determining if the 'characteristic' is of an inputted pseudo-floating point String
     *
     * @param numString input number as a String
     * @return true if number is valid
     */
    static boolean characteristic(String numString) {
        
        // Declaring/Initializing variables
        int d = 0;

        // Try to convert string to double, and then cast to int
        try {
            d = (int)Double.parseDouble(numString);
        }
        catch (NumberFormatException nfe) {
            return false;
        }

        // Return true if conversion successful
        return true;
    }

    /**
     * Method for extracting the mantissa is of an inputted pseudo-floating point String
     *
     * @param numString input number as String
     * @return true if number is valid
     */
    static boolean mantissa(String numString) {
        // Return false if numString is not a valid number
        if ((numString.split("\\.")).length != 1 && (numString.split("\\.")).length != 2) {
            return false;
        }

        // Return true if otherwise
        return true;
    }

    static String F1(String numString) {
        
      // Declaring/Initializing variables
      String numerator = "";
      String denominator = "10";
      String mantissa;
      String after_dec;
      int num_of_zeros = 0;
      int i;
      int characteristic;

      // Checking results for functions
      if (characteristic(numString) && mantissa(numString)) {
          // Checking the number of decimals
          if ((numString.split("\\.")).length == 2) {
              after_dec = numString.split("\\.")[1];

              for (i = 0; i < after_dec.length(); i++) {

                // Counting number of zeros after decimal but before first non-zero number
                if (after_dec.charAt(i) == '0') {
                    num_of_zeros++;
                }

                if (after_dec.charAt(i) != '0') {
                    numerator = after_dec.substring(after_dec.indexOf(after_dec.charAt(i)));
                    break;
                }
              }

              // If no number after decimal, mantissa is 0
              if (numerator == "") {
                  mantissa = "0";
              }

              // else, add zeros to denominator based off of length of number
              else {
                  for (i = 0; i < num_of_zeros; i++) {
                      denominator += "0";
                  }

                  for (i = 1; i < numerator.length(); i++) {
                      denominator += "0";
                  }

                  // Get rid of leading/trailing whitespace
                  numerator = numerator.trim();
                  // Concatenate to create a "fraction"
                  mantissa = numerator + '/' + denominator;
              }
          }

          // Check if no decimals
          else {
              mantissa = "0";
          }

          // Initializing the characteristic
          characteristic = (int)Double.parseDouble(numString);

          return "Characteristic: " + Integer.toString(characteristic) + " Mantissa: " + mantissa;

      }

      // Number isn't valid
      else {
          return "The input number is not valid";
      }
    }

    public static void main(String[] args) {

        // Test number
        String number = "23.44602";

        System.out.println(F1(number));

    }
}

