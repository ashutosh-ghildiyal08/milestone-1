package com.store.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.store.db.DBconnection;
import com.store.exception.LoginInvalidException;
import com.store.to.AdminTO;

public class AdminRepo {
	Connection connection = DBconnection.getConnection();

	public void register(AdminTO admin) {

		try {

			PreparedStatement statement = connection.prepareStatement("insert into admin values(?, ?, ?, ?, ?)");

			statement.setInt(1, admin.getId());
			statement.setString(2, admin.getUsername());
			statement.setString(3, admin.getPassword());
			statement.setString(4, admin.getFirstName());
			statement.setString(5, admin.getLastName());

			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("inside regsiter of AdminRepo");
			e.printStackTrace();
		}

	}

	public int login(String username, String password) {

		try {

			PreparedStatement statement = connection.prepareStatement("select * from admin where username = ? && password = ?");

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

			System.out.println("inside catch of Login of adminRepo");
			e.printStackTrace();
		}

		return 0;
	}

}
