import java.util.ArrayList;

public class GrafoManager {
    
    public static Grafo grafoByArquivo(String caminho){

        int index;
        Grafo grafo;
        No noA, noB, noAux;
        ArrayList<No> node;
        String grafoNoArquivo;

        try{
            grafoNoArquivo = FileManager.readFile(caminho);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

        grafo = new Grafo();
        node = new ArrayList<>();
        String grafoAresta[] = new String[4];
        String grafoTxtSeparado[] = grafoNoArquivo.split(";");

        for(index = 0; index < grafoTxtSeparado.length ;index++){
            grafoAresta = grafoTxtSeparado[index].split(",");

            if( ! verificaSeNoExiste(node, grafoAresta[0]) ){
                node.add(new No(grafoAresta[0]));
            }

            if( ! verificaSeNoExiste(node, grafoAresta[1]) ){
                node.add(new No(grafoAresta[1]));
            }

            noAux = adicionarRota(node, grafoAresta[0], grafoAresta[1], Integer.parseInt(grafoAresta[2]));
            grafo.adicionarNo(noAux);
        }

        return grafo;
    }

    public static boolean verificaSeNoExiste(ArrayList<No> node, String nome){

        for (No no : node) {
            if(no.getNome().equalsIgnoreCase(nome)){
                return true;
            }
        }

        return false;
    } 

    public static No capturaNoByName(ArrayList<No> node, String nome){

        for (No no : node) {
            if(no.getNome().equalsIgnoreCase(nome)){
                return no;
            }
        }

        return null;
    }

    public static No adicionarRota(ArrayList<No> node, String pontoA, String pontoB, int value){

        No noA;
        No noB;

        noA = capturaNoByName(node, pontoA);
        noB = capturaNoByName(node, pontoB);

        noA.adicionarAdjacencia(noB, value);

        return noA;
    }

    public static Grafo grafoByHardCode(){

        Grafo graph;

        No nodeA = new No("A");
        No nodeB = new No("B");
        No nodeC = new No("C");
        No nodeD = new No("D"); 
        No nodeE = new No("E");
        No nodeF = new No("F");

        nodeA.adicionarAdjacencia(nodeB, 10);
        nodeA.adicionarAdjacencia(nodeC, 15);
        
        nodeB.adicionarAdjacencia(nodeD, 12);
        nodeB.adicionarAdjacencia(nodeF, 15);
        
        nodeC.adicionarAdjacencia(nodeE, 10);
        
        nodeD.adicionarAdjacencia(nodeE, 2);
        nodeD.adicionarAdjacencia(nodeF, 1);
        
        nodeF.adicionarAdjacencia(nodeE, 5);
        
        graph = new Grafo();
        
        graph.adicionarNo(nodeA);
        graph.adicionarNo(nodeB);
        graph.adicionarNo(nodeC);
        graph.adicionarNo(nodeD);
        graph.adicionarNo(nodeE);
        graph.adicionarNo(nodeF);

        return graph;
    }

}
