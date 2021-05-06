import java.util.Set;
import java.util.HashSet;

public class Grafo {
    
    private Set<No> no = new HashSet<>();

    public void adicionarNo(No pontoA){
        no.add(pontoA);
    }

    public Set<No> getNo() {
        return no;
    }

    public void setNo(Set<No> no) {
        this.no = no;
    }

    public No getNoByKey(String key){
        for (No no2 : no) {
            if(no2.getNome().equalsIgnoreCase(key)){
                return no2;
            }
        }
        return null;
    }

}
