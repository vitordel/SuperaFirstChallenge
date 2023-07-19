package terceiroDesafio;

import java.util.Scanner;

public class TerceiroDesafio {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n, k;
        do {
            System.out.print("Digite a quantidade de inteiros: ");
            n = validInteger(sc);
        } while (n <= 0);

        do {
            System.out.print("Digite o número inteiro alvo: ");
            k = validInteger(sc);
        } while (k <= 0);

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int value;
            do {
                System.out.printf("Digite o %dº número: ", i+1);
                value = validInteger(sc);
            } while (value < 0);
            arr[i] = value;
        }

        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(Math.abs(arr[i] - arr[j]) == k) {
                    result += 1;
                }
            }
        }

        System.out.println("\n" + result);

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
}
