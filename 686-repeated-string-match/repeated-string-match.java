class Solution {
    public int repeatedStringMatch(String a, String b) {
        int minRepeats = (int) Math.ceil((double) b.length() / a.length());  
        StringBuilder sb = new StringBuilder(); 
        for(int i = 0; i < minRepeats; i++){
            sb.append(a);
        }      

        if(sb.toString().contains(b)){
            return minRepeats;
        }

        sb.append(a);
        if(sb.toString().contains(b)){
            return minRepeats+1;
        }

        sb.append(a);
        if(sb.toString().contains(b)){
            return minRepeats+2;
        }

        return -1;

    }
}