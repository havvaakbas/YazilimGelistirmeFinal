package com.havva.havva;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
*@author havvaakbas
*@version 4.0.0
*Restservisi sınıfıdır.
*/

public class RESTServisi {

    private static final List<Haber> HABERLER = new ArrayList<Haber>();
    /** 
     * Haber oluşturma:
     *@return Haberi döner.
     *@param baslik: Haber baslığını tutar.
     *@param icerik: Habere ait girilen verileri tutar.
     *
     */
    private Object kilit = new Object();
    
    @RequestMapping("/haber/olustur")
    public synchronized Haber haberOlustur(String baslik, String icerik){
        synchronized (kilit) {
            Haber haber = new Haber(baslik, icerik);
            HABERLER.add(haber);
            return haber;
        }
    }
    
    /**
     *Haber listeleme:
     *@return Liste de ki haberleri döner.
     */
    
    @RequestMapping("/haber/listele")
    public synchronized List<Haber> haberListele(){
        synchronized (kilit) {
            if (HABERLER.size()>10) {
                return HABERLER.subList(0, 10);
            } else {
                return HABERLER;
            }
            
        }
    }
    /**
     *Haber Temizleme
     *Listeye ait haberlerin hepsini temizler.
     *@return Haberlerin hepsi silindikten sonra "Temizlendi" döner.
     */
    @RequestMapping("/haber/temizle")
    public String haberTemizle(){
        synchronized (kilit) {
            HABERLER.clear();
            return "Temizlendi";
        }
    }
    
    
    
    
    
    
}
