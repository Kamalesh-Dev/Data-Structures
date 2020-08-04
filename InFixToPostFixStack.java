//$Id$
package kam.interviewprep;

import java.util.HashMap;

public class InFixToPostFixStack {

	static java.util.Stack <Character> operatorStack;
	public static boolean isLeftAssoc(Character operator)
	{
		return ('^'==operator)?false:true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> pri=new HashMap<>();
		pri.put('(', 0);
		pri.put('+',1);
		pri.put('-', 1);
		pri.put('*', 2);
		pri.put('/', 2);
		pri.put('^', 3);
		String inF="a+b*c-d^e^f";
		operatorStack=new java.util.Stack<Character>();
		for(int i=0;i<inF.length();i++)
		{
			if(Character.isLetterOrDigit(inF.charAt(i)))
			{
				System.out.print(inF.charAt(i));
			}
			else if(inF.charAt(i)=='(')
			{
				operatorStack.push(inF.charAt(i));
			}
			else if(inF.charAt(i)==')')
			{
				while(operatorStack.peek()!='(')
				{
					System.out.println(operatorStack.pop());
				}
				operatorStack.pop();
			}
			else
			{
				boolean leftAssoc=isLeftAssoc(inF.charAt(i));
				int currentOperatorPri=pri.get(inF.charAt(i));
				if(leftAssoc)
				{
					
					while( !operatorStack.isEmpty() &&pri.get(operatorStack.peek()) >= currentOperatorPri)
					{
						System.out.print(operatorStack.pop());
					}
					
				}
				else
				{
					while( !operatorStack.isEmpty() && pri.get(operatorStack.peek()) > currentOperatorPri)
					{
						System.out.print(operatorStack.pop());
					}
				}
				operatorStack.push(inF.charAt(i));
					
			}
				
		}
		while(!operatorStack.isEmpty())
		{
			System.out.print(operatorStack.pop());
		}
	}

}
