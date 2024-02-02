// Maths solution
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


//
