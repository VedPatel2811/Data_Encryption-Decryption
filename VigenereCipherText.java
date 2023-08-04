package testing;

import static org.junit.Assert.*;

import org.junit.Test;


import encryption.ciphers.VigenereCipher;


public class VigenereCipherText {
    private VigenereCipher vc = new VigenereCipher("test");

    @Test
    public void vcEnc1(){
        String encripted = vc.encrypt("have a great day");
        assertEquals(encripted, "aKn^tKs`kOYmtNYr");
    }
    @Test
    public void vcEnc2(){
        String encripted = vc.encrypt("Once upon a time");
        assertEquals(encripted, "HX[^t_hhgeYtmSe^");
    }
    @Test
    public void vcEnc3(){
        String encripted = vc.encrypt("winter is coming");
        assertEquals(encripted, "pSfm^\\sble[hfSf`");
    }
    @Test
    public void vcEnc4(){
        String encripted = vc.encrypt("Fire in the field");
        assertEquals(encripted, "?Sj^tSftmR]t_S]e]");
    }
    @Test
    public void vcDec1(){
        String decrypted = vc.decrypt("HXsmaOseZ]lt]KqthPs\\hVd^`O");
        assertEquals(decrypted, "On the last day of college");
    }
    @Test
    public void vcDec2(){
        String decrypted = vc.decrypt("`OltlYe^tPgh]");
        assertEquals(decrypted, "get some food");
    }
    @Test
    public void vcDec3(){
        String decrypted = vc.decrypt("MSeltSktZefb\\OsieK[^t^gt\\Raee");
        assertEquals(decrypted, "Tims is a nice place to chill");
    }
    @Test
    public void vcDec4(){
        String decrypted = vc.decrypt("L_ZpZcsbleZ^l^");
        assertEquals(decrypted, "Subway is best");
    }
}
