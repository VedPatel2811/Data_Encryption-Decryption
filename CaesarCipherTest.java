package testing;

import static org.junit.Assert.*;
import org.junit.Test;

import encryption.ciphers.CaesarCipher;

public class CaesarCipherTest {
    private CaesarCipher cc = new CaesarCipher(5);

    
    @Test
    public void ccEnc1() {
        String encripted = cc.encrypt("Once upon a time...");
        assertEquals(encripted, "Tshj%zuts%f%ynrj333");
    }
    @Test
    public void ccEnc2() {
        String encripted = cc.encrypt("How long it will take");
        assertEquals(encripted, "Mt!%qtsl%ny%!nqq%yfpj");
    }
    @Test
    public void ccEnc3() {
        String encripted = cc.encrypt("help");
        assertEquals(encripted, "mjqu");
    }
    @Test
    public void ccEnc4() {
        String encripted = cc.encrypt("need water");
        assertEquals(encripted, "sjji%!fyjw");
    }
    @Test
    public void ccDec1(){
        String decrypted = cc.decrypt("xjhzwj%hmfyx");
        assertEquals(decrypted, "secure chats");
    }
    @Test
    public void ccDec2(){
        String decrypted = cc.decrypt("fyyfhp%kwtr%gfhp");
        assertEquals(decrypted, "attack from back");
    }
    @Test
    public void ccDec3(){
        String decrypted = cc.decrypt("Of{f%uwtlwfrrnsl%nx%kzs&");
        assertEquals(decrypted, "Java programming is fun!");
    }
    @Test
    public void ccDec4(){
        String decrypted = cc.decrypt("Yjxynsl%jshw~uynts%rjymtix");
        assertEquals(decrypted, "Testing encryption methods");
    }
}
