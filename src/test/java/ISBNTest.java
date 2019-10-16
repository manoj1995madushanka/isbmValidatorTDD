import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ISBNTest {

    @Test
    void checkAValid10DigitISBN(){
        ISBN isbn = new ISBN();
        boolean result = isbn.checkISBN("0140449116");
        assertTrue(result,"first value");
        result = isbn.checkISBN("0140177396");
        assertTrue(result,"second value");
    }

    @Test
    void checkAValid13DigitISBN(){
        ISBN isbn = new ISBN();
        boolean result = isbn.checkISBN("9781853260087");
        assertTrue(result,"first value");
        result = isbn.checkISBN("9781853267338");
        assertTrue(result,"second value");
    }

    @Test
    void TenDigitISBNNumbersEndInAnXAreValid(){
        ISBN isbn=new ISBN();
        boolean result = isbn.checkISBN("012000030X");
        assertTrue(result);
    }

    @Test
    void checkAnInvalid10DigitISBN(){
        ISBN isbn=new ISBN();
        boolean result=isbn.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test
    void checkAnInvalid13igitISBN(){
        ISBN isbn=new ISBN();
        boolean result=isbn.checkISBN("9781853267337");
        assertFalse(result);
    }

    @Test//(expected=NumberFormatException.class)
    void nineDigitISBNAreNotValid(){
        ISBN isbn=new ISBN();
        isbn.checkISBN("123456789");
    }

    @Test
    void nonNumericISBNAreNotValid(){
        ISBN isbn=new ISBN();
        isbn.checkISBN("helloworld");
    }



    /*@Test
    public void checkAValidISBN(){
        ISBN isbn = new ISBN();
        boolean result = isbn.checkISBN("0140449116");
        assertTrue(result, "first value");
        result = isbn.checkISBN("0140177396");
        assertTrue(result,"second value");
    }

    @Test
    public void checkAnInValidISBN(){
        ISBN isbn = new ISBN();
        boolean result = isbn.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test//(expected =NumberFormatException.class)
    public void nineDigitISBNNotAllowed(){
        ISBN isbn=new ISBN();
        isbn.checkISBN("123456789");
    }*/


}
