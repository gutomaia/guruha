import org.guruha.exceptions.InvalidDicePoolStringException;
import org.guruha.commons.DicePool;

class DicePoolFromString {
	
	public static void main(String args[]) {
		if(args.length != 1) {
			System.err.println("Invalid number of arguments '" + args.length + "'.");
			System.exit(1);
		}
		try {
			DicePool dicePool = new DicePool(args[0]);
			System.out.println("Number of dices: " + dicePool.getDices());
			System.out.println("Modifiers: " + dicePool.getModifiers());
			System.out.println("String representation: " + dicePool);
			System.exit(0);
		} catch (InvalidDicePoolStringException exception) {
			System.err.println(exception.getMessage());
			System.exit(1);
		}
	}

}
