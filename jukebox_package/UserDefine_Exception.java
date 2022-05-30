package jukebox_package;

public class UserDefine_Exception {

}

class notAvalidException extends Exception
{
	public notAvalidException()
	{
		System.out.print("Not a valid Option");
	}
}

class invalidName extends Exception
{ public invalidName()
{
	System.out.print("Take a first letter of Artist");
}
}

class invalidGenreeName extends Exception
{
	public invalidGenreeName()
	{
		System.out.print("Take a first letter of Genree");
	}
}