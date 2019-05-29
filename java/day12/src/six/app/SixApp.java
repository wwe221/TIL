package six.app;

import six.messenger.Kakaotalk;
import six.messenger.Messenger;
import six.messenger.Telegram;
import six.user.User;

public class SixApp {

	public static void main(String[] args) {
		Messenger k = new Kakaotalk();
		Messenger t = new Telegram();
		User u = new User("you", "pwd");
		User u2 = new User("me", "pwd123");
		k.register(u);
		k.login(u);
		k.sendMessenger(u, u2, "æ»≥Á");
		t.register(u2);
		t.login(u2);
		t.sendMessenger(u2, u, "πŸ¿Ã");

	}

}
