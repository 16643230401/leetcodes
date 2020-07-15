package BaseAlgorithm;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-14 21:28
 */
public class Sorts {


    public static void main(String[] args) {
        Sorts sorts =  new Sorts();
        int n = 99999;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * 10000);
        }
        sorts.quickSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) System.out.println(false);
        }

    }


    public void quickSort(int[] arr) {
        partition(arr, 0, arr.length - 1);
    }


    public void partition(int[] arr,int left, int right) {
        if(left >= right) return;
        int temp = arr[left];

        int i = left, j = right;

        while(i < j) {
            while(i < j && arr[j] >= temp) j--;
            arr[i] = arr[j];
            while(i < j && arr[i] <= temp) i++;
            arr[j] = arr[i];
        }
        arr[i] = temp;
        partition(arr, left, i - 1);
        partition(arr, i + 1, right);
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public void insertSort(int[] arr) {
        int i = 0;




    }
}
