import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumToys function below.
    static void swap(int[] prices, int left, int right){
        int temp = prices[right];
        prices[right] = prices[left];
        prices[left] = temp;
    }
    static void quickSort(int[] prices){
        quickSort(prices, 0, prices.length-1);
    }

    static void quickSort(int[] prices, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = prices[(left+right)/2] ;
        int index = partition(prices, left, right, pivot);
        quickSort(prices, left, index-1);
        quickSort(prices, index, right);
    }

    static int partition(int[] prices, int left, int right, int pivot){
        while(left<=right){
            while(prices[left]<pivot){
                left++;
            }
            while(prices[right]>pivot){
                right--;
            }
            if(left<=right){
                swap(prices, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
    static int maximumToys(int[] prices, int k) {
        quickSort(prices);
        int toys = 0;
        int i = 0;
        while(k>=prices[i]){
            k = k - prices[i];
            toys++;
            i++;
        }
        return toys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
