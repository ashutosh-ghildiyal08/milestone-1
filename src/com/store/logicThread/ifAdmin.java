package com.store.logicThread;

import com.store.page.AdminPage;

public class ifAdmin implements Runnable {
	AdminPage admin = new AdminPage();
	public void run() {
		admin.ifadmin();
	}
} 