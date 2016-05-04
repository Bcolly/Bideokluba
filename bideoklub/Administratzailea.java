package bideoklub;

import java.util.Random;

public class Administratzailea extends Libre {

	public Administratzailea(){}
	
	public String bazkideaSortu(String pIzena, String pAbizena, String pPass, String pHelbidea){
		int zenb = new Random().nextInt(1000);
		String pKodea = pIzena.substring(0,3)+pAbizena.substring(0,3)+String.valueOf(zenb);
		return Bideokluba.getDB().bazkideaSortu(pIzena, pAbizena, pKodea, pPass, pHelbidea);
	}
	
	public String bazkideEgoera(String pKodea){
		return Bideokluba.getDB().bazkideaAldatu(pKodea);
	}
	
	public String pelikulaSortu(String pTitulo, String pPrezio){
		int zenb = new Random().nextInt(10000);
		String pKodea = pTitulo.substring(0,3)+String.valueOf(zenb);
		return Bideokluba.getDB().pelikulaSortu(pKodea, pTitulo, pPrezio);
	}
	
	public String pelikulaBajaEman(String pKodea){
		return Bideokluba.getDB().pelikulaBajaEman(pKodea);
	}
}
