package test;

import com.FactoryBiz;
import com.ProductsBiz;

import frame.Biz;
import vo.Factory;
import vo.Join;
import vo.Products;

public class UserInsert {
	public static void main(String[] args) {
		//Products p = new Products(45, "의류", "신발", "10",null , 3000, 5000,20 );
		Factory f = new Factory("30","NIKE","JEJU");
		Biz<Integer, Products> biz = new ProductsBiz();
		Biz<String, Factory> biz2 = new FactoryBiz();
		try {
			//biz2.register(f);
			// biz.remove("id69");
			// biz2.modify(u2);\
			for(Factory j : biz2.get()) {
				System.out.println(j);
			}
			for(Join j : biz.join()) {
				System.out.println(j);
			}
			
			
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
