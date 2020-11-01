package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein(){
        String vastaus = kortti.toString();
        assertEquals("saldo: 0.10",vastaus);
    }
    
    @Test
    public void lataaminenKasvattaaSaldoaOikein(){
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20",kortti.toString());
    }
    
    @Test
    public void rahanOttaminenToimiiOikein(){
        kortti.lataaRahaa(10);
        //rahaa 0.20
        assertEquals("saldo: 0.20",kortti.toString());
        kortti.otaRahaa(5);
        assertEquals("saldo: 0.15",kortti.toString());
        assertTrue(true);
    }
    
    @Test
    public void rahanOttaminenToimiiEiOikein(){
    kortti.lataaRahaa(10);
    //rahaa 0.20
    kortti.otaRahaa(25);
    assertEquals("saldo: 0.20",kortti.toString());
    assertFalse(false);
    }
    

}
