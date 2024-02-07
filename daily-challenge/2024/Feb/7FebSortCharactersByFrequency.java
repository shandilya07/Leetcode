// https://leetcode.com/problems/sort-characters-by-frequency/
// Map based approach, by sorting the keyset by frequency
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        
        List<Character> chars = new ArrayList<>(map.keySet());
        Collections.sort(chars, (a, b) -> map.get(b) - map.get(a));
        
        StringBuilder sb = new StringBuilder();
        for(char c : chars) {
            int till = map.get(c);
            for(int i = 0; i < till; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

// Map plus maxheap
class Solution {
    public String frequencySort(String s) {
        Queue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        
        maxHeap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.remove();
            for(int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
