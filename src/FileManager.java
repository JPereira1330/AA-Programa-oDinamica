import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileManager {
 
    public static String readFile(String caminho) throws Exception{

        String linha;
        String retorno;
        BufferedReader buffRead;
        
        buffRead = new BufferedReader(new FileReader(caminho));
        if(buffRead == null){
            buffRead.close();
            return "";
        }

        linha = "";
        retorno = "";
        do{

            if(linha != null){
                retorno += linha;
            }else{
                break;
            }

            linha = buffRead.readLine();

        }while(true);

        buffRead.close();

        return retorno;
    }

}
