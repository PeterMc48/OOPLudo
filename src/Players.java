import javax.swing.*;

public class Players{
    private String name;
    protected Token tokens;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

   public Players()
   {
       setName("unknown");
   }
    public Players(String name,Token tokens){
        setName(name);

    }

}
