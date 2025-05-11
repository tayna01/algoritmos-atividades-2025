package algorithmsRevision;

import java.util.Scanner;

public class ConversaoDeTemperatura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma temperatura em Celsius para converter para Fahrenheit: ");
        int celsius = scanner.nextInt();

        int fahrenheit = celsius * 9 / 5 + 32;

        System.out.println("A temperatura em Fahrenheit é: " + fahrenheit);
    }
}
