public class Bishop implements Piece{

    private boolean white;
    private Position pos;

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public Bishop(boolean white,Position pos) {
        this.white = white;
        this.pos = pos;
    }

    @Override
    public String toString(){
        return "B";
    }

    @Override
    public boolean isWhite() {
        return white;
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece isTaken, Board board) {
        // TODO Auto-generated method stub
        return false;
    }
    
}

