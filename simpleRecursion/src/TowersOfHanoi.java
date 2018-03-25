import java.util.Scanner;
public class TowersOfHanoi {

	/**
	 * @param args
	 */
	private static void solve(int n, char source, char destination, char temp)
	{
		if(n == 1)
		{
			System.out.println("move disk from " + source + " to " + destination);
		}
		else
		{
			solve(n-1,source, temp, destination);
			System.out.println("move disk from " + source + " to " + destination);
			solve(n-1,temp, destination, source);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char source = 'A', destination = 'B' ,temp = 'C';
		int n = 3;
		Scanner keyscan = new Scanner(System.in);
		System.out.println("How many disks?");
		n = keyscan.nextInt();
		System.out.println("How many disks: " + n);
		solve(n, source, destination, temp);
		keyscan.close();
	}

}
