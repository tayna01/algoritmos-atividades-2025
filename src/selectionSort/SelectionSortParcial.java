package selectionSort;

import java.util.Scanner;

public class SelectionSortParcial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do vetor: ");
        int tamanho = scanner.nextInt();

        int[] vetor = new int[tamanho];
        System.out.println("Digite os elementos do vetor:");
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = scanner.nextInt();
        }

        System.out.print("Digite o valor de N (quantidade de elementos a ordenar): ");
        int N = scanner.nextInt();

        for (int i = 0; i < N - 1; i++) {
            int menorIndice = i;
            for (int j = i + 1; j < N; j++) {
                if (vetor[j] < vetor[menorIndice]) {
                    menorIndice = j;
                }
            }

            int temp = vetor[i];
            vetor[i] = vetor[menorIndice];
            vetor[menorIndice] = temp;
        }

        System.out.println("\nVetor após ordenação parcial:");
        for (int num : vetor) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}