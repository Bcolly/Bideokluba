package bideoklub;

public class Bazkidea extends Libre {
	
	/*private String kodea;
	private String izena;
	private String abizena;
	private String passw;
	private String helbidea;*/

	public Bazkidea(){
		/*kodea = pKodea;
		izena = pIzena;
		abizena = pAbizena;
		passw = pPass;
		helbidea = pHelbidea;*/
	}
	
	public String pelikulaAlokatu(String pPeliKodea, String pBazKodea){
		return Bideokluba.getDB().pelikulaAlokatu(pPeliKodea, pBazKodea);
	}
	
	public String pelikulaItzuli(String pPeliKodea, String pBazKodea){
		return Bideokluba.getDB().pelikulaItzuli(pPeliKodea, pBazKodea);
	}
	
	public String kredituaGehitu(String pKodea, String pDirua) {
		return Bideokluba.getDB().kredituaSartu(pKodea, pDirua);
	}

	public String datuakAldatu(String pKodea, String pIzena, String pAbizenak, String pPass, String pHelbidea) {
		return Bideokluba.getDB().datuakAldatu(pKodea, pIzena, pAbizenak, pPass, pHelbidea);
	}
	
	
	
	
}
