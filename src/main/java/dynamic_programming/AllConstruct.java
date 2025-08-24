package dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AllConstruct {

    public static void run(String[] args) {
        System.out.println(Arrays.deepToString(allConstruct1("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})));
        System.out.println(Arrays.deepToString(allConstruct1("skateboard", new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"})));
        System.out.println(Arrays.deepToString(allConstruct1("enterapotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"})));
        System.out.println(Arrays.deepToString(allConstruct1("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"})));
    }

    // brute force
    // n = wordBank.length
    // m = target.length
    // time  =>
    // space =>
    private static String[][] allConstruct1(String target, String[] wordBank) {
        if(target.isEmpty()) return new String[1][];

        for (String word : wordBank) {
            if(target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                String[][] suffixWays = allConstruct1(suffix, wordBank);
                String[][] targetWays = new String[suffixWays.length][];

            }
        }

        return new String[][]{{target}};
    }
}
