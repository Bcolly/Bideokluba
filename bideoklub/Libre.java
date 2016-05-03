package bideoklub;

import java.util.ArrayList;

public class Libre {
	
	public Libre(){}
	
	public ArrayList<String> katalogoaIkusi(){
		return Bideokluba.getDB().katalogoaIkusi();
	}

	public ArrayList<String> estreinaldiakIkusi() {
		return Bideokluba.getDB().estreinaldiakIkusi();
	}
}
