package insertionSort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 9, 2, 5, 8, 2, 1, 7};
        insertionSort(arr);
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Insertion Sort:");
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            printArray(arr);
        }
    }

    static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }
}

