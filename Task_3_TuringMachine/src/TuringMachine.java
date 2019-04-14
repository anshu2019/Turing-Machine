import java.util.ArrayList;

public class TuringMachine {

	int noOfState = 0;
	State[] states;
	char[] tape;
	char[] decide_tape;
	int HEAD_POSITION = 0;
	int currentState = 0;
	int stateIncrement = 0;
	int haltStateId = 0;

	char[] input;

	public TuringMachine(int statecount) {
		this.noOfState = statecount;
		haltStateId = statecount - 1;
		states = new State[statecount];
		tape = new char[100];
		decide_tape = new char[101];
		// add halt state
		State halt_state = new State(haltStateId); // Only s0 has transitions

		halt_state.addTransition(new Transition('B', 'B', Transition.RIGHT, haltStateId));
		states[haltStateId] = halt_state;
	}

	public void addState(State s) {
		states[stateIncrement] = s;
		stateIncrement++;
	}

	public String execute(String in) {
		this.input = in.toCharArray();
		this.initiateInputTape();
		turingDecider();
		String op = "";
		int inputcntr = 0;

		

		op = getTapeString();
		return op;
	}

	public char writeTape(char symbol) {
		char write = '0';
		ArrayList<Transition> allowedTransition = states[currentState].allowedTransition;

		for (Transition T : allowedTransition) {
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
		StringBuilder ts = new StringBuilder();
		for (char c : decide_tape) {
			if(c !='S') {
				ts.append(c);
			}

		}
		return ts.toString();
	}

	private void initiateInputTape() {

		// entire tape is blank initially.......
		for (int t = 0; t < 101; t++) {
			decide_tape[t] = 'B';
		}
		// append input after first element
		for (int t = 1; t <= this.input.length; t++) {
			decide_tape[t] = this.input[t - 1];
		}
		decide_tape[0] = 'S';  //start of tape 
		
		
		// System.out.println(new String(decide_tape));
	}

	private void turingDecider() {
		HEAD_POSITION = 1;
		while (currentState < haltStateId) {
			ArrayList<Transition> allowedTransition = states[currentState].allowedTransition;
			for (Transition T : allowedTransition) {
				if (T.read == decide_tape[HEAD_POSITION]) {

					decide_tape[HEAD_POSITION] = T.write;
					if (T.move.equals(Transition.RIGHT)) {
						HEAD_POSITION += 1;
					} else if (T.move.equals(Transition.LEFT)) {
						HEAD_POSITION -= 1;
					}

					currentState = T.nxtState;
                    break;
				}

			}
		}
		//System.out.println(new String(decide_tape));
	}

}
