import java.util.ArrayList;

public class TuringMachine {

	int noOfState = 0;
	State[] states;
	char[] tape;
	int HEAD_POSITION = 0;
	int currentState = 0;
	int stateIncrement=0;
	int haltStateId =0;

	char[] input;

	public TuringMachine(int statecount) {
		this.noOfState = statecount;
		haltStateId= statecount-1;
		states = new State[statecount];
		tape = new char[100];
		
		//add halt state 
		State halt_state = new State(haltStateId); // Only s0 has transitions

		halt_state.addTransition(new Transition('B', 'B', Transition.RIGHT, haltStateId));
		states[haltStateId] = halt_state;
	}
	
	public void addState(State s) {
		states[stateIncrement] =s;
		stateIncrement++;
	}

	public String execute(String in) {
		this.input = in.toCharArray();
		String op = "";
		int inputcntr=0;
		
		for (char c : input) {
			tape[HEAD_POSITION] = writeTape(c);
			inputcntr++;
		}
		
		//once input is done , get in halt state		
		currentState = haltStateId;
		
		//handle blank input..
		while(HEAD_POSITION < 100 ) {
			tape[HEAD_POSITION] =writeTape('B');
			//HEAD_POSITION += 1;
		}
		
        op = getTapeString();
		return op;
	}

	public char writeTape(char symbol) {
		char write='0' ;
		ArrayList<Transition> allowedTransition = states[currentState].allowedTransition;

		for (Transition T:allowedTransition ) {
			if (T.read == symbol) {
				write = T.write;				
				if (T.move.equals(Transition.RIGHT)) {
					HEAD_POSITION += 1;
				} else if (T.move.equals(Transition.LEFT)) {
					HEAD_POSITION -= 1;
				}

				currentState = T.nxtState;
				return write;
			}

		}

		return write;
	}
	
	public String getTapeString() {
		String ts;
		ts = new String(tape);
		
		return ts;
	}
}
