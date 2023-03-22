package com.store.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.store.db.DBconnection;
import com.store.exception.LoginInvalidException;
import com.store.to.UserTO;

public class UserRepo {
	Connection connection = DBconnection.getConnection();

	public void register(UserTO user) {

		try {

			PreparedStatement statement = connection.prepareStatement("insert into user values(?, ?, ?, ?, ?)");

			statement.setInt(1, user.getId());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getFirstName());
			statement.setString(5, user.getLastName());

			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("inside regsiter of UserRepo");
			e.printStackTrace();
		}

	}

	public int login(String username, String password) {

		try {

			PreparedStatement statement = connection.prepareStatement("select * from user where username = ? && password = ?");

			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet resultset = statement.executeQuery();

			if (resultset.next() == true) {
				
				return 1;
			}
			else {
				throw new LoginInvalidException("- - - Wrong Credentials - - -");
			}

		} catch (Exception e) {

			System.out.println("inside catch of Login of UserRepo");
			e.printStackTrace();
		}

		return 0;
	}

}
