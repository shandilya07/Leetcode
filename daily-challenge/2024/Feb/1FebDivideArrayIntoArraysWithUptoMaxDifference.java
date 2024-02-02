// https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/
// Came up with this, idea is greedy, first sort the array in increasing order and group into 3

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i = i+3) {
            int[] num = {nums[i], nums[i+1], nums[i+2]};
            List<Integer> hold = new ArrayList<>();
            if(isDiffLessThankK(num, k)) {
                hold.add(num[0]);
                hold.add(num[1]);
                hold.add(num[2]);
                res.add(hold);
            } else {
                return new int[0][0];
            }
        }
        int[][] ret = new int[res.size()][3];
        int i = 0;
        for(List<Integer> list : res) {
            int[] hold = {list.get(0), list.get(1), list.get(2)};
            ret[i] = hold;
            i++;
        }
        return ret;
    }
    
    private boolean isDiffLessThankK(int[] arr, int k) {
        if(Math.abs(arr[0] - arr[1]) <= k && Math.abs(arr[1] - arr[2]) <= k && Math.abs(arr[0] - arr[2]) <= k) {
            return true;
        }
        return false;
    }
}

// Same idea but lot cleaner code, inspired from editorial solution
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int[][] res = new int[nums.length/3][3];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i = i+3) {
            if(nums[i+2] - nums[i] > k)
                return new int[0][0];
            res[i/3] = new int[]{nums[i], nums[i+1], nums[i+2]};
        }
        return res;
    }
}
