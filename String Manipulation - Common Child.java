import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        int n = s1.length();
        int c[][] = new int[n+1][n+1];

        for(int i = 0; i<n+1; i++){
            c[i][0] = 0;
            c[0][i] = 0;
        }

        for(int i = 1 ; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    c[i][j] = c[i-1][j-1] +1;
                }
                else{
                    c[i][j] = Math.max(c[i][j-1],c[i-1][j]);
                }
            }
        }
        return c[n][n];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
