package db2;

public abstract class DB {
	String ip;

	public DB(String ip) {
		this.ip = ip;
	}

	public DB() {
	}

	public void connection() {
		System.out.println(ip+" Connected..");

	}

	public void close() {
		System.out.println(ip+" Closed..");
	}

	public abstract void insert(Object obj);
	public abstract Object select(Object obj);
}
