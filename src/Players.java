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
        Token[] blueToken = new Token[3];
        Token[] redToken = new Token[3];
        Token[] greenToken = new Token[3];
        Token[] pinkToken = new Token[3];

        for(int i =0;i<blueToken.length;i++)
        {
            blueToken[i] = tokens;
        }


    }

}
