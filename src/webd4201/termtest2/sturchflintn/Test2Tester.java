package webd4201.termtest2.sturchflintn;

import java.sql.Connection;

public class Test2Tester {
	public static void main(String[] args) {
		Connection c = null;
		try {
			c = ClientConnect.initialize();
			Client.initialize(c);
			Client aClient;
			String clientFirstName = "Les";

			System.out.println("Attempt to find a client in the system: " + clientFirstName);
			try {
				aClient = Client.retrieve(clientFirstName);
				System.out.println(aClient.toString());
			} catch (ClientNotFoundException nfe) {
				System.out.println(nfe);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
