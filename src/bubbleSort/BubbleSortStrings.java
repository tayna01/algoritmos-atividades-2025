package bubbleSort;

import java.util.Scanner;

public class BubbleSortStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas palavras deseja inserir(tamanho)? ");
        int tamanho = scanner.nextInt();
        scanner.nextLine();

        String[] palavras = new String[tamanho];

        for (int i = 0; i < tamanho; i++) {
            System.out.print("Palavra " + (i + 1) + ": ");
            palavras[i] = scanner.nextLine();
        }

        for (int i = 0; i < palavras.length - 1; i++) {
            for (int j = 0; j < palavras.length - 1 - i; j++) {
                if (palavras[j].compareTo(palavras[j + 1]) > 0) {
                    String temp = palavras[j];
                    palavras[j] = palavras[j + 1];
                    palavras[j + 1] = temp;
                }
            }
        }

        System.out.println("\nPalavras ordenadas:");
        for (String palavra : palavras) {
            System.out.println(palavra);
        }

        scanner.close();
    }
}
