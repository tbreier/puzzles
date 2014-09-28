import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;


public class FlexibleSpaces {

	public static void main(String[] args) {	

		Kattio io = new Kattio(System.in, System.out);
		
		// read input
		
		int partition_no = 0;
		int width = 0;
		
		while (io.hasMoreTokens()) {
			width = io.getInt();
			partition_no = io.getInt() + 2;
			break;
		}
		
		int partitions[] = new int[partition_no];
		partitions[0] = 0;
		partitions[partition_no - 1] = width;
		
		while (io.hasMoreTokens()) {
			for(int i = 1; i < partition_no-1; i++) {
				partitions[i] = io.getInt();
			}
			break;
		}
		
		// Done reading input
		
		boolean[] possible = new boolean[width+1];
		
		for(int i = 0; i < partition_no; i++) {
			for(int j = i+1; j < partition_no; j++) {
				possible[partitions[j] - partitions[i]] = true;
			}
		}
		
		for(int i = 0; i < width; i++) {
			if(possible[i]) System.out.print(i + " ");
		}
		
		if(possible[width]) System.out.print((width) + " ");
		
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





