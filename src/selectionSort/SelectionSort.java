package selectionSort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 9, 2, 5, 8, 2, 1, 7};
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Selection Sort:");
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            // Troca
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
            printArray(arr);
        }
    }

    static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }
}
