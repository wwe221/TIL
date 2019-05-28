package db;

public class ProductBiz extends Biz {
	Dao dao;

	public ProductBiz() {

	}

	public ProductBiz(String ip) {
		dao = new ProductDao(ip);
	}

	@Override
	public void register(Object obj) {
		dao.insert(obj);

	}

	@Override
	public void remove(Object obj) {
		dao.delete(obj);

	}

	@Override
	public Object get(Object obj) {
		Product p = (Product) dao.select(obj);
		return p;
	}

}
