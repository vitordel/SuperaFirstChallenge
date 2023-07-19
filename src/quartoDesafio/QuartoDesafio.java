package quartoDesafio;

import java.util.Scanner;

public class QuartoDesafio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = validInteger(sc);

        String[] texts = new String[n];

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            do {
                System.out.print("Digite uma frase: ");
                texts[i] = sc.nextLine();

                if (texts[i].length() < 2 || texts[i].length() > 100) {
                    System.out.println("Frase inválida. Digite uma frase entre 2 e 100 caracteres.");
                } else {
                    flag = false;
                }
            } while (flag);
        }

        for (String text : texts) {
            printWrong(text);
        }
    }

    public static int validInteger(Scanner sc) {
        int value;
        do {
            try {
                System.out.print("Digite um inteiro maior que zero: ");
                value = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                value = 0;
            }
            if (value <= 0 ) {
                System.out.println("Isso não é um inteiro válido. Digite um inteiro maior que zero.");
            }
        } while (value <= 0);

        return value;
    }

    public static void printWrong(String text) {

        StringBuilder reversed = new StringBuilder(text).reverse();
        String reversedText = reversed.toString();

        String reversedSecondHalf = reversedText.substring(0, reversedText.length()/2);
        String reversedFirstHalf = reversedText.substring(reversedText.length()/2);

        System.out.println(reversedFirstHalf + reversedSecondHalf);
    }

}
