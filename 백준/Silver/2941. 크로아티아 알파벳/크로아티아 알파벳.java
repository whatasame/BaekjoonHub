import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        /* Read input */
        String inputStr = br.readLine();
        
        /* Run solution */
        int result = solution(inputStr);
        
        /* Print result */ 
        System.out.println(result);

        br.close();
        
    }
    
    private static int solution(String str){
        int count = str.length();
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            
            if(c == '='){
                if (i - 2 >= 0 && 
                           (str.charAt(i-2) == 'd' && str.charAt(i-1) == 'z')){
                    count -= 2;
                } else if(i - 1 >= 0 
                   && (str.charAt(i-1) == 'c' || str.charAt(i-1) == 's' || str.charAt(i-1) == 'z') ){
                    count--;
                }
            } else if (c == '-'){
                if(i - 1 >= 0
                  && (str.charAt(i-1) == 'c' || str.charAt(i-1) == 'd')){
                    count--;
                }
            } else if (c == 'j'){
                if(i - 1 >= 0 
                  && (str.charAt(i-1) == 'l' || str.charAt(i-1) == 'n')){
                    count--;
                }
            }
                
        }
        
        return count;
    }
}