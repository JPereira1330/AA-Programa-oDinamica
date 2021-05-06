import java.util.ArrayList;

public class BancoDados {

    private String retorno;
    private ArrayList<String> keyResultado;
    private ArrayList<Grafo> resultado;
 
    public BancoDados(){
        retorno = "\n";
        keyResultado = new ArrayList<>();
        resultado = new ArrayList<>();
    }

    public void adicionarNoBanco(String key, Grafo result){
        retorno += " [ * ] Adicionado no Banco de dados, Entrada: "+key+"\n"; 
        keyResultado.add(key);
        resultado.add(result);
    }

    public Grafo capturaGrafoPorKey(String key){

        int index;

        for(index = 0; index < keyResultado.size(); index++){
            if(keyResultado.get(index).equalsIgnoreCase(key)){
                return resultado.get(index);
            }
        }

        return null;
    }

    public int exibirCaminho(String keyInicial, String KeyFinal){

        Grafo grafo;

        if(resultado.size() <= 0){
            retorno += " [ * ] Entrada nao encontrada no Banco de dados \n";
            return -1;
        }

        grafo = capturaGrafoPorKey(keyInicial);
        if(grafo == null){
            retorno += " [ * ] Entrada nao encontrada no Banco de dados \n";
            return 2;
        }

        retorno += " [ * ] Entrada encontrada no Banco de dados \n";
        retorno += " [ * ] Caminho: ";

        for (No no : grafo.getNo()) {
            if(no.getNome().equalsIgnoreCase(KeyFinal)){
                for (No no02 : no.getCaminho()) {
                    retorno += " "+no02.getNome()+ "("+no02.getDistancia()+") =>";
                }
                retorno += no.getNome()+ "("+no.getDistancia()+") \n";
                return 1;
            }
        }

        retorno = " [ ! ] Erro Fatal";
        return -2;
    }

    public int exibirCaminhoReutilizado(String keyInicial, String KeyFinal){

        int index;
        No noInicial;
        
        retorno += " [ * ] Tentando reutilizar a resposta de outra entrada \n";

        noInicial = null;

        for(index = 0; index < resultado.size(); index++){
            for (No no : resultado.get(index).getNo()) {
                if(no.getNome().equalsIgnoreCase(KeyFinal)){

                    for(No tentaivaNo : no.getCaminho()){
                        if(tentaivaNo.getNome().equalsIgnoreCase(keyInicial)){
                            noInicial = tentaivaNo;
                            retorno += " [ * ] Resposta Encontrada, sucesso em reutilizar resposta \n";
                        }
                        if(noInicial != null){
                            retorno += " -> "+tentaivaNo.getNome()+" ("+( tentaivaNo.getDistancia() - noInicial.getDistancia() )+")";
                        }
                    }

                    if(noInicial != null){
                        retorno += " -> "+no.getNome()+" ("+( no.getDistancia() - noInicial.getDistancia() )+")";
                        return 1;
                    }else{
                        retorno += " [ * ] Resposta nao encontrada, falha em reutilizar resposta \n";
                        return -1;
                    }
                }
            }
        }

        return -1;
    }

    public String getRetorno(){
        String ret = this.retorno;
        this.retorno = "\n";
        return ret;
    }
}
 