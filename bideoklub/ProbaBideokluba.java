package bideoklub;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

public class ProbaBideokluba {

	 public static void main(String[] args) {
		 Bideokluba bk = Bideokluba.getDB();
		 //bk.konektatu();
		 bk.datuakAldatu("jonu12", "Jon", "Holi", "12345", "Calle dos");
	    	 //probak
	   //bk.kredituaSartu("jonu12", "2.50");
	    // bk.bazkideaAldatu("1112B");
         //bk.bazkideaSortu("Pedro", "Diaz", "PEDI2016", "12345678", "Iturriaga 2 A");
        // bk.pelikulaBajaEman("ta1990");
        // bk.pelikulaSortu("ta1990", "tarzan", "10.50");   
        // bk.pelikulaBilatu("tarzan");
         //bk.pelikulaAlokatu("CAP122", "jonu12");
        // bk.pelikulaItzuli("CAP122", "jonu12");
         //bk.katalogoaIkusi();
         //bk.estreinaldiakIkusi();
         
        // bk.konexioaItxi();
	     }
	 }
