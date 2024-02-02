// https://leetcode.com/problems/sequential-digits/
// Maths solution -- Came up with this solution
class Solution {
    public List<Integer> sequentialDigits(int loww, int highh) {
        List<Integer> nums = new ArrayList<>();
        for(int st = findLengthOfNumber(loww); st <= findLengthOfNumber(highh); st++) {
            int low = 1;
            int high = st;
            int res = 0;
            
            while(low <= 10-st && high <= 9) {
                res = 0;
                int place = st-1;
                for(int i = low; i <= high; i++) {
                    res += (i * Math.pow(10, place--));
                }
                if(res >= loww && res <= highh) {
                    nums.add(res);        
                }
                low++;
                high++;
            }
        }
        return nums;
    }
    
    private int findLengthOfNumber(int number) {
        int length = 0;
        while(number/10 > 0) {
            number /= 10;
            length++;
        }
        return length+1;
    }
}


// Sliding window approach -- Got this solution from editorial
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String seed = "123456789";
        int lowLength = String.valueOf(low).length();
        int highLength = String.valueOf(high).length();
        List<Integer> solution = new ArrayList<>();
            
        for(int window = lowLength; window <= highLength; window++) {
            for(int left = 0; left < 10 - window; left++) {
                int candidate = Integer.parseInt(seed.substring(left, left+window));
                if(candidate >= low && candidate <= high) {
                    solution.add(candidate);
                }
            }
        }
        return solution;
    }
}
