public class App {

    public static void main(String[] args) throws Exception {

        Grafo grafo;
        BancoDados db;
        String entrada, saida;

        db = new BancoDados();

        System.out.println(  args.length != 0 ? " [ * ] Utilizando o grafo do arquivo: "+args[0]+".\n" 
        : " [ * ] Utilizando o grafo hardcode.\n");

        do{
            Interface.printMenu();
            entrada = Interface.getEntrada();
            saida = Interface.getSaida();

            // @BUG_FIX - Toda vez que calcula o grafo, mexe nos pesos, logo é necessario recarregar o grafico.
            if(args.length != 0)
                grafo = GrafoManager.grafoByArquivo(args[0]);
            else
                grafo = GrafoManager.grafoByHardCode();

            switch(db.exibirCaminho(entrada, saida)){

                case -1:    // Caso não encontrado no banco
                    grafo = Dijkstra.calcularPesoDoGrafo(grafo, grafo.getNoByKey(entrada));
                    db.adicionarNoBanco(grafo.getNoByKey(entrada).getNome(), grafo);
                    db.exibirCaminho(entrada, saida);
                    break;

                case 2:     // Tentando reutilizar a resposta
                    if(db.exibirCaminhoReutilizado(entrada, saida) == -1){
                        grafo = Dijkstra.calcularPesoDoGrafo(grafo, grafo.getNoByKey(entrada));
                        db.adicionarNoBanco(grafo.getNoByKey(entrada).getNome(), grafo);
                        db.exibirCaminho(entrada, saida);
                    }
                    break;

            }

            System.out.println(db.getRetorno());

        }while(true);

    }

}
