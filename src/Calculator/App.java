package Calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> resultList = new LinkedList<>();

        do {

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

                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    operator = c;
                    break;
                } else {
                    System.out.println("연산자를 제대로 입력하세요.");
                }
            }

            double result = 0;
            // 오류케이스일 때 결과를 출력하지 않기 위해 선언
            boolean flag = true;

            switch (operator) {
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
                    result = firstNumber / (double) secondNumber;
                    break;
            }
            // 정상 케이스일 때 결과 출력
            if (flag) {
                System.out.println("결과: " + result);
                resultList.add(result);
            }

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            if (sc.nextLine().equalsIgnoreCase("remove")) {
                if (resultList.isEmpty()) { // 리스트가 비어있는지 확인
                    System.out.println("리스트가 비어있습니다.");
                } else {
                    resultList.remove(0); // 0번째 값을 삭제함 -> 다음 인덱스의 값이 0번째로 이동
                }
            }

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            if (sc.nextLine().equalsIgnoreCase("inquiry")) {
                if (resultList.isEmpty()) { // 리스트가 비어있는지 확인
                    System.out.println("리스트가 비어있습니다.");
                } else {
                    for (Double d : resultList) {
                        System.out.print(d + " ");
                    }
                    System.out.println();
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        } while (!sc.nextLine().equalsIgnoreCase("exit"));  // 최초 한번 실행 후 exit 입력 시 while 탈출
    }
}
