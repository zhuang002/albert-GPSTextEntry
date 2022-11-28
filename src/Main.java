import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		Position last = new Position(0,0);
		int steps =0;
		for (int i=0;i<text.length();i++) {
			char c = text.charAt(i);
			Position current = getCoordinate(c);
			steps += current.distance(last);
			last = current;
		}
		
		steps += getCoordinate('\n').distance(last);
		System.out.println(steps);
	}

	private static Position getCoordinate(char c) {
		// TODO Auto-generated method stub
		if (c==' ') return new Position(4,2);
		if (c=='-') return new Position(4,3);
		if (c=='.') return new Position(4,4);
		if (c=='\n') return new Position(4,5);
		
		if (c<'A' || c>'Z')
			return null;
		int offset = c-'A';
		int row = offset / 6;
		int col = offset % 6;
		return new Position(row, col);
	}

}

class Position {
	int row;
	int col;
	
	public Position(int r, int c) {
		this.row = r;
		this.col = c;
	}

	public int distance(Position last) {
		// TODO Auto-generated method stub
		return Math.abs(col-last.col)+Math.abs(row-last.row);
	}
}
