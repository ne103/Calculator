package Calculator;

public class BadListException extends Exception {
    public BadListException() {
        super("리스트가 비어있습니다.");
    }
}
