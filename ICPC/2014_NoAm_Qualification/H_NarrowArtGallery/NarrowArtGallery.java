import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;


public class NarrowArtGallery {

	public static void main(String[] args) {	

		Kattio io = new Kattio(System.in, System.out);
		
		while (io.hasMoreTokens()) {
			int no_rows = io.getInt();
			int no_rooms = io.getInt() + 1;
			
			do {
				int[] left = new int[no_rows];
				int[] right = new int[no_rows];
				// max_table(row,rooms_left_to_close,left_has_to_be_open,right_has_to_be_open)
				int[][][][] max_table = new int[no_rows][no_rooms][2][2];
				
				for(int i = 0; i < no_rows; i ++) {
					left[i] = io.getInt();
					right[i] = io.getInt();
				}
				
				// Done reading input.				
				
				// Last row
				max_table[no_rows-1][0][0][0] = left[no_rows-1] + right[no_rows-1];
				max_table[no_rows-1][0][0][1] = left[no_rows-1] + right[no_rows-1];
				max_table[no_rows-1][0][1][0] = left[no_rows-1] + right[no_rows-1];
				
				if(no_rooms > 1) {
					max_table[no_rows-1][1][0][0] = Math.max(left[no_rows-1],right[no_rows-1]);
					max_table[no_rows-1][1][0][1] = right[no_rows-1];
					max_table[no_rows-1][1][1][0] = left[no_rows-1];
				}
				
				for(int i = 2; i < no_rooms; i++) {
					max_table[no_rows-1][i][0][0] = Integer.MIN_VALUE;
					max_table[no_rows-1][i][0][1] = Integer.MIN_VALUE;
					max_table[no_rows-1][i][1][0] = Integer.MIN_VALUE;
				}
				
				// Fill the rest
				for(int row = no_rows-2; row >= 0; row--) {
					max_table[row][0][0][0] = right[row] + left[row] + max_table[row+1][0][0][0];
					max_table[row][0][0][1] = right[row] + left[row] + max_table[row+1][0][0][0];
					max_table[row][0][1][0] = right[row] + left[row] + max_table[row+1][0][0][0];
					for(int to_be_closed = 1; to_be_closed < no_rooms; to_be_closed++) {
						int close_left = right[row] + max_table[row+1][to_be_closed-1][0][1];
						int close_right = left[row] + max_table[row+1][to_be_closed-1][1][0];
						int leave_open = left[row] + right[row] +  max_table[row+1][to_be_closed][0][0];
						
						max_table[row][to_be_closed][0][0] = Math.max(Math.max(close_left, close_right),leave_open);
						max_table[row][to_be_closed][0][1] = Math.max(close_left,leave_open);
						max_table[row][to_be_closed][1][0] = Math.max(close_right,leave_open);
					}
				}
				
				// print DP table
				/*System.out.println(no_rows);
				for(int i = 0; i < no_rows; i++) {
					for(int j = 0; j < no_rooms; j++) {
						System.out.print(max_table[i][j][0][0] + "\t");
					}
					System.out.print("\n");
				}*/
				
				System.out.println(max_table[0][no_rooms-1][0][0]);
				
				no_rows = io.getInt();
				no_rooms = io.getInt();
			} while (no_rows > 0);
		}
		
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

