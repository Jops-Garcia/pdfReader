import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Payment {
    String barCode;
    //TODO: transform to float
    String value;
    String info;
    
    //this is for avoid calling functions with no need
    Boolean hasValue;
    Boolean hasInfo;
    Boolean hasCode;
    
    //constructor, setting default values
    public Payment() {
        this.barCode="Não encontrado";
        this.value="Não encontrado";
        this.info="Não encontrado";

        this.hasInfo = false;
        this.hasValue = false;
        this.hasCode = false;
    }

    //===================================================================

    public void search(String line){
        this.searchBarCode(line);
        this.searchValue(line);
        this.searchNumber(line);
    }

    public void searchBarCode(String line){
        //already found?
        if (!this.hasCode){
            
            Pattern pattern = Pattern.compile("Código de barras:(.*)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);
            boolean matchFound = matcher.find();

            if(matchFound) {
                this.hasCode=true;
                //everything after Nome: and removing spaces before the first character
                this.barCode = matcher.group(1).trim();
            } 
        }
    }

    public void searchValue(String line){
        if (!this.hasValue){
            Pattern pattern = Pattern.compile("Valor do documento:(.*)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);
            boolean matchFound = matcher.find();

            if(matchFound) {
                this.hasValue=true;
                this.value = matcher.group(1).trim();
            } 
        }
    }

    public void searchNumber(String line){
        if (!this.hasInfo){
            Pattern pattern = Pattern.compile("pagador:(.*)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);
            boolean matchFound = matcher.find();

            if(matchFound) {
                this.hasInfo=true;
                this.info = matcher.group(1).trim();
            } 
        }
    }


    //=======================GETERS & SETERS=======================

    public Boolean getHasValue() {
        return hasValue;
    }
    public void setHasValue(Boolean hasValue) {
        this.hasValue = hasValue;
    }
    public Boolean getHasInfo() {
        return hasInfo;
    }
    public void setHasInfo(Boolean hasInfo) {
        this.hasInfo = hasInfo;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    
    public String getCode() {
        return barCode;
    }
    public void setCode(String barCode) {
        this.barCode = barCode;
    }


    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
}
