package bideoklub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import interfazeGrafikoa.BazkideaIn;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Bideokluba {
	private static Bideokluba nBideoklub;
	
    private Connection con = null;
    private Statement sta = null;
    private ResultSet res = null;

    final private String user = "root";
    final private String pass = "";
    private String host = "localhost";
    private String nombre_BD = "bideoklub";

    private Bideokluba(){}
    
    public static Bideokluba getDB(){
    	if (nBideoklub == null){
    		nBideoklub = new Bideokluba();
    	}
    	return nBideoklub;
    }
    
    private Connection getConexionMYSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance( );
            String servidor = "jdbc:mysql://"+host+"/"+nombre_BD;
            con = DriverManager.getConnection(servidor,user,pass);
            return con;
        }catch(Exception e){
            e.printStackTrace();
            return con;
        }
    }
    
    public void konektatu() {
    	con = getConexionMYSQL();
    	 if(con == null) System.out.println("Error con la conexion a la BD!!");
    }
    
    public void konexioaItxi() {
    	 try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al cerrar la conexion!!");
		}
    }
    
    public static void main(String[] args) {}
    
    public String bazkideaSortu(String pIzena, String pAbizena, String pKodea, String pPass, String pHelbidea) {
    	//el kode automatico???
    	try {
    		sta = con.createStatement();
    		sta.executeUpdate("INSERT INTO BAZKIDE (kodea, passWord, izena, abizenak, helbidea) VALUES ('"+pKodea+"','"+pPass+"','"+pIzena+"','"+pAbizena+"','"+pHelbidea+"')");
    		return "Bazkidea ondo sortu duzu";
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    		return "Bazkidea ezin izan da sortu";
    	}
    }

    public String pelikulaSortu(String pKodea, String pTitulo, String pPrezio) {
    	//el kode automatico???
    	try {
    		sta = con.createStatement();
    		sta.executeUpdate("INSERT INTO PELIKULA (kodea, titulua, prezioa) VALUES ('"+pKodea+"','"+pTitulo+"','"+pPrezio+"')");
    		return "Pelikula ondo sortu duzu";
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
        }
    	return "Pelikula ezin izan da sortu";
    }

    public String pelikulaBajaEman(String pKodea) {
    	try{
    		sta = con.createStatement();
			res = sta.executeQuery("SELECT egoera FROM PELIKULA WHERE kodea='"+pKodea+"'");
			res.next();
			System.out.println("Egoera: "+res.getString("egoera"));
		    String egoera = res.getString("egoera");
		    if (egoera.equals("Libre")) {
		    	pelikulaBorratu(pKodea);
		    	return "Pelikula ezabatu egin da";
		    }
		    else {
		    	sta.executeUpdate("UPDATE PELIKULA SET egoera='Deskatalogatuta' WHERE kodea='"+pKodea+"'");
		    	return "Pelikula norbaitek dauka, deskatalogatu egin da momentuz. Itzultzean ezabatuko da";
		    }
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
        }
    	return "Arazo bat gertatu da pelikula baja ematerakoan";
    }

    public ArrayList<String> pelikulaBilatu(String pTitulo){
    	ArrayList<String> pelikula = new ArrayList<String>();
    	try {
    	sta = con.createStatement();
        res = sta.executeQuery("SELECT titulua,kodea,prezioa,egoera FROM PELIKULA WHERE titulua like '%"+pTitulo+"%' ORDER BY titulua");
        while (res.next()) {
			String izena = res.getString("titulua");
			String kodea = res.getString("kodea");
			String prezioa = res.getString("prezioa");
			String egoera = res.getString("egoera");
			/*System.out.println("Kodea: "+kodea+", "
					+ "Izena: "+izena+", "
					+ "Egoera: "+egoera+", "
					+ "Prezioa: "+prezioa);*/
			pelikula.add(izena); pelikula.add(kodea);
			pelikula.add(prezioa); pelikula.add(egoera);
			}
        res.close();
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
        }
    	return pelikula;
    }
    
    public boolean login(String pKodea, String pPass){
    	try {
    	sta = con.createStatement();
        res = sta.executeQuery("SELECT egoera FROM BAZKIDE WHERE kodea='"+pKodea+"' and passWord='"+pPass+"'");
        res.next();
        String egoera = res.getString("egoera");
	    if (egoera.equals("Alta")) {
	    	res.close();
	    	return true;
	    }
	    else System.out.println("Bazkide honek baja heman du.");
		/*String izena = res.getString("izena");
		String abizenak = res.getString("abizenak");
		String helbidea = res.getString("helbidea");
		String kreditua = res.getString("kreditua");
		System.out.println("Kodea: "+pKodea+", "
					+ "Izena: "+izena+", "
					+ "Abizenak: "+abizenak+", "
					+ "Helbidea: "+helbidea+", "
					+ "Kreditua: "+kreditua);*/
        res.close();
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
        }
		return false;
    }

    public String bazkideaAldatu(String pKodea) {
    	try {
			sta = con.createStatement();
			res = sta.executeQuery("SELECT egoera FROM BAZKIDE WHERE kodea='"+pKodea+"'");
			res.next();
		    String egoera = res.getString("egoera");
		    if (egoera.equals("Alta")) {
		    	bazkideBaja(pKodea);
		    	 res.close();
		    	return "Bazkideari baja eman diozu";
		    }
		    else {
		    	bazkideAlta(pKodea);
		    	 res.close();
		    	return "Bazkideari alta eman diozu";
		    } 
    	}
		catch (SQLException e) {
		    e.printStackTrace();
		}
    	return "Arazoren bat gertatu da ezin izan da egoera aldatu";
    }
    
    private void bazkideAlta(String pKodea) throws SQLException {
		sta.executeUpdate("UPDATE BAZKIDE SET egoera='Alta' WHERE kodea='"+pKodea+"'");
	
    }
    
    private void bazkideBaja(String pKodea) throws SQLException {
    	sta.executeUpdate("UPDATE BAZKIDE SET egoera='Baja' WHERE kodea='"+pKodea+"'");
    	res = sta.executeQuery("SELECT pelKodea FROM ALOKATU WHERE itzulData IS NULL AND bazKodea='"+pKodea+"'");
		while (res.next()) {
			String pelikula = res.getString("pelKodea");
			pelikulaItzuli(pelikula, pKodea);
		}
    }

    public String pelikulaAlokatu(String pKodea, String pBazKodea) {
	  Calendar c = new GregorianCalendar();
      String eguna = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
      String hila = Integer.toString(c.get(Calendar.MONTH)+1);
      String urtea = Integer.toString(c.get(Calendar.YEAR));
      String ordua = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
      String min = Integer.toString(c.get(Calendar.MINUTE));
      String sec = Integer.toString(c.get(Calendar.SECOND));
    	try {
    		res = sta.executeQuery("SELECT egoera FROM BAZKIDE WHERE kodea='"+pBazKodea+"'");
			res.next();
			System.out.println("Egoera: "+res.getString("egoera"));
		    String egoera = res.getString("egoera");
		    res.close();
		    if (egoera.equals("Alta")) {
		    	if (pelikulaAlokatuDaiteke(pKodea)){
			    	if (diruNahikoaDuzu(pKodea, pBazKodea)) {
				    	sta.executeUpdate("UPDATE PELIKULA SET egoera='Alokatua' WHERE kodea='"+pKodea+"'");
			    		sta.executeUpdate("INSERT INTO ALOKATU(pelkodea, bazkodea, alokData) VALUES('"+pKodea+"','"+pBazKodea+"', '"+urtea+"-"+hila+"-"+eguna+" "+ordua+":"+min+":"+sec+"')");
			    		return "Pelikula ondo alokatu duzu";
			    	}
			    	else return "Ez duzu diru nahikorik";
			    }
		    }
		    else return "Bazkidea baja emanda dago";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Pelikula ezin izan da alokatu. DATUBASEAREN ERROREA";
		}
			return "Pelikula ez dago alokagai";
    }
  	
  	private boolean diruNahikoaDuzu(String pKodea, String pBazKodea) throws SQLException {
  			sta = con.createStatement();
			res = sta.executeQuery("SELECT kreditua FROM BAZKIDE WHERE kodea='"+pBazKodea+"'");
			res.next();
		    String kreditua = res.getString("kreditua");
		    System.out.println("Kreditua: "+kreditua);
		    float dirua = Float.parseFloat(kreditua);
		    
			res = sta.executeQuery("SELECT prezioa FROM PELIKULA WHERE kodea='"+pKodea+"'");
			res.next();
			String prezioa = res.getString("prezioa");
		    System.out.println("Prezioa :"+prezioa);
		    dirua = dirua - Float.parseFloat(prezioa);
		    if (dirua >= 0.0) {
		    	System.out.println(String.valueOf(dirua));
		    	sta.executeUpdate("UPDATE BAZKIDE SET kreditua='"+String.valueOf(dirua)+"' WHERE kodea='"+pBazKodea+"'");
		    	return true;
		    }
		    else return false;
  	}

	private boolean pelikulaAlokatuDaiteke(String pKodea) throws SQLException {
			sta = con.createStatement();
			res = sta.executeQuery("SELECT egoera FROM PELIKULA WHERE kodea='"+pKodea+"'");
			res.next();
			System.out.println("Egoera: "+res.getString("egoera"));
		    String egoera = res.getString("egoera");
		    res.close();
		    if (egoera.equals("Libre")) return true;
		    else return false;
  	}
  
  	public String pelikulaItzuli(String pKodea, String pBazKodea) {
    	try {
			sta = con.createStatement();
			res = sta.executeQuery("SELECT egoera FROM PELIKULA,ALOKATU WHERE kodea=pelKodea AND kodea='"+pKodea+"' AND bazKodea='"+pBazKodea+"'");
			if (res.next()){
				System.out.println("Egoera: "+res.getString("egoera"));
				String egoera = res.getString("egoera");
				if (egoera.equals("Alokatua")) {
					sta.executeUpdate("UPDATE PELIKULA SET egoera='Libre' WHERE kodea='"+pKodea+"'");
					sta.executeUpdate("UPDATE ALOKATU SET itzulData=CURRENT_TIMESTAMP WHERE pelkodea='"+pKodea+"'"+" AND bazkodea='"+pBazKodea+"' AND itzulData IS NULL");
					return "Pelikula itzuli duzu";
				}
				else if (egoera.equals("Deskatalogatuta")){
					pelikulaBorratu(pKodea);
					return "Pelikula itzuli duzu";
				}
			}
		    res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return "Ezin da pelikula itzuli";
    }

    public ArrayList<String> katalogoaIkusi() {
    	ArrayList<String> zerrenda = new ArrayList<String>();
    	try {
        	sta = con.createStatement();
        	res = sta.executeQuery("SELECT titulua,kodea,prezioa,egoera FROM PELIKULA ORDER BY titulua");
			while (res.next()) {
				String izena = res.getString("titulua");
		    	String kodea = res.getString("kodea");
		    	String prezioa = res.getString("prezioa");
		    	String egoera = res.getString("egoera");
		    	System.out.println("Kodea: "+kodea+", "
		    			+ "Izena: "+izena+", "
		    			+ "Prezioa: "+prezioa+" ,"
		    			+ "Egoera: "+egoera);
		    	zerrenda.add(izena); zerrenda.add(kodea); 
		    	zerrenda.add(prezioa); zerrenda.add(egoera);
		    	}
		    res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zerrenda; //orden: 1-titulo 2-kodigo 3-precio 4-estado
      
    }
    
    public ArrayList<String> estreinaldiakIkusi() {
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_YEAR, -7);
        String eguna = Integer.toString(c.get(Calendar.DATE));
        String hila = Integer.toString(c.get(Calendar.MONTH)+1);
        String urtea = Integer.toString(c.get(Calendar.YEAR));
        ArrayList<String> zerrenda = new ArrayList<String>();
    	try {
    		sta = con.createStatement();
    		res = sta.executeQuery("SELECT titulua,kodea,prezioa,egoera FROM PELIKULA WHERE data>='"+urtea+"-"+hila+"-"+eguna+"%' ORDER BY data");
    		while (res.next()) {
				String izena = res.getString("titulua");
		    	String kodea = res.getString("kodea");
		    	String prezioa = res.getString("prezioa");
		    	String egoera = res.getString("egoera");
		    	System.out.println("Kodea: "+kodea+", "
		    			+ "Izena: "+izena+", "
		    			+ "Prezioa: "+prezioa+" ,"
		    			+ "Egoera: "+egoera);
		    	zerrenda.add(izena); zerrenda.add(kodea); 
		    	zerrenda.add(prezioa); zerrenda.add(egoera);
		    	}
    		res.close();
    	} catch (SQLException e) {
			e.printStackTrace();
    	}
    	return zerrenda; //orden: 1-titulo 2-kodigo 3-precio 4-estado
    }
    
    private void pelikulaBorratu(String pKodea) throws SQLException {
		sta = con.createStatement();
		sta.executeUpdate("DELETE FROM PELIKULA WHERE kodea='"+pKodea+"'");
    }
     public String dirua(String pKodea) {
    	 String kreditua = null;
    	 try {
    	 	sta = con.createStatement();
			res = sta.executeQuery("SELECT kreditua FROM BAZKIDE WHERE kodea='"+pKodea+"'");
			res.next();
		    kreditua = res.getString("kreditua");
    	 }
    	 catch (SQLException e) {
     		e.printStackTrace();
         }
    	 return kreditua;
     }
    
    public String kredituaSartu(String pKodea, String pDirua) {
    	try{
		    String kreditua = dirua(pKodea);
		    if (Float.parseFloat(pDirua) > 0.0) {
		    	float dirua = Float.parseFloat(kreditua) + Float.parseFloat(pDirua);
		    	if (dirua >= 0.0) {
		    		kreditua = String.valueOf(dirua);
		    		sta.executeUpdate("UPDATE BAZKIDE SET kreditua='"+String.valueOf(dirua)+"' WHERE kodea='"+pKodea+"'");
		    		return "Dirua ondo gehitu da";
		    	}
		    }
		    else return "Dirua positiboa izan behar da";
		}
    	catch (SQLException e) {
    		e.printStackTrace();
        }
    	return "Arazoren bat dago, ezi da dirua gehitu";
    }

	public String[] bazkideOsoa(String pKodea) {
		String[] bazkidea = new String[3];
		try {
			sta = con.createStatement();
			res = sta.executeQuery("SELECT izena,abizenak,helbidea FROM BAZKIDE WHERE kodea='"+pKodea+"'");
			res.next();
			bazkidea[0] = res.getString("izena");
			bazkidea[1] = res.getString("abizenak");
			bazkidea[2] = res.getString("helbidea");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bazkidea;
	}

	public String datuakAldatu(String pKodea, String pIzena, String pAbizenak, String pPass, String pHelbidea) {
		try {
			sta = con.createStatement();
			System.out.println("UPDATE BAZKIDE SET izena='"+pIzena+"', "
					+ "abizenak='"+pAbizenak+"', "
					+ "passWord='"+pPass+"', "
					+ "helbidea='"+pHelbidea+"' WHERE kodea='"+pKodea+"'");
			sta.executeUpdate("UPDATE BAZKIDE SET izena='"+pIzena+"', "
					+ "abizenak='"+pAbizenak+"', "
					+ "passWord='"+pPass+"', "
					+ "helbidea='"+pHelbidea+"' WHERE kodea='"+pKodea+"'");
			return "Datuak aldatu dira";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Datuakez dira aldatu errore bat egon delako";
	}
}
