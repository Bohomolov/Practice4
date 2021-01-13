
public class RegExTask {
    public boolean isItPhoneNumber(String phoneNumber){
        boolean result = phoneNumber.matches("^(\\+\\d{1,4}( )?)?((\\(\\d{1,3}\\))( )\\d{3})(-)?\\d{2}(-)?\\d{2}$");
        return result ;
    }
}
