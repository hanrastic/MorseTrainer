/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author maisajoo
 */
public class KassapaateTest {
    
    Kassapaate kassapaate = new Kassapaate();
    Maksukortti kortti = new Maksukortti(1000);
    int lounaat = 0;
    

    @Test
    public void kassapaatteenRahaOikein(){
        assertEquals(100000, kassapaate.kassassaRahaa());       
    }

    @Test
    public void kassapaatteenLounaatOikein(){
        lounaat = kassapaate.edullisiaLounaitaMyyty()+kassapaate.maukkaitaLounaitaMyyty();
        assertEquals(0,lounaat);
    }
    
    @Test
    public void kateisMaksuToimiiOikeinKassalla(){       
        assertEquals(260, kassapaate.syoEdullisesti(500));
        assertEquals(100, kassapaate.syoMaukkaasti(500));
        assertEquals(100640, kassapaate.kassassaRahaa());    
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
        
        
    }
    
    @Test
    public void kateisMaksuToimiiOikeinKassallaKunRahaaEiOleTarpeeksi(){       
        assertEquals(230, kassapaate.syoEdullisesti(230));
        assertEquals(230, kassapaate.syoMaukkaasti(230));
        assertEquals(100000, kassapaate.kassassaRahaa());    
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());        
    }
    
    @Test
    public void korttimaksuToimiiOikeinKassalla(){
        assertTrue(kassapaate.syoEdullisesti(kortti));
        assertEquals(1,kassapaate.edullisiaLounaitaMyyty());
        assertTrue(kassapaate.syoMaukkaasti(kortti));
        assertEquals(1,kassapaate.maukkaitaLounaitaMyyty());      
    }
    
    @Test
    public void korttimaksuToimiiOikeinKassallaKunRahaaEiOleTarpeeksi(){
        assertTrue(kassapaate.syoMaukkaasti(kortti));
        assertEquals(1,kassapaate.maukkaitaLounaitaMyyty());
        assertTrue(kassapaate.syoEdullisesti(kortti));
        assertEquals(1,kassapaate.edullisiaLounaitaMyyty());       
    }
    
        
    @Test
    public void korttimaksuEiToimiKunRahaaLiianVahan(){
        kortti = new Maksukortti(10);
        
        assertFalse(kassapaate.syoEdullisesti(kortti));
        assertFalse(kassapaate.syoMaukkaasti(kortti));
    }
    
    
    
    @Test
    public void rahanLataaminenToimiiOkeinKassallaJaKortilla(){
        kassapaate.lataaRahaaKortille(kortti, 500);
        assertEquals(1500, kortti.saldo());
        assertEquals(100500, kassapaate.kassassaRahaa());
        
        kassapaate.lataaRahaaKortille(kortti, -100);
        assertEquals(100500, kassapaate.kassassaRahaa());
    }
    
    
}
