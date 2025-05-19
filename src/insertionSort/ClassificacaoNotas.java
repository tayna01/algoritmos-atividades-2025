package insertionSort;

import java.util.Arrays;

public class ClassificacaoNotas {
    public static void main(String[] args) {
        int[] notas = {85, 70, 95, 60, 75, 80};

        insertionSort(notas);

        System.out.println("Notas Ordenadas: " + Arrays.toString(notas));

        double mediana;
        int meio = notas.length / 2;
        if (notas.length % 2 == 0) {
            mediana = (notas[meio - 1] + notas[meio]) / 2.0;
        } else {
            mediana = notas[meio];
        }

        System.out.println("Mediana: " + mediana);
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
