package lambda3;

public class Main 
{
	public static void main(String[] args) 
	{
		// args[0] : in/vehicles.json 
		// args[1] : in/connections.json
		
		BDApplication.run(args[0], args[1]);
	}
}
