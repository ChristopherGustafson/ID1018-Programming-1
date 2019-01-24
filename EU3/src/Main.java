
public class Main {
	
	public static void main(String[] args) {
		
		Chessboard board = new Chessboard();
		
		Chessboard.Chesspiece R = board.new King('w', 'K');
		R.moveTo('d', (byte)4);
		R.markReachableFields();
		System.out.println(board);
		
	}

}
