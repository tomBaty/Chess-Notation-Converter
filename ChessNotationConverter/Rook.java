public class Rook implements Piece{

    private boolean white;
    private Position pos;

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public Rook(boolean white,Position pos) {
        this.white = white;
        this.pos = pos;
    }

    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean isWhite() {
        return white;
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece isTaken, Board board) {
        return pos.row == newPosition.row | pos.column == newPosition.column;
    }
    
}
