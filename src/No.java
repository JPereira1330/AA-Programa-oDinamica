import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class No {
    
    private String nome;
    private LinkedList<No> caminho; 
    private Integer distancia;
    private Map<No, Integer> noAdjacentes;

    public No(){
        distancia = Integer.MAX_VALUE;
        caminho = new LinkedList<>();
        noAdjacentes = new HashMap<>();
    }

    public No(String nome){
        super();
        this.nome = nome;
        this.distancia = Integer.MAX_VALUE;
        this.caminho = new LinkedList<>();
        this.noAdjacentes = new HashMap<>();
    }

    public void adicionarAdjacencia(No destino, int distancia){
        noAdjacentes.put(destino, distancia);
        destino.noAdjacentes.put(this, distancia);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<No> getCaminho() {
        return caminho;
    }

    public void setCaminho(LinkedList<No> caminho) {
        this.caminho = caminho;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Map<No, Integer> getNoAdjacentes() {
        return noAdjacentes;
    }

    public void setNoAdjacentes(Map<No, Integer> noAdjacentes) {
        this.noAdjacentes = noAdjacentes;
    }
    
}
