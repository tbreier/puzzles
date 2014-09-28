import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class EightQueens {

	public static void main(String[] args) {	

		Kattio io = new Kattio(System.in, System.out);

		String[] rows = new String[8];
		boolean[][] chessboard = new boolean[8][8];
		int[] queens_x = new int[8];
		int[] queens_y = new int[8];
		int currentQueen = 0;

		while (io.hasMoreTokens()) {
			for(int i = 0; i < 8; i++) {
				rows[i] = io.getWord();
				for(int j = 0; j < 8; j++) {
					if (rows[i].charAt(j) == '*') {
						if (currentQueen == 8) {
							System.out.println("invalid");
							io.close();
							return;
						}
						chessboard[i][j] = true;
						queens_x[currentQueen] = i;
						queens_y[currentQueen] = j;
						currentQueen++;
					}
				}
			}
			break;
		}
		
		if(currentQueen < 8) {
			System.out.println("invalid");
			io.close();
			return;
		}

		for(int queen = 0; queen < 8; queen++) {
			// Horizontal
			for(int i = 0; i < 8; i++) {
				if(chessboard[queens_x[queen]][i] && i != queens_y[queen]) {
					System.out.println("invalid");
					io.close();
					return;
				}
			}

			// Vertical
			for(int i = 0; i < 8; i++) {
				if(chessboard[i][queens_y[queen]] && i != queens_x[queen]) {
					System.out.println("invalid");
					io.close();
					return;
				}
			}

			// Diagonal
			int x1 = queens_x[queen] - queens_y[queen];
			int x2 = queens_x[queen] + queens_y[queen];
			int y = 0;
			for(int i = 0; i < 8; i++) {
				if(x1 >= 0 && x1 < 8 && chessboard[x1][y] && x1 != queens_x[queen] && y != queens_y[queen]) {
					System.out.println("invalid");
					io.close();
					return;
				}
				if(x2 >= 0 && x2 < 8 && chessboard[x2][y] && x2 != queens_x[queen] && y != queens_y[queen]) {
					System.out.println("invalid");
					io.close();
					return;
				}
				x1++;
				x2--;
				y++;
			}
		}


		System.out.println("valid");
		io.close();

	}

}



/** Simple yet moderately fast I/O routines.
*
* Example usage:
*
* Kattio io = new Kattio(System.in, System.out);
*
* while (io.hasMoreTokens()) {
*    int n = io.getInt();
*    double d = io.getDouble();
*    double ans = d*n;
*
*    io.println("Answer: " + ans);
* }
*
* io.close();
*
*
* Some notes:
*
* - When done, you should always do io.close() or io.flush() on the
*   Kattio-instance, otherwise, you may lose output.
*
* - The getInt(), getDouble(), and getLong() methods will throw an
*   exception if there is no more data in the input, so it is generally
*   a good idea to use hasMoreTokens() to check for end-of-file.
*
* @author: Kattis
*/

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
	super(new BufferedOutputStream(System.out));
	r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
	super(new BufferedOutputStream(o));
	r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
	return peekToken() != null;
    }

    public int getInt() {
	return Integer.parseInt(nextToken());
    }

    public double getDouble() { 
	return Double.parseDouble(nextToken());
    }

    public long getLong() {
	return Long.parseLong(nextToken());
    }

    public String getWord() {
	return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
	if (token == null) 
	    try {
		while (st == null || !st.hasMoreTokens()) {
		    line = r.readLine();
		    if (line == null) return null;
		    st = new StringTokenizer(line);
		}
		token = st.nextToken();
	    } catch (IOException e) { }
	return token;
    }

    private String nextToken() {
	String ans = peekToken();
	token = null;
	return ans;
    }
}



