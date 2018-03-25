
public class Fibonacci {

	/**
	 * @param args
	 */
	private static int fibonacci(int n)
	{
		if(n == 1 || n == 0)
		{
			return 1;
		}
		else 
		{
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 20; i++)
		{
			System.out.println(fibonacci(i));
		}
	}

}
