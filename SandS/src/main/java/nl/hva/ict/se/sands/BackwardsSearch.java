package nl.hva.ict.se.sands;

public class BackwardsSearch {

    private int comparisons;
    private int ALPHABET = 128;
    private int[] right = new int[ALPHABET];     // the bad-character skip array

    /**
     * Returns index of the right most location where <code>needle</code> occurs within <code>haystack</code>. Searching
     * starts at the right end side of the text (<code>haystack</code>) and proceeds to the first character (left side).
     *
     * @param needle   the text to search for.
     * @param haystack the text which might contain the <code>needle</code>.
     * @return -1 if the <code>needle</code> is not found and otherwise the left most index of the first
     * character of the <code>needle</code>.
     */
    int findLocation(String needle, String haystack) {

        int h = haystack.length();
        int n = needle.length();
        int skip;

        // init
        pre(needle, haystack, h);

        //loop over haystack
        for (int i = 0; i <= h - n; i += skip) {
            skip = 0;

            //loop over pattern, right to left
            for (int j = n - 1; j >= 0; j--) {
                //check if there is a mismatch
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    skip = Math.max(1, j - right[haystack.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return right.length;
    }

    private void pre(String needle, String haystack, int length) {
        //create array for all chars
        right = new int[ALPHABET];
        //initialize everything with -1
        for (int c = 0; c < length; c++)
            right[c] = -1;
        //store rightmost occurrence
        //M is the length of Pattern P
        for (int j = 0; j < needle.length(); j++)
            right[needle.charAt(j)] = j;
    }

    /**
     * Returns the number of character compared during the last search.
     *
     * @return the number of character comparisons during the last search.
     */

    int getComparisonsForLastSearch() {
        return comparisons;
    }

    /**
     * This method will be called when we find a bad character in the haystack which is not matching with the needle.
     * When the mismatch has occurred, we will shift the entire pattern until the mismatch becomes a match, otherwise,
     * pattern moves past the bad character.
     */

    private String badCharacter(String needle) {
        return needle;
    }

    /**
     * This method will be used to ...
     *
     * @param needle
     * @return
     */

    private String goodSuffix(String needle) {
        return needle;
    }


}
