package segundoDesafio;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class SegundoDesafio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigDecimal value = validNumber(sc);

        int valueInteger = value.intValue();
        int valueCents = (int) ((value.doubleValue() - valueInteger) * 100);

        calculateResult(valueInteger, valueCents);
    }

    public static BigDecimal validNumber(Scanner sc) {
        double doubleValue;
        BigDecimal value = BigDecimal.valueOf(0);
        boolean flag = true;

        do {
            System.out.print("Digite um valor maior que zero e com no máximo 2 casas decimais: ");
            String input = sc.nextLine();
            try {
                doubleValue = Double.parseDouble(input);
                value = BigDecimal.valueOf(doubleValue);

                if (value.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("Inválido! Isso é um número negativo.");
                } else if (value.scale() > 2){
                    System.out.println("Inválido! Isso é um número com mais de 2 casas decimais.");
                } else {
                    flag = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Inválido! Isso não é um número válido.");
            }

        } while (flag);

        return value;
    }

    public static void calculateResult(int valueInteger, int valueCents) {

        int[] notes = {100, 50, 20, 10, 5, 2};
        int[] coins = {100, 50, 25, 10, 5, 1};

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat dF = new DecimalFormat("0.00", symbols);

        System.out.println("\nNOTAS:");
        for (int note : notes) {
            int n = valueInteger / note;
            System.out.println(n + "\tnota(s)\t\tde\tR$\t" + dF.format(note));
            valueInteger %= note;
        }

        for (int coin : coins) {
            int n;

            if (coin == 100) {
                n = valueInteger;
            } else {
                n = valueCents/coin;
                valueCents %= coin;
            }
            System.out.println(n + "\tmoeda(s)\tde\tR$\t" + dF.format(coin/100d));
        }
    }
}