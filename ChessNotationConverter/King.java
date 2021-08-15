public class King implements Piece{

    private boolean white;
    private Position pos;

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public King(boolean white,Position pos) {
        this.white = white;
        this.pos = pos;
    }

    @Override
    public boolean isWhite() {
        return white;
    }

    @Override
    public String toString(){
        return "K";
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece isTaken, Board board) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
