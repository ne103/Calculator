package Calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int firstNumber = 0;
        int secondNumber = 0;
        char operator = 0;

        while (true) {
            System.out.print("첫 번째 양의 정수를 입력하세요: ");
            firstNumber = sc.nextInt();

            if (firstNumber < 0) {
                System.out.println("양의 정수만 입력하세요.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("두 번째 양의 정수를 입력하세요: ");
            secondNumber = sc.nextInt();

            if (secondNumber < 0) {
                System.out.println("양의 정수만 입력하세요.");
            } else {
                break;
            }
        }

        sc.nextLine();  // nextInt()에 nextLine()이 씹히는 걸 방지

        while (true) {
            System.out.print("연산자를 입력해주세요: ");
            String str = sc.nextLine();
            char c = str.charAt(0);

            if ( c == '+' || c == '-' || c == '*' || c == '/') {
                operator = c;
                break;
            } else {
                System.out.println("연산자를 제대로 입력하세요.");
            }
        }

        double result = 0;
        // 오류케이스일 때 결과를 출력하지 않기 위해 선언
        boolean flag = true;

        switch(operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                // 나눗셈 오류 케이스
                if (firstNumber == 0 || secondNumber == 0) {
                    System.out.println("나눗셈은 0이 들어갈 수 없습니다.");
                    flag = false;
                    break;
                }
                // 소숫점까지 출력해주기 위해 double 형변환
                result = firstNumber / (double)secondNumber;
                break;
        }
        // 정상 케이스일 때 결과 출력
        if (flag) {
            System.out.println("결과: " + result);
        }
    }
}
