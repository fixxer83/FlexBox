package initialisation;
import customers.UserClass;
import fileIO.FileOperations;
import graphicalUserInterface.LoginScreen;

public class Initialisation {

	public static void main(String[] args) {
		initialise();
	}
	
	public static void initialise(){
		FileOperations fio = new FileOperations();
		UserClass uc = new UserClass();
		//fio.writeObjListUserToFile(uc.validateDefaultUsers(), uc.DIRECTORY_PATH, uc.USER_PATH);
		LoginScreen ls = new LoginScreen();
	}

}
