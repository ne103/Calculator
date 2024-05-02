package Calculator;

import java.util.LinkedList;
import java.util.List;

public class Calculator {
    private List<Double> resultList = new LinkedList<>();

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
}
