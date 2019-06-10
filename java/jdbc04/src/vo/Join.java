package vo;

public class Join {
	Factory f;
	Products p;

	public Join() {
	}

	public Join(Factory f, Products p) {
		super();
		this.f = f;
		this.p = p;
	}

	@Override
	public String toString() {
		return "Join [f=" + f + ", p=" + p + "]";
	}
}
