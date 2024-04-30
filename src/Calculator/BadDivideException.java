package Calculator;

public class BadDivideException extends Exception{

    public BadDivideException() {
        super("나눗셈은 분모가 0이 될 수 없습니다.");
    }


}
