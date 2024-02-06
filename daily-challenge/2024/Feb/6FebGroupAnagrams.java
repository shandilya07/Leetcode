// https://leetcode.com/problems/group-anagrams/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> res = new HashMap<>();
        
        for(String st : strs) {
            int[] count = new int[26];
            
            for(char c : st.toCharArray()) {
                count[c - 'a']++;
            }
            
            StringBuilder key = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                key.append("#");
                key.append(count[i]);
            }
            
            if(!res.containsKey(key.toString())) {
                res.put(key.toString(), new ArrayList<>());
            }
            res.get(key.toString()).add(st);
        }
        return new ArrayList<>(res.values());
    }
}
