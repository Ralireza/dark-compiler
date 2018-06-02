package ir.mrbug.darkcompiler.parser;

public class Rule {

	/** Number of the rule */
	private int ruleNumber;

	/** Left side of production */
	private NonTerminal leftSide;

	/** Right side of production */
	private Symbol[] rightSide;

	/**
	 * Creates a rule
	 * 
	 * @param ruleNumber
	 *            number of rule as it is in grammar description
	 * @param leftSide
	 *            nonterminal symbol in the left side of rule
	 * @param rightSide
	 *            terminals and nonterminals in the right side
	 */
	public Rule(int ruleNumber, NonTerminal leftSide, Symbol[] rightSide) {
		this.ruleNumber = ruleNumber;
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}

	public int getRuleNumber() {
		return ruleNumber;
	}

	public NonTerminal getLeftSide() {
		return leftSide;
	}

	public Symbol[] getRightSide() {
		return rightSide;
	}

	@Override
	public String toString() {
		String t = "";
		for (Symbol s : rightSide) {
			if (s.toString().equals("EPSILON"))
				t+="ϵ";
			else
				t+=" "+s.toString();
		}
		return "\t"+ leftSide + " -> " + t;
	}

}