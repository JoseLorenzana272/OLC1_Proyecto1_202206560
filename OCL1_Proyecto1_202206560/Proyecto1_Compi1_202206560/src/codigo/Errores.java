package codigo;

public class Errores {
    private String errorMessage;
    private int line;
    private int column;

    public Errores(String errorMessage, int line, int column) {
        this.errorMessage = errorMessage;
        this.line = line;
        this.column = column;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
