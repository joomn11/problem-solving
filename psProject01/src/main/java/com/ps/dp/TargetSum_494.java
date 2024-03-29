package com.ps.dp;

import java.util.HashMap;
import java.util.Map;

public class TargetSum_494 {

    public static void main(String[] args) {
        TargetSum_494 t = new TargetSum_494();
        int[] nums = { 1, 1, 1, 1, 1 };
        t.findTargetSumWays(nums, 3);
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        int rst = dp(nums, target, nums.length - 1, map);
        System.out.println(map.keySet());
        return rst;
    }

    private int dp(int[] nums, int target, int idx, Map<String, Integer> map) {

        if (idx == -1 && target == 0) {
            return 1;
        } else if (idx == -1) {
            return 0;
        }

        if (map.containsKey(idx + "/" + target)) {
            return map.get(idx + "/" + target);
        }

        int add = dp(nums, target + nums[idx], idx - 1, map);
        int sub = dp(nums, target - nums[idx], idx - 1, map);

        map.put(idx + "/" + target, add + sub);

        return add + sub;
    }

    public int findTargetSumWays_2(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        int rst = dp_2(nums, map, target, nums.length - 1);
        return rst;
    }

    private int dp_2(int[] nums, Map<String, Integer> map, int target, int idx) {

        if (target == 0 && idx == -1) {
            return 1;
        } else if (idx == -1) {
            return 0;
        }

        if (map.containsKey(idx + "/" + target)) {
            return map.get(idx + "/" + target);
        }

        int add = dp_2(nums, map, target + nums[idx], idx--);
        int sub = dp_2(nums, map, target - nums[idx], idx--);

        map.put(idx + "/" + target, add + sub);
        return add + sub;
    }
}
