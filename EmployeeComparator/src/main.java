import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Employee> companySet = new TreeSet<Employee>();
		File file = new File("data.txt");
		try
		{
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext())
			{
				String name = scanner.next();
				int id = scanner.nextInt();
				Employee employee = new Employee(name, id);
				companySet.add(employee);
			}
		}catch(FileNotFoundException e)
		{
			
		}
		System.out.println("\nRunning in enhanced for loop...");
		for(Employee employee: companySet)
		{
			System.out.println(employee);
		}
		System.out.println("\nRunning in iterator over tree set...");
		Iterator<Employee> iter = companySet.iterator();
		while(iter.hasNext())
		{
			Employee employee = iter.next();
			System.out.println(employee);
		}
	}

}
