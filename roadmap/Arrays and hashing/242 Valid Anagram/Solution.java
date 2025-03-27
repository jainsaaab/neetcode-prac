// https://leetcode.com/problems/valid-anagram/description/

import java.util.*;

public class Solution {
    public boolean isAnagram(String s, String t) {
        final Map<Character, Integer> map = new HashMap<>();
        for (Character ch: s.toCharArray()) {
            if (map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
            else map.put(ch, 1);
        }

        for (Character ch: t.toCharArray()) {
            if (map.containsKey(ch)) {
                if (map.get(ch) == 1) map.remove(ch);
                else map.put(ch, map.get(ch) - 1);
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new Solution().isAnagram(sc.next(), sc.next()));
    }
}