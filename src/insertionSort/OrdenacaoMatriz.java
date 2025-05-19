package insertionSort;

public class OrdenacaoMatriz {
    public static void main(String[] args) {
        int[][] matriz = {
                {3, 2, 1},
                {6, 5, 4},
                {9, 8, 7}
        };

        for (int i = 0; i < matriz.length; i++) {
            insertionSort(matriz[i]);
        }

        System.out.println("Matriz ordenada por linha:");
        for (int[] linha : matriz) {
            for (int valor : linha) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }

    public static void insertionSort(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }
    }
}
