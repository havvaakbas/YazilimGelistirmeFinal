package com.havva.havva;

/**
 * 
 *
 * @author havvaakbas
 * @version 0.0.1 SNAPSHOT
 */
/**
 * Haber class ına ait iki adet String oluşturdum.
 */
public class Haber {
    private String baslik;
    private String icerik;
    
    /**
	 *@param baslik: restServisi.java da ki haber baslıgına ait veriyi buradan alır.
     *@param icerik: restServisi.java da ki haber içeriklerini buradan alır.
	 */
    
    public Haber(String baslik, String icerik) {

        this.baslik = baslik;
        this.icerik = icerik;
    }
    /**
	 *Haber baslığını döndürmeye yarar.
	 */
    public String getbaslik() {
        return baslik;
    }
    /**
	 * Haer içeriğini döndürür.
	 */
    public String geticerik() {
        return icerik;
    }
    
}
