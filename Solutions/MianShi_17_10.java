
// 思路1：使用哈希表作为辅助数据结构 O(n)时间复杂度，O(n)空间复杂度
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) >= (n + 1) / 2) {
                return nums[i];
            }
        }
        return -1;
    }
}

// 思路2：TOPK问题变体，确定排序后位于中间的元素是否是超过一半的元素 O(n+logn)时间复杂度，O(1)空间复杂度
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int num = help(nums, 0, n-1);
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count > n / 2 ? num : -1;
    }
    int help(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < pivot);
            while (--j >= lo && nums[j] > pivot);
            if (i >= j) {
                break;
            }
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        nums[lo] = nums[j];
        nums[j]  = pivot;
        int middle = nums.length / 2;
        if (j == middle) {
            return nums[j];
        } else if (j < middle) {
            return help(nums, j + 1, hi);
        } else {
            return help(nums, lo, j - 1);
        }
    }
}

// 思路3：摩尔投票法 时间复杂度O(n) 空间复杂度O(1)
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int count = 1;
        int val = nums[0];
        for (int i = 1; i < n; ++i) {
            if (count >= 1) {
                if (val == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            } else {
                val = nums[i];
                count = 1;
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == val) {
                cnt++;
            }
        }
        return cnt > n / 2 ? val : -1;
    }
}
