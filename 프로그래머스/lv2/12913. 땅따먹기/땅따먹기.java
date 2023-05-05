class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++){
            for(int j = 0; j < 4; j++){
                // j열을 제외한 i-1행의 최대값 찾기
                int max = 0;
                for (int k = 0; k < 4; k++){
                    if (k == j){
                        continue;
                    }
                    max = Math.max(land[i-1][k], max);
                }
                
                land[i][j] += max;
            }
        }
        
        int answer = 0;
        for (int i = 0; i < 4; i++){
            answer = Math.max(answer, land[land.length-1][i]);
        }
        
        return answer;
    }
}