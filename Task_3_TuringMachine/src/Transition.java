
public class Transition {

	char read;
	char write;
	int nxtState;
	String move;

	public static String RIGHT = "RIGHT";
	public static String LEFT = "LEFT";

	public Transition(char r, char w, String m, int ns) {
		this.read = r;
		this.write = w;
		this.move = m;
		this.nxtState = ns;

	}
}
