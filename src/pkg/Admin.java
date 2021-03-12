package pkg;

public class Admin extends UserProfile implements Management{

	public Admin(String ln, String fn, String id, String pass, Roles role) {
		super(ln, fn, id, pass, role);
		// TODO Auto-generated constructor stub
	}

	public void passReset() //reset for any user
	{

	}
	public void displayUserList() //show all users
	{

	}
	public void assignRoles() //can assign any roles but admin and owner
	{

	}
	public void searchUserList() //search for any user
	{

	}
	public void createUserProfile()
	{

	}
	public void UpdateUserProfile()	//can update all but admins and owners
	{

	}
	public void DeleteUserProfile() //can delete all but admins and owners
	{

	}
}
