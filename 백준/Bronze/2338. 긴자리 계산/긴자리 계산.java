import java.math.*;
import java.util.*;
import java.io.*;

public class Main {

    public static List<BigInteger> run(BigInteger a, BigInteger b) {
        List<BigInteger> result = new ArrayList<>();
        result.add(a.add(b));
        result.add(a.subtract(b));
        result.add(a.multiply(b));

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        List<BigInteger> result = run(a, b);

        StringBuilder sb = new StringBuilder();
        for (BigInteger element : result){
            sb.append(element).append('\n');
        }
        System.out.println(sb);
    }
}

/* 
1
-1

0
2
-1
*/

/*
0
0

0
0
0
*/

/*
2_123_456_789
2_123_456_789

not overflow
*/
