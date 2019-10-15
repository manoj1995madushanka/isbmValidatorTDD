import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ISBNTest {

    @Test
    public void checkAValidISBN(){
        ISBN isbn = new ISBN();
        boolean result = isbn.checkISBN(140449116);
        assertTrue(result, "first value");
        result = isbn.checkISBN(140177396);
        assertTrue(result,"second value");
    }

    @Test
    public void checkAnInValidISBN(){
        ISBN isbn = new ISBN();
        boolean result = isbn.checkISBN(140449117);
        assertFalse(result);
    }

}