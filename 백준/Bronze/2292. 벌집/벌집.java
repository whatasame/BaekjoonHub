import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        /* Read input */
        final int N = Integer.parseInt(br.readLine());
        
        /* Run solution */
        int result = solution(N);
        
        /* Print result */
        System.out.println(result);
        
        br.close();
    }
    
    private static int solution(int N){
        /* Increase pattern: 1, 6, 12, 18, ... */
        /* Num increase pattern: 1, 7(1+6), 19(1+6+12), ... */
        int count = 1, num = 1;
        while(num < N){
            num = num + count * 6;
            count++;
        }
        
        return count;
    }
        
}