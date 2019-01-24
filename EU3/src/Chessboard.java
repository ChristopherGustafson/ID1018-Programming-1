
public class Chessboard {
	
	public static class Field{
		private char row;
		private byte column;
		private Chesspiece piece = null;
		private boolean marked = false;
		
		public Field(char row, byte column) {
			this.row = row;
			this.column = column;
		}
		
		public void put(Chesspiece piece) {
			this.piece = piece;
		}
		
		public Chesspiece take() {
			Chesspiece p = this.piece;
			piece = null;
			return p;
			
		}
		
		public void mark() {
			this.marked = true;
		}
		
		public void unMark() {
			this.marked = false;
		}
		
		public String toString() {
			String s = (marked)? "xx": "--";
			return (piece == null)? s : piece.toString();
		}
	}
	
	public static final int NUMBER_OF_ROWS = 8;
	public static final int NUMBER_OF_COLUMNS = 8;
	
	public static final int FIRST_ROW = 'a';
	public static final int FIRST_COLUMN = 1;
	
	private Field[][] fields;
	
	public Chessboard() {
		fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		char row = 0;
		byte column = 0;
		
		for(int r = 0; r < NUMBER_OF_ROWS; r++) {
			
			row = (char) (FIRST_ROW + r);
			column = FIRST_COLUMN;
			
			for(int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				fields[r][c] = new Field(row, column);
				column++;
			}
		}
	}
	
	public String toString() {
		
		String s = "  ";
		for(int i = 0; i < NUMBER_OF_COLUMNS; i++) {
			s += (FIRST_COLUMN + i) + "  ";
		}
		
		for(int r = 0; r < NUMBER_OF_ROWS; r++) {
			s += "\n" + (char)(FIRST_ROW + r);
			
			for(int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				s += " " + fields[r][c];
			}	
		}
		
		return s;
	}
	
	public boolean isValidField(char row, byte column) {
		return row >= 'a' && row <= 'h' && column > 0 && column <= NUMBER_OF_COLUMNS;
	}
	
	public abstract class Chesspiece {
		
		private char color;
		//w - white, b - black
		
		private char name;
		//K - King, Q - Queen, R - Rook, B - Bishop, N - Knight, P - Pawn

		protected char row = 0;
		protected byte column = 0;
		
		protected Chesspiece(char color, char name) {
			this.color = color;
			this.name = name;
		}
		
		public String toString() {
			return "" + color + name;
		}
		
		public boolean isOnBoard() {
			return Chessboard.this.isValidField(row, column);
		}
		
		public void moveTo(char row, byte column) throws NotValidFieldException{
			if(!Chessboard.this.isValidField(row, column)) {
				throw new NotValidFieldException("Invalid field: " + row + column);
			}
			
			this.row = row;
			this.column = column;
			
			int r = row - FIRST_ROW;
			int c = column - FIRST_COLUMN;
			Chessboard.this.fields[r][c].put(this);
		}
		
		public void moveOut() {
			int r = row-FIRST_ROW;
			int c = column - FIRST_COLUMN;
			Chessboard.this.fields[r][c].take();
			r = 0;
			c = 0;
		}
		
		public abstract void markReachableFields();
		public abstract void unmarkReachableFields();
	}
	
	public class Pawn extends Chesspiece{

		public Pawn(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			
			byte col = (byte) (column + 1);
			if(Chessboard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col-FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
			}
		}

		public void unmarkReachableFields() {
			
			byte col = (byte) (column + 1);
			if(Chessboard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col-FIRST_COLUMN;
				Chessboard.this.fields[r][c].unMark();
			}
		}
	}
	
	public class Rook extends Chesspiece{

		public Rook(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			
			for(int r = 0; r < NUMBER_OF_ROWS; r++) {
				Chessboard.this.fields[r][column-FIRST_COLUMN].mark();
			}
			
			for(int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				Chessboard.this.fields[row-FIRST_ROW][c].mark();
			}
		}

		public void unmarkReachableFields() {
			
			for(int r = 0; r < NUMBER_OF_ROWS; r++) {
				Chessboard.this.fields[r][column-FIRST_COLUMN].unMark();
			}
			
			for(int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				Chessboard.this.fields[row-FIRST_ROW][c].unMark();
			}
		}
	}
	
	public class Knight extends Chesspiece{

		public Knight(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			char r = (char) (row-2);
			byte c = (byte) (column-1);
			
			//Possible moves upwards
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
			}
			c += 2;
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
			}
			
			//Possible moves to the right
			
