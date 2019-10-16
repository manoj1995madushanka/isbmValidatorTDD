public class StockManager {

    private ExternalISBNDataService webService;
    private ExternalISBNDataService databeseService;

    public void setDatabeseService(ExternalISBNDataService databeseService) {
        this.databeseService = databeseService;
    }


    public void setExternalISBNDataService(ExternalISBNDataService externalISBNDataService) {
        this.webService = externalISBNDataService;
    }

    public String getLocatorCode(String isbn){
        Book book=databeseService.lookup(isbn);
        if(book==null) book= webService.lookup(isbn);
        StringBuilder locator = new StringBuilder();
        locator.append(isbn.substring(isbn.length()-4));
        locator.append(book.getAuthor().substring(0,1));
        locator.append(book.getTitle().split(" ").length);
        return  locator.toString();
    }
}
