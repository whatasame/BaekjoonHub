import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Read student data */
        List<Student> studentList = new ArrayList<>();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            studentList.add(new Student(name, kor, eng, math));
        }

        /* Sort list */
        studentList.sort((s1, s2) -> {
            if (s1.koreanGrade != s2.koreanGrade) {
                return s2.koreanGrade - s1.koreanGrade;
            }
            if (s1.englishGrade != s2.englishGrade) {
                return s1.englishGrade - s2.englishGrade;
            }
            if (s1.mathGrade != s2.mathGrade) {
                return s2.mathGrade - s1.mathGrade;
            }
            return s1.name.compareTo(s2.name);
        });


        /* Print result */
        StringBuilder sb = new StringBuilder();
        for (Student s : studentList) {
            sb.append(s.name).append('\n');
        }
        System.out.println(sb);


        br.close();
    }

    static class Student {
        String name;

        int koreanGrade;
        int englishGrade;
        int mathGrade;

        public Student(String name, int koreanGrade, int englishGrade, int mathGrade) {
            this.name = name;
            this.koreanGrade = koreanGrade;
            this.englishGrade = englishGrade;
            this.mathGrade = mathGrade;
        }

    }

}