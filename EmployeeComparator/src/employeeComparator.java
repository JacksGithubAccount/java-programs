import java.util.Comparator;

public class employeeComparator implements Comparator<Employee>
{
	public int compare(Employee employee1, Employee employee2)
	{
		if(employee1.getId() > employee2.getId())
			return 1;
		else if(employee1.getId() == employee2.getId())
			return 0;
		else
			return -1;
	}
}