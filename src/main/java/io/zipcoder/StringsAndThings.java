package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     * countYZ("day fez"); // Should return 2
     * countYZ("day fyyyz"); // Should return 2
     */


    public Integer countYZ(String input) {
        Integer retVal = 0; // count of words ending in y or z
        int len = 0;
        String[] splitString = input.split(" ");

        for (String ele : splitString) {
            len = ele.length();
            if (ele.charAt(len - 1) == 'y' || ele.charAt(len - 1) == 'z') {
                retVal++;
            }
        }

        return retVal;
    }


    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * <p>
     * example : removeString("Hello there", "llo") // Should return "He there"
     * removeString("Hello there", "e") //  Should return "Hllo thr"
     * removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove) {
        String retVal = "";

        // split up into array by splitting on remove
        String[] splitString = base.split(remove);


        // use for-each loop
        //   concate the split together back int string
        //   retVal = retVal + ele;
        for (String element : splitString) {
            retVal = retVal + element;
        }

        return retVal;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     * <p>
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     * containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     * containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    // This will fail 2 unti tes, but pass the requirement in the comments
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        Boolean retval = false;


        int isCount = countOfOccurances(input, "is");
        int notCount = countOfOccurances(input, "not");

        // debug only
        //     System.out.println("is count: " + isCount);
        //     System.out.println("not count: " + notCount);

        // get count of 'is'
        // get count of not
        // if count of 'is' equals count of 'not'
        if (isCount == notCount) {
            retval = true;
        }


        return retval;
    }

    // new method , but not added in JUNIT - can add later
    public Integer countOfOccurances(String input, String valueToCount) {

        Integer retVal = 0; // count of words in string
        Integer lenOfValToCount = valueToCount.length();
        Integer lenOfInput = input.length();

        // get loop iteration
        int maxLoop = lenOfInput - lenOfValToCount;

        // loop through sub string
        for (int i = 0; i <= maxLoop; i++) {
            if (valueToCount.equals(input.substring(i, i + lenOfValToCount))) {
                retVal = retVal + 1;
            }
        }
        // for debug only - display count
        //    System.out.println(retVal);

        return retVal;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     * gHappy("xxgxx") // Should return  false
     * gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input) {
        Boolean retVal = false;
        int lenOfInput = input.length();
        char g = 'g';

        // loop through string using charAt
        for (int i = 0; i < lenOfInput; i++) {
            // if found, check next val
            if (input.charAt(i) == g) {
                // if not last char , check next
                if (i < (lenOfInput - 1) && input.charAt(i + 1) == g) {
                        i++;
                        retVal = true;
                }
                else // only a single g
                {
                    retVal = false;
                }
            }

        }


        return retVal;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     * countTriple("xxxabyyyycd") // Should return 3
     * countTriple("a") // Should return 0
     */
    public Integer countTriple(String input) {
        Integer retVal = 0;

        int lenOfInput = input.length();
        // loop through string using charAt
        for (int i = 0; i < lenOfInput; i++) {
            // is next char = this char and next char is not out of bounds
            if (i < (lenOfInput - 1) && input.charAt(i + 1) == input.charAt(i)) {
                // check the 3rd char and is not out of bounds, and if it equals
                if (i < (lenOfInput - 2) && input.charAt(i + 2) == input.charAt(i)) {
                    retVal ++;
                }

            }
        }   

        return retVal;
    }
}
