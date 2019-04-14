import java.util.Scanner;



public class TuringDecider {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter the input: ");
		String usrStr = userInput.next();
		
		TuringMachine machine1 = new TuringMachine(7); // A two state machine

		State s0 = new State(0);
		State s1 = new State(1); 
		State s2 = new State(2); 
		State s3 = new State(3); 
		State s4 = new State(4); 
		State s5 = new State(5);

		s0.addTransition(new Transition('0', 'X', Transition.RIGHT, 1));
		s0.addTransition(new Transition('1', '0', Transition.RIGHT, 5));		
		
		s1.addTransition(new Transition('0', '0', Transition.RIGHT, 1));
		s1.addTransition(new Transition('1', 'Y', Transition.LEFT, 2));
		s1.addTransition(new Transition('Y', 'Y', Transition.RIGHT, 1));
		s1.addTransition(new Transition('B', 'B', Transition.LEFT, 5));
		
		s2.addTransition(new Transition('0', '0', Transition.LEFT, 2));
		s2.addTransition(new Transition('X', 'X', Transition.RIGHT, 3));
		s2.addTransition(new Transition('Y', 'Y', Transition.LEFT, 2));
		s2.addTransition(new Transition('B', 'B', Transition.LEFT, 2));
		
		s3.addTransition(new Transition('0', 'X', Transition.RIGHT, 1));
		s3.addTransition(new Transition('Y', 'Y', Transition.RIGHT, 3));
		s3.addTransition(new Transition('B', 'B', Transition.LEFT, 4));
		s3.addTransition(new Transition('1', 'Y', Transition.RIGHT, 5));
		
		s4.addTransition(new Transition('Y', 'B', Transition.LEFT, 4));
		s4.addTransition(new Transition('X', 'B', Transition.LEFT, 4));
		s4.addTransition(new Transition('S', '1', Transition.RIGHT, 6));
		s4.addTransition(new Transition('0', 'B', Transition.LEFT, 5));
		
		s5.addTransition(new Transition('0', 'B', Transition.LEFT, 5));
		s5.addTransition(new Transition('1', 'B', Transition.RIGHT, 5));
		s5.addTransition(new Transition('B', 'B', Transition.LEFT, 5));
		s5.addTransition(new Transition('S', '0', Transition.RIGHT, 6));
		s5.addTransition(new Transition('Y', 'B', Transition.LEFT, 5));
		s5.addTransition(new Transition('X', 'B', Transition.LEFT, 5));

		machine1.addState(s0); // Add the state to the machine
		machine1.addState(s1); // Add the state to the machine
		machine1.addState(s2); // Add the state to the machine
		machine1.addState(s3); // Add the state to the machine
		machine1.addState(s4); // Add the state to the machine
		machine1.addState(s5); // Add the state to the machine

		String inTape = usrStr; //"01"; // Define some input
		//String inTape = "01"; // Define some input

		//System.out.println(inTape);

		String outTape = machine1.execute(inTape); // Execute the machine

		System.out.println(outTape); // Show the machine’s output

	}
	
}
