import java.util.Hashtable;

public class LongestNonRepeatingSubstring {
    static int longestNonRepeating(String s)
    {
        if(s == null || s.length() == 0)
            return 0;
        int length = s.length();
        Hashtable<Character, Integer> charIndex = new Hashtable<Character, Integer>();
        int maxlen = 0;
        int curlen = 0;
        int start = 0;
        int i = 0;
        while(i < length)
        {
            if(charIndex.containsKey(s.charAt(i))) {
                start = charIndex.get(s.charAt(i)) + 1;
                curlen = i - start + 1;
            }
            else {
                curlen++;
            }
            charIndex.put(s.charAt(i), i);
            if(curlen > maxlen)
                maxlen = curlen;
            i++;
        }
        return maxlen;

    }
    public static void main(String args[]) {
        System.out.println(longestNonRepeating("sandeep"));
    }
}
