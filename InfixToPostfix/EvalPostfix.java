package infixToPostfix;

/**
 * Postfix evaluation Class
 * @author Patrick Stearns
 *
 */
public class EvalPostfix {
	
	private char temp;
	private int result;
	ObjectStack stack = new ObjectStack();
	
	/**
	 * Evaluates a value to determine which operator to use
	 * @param val1 - First value
	 * @param val2 - Second value
	 * @param val3 - Type of operator (if any)
	 * @return int - Result of operation on val1 and val2
	 */
	public int evalOperator(int val1, int val2, char val3)
	{
	    switch (val3)
	    {
	        case '+':
	            return val2 + val1;
	        case '-':
	            return val2 - val1;
	        case '*':
	            return val2 * val1;
	        case '/':
	            return val2 / val1;
	        case '^':
	        	return val2 ^ val1;
	        default:
	            return -1;
	    }
	}
	
	/**
	 * Evaluation of a postfix expression
	 * @param postfix - postfix value
	 * @return int - postfix evaluation
	 */
	public int evaluatePostfix(String postfix)
	{
		for (int i = 0; i < postfix.length(); i++)
	    {
	        temp = postfix.charAt(i);
			
			if ((temp == '^') || (temp == '*') || (temp == '/') || (temp == '+') || (temp == '-'))
	        {
	            result = evalOperator((int)stack.pop(), (int)stack.pop(), temp);
	            stack.push(result);
	        }
	        else if ((temp >= '0') || (temp <= '9'))
	        {
	            stack.push((int)(temp - '0'));
	        }
	    }
		return (int)stack.pop();
	}
}
