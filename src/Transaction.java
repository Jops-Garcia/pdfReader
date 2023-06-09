import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transaction {
    String date;

    //this is for avoid searching the same pattern multiple times
    Boolean hasDate;

    //constructor, setting default values
    public Transaction() {

        this.date="Não encontrado";
        
        this.hasDate = false;
    }
    
//===================================================================

    public void search(String line){
        //already found?
        if (!this.hasDate){
            
            Pattern pattern = Pattern.compile("[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}");
            Matcher matcher = pattern.matcher(line);
            boolean matchFound = matcher.find();

            if(matchFound) {
                this.hasDate=true;
                //removing spaces before the first character
                this.date = matcher.group(0).trim();
            } 
        }
    }

    //=======================GETERS & SETERS=======================

    public Boolean getHasDate() {
        return hasDate;
    }

    public void setHasDate(Boolean hasDate) {
        this.hasDate = hasDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
