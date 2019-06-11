package vo;

import java.util.ArrayList;

public class Join {
	private ArrayList<Factory> f;
	private ArrayList<Products> p;
	private Factory ff;
	private Products pp;
	public Join() {
	}

	public Join(Factory ff, Products pp) {
		super();
		this.ff = ff;
		this.pp = pp;
	}

	public Join(ArrayList<Factory> f, ArrayList<Products> p) {
		super();
		this.f = f;
		this.p = p;
	}

	public ArrayList<Factory> getF() {
		return f;
	}

	@Override
	public String toString() {
		return "Join [f=" + f + ", p=" + p + "]";
	}
	public String print() {
		String str = "";
		int a = this.p.size();
		int b = this.f.size();
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				if(this.p.get(i).getFactno().equals(this.f.get(j).getFactno())) {					
					str +=this.p.get(i) + " "+ this.f.get(j) + "\n";
				}
			}
		}
		return str;
	}
	public String numb1() {
		String str = "";
		int a = this.p.size();
		int b = this.f.size();
		ArrayList<Join> jj = new ArrayList<Join>(); 
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				if(this.p.get(i).getFactno().equals(this.f.get(j).getFactno())) {
					jj.add(new Join(this.f.get(j),this.p.get(i)));					
				}					
			}
		}
		for(int i=0;i<a;i++) {
			if(jj.get(i).ff.getFacloc().equals("SEOUL"))
				str += jj.get(i).pp + "\n";
			
		}
		return str;
			
		
	}
	public void setF(ArrayList<Factory> f) {
		this.f = f;
	}

	public ArrayList<Products> getP() {
		return p;
	}

	public void setP(ArrayList<Products> p) {
		this.p = p;
	}

}
