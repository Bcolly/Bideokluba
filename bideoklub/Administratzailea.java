package bideoklub;

import java.util.Random;

public class Administratzailea extends Libre {

	public Administratzailea(){}
	
	public void bazkideaSortu(String pIzena, String pAbizena, String pPass, String pHelbidea){
		int zenb = new Random().nextInt(1000);
		String pKodea = pIzena.substring(0,3)+pAbizena.substring(0,3)+String.valueOf(zenb);
		Bideokluba.getDB().bazkideaSortu(pIzena, pAbizena, pKodea, pPass, pHelbidea);
	}
	
	public void bazkideEgoera(String pKodea){
		Bideokluba.getDB().bazkideaAldatu(pKodea);
	}
	
	public void pelikulaSortu(String pTitulo, String pPrezio){
		int zenb = new Random().nextInt(10000);
		String pKodea = pTitulo.substring(0,3)+String.valueOf(zenb);
		Bideokluba.getDB().pelikulaSortu(pKodea, pTitulo, pPrezio);
	}
	
	public void pelikulaBajaEman(String pKodea){
		Bideokluba.getDB().pelikulaBajaEman(pKodea);
	}
}
