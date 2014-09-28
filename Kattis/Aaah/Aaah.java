public class Aaah {

	public static void main(String[] args) {	

		Kattio io = new Kattio(System.in, System.out);

		while (io.hasMoreTokens()) {
			String jon = io.getWord();
			String doctor = io.getWord();

			System.out.println(jon.length() >= doctor.length() ? "go" : "no");

		}
		
		io.close();

	}

}


