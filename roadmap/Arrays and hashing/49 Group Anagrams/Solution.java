// https://leetcode.com/problems/group-anagrams/

// TLE for input2

import java.util.*;

class Solution {
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

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<List<String>>();
        if (strs.length == 0) return groups;

        outerloop:
        for (String str: strs) {
            for (List<String> l: groups) {
                if (isAnagram(l.get(0), str)) {
                    l.add(str);
                    continue outerloop;
                }
            }
            final List<String> l = new ArrayList<String>();
            l.add(str);
            groups.add(l);
        }
        
        return groups;
    }

    public static void main(String[] args) {
        final List<String> strs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            strs.add(sc.next());
        }

        System.out.printf("Input :: %s\nAnswer :: %s\n", strs, new Solution().groupAnagrams(strs.toArray(new String[0])));
    }
}