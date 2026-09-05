class Solution {
    public String frequencySort(String s) {
        Map<Character,  Integer> freqMap = new HashMap<>();
        for(char c : s.toCharArray()){
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }

        List<Character>[] buckets = new List[s.length()+1];
        for(char key : freqMap.keySet()){
            int frequency = freqMap.get(key);
            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        StringBuilder result = new StringBuilder();
        for(int i = buckets.length-1; i>0; i--){
            if(buckets[i] != null){
                for(char c : buckets[i]){
                    for(int j = 0; j<i; j++){
                        result.append(c);
                    }
                }
            }
        }

        return result.toString();
    }
}