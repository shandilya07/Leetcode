// https://leetcode.com/problems/first-unique-character-in-a-string/

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        int i = 0;
        for(Character c : s.toCharArray()) {
            if(map.get(c) < 2) {
                return i;
            }
            i++;
        }
        return -1;
    }
}https://leetcode.com/problems/first-unique-character-in-a-string/
