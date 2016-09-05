package src.sessionbeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends GenericDao<User, Integer> {
	public UserDao(String contextPath, String schemaName) {
		super(contextPath, schemaName);
		// TODO Auto-generated constructor stub
	}

	public List<User> getAllUsers() {
		List<User> userList = null;

		userList = new ArrayList<User>();

		return userList;
	}
	
	public boolean checkAccount(String username,String password)
	{
		boolean valid = em.checkAccount(username, password);
		return valid;
	}

	private void saveUserList(List<User> userList) {
		try {
			File file = new File("Users.dat");
			FileOutputStream fos;

			fos = new FileOutputStream(file);

			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public User getKorisnik(String id) {
		User r = new User();
		return r;
	}

}