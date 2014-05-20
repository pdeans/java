package infixToPostfix;

/**
 * Infix to Postfix Conversion Class
 * @author Patrick Stearns
 *
 */
public class InfixToPostfix {
	
	private String postfix;
	private char temp;
	ObjectStack stack = new ObjectStack();
	
	/**
	 * Compares operator priority for infix to postfix conversion 
	 * @param char - operator to be evaluated
	 * @return int - priority of operator
	 */
	public int priority(char op)
	{
		switch (op) {
			case '^': 
				return 3;
			case '*':
			case '/': 
				return 2;
			case '+':
			case '-': 
				return 1;
			default : 
				return 0;
		}
	}	    
	
	/**
	 * Infix to postfix conversion
	 * @param String - infix value
	 * @return String - postfix value
	 */
	public String toPostfix(String infix) 
	{
		postfix = "";
		
		for(int i=0; i < infix.length(); i++) 
		{
			temp = infix.charAt(i);
			
			if ((temp >= '0') && (temp <= '9'))
	        {
	            postfix += temp;
	        }
			else if (temp == '(')
	        {
	            stack.push(temp);
	        }
			else if ((temp == '^') || (temp == '*') || (temp == '/') || (temp == '+') || (temp == '-'))
	        {
	            while ((!stack.isEmpty()) && ((Character)stack.top() != '('))
	            {
	                if (priority((Character)stack.top()) >= priority(temp))
	                {
	                    postfix += stack.pop();
	                }
	                else
	                {
	                    break;
	                }
	            }
	            stack.push(temp);
	        }
			else if (temp == ')')
	        {
	            while ((!stack.isEmpty()) && ((Character)stack.top() != '('))
	            {
	                postfix += stack.pop();
	            }
	            if (!stack.isEmpty())
	                stack.pop();
	        }
		}
		while (!stack.isEmpty())
	    {
	        postfix += stack.pop();
	    }
		
		return postfix;
	}
}
