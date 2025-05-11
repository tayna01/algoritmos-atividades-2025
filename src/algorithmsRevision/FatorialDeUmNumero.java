package algorithmsRevision;

import java.util.Scanner;

public class FatorialDeUmNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número para descobrir o fatorial dele: ");
        int numero = scanner.nextInt();

        int fatorial = 1;

        for (int i = 1; i <= numero; i++) {
            fatorial *= i;
        }

        System.out.println("O fatorial de " + numero + " é: " + fatorial);
    }
}