			r = (char) (row - 1);
			c = (byte) (column + 2);
			
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
			}
			r += 2;
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
			}
			
			//Possible moves downwards
			
			r = (char) (row + 2);
			c = (byte) (column - 1);
			
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
			}
			c += 2;
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
			}
			
			//Possible moves to the left
			
			r = (char) (row - 1);
			c = (byte) (column - 2);
			
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
			}
			r += 2;
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
			}
			
			
		}

		public void unmarkReachableFields() {
			
			char r = (char) (row-2);
			byte c = (byte) (column-1);
			
			//Possible moves upwards
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
			}
			c += 2;
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
			}
			
			//Possible moves to the right
			
			r = (char) (row - 1);
			c = (byte) (column + 2);
			
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
			}
			r += 2;
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
			}
			
			//Possible moves downwards
			
			r = (char) (row + 2);
			c = (byte) (column - 1);
			
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
			}
			c += 2;
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
			}
			
			//Possible moves to the left
			
			r = (char) (row - 1);
			c = (byte) (column - 2);
			
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
			}
			r += 2;
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
			}
		}
		
	}
	
	public class Bishop extends Chesspiece{
		
		public Bishop(char color, char name) {
			super(color, name);
		}
		
		public void markReachableFields() {
			
			char r = (char) (row+1);
			byte c = (byte) (column+1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
				r++;
				c++;
			}
			
			r = (char) (row+1);
			c = (byte) (column-1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
				r++;
				c--;
			}
			
			r = (char) (row-1);
			c = (byte) (column-1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
				r--;
				c--;
			}
			
			r = (char) (row-1);
			c = (byte) (column+1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
				r--;
				c++;
			}
			
			
		}
		
		public void unmarkReachableFields() {
			char r = (char) (row+1);
			byte c = (byte) (column+1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
				r++;
				c++;
			}
			
			r = (char) (row+1);
			c = (byte) (column-1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
				r++;
				c--;
			}
			
			r = (char) (row-1);
			c = (byte) (column-1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
				r--;
				c--;
			}
			
			r = (char) (row-1);
			c = (byte) (column+1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
				r--;
				c++;
			}
		}
	}
	
	public class Queen extends Chesspiece{
		
		public Queen(char color, char name) {
			super(color, name);
		}

		@Override
		public void markReachableFields() {
			
			for(int r = 0; r < NUMBER_OF_ROWS; r++) {
				Chessboard.this.fields[r][column-FIRST_COLUMN].mark();
			}
			
			for(int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				Chessboard.this.fields[row-FIRST_ROW][c].mark();
			}
			
			//--------------
			
			char r = (char) (row+1);
			byte c = (byte) (column+1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
				r++;
				c++;
			}
			
			r = (char) (row+1);
			c = (byte) (column-1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
				r++;
				c--;
			}
			
			r = (char) (row-1);
			c = (byte) (column-1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
				r--;
				c--;
			}
			
			r = (char) (row-1);
			c = (byte) (column+1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
				r--;
				c++;
			}
		}

		@Override
		public void unmarkReachableFields() {
			
			for(int r = 0; r < NUMBER_OF_ROWS; r++) {
				Chessboard.this.fields[r][column-FIRST_COLUMN].unMark();
			}
			
			for(int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				Chessboard.this.fields[row-FIRST_ROW][c].unMark();
			}
			
			//--------------
			
			char r = (char) (row+1);
			byte c = (byte) (column+1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
				r++;
				c++;
			}
			
			r = (char) (row+1);
			c = (byte) (column-1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
				r++;
				c--;
			}
			
			r = (char) (row-1);
			c = (byte) (column-1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
				r--;
				c--;
			}
			
			r = (char) (row-1);
			c = (byte) (column+1);
			
			while(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
				r--;
				c++;
			}
			
		}
	}
	
	public class King extends Chesspiece{
		
		public King(char color, char name) {
			super(color, name);
		}

		@Override
		public void markReachableFields() {
			char r = (char) (row-1);
			byte c = (byte) (column-1);
			
			for(int i = 0; i < 3; i++) {
				if(Chessboard.this.isValidField(r, c)) {
					Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
					c++;
				}
			}
			
			r = (char) (row+1);
			c = (byte) (column-1);
			
			for(int i = 0; i < 3; i++) {
				if(Chessboard.this.isValidField(r, c)) {
					Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
					c++;
				}
			}
			
			r = row;
			c = (byte) (column-1);
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
			}
			c += 2;
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].mark();
			}
		}

		@Override
		public void unmarkReachableFields() {
			char r = (char) (row-1);
			byte c = (byte) (column-1);
			
			for(int i = 0; i < 3; i++) {
				if(Chessboard.this.isValidField(r, c)) {
					Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
					c++;
				}
			}
			
			r = (char) (row+1);
			c = (byte) (column-1);
			
			for(int i = 0; i < 3; i++) {
				if(Chessboard.this.isValidField(r, c)) {
					Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
					c++;
				}
			}
			
			r = row;
			c = (byte) (column-1);
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
			}
			c += 2;
			if(Chessboard.this.isValidField(r, c)) {
				Chessboard.this.fields[r-FIRST_ROW][c-FIRST_COLUMN].unMark();
			}
		}
	}
}
