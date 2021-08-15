public class Position {

    public int row;
    public int column; 

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public String getStringPos(){
        StringBuilder p = new StringBuilder();
        p.append(Chess.columns[column]);
        p.append(row);
        return p.toString();
    }
}
