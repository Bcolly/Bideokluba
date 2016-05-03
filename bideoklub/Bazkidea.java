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
	
	public void pelikulaAlokatu(String pPeliKodea, String pBazKodea){
		Bideokluba.getDB().pelikulaAlokatu(pPeliKodea, pBazKodea);
	}
	
	public String pelikulaItzuli(String pPeliKodea, String pBazKodea){
		return Bideokluba.getDB().pelikulaItzuli(pPeliKodea, pBazKodea);
	}
	
	public void kredituaGehitu(String pKodea, String pDirua) {
		Bideokluba.getDB().kredituaSartu(pKodea, pDirua);
	}

	public void datuakAldatu(String text, String text2, String text3, String text4) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
