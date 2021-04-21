import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

    public class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int numberOfTests = Integer.parseInt(bufferedReader.readLine());

            int[] result = new int[numberOfTests];

            //테스트 갯수만큼 반복
            for (int i = 0; i < numberOfTests; i++) {
                int successfulCandidate = 1;

                int numberOfApplicants = Integer.parseInt(bufferedReader.readLine());

                int applicantsGradesArray2[][] = new int[numberOfApplicants][2];
                for (int j = 0; j < numberOfApplicants; j++) {
                    String[] applicantsGradesArray1 = bufferedReader.readLine().split(" ");
                    for (int k = 0; k < 2; k++) {
                        applicantsGradesArray2[j][k] = Integer.parseInt(applicantsGradesArray1[k]);
                    }
                }

                Arrays.sort(applicantsGradesArray2, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[0] == o2[0]) {
                            return o1[1] - o2[1];
                        } else {
                            return o1[0] - o2[0];
                        }
                    }
                });
                
                int theFirstMumber = applicantsGradesArray2[0][1];

                for (int h = 1; h < numberOfApplicants; h++) {
                   if (applicantsGradesArray2[h][1] < theFirstMumber) {
                        successfulCandidate += 1;
                        theFirstMumber = applicantsGradesArray2[h][1];
                    }

                }
                result[i] = successfulCandidate;
            }
            for (int u = 0; u < result.length; u++) {
                System.out.println(result[u]);
            }
        }
    }
