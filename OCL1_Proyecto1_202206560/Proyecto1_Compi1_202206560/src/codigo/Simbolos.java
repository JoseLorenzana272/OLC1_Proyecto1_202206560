/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

/**
 *
 * @author PERSONAL
 */
public class Simbolos {
    public String name;
    public int line;
    public int column;
    public String type;
    public String value;

    public Simbolos(String name, int line, int column, String type, String value) {
        this.name = name;
        this.line = line;
        this.column = column;
        this.type = type;
        this.value = value;
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
    
    public String getValue() {
        return this.value;
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
    
    public void setValue(String value) {
        this.type = this.value;
    }
}
