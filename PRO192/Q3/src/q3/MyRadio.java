package q3;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MyRadio implements IRadio{
    public boolean checkDi(String s){
        for(int i = 0 ; i < s.length() ; ++i){
            char c = s.charAt(i);
            if('0' <= c && c <= '9') return true;
        }
        return false;
    }
    
    public int f1(List <Radio> t){
        int ans = 99999;
        for(int i = 0 ; i < t.size() ; ++i){
            Radio x = t.get(i);
            if(checkDi(x.getContent()) == true){
                int di = x.getRate();
                if(di < ans) ans = di;
            }
        }
        return ans;
    }
                                                       
    public void f2 (List <Radio> t){
        ArrayList <Integer> a = new ArrayList <>();
        ArrayList <Radio> Ans = new ArrayList <>();
        int[] dem = new int[1000];
        boolean[] check = new boolean[1000];
        for(int i = 0 ; i < 1000 ; ++i){
            dem[i] = 0;
            check[i] = true;
        }
        for(int i = 0 ; i < t.size() ; ++i){
            Radio x = t.get(i);
            String tmp = x.getContent();
            if(('a' <= tmp.charAt(0) && tmp.charAt(0) <= 'z') || ('A' <= tmp.charAt(0) && tmp.charAt(0) <= 'Z')){
                a.add(x.getRate());
                ++dem[x.getRate()];
            }else check[i] = false;
        }
        Collections.sort(a, Collections.reverseOrder());
        
        int cs = 0;
        for(int i = 0 ; i < a.size() ; ++i){
            int x = a.get(i);
            for(int j = 0 ; j < t.size() ; ++j){
                Radio tmp = t.get(j);
                if(tmp.getRate() == x && dem[x] > 0){
                    Radio kq = new Radio(tmp.getContent(), tmp.getRate());
                    Ans.add(kq);
                    --dem[x];
//                    System.out.print('(' + tmp.getContent() + ", " + tmp.getRate() + ") ");
                }
            }
        }
        for(int i = 0 ; i < t.size() ; ++i){
            Radio tmp = t.get(i);
            if(check[i] == false){
                Radio kq = new Radio(tmp.getContent(), tmp.getRate());
                Ans.add(kq);
//                System.out.print('(' + tmp.getContent() + ", " + tmp.getRate() + ") ");
            }
        }
        t.clear();
        t.addAll(Ans);
    }
    
    
    public void f3 (List <Radio> t){
        
    }
}
