import java.util.ArrayList;

public class State {

	int id;
	
	ArrayList<Transition> allowedTransition;
	int transitionSize=0;
	
	public State(int a) {
		this.id = a;
		allowedTransition = new ArrayList<Transition>();
		
	}
	
	public void addTransition(Transition t) {
		allowedTransition.add(t);
		transitionSize++;
	}
}
