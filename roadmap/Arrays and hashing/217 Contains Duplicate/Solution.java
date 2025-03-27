// https://leetcode.com/problems/contains-duplicate/

import java.util.Set;
import java.util.HashSet;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }

        System.out.println(new Solution().containsDuplicate(list.stream().mapToInt(Integer::intValue).toArray()));
    }
}