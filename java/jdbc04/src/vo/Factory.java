package vo;

public class Factory {
	private String factno;
	private String facname;
	private String facloc;

	public String getFactno() {
		return factno;
	}

	public void setFactno(String factno) {
		this.factno = factno;
	}

	public String getFacname() {
		return facname;
	}

	public void setFacname(String facname) {
		this.facname = facname;
	}

	public String getFacloc() {
		return facloc;
	}

	public void setFacloc(String facloc) {
		this.facloc = facloc;
	}

	public Factory() {
	}

	@Override
	public String toString() {
		return "Factory [factno=" + factno + ", facname=" + facname + ", facloc=" + facloc + "]";
	}

	public Factory(String factno, String facname, String facloc) {
		super();
		this.factno = factno;
		this.facname = facname;
		this.facloc = facloc;
	}

}
