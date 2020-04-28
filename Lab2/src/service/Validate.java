package service;

import model.Login;

public class Validate {
	Login log1= new Login("rahul@123","rahul@123");
	Login log2= new Login("rtvik@123","rtvik@123");
	Login log3= new Login("raman@123","raman@123");
	Login log4= new Login("rohan@123","rohan@123");
	Login[] logins= {log1,log2,log3,log4};
	public String validateLogin(String username,String password) {
		
		for(Login log:logins) {
			if(log.getUserName().equals(username) && log.getPassword().equals(password)) {
				return "Success";
			}
		}
		return "Failure";
	}
}
