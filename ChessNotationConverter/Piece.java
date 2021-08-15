public interface Piece {

	
	public boolean isWhite();
	public boolean isValidMove(Position newPosition, Piece isTaken, Board board);	
}
