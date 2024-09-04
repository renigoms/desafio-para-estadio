package org.example;
import java.util.Scanner;
public class Question05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String entrada = scanner.nextLine();

        String invertida = inverterString(entrada);
        System.out.println("String invertida: " + invertida);
    }

    public static String inverterString(String original) {
        // Cria uma string vazia para armazenar o resultado
        StringBuilder resultado = new StringBuilder();

        // Percorre a string original de trás para frente
        for (int i = original.length() - 1; i >= 0; i--) {
            resultado.append(original.charAt(i));
        }

        return resultado.toString();
    }
}
