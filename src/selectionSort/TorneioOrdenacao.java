package selectionSort;

import java.util.Arrays;
import java.util.Random;

public class TorneioOrdenacao {

    public static int[] gerarVetor(int n, String tipo) {
        int[] vetor = new int[n];
        if (tipo.equals("ordenado")) {
            for (int i = 0; i < n; i++) vetor[i] = i + 1;
        } else if (tipo.equals("invertido")) {
            for (int i = 0; i < n; i++) vetor[i] = n - i;
        } else if (tipo.equals("aleatorio")) {
            Random r = new Random();
            for (int i = 0; i < n; i++) vetor[i] = r.nextInt(n * 10);
        }
        return vetor;
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n -1; i++) {
            int minIdx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0; i<n1; i++) L[i] = arr[left + i];
        for(int j=0; j<n2; j++) R[j] = arr[mid + 1 + j];

        int i=0, j=0, k=left;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while(i < n1) arr[k++] = L[i++];
        while(j < n2) arr[k++] = R[j++];
    }


    public static void main(String[] args) {
        int n = 1000;
        String[] tipos = {"ordenado", "invertido", "aleatorio"};

        for (String tipo : tipos) {
            System.out.println("Vetor tipo: " + tipo);

            int[] vetorBase = gerarVetor(n, tipo);

            int[] vSelection = Arrays.copyOf(vetorBase, n);
            int[] vBubble = Arrays.copyOf(vetorBase, n);
            int[] vInsertion = Arrays.copyOf(vetorBase, n);
            int[] vMerge = Arrays.copyOf(vetorBase, n);

            long start = System.nanoTime();
            selectionSort(vSelection);
            long end = System.nanoTime();
            long timeSelection = end - start;

            start = System.nanoTime();
            bubbleSort(vBubble);
            end = System.nanoTime();
            long timeBubble = end - start;

            start = System.nanoTime();
            insertionSort(vInsertion);
            end = System.nanoTime();
            long timeInsertion = end - start;

            start = System.nanoTime();
            mergeSort(vMerge, 0, n-1);
            end = System.nanoTime();
            long timeMerge = end - start;

            System.out.println("Selection Sort: " + timeSelection + " ns");
            System.out.println("Bubble Sort: " + timeBubble + " ns");
            System.out.println("Insertion Sort: " + timeInsertion + " ns");
            System.out.println("Merge Sort: " + timeMerge + " ns");

            long minTime = timeSelection;
            String vencedor = "Selection Sort";
            if(timeBubble < minTime) {
                minTime = timeBubble;
                vencedor = "Bubble Sort";
            }
            if(timeInsertion < minTime) {
                minTime = timeInsertion;
                vencedor = "Insertion Sort";
            }
            if(timeMerge < minTime) {
                minTime = timeMerge;
                vencedor = "Merge Sort";
            }

            System.out.println("Vencedor: " + vencedor);
            System.out.println("------------------------------");
        }
    }
}
