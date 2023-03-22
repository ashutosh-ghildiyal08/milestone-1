package com.store.logicThread;

import com.store.page.UserPage;

public class ifUser implements Runnable {
	UserPage user = new UserPage();
	public void run() {
		user.ifUser();
	}
} 
