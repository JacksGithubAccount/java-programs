import java.util.Random;

public class HashMapLinear
{
	final static int SIZE = 97;
	final static int ADDITIONS = 20;
	final static int DELETIONS = 30;
	final static int SEARCHES = 30;
	static int collisions = 0;
	enum Occupied {EMPTY, DELETED, FULL};
	static Element[] table;
	static Occupied[] occupied;

	public static void main(String[] args)
	{
		// Variables
		Random random = new Random();
		table = new Element[SIZE];
		occupied = new Occupied[SIZE];
		for (int i = 0; i < SIZE; i++)
			occupied[i] = Occupied.EMPTY;
			
		// Add people
		System.out.println("Inserting people...");
		System.out.println("  id        name       h(id)");
		for (int k = 0; k < ADDITIONS; k++)
		{
			int id = random.nextInt(2 * SIZE);
			int name = random.nextInt(2000) + k;
			System.out.printf("%4d        %4d       %4d\n", id, name, h(id));
			insert(id, name);
		}
		System.out.println();
		
		// Delete people
		System.out.println("Deleting people...");
		System.out.println("  id       found       h(id)");
		for (int k = 0; k < DELETIONS; k++)
		{
			int id = random.nextInt(2 * SIZE);
			boolean found = delete(id);
			System.out.printf("%4d       %5b       %4d\n", id, found, h(id));
		}
		System.out.println();
		
		// Search for people
		System.out.println("Searching for people...");
		System.out.println("  id        name       h(id)");
		for (int k = 0; k < SEARCHES; k++)
		{
			int id = random.nextInt(2 * SIZE); 
			int name = search(id);
			System.out.printf("%4d        %4d       %4d\n", id, name, h(id));
		}
		System.out.println();
		System.out.println("Collisions occurred: " + collisions);
	}
	
	// Hash function
	static int h(int k)
	{
		return k % SIZE;
	}
	
	// Insert a person
	static void insert(int id, int name)
	{
		int loc = h(id);
		int i = 1;
		if(occupied[loc] == Occupied.FULL)
			collisions++;
		while (occupied[loc] == Occupied.FULL)
		{
			loc = (loc + i * i) % SIZE;
			i++;
		}
		Element element = new Element(id, name);
		table[loc] = element;
		occupied[loc] = Occupied.FULL;
	}
	
	// Search for a person
	static int search (int id)
	{
		int loc = h(id);
		int i = 1;
		while ((occupied[loc] == Occupied.FULL && table[loc].getId() != id) || 
				occupied[loc] == Occupied.DELETED)
		{
			loc = (loc + i * i) % SIZE;
			i++;
		}
		if (occupied[loc] == Occupied.FULL && table[loc].getId() == id)
			return table[loc].getName();
		return -1;
	}
	
	// Delete a person
	static boolean delete(int id)
	{
		int loc = h(id);
		int i = 1;
		while ((occupied[loc] == Occupied.FULL && table[loc].getId() != id) || 
				occupied[loc] == Occupied.DELETED)
		{
			loc = (loc + i * i) % SIZE;
			i++;
		}
		if (occupied[loc] == Occupied.FULL && table[loc].getId() == id)
		{
			if (occupied[(loc + i * i) % SIZE] != Occupied.EMPTY)
				occupied[loc] = Occupied.DELETED;
			else
				occupied[loc] = Occupied.EMPTY;
			return true;
		}
		return false;
	}
}

class Element
{
	private int id;
	private int name;
	
	public Element(int id, int name)
	{
		this.id = id;
		this.name = name;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getName()
	{
		return name;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setName(int name)
	{
		this.name = name;
	}
}