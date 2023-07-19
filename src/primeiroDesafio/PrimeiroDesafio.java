package primeiroDesafio;

import java.util.*;

public class PrimeiroDesafio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        do {
            System.out.print("Digite a quantidade de inteiros: ");
            n = validInteger(sc);

        } while (n <= 0);

        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int value;

            System.out.println("Digite inteiros positivos.");
            do {
                System.out.printf("Digite o %dº inteiro: ", i);
                value = validInteger(sc);

            } while (value <= 0);

            if (value % 2 == 0) {
                evens.add(value);
            } else {
                odds.add(value);
            }
        }

        evens.sort(null);
        odds.sort(Comparator.reverseOrder());

        printValues(evens, odds);
    }

    public static int validInteger(Scanner sc) {
        int value;
        try {
            value = Integer.parseInt(sc.nextLine());

        } catch (NumberFormatException e) {
            value = 0;
        }

        if (value <= 0 ) {
            System.out.println("Isso não é um inteiro válido. Digite um inteiro maior que zero.");
        }
        return value;
    }

    public static void printValues(List<Integer> evens, List<Integer> odds) {

        System.out.println("\nValores ordenados:");
        for (long value : evens) {
            System.out.println(value);
        }
        for (long value : odds) {
            System.out.println(value);
        }
    }
}