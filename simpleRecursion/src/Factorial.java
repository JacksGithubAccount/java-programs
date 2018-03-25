
public class Factorial {

	/**
	 * @param args
	 */
	private static int factorial(int n)
	{
		if( n == 1 || n == 0)
		{
			return 1;
		}
		else
		{
			return n*factorial(n-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 20 ; i++)
		System.out.println(factorial(i));
	}

}
