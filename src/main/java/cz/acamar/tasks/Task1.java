package cz.acamar.tasks;

public class Task1 {

    /**
     * Task 1. Length of the last word.
     * <p>
     * Given a string s consisting of some words separated by some number of spaces,
     * return the length of the last word in the string.
     * <p>
     * A word is a maximal substring consisting of non-space characters only.
     * <p>
     * Example input: "Hello World"
     * Expected output: 5
     *
     * @param str - a string s consisting of some words separated by some number of spaces.
     * @return - the length of the last word in the string.
     */

    /**
    Algorithm:
    1. begin from the end of the string, looking for first nonspace char
    2. count all nonspace char until we find another space/reach the beginning of the str
    3. return res from step 2
     */
    public int lengthOfLastWord(String str) {
        int res = 0;

        /*
        flag to determine whether we already skip all spaces from the end and begin count result
         */
        boolean beginLengthCount = false;

        /*
        flag to determine whether we count all letters from last word and should return result
         */
        boolean endLengthCount = false;

        for (int i = str.length() - 1; i >= 0 && !endLengthCount; i--) {
            if (str.charAt(i) == ' ') {
                if (!beginLengthCount) {
                    // STUB: we dont need to do anything, we need to keep processing till we find non space char
                } else {
                    /*
                     If beginLengthCount == true, then we already counting symbols in last word
                     and if we met a space again, then we processed last word in str and need to end our method
                     this information presented in flag endLengthCount
                     */
                    endLengthCount = true;
                }
            } else {
                /*
                here we met nonspace char, so we need to start counting all it symbols and set flag beginLengthCount
                when we'll met another space char, we will set endLengthCount and finish iteration. Or if we have just one word,
                in the beginning of a str, we'll finish iteration with i == 0
                 */
                beginLengthCount = true;
                res++;
            }
        }
        return res;
    }
}
