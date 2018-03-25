
public class Pallendrome {

	/**
	 * @param args
	 */
	private static boolean recursiveCheck(String str, int n)
	{
		if(str.length() == 1 || str.length() == 0)
		{
			return true;
		}
		else if (str.startsWith("") != str.endsWith(""))
		{
			return false;
		}
		else
		{
			//sentence = sentence.Remove(0, 1);
            //sentence = sentence.Remove(sentence.Length-1,1);
            //return recursiveChecking(recursiveChecking(sentence, n+1), n+1);
		}
	}
	private static void palindrome(String str)
	{
		String checkString = str.trim().toLowerCase();
		recusiveCheck(checkString, 0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
