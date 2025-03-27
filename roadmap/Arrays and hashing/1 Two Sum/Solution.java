import java.util.*;
// nums = [2,7,11,15], target = 9

class Solution {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int target = sc.nextInt();
        System.out.printf("nums :: %s, target :: %d\n", Arrays.toString(nums), target);
        System.out.printf("Answer :: %s", Arrays.toString(new Solution().twoSum(nums, target)));
    }
}