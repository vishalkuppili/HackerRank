import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        
        HashMap <String, Integer> count = new HashMap<String, Integer>();
        String[] sparts = s.split("");
        boolean lastChance = false;
        int freq;
        String rem="";

        for(String c: sparts){
            int i = count.containsKey(c) ? count.get(c) : 0;
            count.put(c, i+1);
        }
        int countOne = 0;

        for(String key : count.keySet()){
            if(count.get(key) == 1){
                countOne++;
                rem = key;
            }
        }
        if(countOne == 1 && s.length() !=1){
            count.remove(rem);
            freq = (s.length()-1)/(count.size());
            lastChance = true;    
        }
        else{
            freq = s.length()/count.size();
        }

        for (String key : count.keySet()) {
            if( count.get(key) != freq ){
                if(lastChance){
                    return "NO";
                }
                else{
                    if(Math.abs(count.get(key) - freq) > 1){
                        return "NO";
                    }
                }
                lastChance = true;
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
