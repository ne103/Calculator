package Calculator;

public class BadOperatorException extends Exception{

    public BadOperatorException() {
        super("+, -, *, / 이외의 문자가 들어왔습니다.");
    }


}
