package src;
public class Position {

    private int row;
    private int column;

    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public String getStringPos(){
        StringBuilder p = new StringBuilder();
        p.append(Chess.columns[column-1]);
        p.append(row);
        return p.toString();
    }
    @Override
    public String toString() {
        return getStringPos() + "[column=" + column + ", row=" + row + "]";
    }
}
