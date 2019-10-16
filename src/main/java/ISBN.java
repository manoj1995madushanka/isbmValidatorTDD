public class ISBN {
    public boolean checkISBN(String isbn) {
        /*if(isbn == 140449116){
            return true;
        }
        return false;*/

        if(isbn.length()==13){
            return isThisAValid13DigitISBN(isbn);
        }else if(isbn.length()==10){
            return isThisAValid10DigitISBN(isbn);
        }else {
            throw new NumberFormatException("length must 10");

        }

    }

    private boolean isThisAValid10DigitISBN(String isbn) {
        int total =0;
        for(int i=0;i<10;i++){
            if(!Character.isDigit(isbn.charAt(i))){
                if(i==9 && isbn.charAt(i)=='X'){
                    total+=10;
                }else{
                    throw new NumberFormatException("isbn can only have numeric values");

                }
            }else {
                total+=isbn.charAt(i)*(10-i);
            }
        }
        if(total%11==0){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isThisAValid13DigitISBN(String isbn) {
        int total =0;

        for(int i=0;i<13;i++){
            if(i%2==0){
                total+=Character.getNumericValue(isbn.charAt(i));
            }else {
                total+=Character.getNumericValue(isbn.charAt(i))*3;
            }
        }
        if(total%10==0){
            return true;
        }else {
            return false;
        }
    }
}
