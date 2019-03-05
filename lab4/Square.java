
public class Square {
	
	private int type;
	private int row;
	private int col;
	
	public static final int SPACE = 0;
	public static final int WALL = 1;
	public static final int START = 2;
	public static final int END = 3;

	public static final int ONWORKLIST = 4;
	public static final int EXPLORED = 5;
	public static final int ONFINALPATH = 6;
	
	public Square(int row, int col, int type) {
		this.row = row;
		this.col = col;
		this.type = type;
	}
	public String toString() {
		switch(type) {
		case SPACE:
			return "_";
		case WALL:
			return "#";
		case START:
			return "S";
		case END:
			return "E";
		case ONWORKLIST:
			return "o";
		case EXPLORED:
			return ".";
		case ONFINALPATH:
			return "X";
		default:
			return "Z";
		}
	}

	public int getType() {
		return type;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	
}
