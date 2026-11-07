package q3;

import java.util.List;

public class Radio{
    
    private String content;
    private int rate;
    
    public Radio(){}
    public Radio(String content, int rate){
        this.content = content;
        this.rate = rate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }

    public int getRate() {
        return rate;
    }
    
}
