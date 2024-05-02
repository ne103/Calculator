package Calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator calculator = new Calculator(new LinkedList<>());
        List<Double> resultList = calculator.getResultList();   // resultList는 실제로 List<Double>의 주솟값이 저장되어 있기 때문에 값이 추가되어도 calculator 변수에 다시 set 안해줘도 된다.
        do {

            int firstNumber = 0;
            int secondNumber = 0;
            char operator = 0;


            try {

                while (true) {
                    System.out.print("첫 번째 양의 정수를 입력하세요: ");
                    firstNumber = sc.nextInt();
                    if (firstNumber < 0) {
                        sc.nextLine();
                        throw new BadNumberException();
                    } else {
                        break;
                    }
                }

                while (true) {
                    System.out.print("두 번째 양의 정수를 입력하세요: ");
                    secondNumber = sc.nextInt();
                    if (secondNumber < 0) {
                        sc.nextLine();
                        throw new BadNumberException();
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
                        throw new BadOperatorException();
                    }
                }
                double result = calculator.calculate(firstNumber, secondNumber, operator);
                // 정상 케이스일 때 결과 출력
                System.out.println("결과: " + result);

                resultList.add(result);
            } catch (InputMismatchException e) {
                System.out.println("예외 발생(InputMismatchException) : 숫자가 아닌 다른 값이 입력되었습니다.");
                sc.nextLine();
            } catch (BadNumberException e) {
                System.out.println("예외 발생 : " + e.getMessage()); // 양의 정수가 아닌 값이 들어왔을 때 예외처리
            } catch (BadDivideException e) {
                System.out.println("예외 발생 : " + e.getMessage()); // 연산자 잘못 입력했을 때 예외처리
            } catch (BadOperatorException e) {
                System.out.println("예외 발생 : " + e.getMessage()); // 분모가 0이 들어왔을 때 예외처리
            } finally {

                try {
                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");

                    if (sc.nextLine().equalsIgnoreCase("remove")) {
                        calculator.removeResult();
                    }

                    System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                    if (sc.nextLine().equalsIgnoreCase("inquiry")) {
                        calculator.inquiryResult();
                    }
                } catch (BadListException e) {
                    System.out.println("예외 발생 : " + e.getMessage());
                }
                finally{
                    System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                }
            }
        } while (!sc.nextLine().equalsIgnoreCase("exit"));  // 최초 한번 실행 후 exit 입력 시 while 탈출
    }
}
