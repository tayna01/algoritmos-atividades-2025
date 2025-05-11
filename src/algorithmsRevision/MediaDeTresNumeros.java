package algorithmsRevision;

import java.util.Scanner;

public class MediaDeTresNumeros {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite três números: ");
        double numUm = scanner.nextDouble();
        double numDois= scanner.nextDouble();
        double numTres = scanner.nextDouble();

        double media = ((numUm + numDois + numTres) / 3);

        System.out.println("A média aritmética é: " + media);
    }
}