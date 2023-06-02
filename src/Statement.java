import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Statement {
    String id;
    
    //this is for avoid searching the same pattern multiple times
    Boolean hasId;

    //constructor, setting default values
    public Statement() {
        this.id="Não encontrado";
        this.hasId = false;
    }
//===================================================================
    public void search(String line){
        //already found?
        if (!this.hasId){

            Pattern pattern = Pattern.compile("extrato:(.*)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);
            boolean matchFound = matcher.find();

            if(matchFound) {
                this.hasId=true;
                //everything after Nome: and removing spaces before the first character
                this.id = matcher.group(1).trim();
            } 
        }
    }

    //=======================GETERS & SETERS=======================
    public Boolean getHasId() {
        return hasId;
    }

    public void setHasId(Boolean hasId) {
        this.hasId = hasId;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
