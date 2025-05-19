package bubbleSort;

import java.util.Arrays;
import java.util.Random;

public class ComparacaoDesempenho {

    static class Resultado {
        long tempoNano;
        long comparacoes;
        public Resultado(long tempoNano, long comparacoes) {
            this.tempoNano = tempoNano;
            this.comparacoes = comparacoes;
        }
    }

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

    public static Resultado selectionSort(int[] arr) {
        long comparacoes = 0;
        int n = arr.length;
        long start = System.nanoTime();
        for (int i = 0; i < n -1; i++) {
            int minIdx = i;
            for (int j = i+1; j < n; j++) {
                comparacoes++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        long end = System.nanoTime();
        return new Resultado(end - start, comparacoes);
    }

    public static Resultado bubbleSort(int[] arr) {
        long comparacoes = 0;
        int n = arr.length;
        long start = System.nanoTime();
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-1-i; j++) {
                comparacoes++;
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        long end = System.nanoTime();
        return new Resultado(end - start, comparacoes);
    }

    public static Resultado insertionSort(int[] arr) {
        long comparacoes = 0;
        int n = arr.length;
        long start = System.nanoTime();
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;
            while(j >= 0) {
                comparacoes++;
                if(arr[j] > key) {
                    arr[j+1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j+1] = key;
        }
        long end = System.nanoTime();
        return new Resultado(end - start, comparacoes);
    }

    static class MergeSortCounter {
        long comparacoes = 0;
        public Resultado mergeSort(int[] arr, int left, int right) {
            long start = System.nanoTime();
            mergeSortRec(arr, left, right);
            long end = System.nanoTime();
            return new Resultado(end - start, comparacoes);
        }

        private void mergeSortRec(int[] arr, int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;
                mergeSortRec(arr, left, mid);
                mergeSortRec(arr, mid+1, right);
                merge(arr, left, mid, right);
            }
        }

        private void merge(int[] arr, int left, int mid, int right) {
            int n1 = mid - left + 1;
            int n2 = right - mid;

            int[] L = new int[n1];
            int[] R = new int[n2];

            for(int i=0; i<n1; i++) L[i] = arr[left + i];
            for(int j=0; j<n2; j++) R[j] = arr[mid + 1 + j];

            int i=0, j=0, k=left;
            while(i < n1 && j < n2) {
                comparacoes++;
                if(L[i] <= R[j]) arr[k++] = L[i++];
                else arr[k++] = R[j++];
            }
            while(i < n1) arr[k++] = L[i++];
            while(j < n2) arr[k++] = R[j++];
        }
    }


    public static void main(String[] args) {
        int[] tamanhos = {10000, 50000, 100000}; 
        String[] tipos = {"ordenado", "invertido", "aleatorio"};

        for (int tamanho : tamanhos) {
            System.out.println("Tamanho do vetor: " + tamanho);

            for (String tipo : tipos) {
                System.out.println("  Tipo de vetor: " + tipo);
                int[] base = gerarVetor(tamanho, tipo);

                int[] vSel = Arrays.copyOf(base, tamanho);
                int[] vBub = Arrays.copyOf(base, tamanho);
                int[] vIns = Arrays.copyOf(base, tamanho);
                int[] vMer = Arrays.copyOf(base, tamanho);

                Resultado rSel = selectionSort(vSel);
                Resultado rBub = bubbleSort(vBub);
                Resultado rIns = insertionSort(vIns);

                MergeSortCounter msc = new MergeSortCounter();
                Resultado rMer = msc.mergeSort(vMer, 0, tamanho-1);

                System.out.printf("    Selection Sort - Tempo: %d ms, Comparações: %d\n", rSel.tempoNano / 1_000_000, rSel.comparacoes);
                System.out.printf("    Bubble Sort    - Tempo: %d ms, Comparações: %d\n", rBub.tempoNano / 1_000_000, rBub.comparacoes);
                System.out.printf("    Insertion Sort - Tempo: %d ms, Comparações: %d\n", rIns.tempoNano / 1_000_000, rIns.comparacoes);
                System.out.printf("    Merge Sort     - Tempo: %d ms, Comparações: %d\n", rMer.tempoNano / 1_000_000, rMer.comparacoes);

                System.out.println();
            }
            System.out.println("---------------------------");
        }
    }
}

