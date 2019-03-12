import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        String [] achar = a.split("");
        String [] bchar = b.split("");
        List<String> checkA = new ArrayList<String>();
        List<String> checkB = new ArrayList<String>();
        for(String s: achar){
            System.out.println(s);
            checkA.add(s);
        }
        System.out.println("---------------");
        for(String t : bchar){
            if(checkA.contains(t)){
                System.out.println(t);
                checkA.remove(t);
            }
            else{
                checkB.add(t);
            }
        }

        return checkA.size()+checkB.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
