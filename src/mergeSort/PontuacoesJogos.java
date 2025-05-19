package mergeSort;

import java.util.Scanner;
import java.util.Arrays;

public class PontuacoesJogos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de pontuações: ");
        int n = scanner.nextInt();
        int[] pontuacoes = new int[n];

        System.out.println("Digite as pontuações:");
        for (int i = 0; i < n; i++) {
            pontuacoes[i] = scanner.nextInt();
        }

        mergeSort(pontuacoes, 0, pontuacoes.length - 1);

        System.out.println("Pontuações Ordenadas: " + Arrays.toString(pontuacoes));

        System.out.println("Pontuação Mais Alta: " + pontuacoes[0]);

        scanner.close();
    }

    public static void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }
    }

    public static void merge(int[] vetor, int inicio, int meio, int fim) {
        int[] temp = new int[fim - inicio + 1];
        int i = inicio, j = meio + 1, k = 0;

        while (i <= meio && j <= fim) {
            if (vetor[i] > vetor[j]) {
                temp[k++] = vetor[i++];
            } else {
                temp[k++] = vetor[j++];
            }
        }

        while (i <= meio) {
            temp[k++] = vetor[i++];
        }

        while (j <= fim) {
            temp[k++] = vetor[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            vetor[inicio + l] = temp[l];
        }
    }
}
