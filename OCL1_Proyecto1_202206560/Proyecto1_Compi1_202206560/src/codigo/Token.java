package codigo;

public class Token {
    public String name;
    public int line;
    public int column;
    public String type;

    public Token(String name, int line, int column, String type) {
        this.name = name;
        this.line = line;
        this.column = column;
        this.type = type;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

    public String getType() {
        return this.type;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setType(String type) {
        this.type = type;
    }
}
