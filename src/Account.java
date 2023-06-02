import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    String name;
    String agency;
    String number;

    //this is for avoid searching the same pattern multiple times
    Boolean hasName;
    Boolean hasAgency;
    Boolean hasNumber;


   
    //constructor, setting default values
    public Account() {

        this.name="Não encontrado";
        this.agency="Não encontrado";
        this.number="Não encontrado";

        this.hasName = false;
        this.hasAgency = false;
        this.hasNumber = false;
    }



    //===================================================================
    public void search(String line){
        this.searchName(line);
        this.searchAgency(line);
        this.searchNumber(line);
    }

    public void searchName(String line){
        //already found?
        if (!this.hasName){
            
            Pattern pattern = Pattern.compile("Nome:(.*)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);
            boolean matchFound = matcher.find();

            if(matchFound) {
                this.hasName=true;
                //everything after Nome: and removing spaces before the first character
                this.name = matcher.group(1).trim();
            } 
        }
    }

    public void searchAgency(String line){
        if (!this.hasAgency){
            Pattern pattern = Pattern.compile("Agência:(.*)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);
            boolean matchFound = matcher.find();

            if(matchFound) {
                this.hasAgency=true;
                this.agency = matcher.group(1).trim();
                //removes all after " "
                this.agency = agency.replaceAll(" +.*", "");
            } 
        }
    }

    public void searchNumber(String line){
        if (!this.hasNumber){
            Pattern pattern = Pattern.compile("Conta:(.*)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);
            boolean matchFound = matcher.find();

            if(matchFound) {
                this.hasNumber=true;
                this.number = matcher.group(1).trim();
            } 
        }
    }

    
    //=======================GETERS & SETERS=======================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getHasName() {
        return hasName;
    }

    public void setHasName(Boolean hasName) {
        this.hasName = hasName;
    }

    public Boolean getHasAgency() {
        return hasAgency;
    }

    public void setHasAgency(Boolean hasAgency) {
        this.hasAgency = hasAgency;
    }

    public Boolean getHasNumber() {
        return hasNumber;
    }

    public void setHasNumber(Boolean hasNumber) {
        this.hasNumber = hasNumber;
    }




}
