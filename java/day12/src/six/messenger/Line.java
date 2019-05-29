package six.messenger;

import six.inter.Shopping;
import six.inter.TimeLine;
import six.user.User;

public class Line extends Messenger implements TimeLine, Shopping {
	public void uploading() {
		System.out.println("Uploading...");
	}

	public void comment() {
		System.out.println("set comment");
	}

	public void sendgifticon() {
		System.out.println("send gifticon");
	}

	@Override
	public void register(User u) {
		System.out.println("Completed sign up");
	}

	@Override
	public void login(User u) {
		System.out.println("Hello, User" + u);
	}

	@Override
	public void logout(User u) {
		System.out.println("Bye..");
		System.out.println("Logout from Line");

	}

	@Override
	public void sendMessenger(User u, User u2, String Messenge) {
		System.out.println("User" + u + "send Message to" + u2);

	}

	@Override
	public void sendPhoto(User u, User u2, String Photo) {
		System.out.println("User" + u + "send Photo to" + u2);

	}

	@Override
	public void call(User u, User u2) {
		System.out.println("User" + u + "call to" + u2);

	}

	@Override
	public void sendgifticon(User u, User u2, String gift) {
		System.out.println("User" + u + "sends" + gift + " to" + u2);

	}

}