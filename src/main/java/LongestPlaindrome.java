public class LongestPlaindrome {
    static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int maxlen = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++)
        {
            int curlen = 1;
            start = i;
            end = i;
            while(start >= 0 && end < s.length())
            {
                if(s.charAt(start) != s.charAt(end)) {
                    break;
                }
                else
                {
                    curlen++;
                    if(curlen > maxlen) {
                        maxlen = curlen;
                        res = s.substring(start,end+1);
                    }

                    start--;
                    end++;
                }
            }
            start = i;
            end = i+1;
            while(start >= 0 && end < s.length()) {
                if(s.charAt(start) != s.charAt(end)) {
                    break;
                }
                else
                {
                    curlen++;
                    if(curlen > maxlen) {
                        maxlen = curlen;
                        res = s.substring(start,end+1);
                    }

                    start--;
                    end++;
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        System.out.println(longestPalindrome("pbabbad"));
    }
}
