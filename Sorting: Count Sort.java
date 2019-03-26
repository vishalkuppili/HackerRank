import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int[] countSort(int[] array){
        int n = array.length; 
        int output[] = new int[n];
        int count[] = new int[201];

        for (int i=0; i<n; ++i) 
            count[array[i]] = count[array[i]] + 1;
        
        return count;
    }

    static void countSort(int[] array, int pop, int push){
      
       array[pop] = array[pop] - 1;
       array[push] = array[push] + 1;
       
    }
    static int activityNotifications(int[] expenditure, int d) {
        int[] temp;
        int[] sortedArray = new int[201];
        int notifications = 0;
        int limit = 0;
        for(int i = 0; i<expenditure.length; i++){
            if (d <= i){
                if(d == i){
                    temp = Arrays.copyOfRange(expenditure, (i-d), i);
                    sortedArray = countSort(temp);
                }

                else{
                    countSort(sortedArray,expenditure[i-d-1], expenditure[i-1]);
                }
                
                int index = 0;
                int rider = 0;
                if(d%2 == 0){
                    boolean first= false, second= false;
                    int median1 = 0, median2 = 0;
                    while(!first || !second ){
                        index = index + sortedArray[rider];
                        if((index >= (d/2)) && !first){
                            first = true;
                            median1 = rider;
                        }
                        if((index >= (d/2)+1) && !second){
                            second = true;
                            median2 = rider;
                        }
                        rider++;
                    }
                    limit = median1 + median2 ;                    
                }

                else{
                    boolean isMedian = false;
                    while(!isMedian){
                        index = index + sortedArray[rider];
                        if(index >= (d+1)/2){
                            limit = 2*rider;
                            isMedian = true;
                        }
                        rider++;
                    }
                }
                if( expenditure[i] >= limit ){
                    notifications++;
                }
            }
        }
        return notifications;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
