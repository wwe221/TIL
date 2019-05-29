package six.messenger;

import six.inter.Shopping;
import six.user.User;

public class Kakaotalk extends Messenger implements Shopping {

	@Override
	public void register(User u) {
		System.out.println("User [" + u.getId() + "] registerd in KaKaoTalk");

	}

	@Override
	public void login(User u) {
		System.out.println("User [" + u.getId() + "] login to KaKaoTalk");

	}

	@Override
	public void logout(User u) {
		System.out.println("User" + u.getId() + "logout from KakaoTalk");
	}

	@Override
	public void sendMessenger(User u, User u2, String Messenge) {
		System.out.println("User [" + u.getId() + "] send Messenge to [" + u2.getId() + "] " + Messenge + " ");

	}

	@Override
	public void sendPhoto(User u, User u2, String Photo) {
		System.out.println("User [" + u.getId() + "] sends Photo (+" + Photo + ") to [" + u2.getId() + "]");

	}

	@Override
	public void call(User u, User u2) {
		System.out.println("User [" + u.getId() + "] Call to [" + u2.getId() + "]");

	}

	@Override
	public void sendgifticon(User u, User u2, String gift) {
		System.out.println("User [" + u.getId() + "] sends giftcon (+" + gift + ") to [" + u2.getId() + "]");

	}

}
