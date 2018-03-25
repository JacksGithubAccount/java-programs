
public class Employee implements Comparable<Employee>
{
	private String name;
	private int id;
	
	public Employee(String name, int id)
	{
		this.name = name;
		this.setId(id);
	}
	public int compareTo(Employee other)
	{
		if(getId() != other.getId())
		{
			return getId() - other.getId();
		}
		return name.compareTo(other.name);
	}
	public String toString()
	{
		return name + " " + getId();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
