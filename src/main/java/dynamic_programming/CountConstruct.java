package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {

    public static void run(String[] args) {
        System.out.println(countConstruct2("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(countConstruct2("skateboard", new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(countConstruct2("enterapotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"}));
        System.out.println(countConstruct2("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
    }

    // brute force
    // n = wordBank.length
    // m = target.length
    // time  => O(n^m * m)
    // space => O(m^2)
    private static int countConstruct1(String target, String[] wordBank) {
        if(target.isEmpty()) return 1;

        int total = 0;

        for (String word : wordBank) {
            if(target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                total += countConstruct1(suffix, wordBank);
            }
        }

        return total;
    }

    // memoized
    // n = wordBank.length
    // m = target.length
    // time  => O(n * m^2)
    // space => O(m^2)
    private static int countConstruct2(String target, String[] wordBank) {
        Map<String, Integer> memo = new HashMap<>();
        return countConstruct2Helper(target, wordBank, memo);
    }

    private static int countConstruct2Helper(String target, String[] wordBank, Map<String, Integer> memo) {
        if(memo.containsKey(target)) return memo.get(target);
        if(target.isEmpty()) return 1;

        int total = 0;

        for (String word : wordBank) {
            if(target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                total += countConstruct2Helper(suffix, wordBank, memo);
            }
        }

        memo.put(target, total);
        return total;
    }
}
