package Calculator;

import java.util.LinkedList;
import java.util.List;

public class Calculator {
    private List<Double> resultList = new LinkedList<>();

    public Calculator(List<Double> resultList) {
        this.resultList = resultList;
    }

    public double calculate(int firstNumber, int secondNumber, char operator) throws BadDivideException {
        double result = 0;

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
                if (secondNumber == 0) {
                    throw new BadDivideException();
                }
                // 소숫점까지 출력해주기 위해 double 형변환
                result = firstNumber / (double) secondNumber;
                break;
        }

        return result;

    }

    public List<Double> getResultList() {
        return resultList;
    }

    public void setResultList(List<Double> resultList) {
        this.resultList = resultList;
    }

    public void removeResult() throws BadListException {
        if (resultList.isEmpty()) { // 리스트가 비어있는지 확인
            throw new BadListException();
        } else {
            resultList.remove(0); // 0번째 값을 삭제함 -> 다음 인덱스의 값이 0번째로 이동
        }
    }

    public void inquiryResult() throws BadListException {
        if (resultList.isEmpty()) { // 리스트가 비어있는지 확인
            throw new BadListException();
        } else {
            for (Double d : resultList) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }
}
