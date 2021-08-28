public class Rook extends PieceImpl{

    public Rook(boolean white,Position pos) {
        super(white,pos);
    }

    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean isValidMove(Position newPosition, boolean takes, Board board) {
        if(newPosition.getColumn() == this.getPos().getColumn()){
            // check the column is empty between old pos and new pos
            for(int i = this.getPos().getRow()+1; i < newPosition.getRow(); i ++){
                if(board.pieces[i][this.getPos().getColumn()] != null){
                    return false;
                }
            }
        }else{
            // check the row is empty between old pos and new pos
            for(int i = this.getPos().getColumn()+1; i < newPosition.getColumn(); i ++){
                if(board.pieces[this.getPos().getRow()][i] != null){
                    return false;
                }
            }
        }
        
        return this.getPos().getRow() == newPosition.getRow() | this.getPos().getColumn() == newPosition.getColumn();
    }
    
}
