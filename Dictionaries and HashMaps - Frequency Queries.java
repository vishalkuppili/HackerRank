import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> output = new ArrayList<Integer>();
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> temp2 = new HashMap<Integer, Integer>();
        for(int[] l : queries){
            int query = (int)l[0];
            int num = (int)l[1];
            if(query == 1){
                int bool = temp.containsKey(num) ? temp.get(num) : 0;
                temp.put(num, bool+1);
                int tb = temp2.containsKey(bool) ? temp2.get(bool) : 1;
                int tb1 = temp2.containsKey(bool+1) ? temp2.get(bool+1) : 0;
                temp2.put(bool,tb -1);
                temp2.put(bool+1,tb1+1);
                if(temp2.get(bool)==0){
                    temp2.remove(bool);
                }
            }
            else if(query == 2){
                if(temp.containsKey(num)){
                    temp.put(num, temp.get(num)-1);
                    int bool2 = temp.get(num);
                    if(temp.get(num)==0){
                        temp.remove(num);
                        temp2.put(1, temp2.get(1)-1);
                    }
                    else{
                        int t2b = temp2.containsKey(bool2) ? temp2.get(bool2) : 0;
                        int t2b1 = temp2.containsKey(bool2+1) ? temp2.get(bool2+1) : 1;
                        temp2.put(bool2,t2b+1);
                        temp2.put(bool2+1,t2b1-1);
                    }
                    if(temp2.get(bool2+1)==0){
                        temp2.remove(bool2+1);
                    }
                }
            }
            else{
                int freq = temp2.containsKey(num) ? 1 : 0;
                output.add(freq);
            }
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
      int q = Integer.parseInt(bufferedReader.readLine().trim());
      List<int[]> queries = new ArrayList<>(q);
      Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
      for (int i = 0; i < q; i++) {
        int[] query = new int[2];
        Matcher m = p.matcher(bufferedReader.readLine());
        if (m.matches()) {
          query[0] = Integer.parseInt(m.group(1));
          query[1] = Integer.parseInt(m.group(2));
          queries.add(query);
        }
      }
      List<Integer> ans = freqQuery(queries);
      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");
      }
    }
  }
}
