import java.util.Scanner;

public class Interface {
    
    private static String saida;
    private static String entrada;

    public static void printMenu(){

        Scanner scan;
        scan = new Scanner(System.in);

        System.out.println(" \t === > UMA NOITE NO MUSEU < ===");
        System.out.print(" [ * ] Entrada: ");
        entrada = scan.nextLine();

        System.out.print(" [ * ] Saida: ");
        saida = scan.nextLine();
    }

    public static String getSaida(){
        return saida;
    } 

    public static String getEntrada(){
        return entrada;
    } 
}
