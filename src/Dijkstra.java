import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;

import java.util.Set;

public class Dijkstra {
    
    public static Grafo calcularPesoDoGrafo(Grafo grafo, No inicio){

        inicio.setDistancia(0);

        No atual;
        No noAdjacente;
        Integer arestaPeso;
        Set<No> noResolvido = new HashSet<>();
        Set<No> noNaoResolvido = new HashSet<>();
        
        noNaoResolvido.add(inicio);

        while(noNaoResolvido.size() != 0){
            
            atual = pegarMenorDistanciaDeNo(noNaoResolvido);
            noNaoResolvido.remove(atual);

            for(Entry<No, Integer> adjacente : atual.getNoAdjacentes().entrySet()){
                noAdjacente  = adjacente.getKey();
                arestaPeso = adjacente.getValue();
                if(!noResolvido.contains(noAdjacente)){
                    calcularArestaMinima(noAdjacente, arestaPeso, atual);
                    noNaoResolvido.add(noAdjacente);
                }
            }
            noResolvido.add(atual);
        }

        return grafo;
    }

    private static void calcularArestaMinima(No verificaNo, Integer peso, No noInicial){

        Integer noInicialDistancia;
        LinkedList<No> menorCaminho;

        noInicialDistancia = noInicial.getDistancia();
        if(noInicialDistancia + peso < verificaNo.getDistancia()){
            verificaNo.setDistancia(noInicialDistancia + peso);
            menorCaminho = new LinkedList<>(noInicial.getCaminho());
            menorCaminho.add(noInicial);
            verificaNo.setCaminho(menorCaminho);
        }

    }

    private static No pegarMenorDistanciaDeNo(Set<No> noNaoResolvido){
        
        int noMenor;
        No menorDistanciaDeNo = null;
        int menorDistancia = Integer.MAX_VALUE;

        for(No atual : noNaoResolvido){
            noMenor = atual.getDistancia();
            if(noMenor < menorDistancia){
                menorDistancia = noMenor;
                menorDistanciaDeNo = atual;
            }
        }

        return menorDistanciaDeNo;
    }

}
