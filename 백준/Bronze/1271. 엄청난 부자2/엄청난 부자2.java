import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Read input */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger money = new BigInteger(st.nextToken());
        BigInteger creature = new BigInteger(st.nextToken());

        /* Run solution */
        BigInteger[] result = solution(money, creature);

        /* Print result */
        System.out.println(result[0]);
        System.out.println(result[1]);

        br.close();

    }

    private static BigInteger[] solution(BigInteger money, BigInteger creature) {
        BigInteger each = money.divide(creature);
        BigInteger remain = money.mod(creature);

        return new BigInteger[]{each, remain};
    }

}