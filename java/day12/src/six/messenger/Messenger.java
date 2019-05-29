package six.messenger;

import six.user.User;

public abstract class Messenger {

	public abstract void register(User u);

	public abstract void login(User u);

	public abstract void logout(User u);

	public abstract void sendMessenger(User u1, User u2, String Messenge);

	public abstract void sendPhoto(User u1, User u2, String Photo);

	public abstract void call(User u1, User u2);

}