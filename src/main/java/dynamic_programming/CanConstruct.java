package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public static void run(String[] args) {
        System.out.println(canConstruct2("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(canConstruct2("skateboard", new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(canConstruct2("enterapotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"}));
        System.out.println(canConstruct2("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
    }

    // brute force
    // m = target.length
    // n = wordBank.length
    // time  => O(n^m * m)
    // space => O(m^2)
    private static boolean canConstruct1(String target, String[] wordBank) {
        if(target.isEmpty()) return true;

        for(String word : wordBank) {
            if(target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                if(canConstruct1(suffix, wordBank)) return true;
            }
        }

        return false;
    }

    // memoized
    // m = target.length
    // n = wordBank.length
    // time  => O(n * m^2)
    // space => O(m^2)
    private static boolean canConstruct2(String target, String[] wordBank) {
        Map<String, Boolean> memo = new HashMap<>();

        return canConstruct2Helper(target, wordBank, memo);
    }

    private static boolean canConstruct2Helper(String target, String[] wordBank, Map<String, Boolean> memo) {
        if(memo.containsKey(target)) return memo.get(target);
        if(target.isEmpty()) return true;

        for(String word : wordBank) {
            if(target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                boolean construct = canConstruct2Helper(suffix, wordBank, memo);
                memo.put(target, construct);
                if(construct) return true;
            }
        }

        return false;
    }
}
