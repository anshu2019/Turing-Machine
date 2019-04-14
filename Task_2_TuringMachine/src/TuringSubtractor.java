
public class TuringSubtractor {

	public static void main(String args[]) {
		TuringMachine machine1 = new TuringMachine(7); // A two state machine

		State s0 = new State(0);
		State s1 = new State(1); // Only s0 has transitions
		State s2 = new State(2); // Only s0 has transitions
		State s3 = new State(3); // Only s0 has transitions
		State s4 = new State(4); // Only s0 has transitions
		State s5 = new State(5); // Only s0 has transitions

		s0.addTransition(new Transition('0', 'B', Transition.RIGHT, 1));
		s0.addTransition(new Transition('1', 'B', Transition.RIGHT, 5));		
		
		s1.addTransition(new Transition('0', '0', Transition.RIGHT, 1));
		s1.addTransition(new Transition('1', '1', Transition.RIGHT, 2));
		
		s2.addTransition(new Transition('1', '1', Transition.RIGHT, 2));
		s2.addTransition(new Transition('0', '1', Transition.LEFT, 3));
		s2.addTransition(new Transition('B', 'B', Transition.LEFT, 4));
		
		s3.addTransition(new Transition('0', '0', Transition.LEFT, 3));
		s3.addTransition(new Transition('1', '1', Transition.LEFT, 3));
		s3.addTransition(new Transition('B', 'B', Transition.RIGHT, 0));
		
		s4.addTransition(new Transition('1', 'B', Transition.LEFT, 4));
		s4.addTransition(new Transition('0', '0', Transition.LEFT, 4));
		s4.addTransition(new Transition('B', '0', Transition.RIGHT, 6));
		
		s5.addTransition(new Transition('0', 'B', Transition.RIGHT, 5));
		s5.addTransition(new Transition('1', 'B', Transition.RIGHT, 5));
		s5.addTransition(new Transition('B', 'B', Transition.RIGHT, 6));

		machine1.addState(s0); // Add the state to the machine
		machine1.addState(s1); // Add the state to the machine
		machine1.addState(s2); // Add the state to the machine
		machine1.addState(s3); // Add the state to the machine
		machine1.addState(s4); // Add the state to the machine
		machine1.addState(s5); // Add the state to the machine

		String inTape = "000001000"; // Define some input

		System.out.println(inTape);

		String outTape = machine1.execute(inTape); // Execute the machine

		System.out.println(outTape); // Show the machine’s output
	}
	
}
