import java.util.Random;

public class ReachableFieldsOnChessboard {
	
	public static void main(String[] args) throws InterruptedException {
		
		Chessboard chessBoard = new Chessboard();
		System.out.println(chessBoard + "\n");
		
		Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];
		pieces[0] = chessBoard.new Pawn('w', 'P');
		pieces[1] = chessBoard.new Rook('w', 'R');
		pieces[2] = chessBoard.new Knight('b', 'N');
		pieces[3] = chessBoard.new Bishop('w', 'B');
		pieces[4] = chessBoard.new Queen('w', 'Q');
		pieces[5] = chessBoard.new King('w', 'K');
		
		Random r = new Random();
		byte a  = (byte)(r.nextInt(7) + 1);
		char b = (char)(r.nextInt(7)+97);
		
		for(int i = 0; i < pieces.length; i++) {
			pieces[i].moveTo(b, a);
			System.out.println(chessBoard);
			Thread.sleep(200);
			
			pieces[i].markReachableFields();
			System.out.println(chessBoard);
			Thread.sleep(200);
			
			pieces[i].unmarkReachableFields();
			System.out.println(chessBoard);
			Thread.sleep(200);
			
			pieces[i].moveOut();
			System.out.println(chessBoard);
			Thread.sleep(200);
		}
		
	}

}
