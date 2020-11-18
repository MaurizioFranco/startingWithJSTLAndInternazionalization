package cerepro.web.servlets.maven.originSites;

public class Methods {
	Object x = new Object();

	public Methods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String ObjectInsert(Object x) {
		if (x != null) {
			boolean insertResult = Boolean.valueOf(x + "");
			if (insertResult) {
				String strok = "Inserimento andato a buon fine";
				return strok;
			} else {
				String strko = "Inserimento NON andato a buon fine";
				return strko;
			}
		}
		String err = "";
		return err;
	}

	public Object getX() {
		return x;
	}

	public void setX(Object x) {
		this.x = x;
	}

}
