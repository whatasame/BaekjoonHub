class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        boolean isFirst = true;
        for (char c : s.toLowerCase().toCharArray()){
            if (isFirst){
                isFirst = false;
                if (Character.isAlphabetic(c)){
                    c = Character.toUpperCase(c);
                }
            }
            if (c == ' '){
                isFirst = true;
            }
            
            answer.append(c);
        }
        
        return answer.toString();
    }
}