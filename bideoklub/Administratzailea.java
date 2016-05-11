package bideoklub;

import java.util.Random;

public class Administratzailea extends Libre {

	public Administratzailea(){}
	
	public String bazkideaSortu(String pIzena, String pAbizena, String pPass, String pHelbidea){
		boolean badago = false;
		String pKodea = null;
		while (!badago) {
			int zenb = new Random().nextInt(1000);
			pKodea = pIzena.substring(0,3)+pAbizena.substring(0,3)+String.valueOf(zenb);
			if (!Bideokluba.getDB().badagoKodea(pKodea))
				badago = true;
		}
		return Bideokluba.getDB().bazkideaSortu(pIzena, pAbizena, pKodea, pPass, pHelbidea);
	}
	
	public String bazkideEgoera(String pKodea){
		return Bideokluba.getDB().bazkideaAldatu(pKodea);
	}
	
	public String pelikulaSortu(String pTitulo, String pPrezio){
		boolean badago = false;
		String pKodea = null;
		while (!badago) {
			int zenb = new Random().nextInt(100000);
			pKodea = pTitulo.substring(0,2)+String.valueOf(zenb);
			if (!Bideokluba.getDB().badagoKodeaPeli(pKodea))
				badago = true;
		}
		return Bideokluba.getDB().pelikulaSortu(pKodea, pTitulo, pPrezio);
	}
	
	public String pelikulaBajaEman(String pKodea){
		return Bideokluba.getDB().pelikulaBajaEman(pKodea);
	}
}
