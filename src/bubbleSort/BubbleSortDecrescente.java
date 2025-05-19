package bubbleSort;

public class BubbleSortDecrescente {
    public static void main(String[] args) {
        int[] vetor = {3, 0, -2, 5, 8};

        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j] < vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }

        for (int num : vetor) {
            System.out.print(num + " ");
        }
    }
}