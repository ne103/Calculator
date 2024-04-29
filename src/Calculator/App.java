package Calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int firstNumber = 0;
        while (true) {
            System.out.print("첫 번째 양의 정수를 입력하세요: ");
            int i = sc.nextInt();

            if (i < 0) {
                System.out.println("양의 정수만 입력하세요.");
            } else {
                firstNumber = i;
                break;
            }
        }

        int secondNumber = 0;
        while (true) {
            System.out.print("두 번째 양의 정수를 입력하세요: ");
            int i = sc.nextInt();

            if (i < 0) {
                System.out.println("양의 정수만 입력하세요.");
            } else {
                secondNumber = i;
                break;
            }
        }
    }
}
