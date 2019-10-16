import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class StockManagementTests {
    @Test
    public void testCanGetACorrectLocatorCode(){

        /*ExternalISBNDataService testWebService=new ExternalISBNDataService() {
            public Book lookup(String isbn) {
                return new Book(isbn,"Of Mice And Men","J. steinbeck");
            }
        };*/
        ExternalISBNDataService testWebService = mock(ExternalISBNDataService.class);
        when(testWebService.lookup(anyString())).thenReturn(new Book("0140177396","Of Mice And Men","J. steinbeck"));

        ExternalISBNDataService testDatabaseService = new ExternalISBNDataService() {
            public Book lookup(String isbn) {
                return null;
            }
        };

        StockManager stockManager=new StockManager();

        stockManager.setExternalISBNDataService(testWebService);

        stockManager.setDatabeseService(testDatabaseService);

        String isbn="0140177396";
        // StockManager sttockManager=new StockManager();
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4",locatorCode);
    }

    @Test
    void databaseIsUsedIfDataIsPresent(){
        ExternalISBNDataService databaseService=mock(ExternalISBNDataService.class);
        ExternalISBNDataService webService=mock(ExternalISBNDataService.class);

        // make book object
        when(databaseService.lookup("0140177396")).thenReturn(new Book("0140177396","abc","abc"));


        StockManager stockManager=new StockManager();

        stockManager.setExternalISBNDataService(webService);

        stockManager.setDatabeseService(databaseService);

        String isbn="0140177396";
        // StockManager sttockManager=new StockManager();
        String locatorCode = stockManager.getLocatorCode(isbn);
        //assertEquals("7396J4",locatorCode);
        verify(databaseService,times(1)).lookup("0140177396");
        verify(webService,times(0)).lookup("0140177396");

        //fail();
    }

    @Test
    void webserviceIsUsedIfDataIsNotPresentInDatabase(){
        ExternalISBNDataService databaseService=mock(ExternalISBNDataService.class);
        ExternalISBNDataService webService=mock(ExternalISBNDataService.class);

        // make book object
        when(databaseService.lookup("0140177396")).thenReturn(null);
        when(databaseService.lookup("0140177396")).thenReturn(new Book("0140177396","abc","abc"));

        StockManager stockManager=new StockManager();

        stockManager.setExternalISBNDataService(webService);

        stockManager.setDatabeseService(databaseService);

        String isbn="0140177396";
        // StockManager sttockManager=new StockManager();
        String locatorCode = stockManager.getLocatorCode(isbn);
        //assertEquals("7396J4",locatorCode);
        verify(databaseService,times(1)).lookup("0140177396");
        verify(webService,times(1)).lookup("0140177396");
        //verify(webService,times(1)).lookup(any(Book.class));

    }
}
