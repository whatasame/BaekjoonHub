import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        String[] inputs = new String[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine();
        }
        String[] questions = new String[M];
        for (int i = 0; i < M; i++) {
            questions[i] = br.readLine();
        }

        String result = solution(inputs, questions);

        System.out.println(result);

        br.close();
    }

    private static String solution(String[] inputs, String[] questions) {
        /* 번호:이름, 이름:번호 -> 확실하게 구분되는 자료이므로 같은 맵에 저장 */
        Map<String, String> book = new HashMap<>();
        for (int i = 0; i < inputs.length; i++) {
            book.put(String.valueOf(i + 1), inputs[i]);
            book.put(inputs[i], String.valueOf(i + 1));
        }

        /* 도감 찾기 */
        StringBuilder sb = new StringBuilder();
        for (String question : questions) {
            sb.append(book.get(question))
                    .append('\n');
        }

        return sb.toString();
    }
}