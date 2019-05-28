package ws;

public abstract class Db<T, U, S> {

	public abstract void insert(T obj);

	public abstract T select(U obj);

	public abstract S select();

	public abstract void delete(U obj);

	public abstract void Update(T obj);

}
