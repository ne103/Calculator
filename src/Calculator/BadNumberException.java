package Calculator;

import java.util.InputMismatchException;

public class BadNumberException extends Exception {

    public BadNumberException() {
        super("양의 정수가 아닌 다른 값이 들어왔습니다.");
    }


}
