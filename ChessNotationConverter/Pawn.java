public class Pawn implements Piece{

    private boolean white;
    private Position pos;

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public Pawn(boolean white,Position pos) {
        this.white = white;
        this.pos = pos;
    }

    @Override
    public String toString(){
        return "P";
    }

    @Override
    public boolean isWhite() {
        return white;
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece isTaken, Board board) {
        if(isTaken==null){
            return pos.column == newPosition.column && Math.abs(pos.row-newPosition.row) <= 2;
        }else{
            return Math.abs(pos.row-newPosition.row) == 1 && Math.abs(pos.column-newPosition.column) == 1;
        }
    }
    
}
