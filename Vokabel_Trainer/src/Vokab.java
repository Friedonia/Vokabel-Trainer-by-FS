import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;

public class Vokab
{
    int[] alphSortEN = {};
    int[] alphSortDE = {};
    int[] alphSortVal = {};


    public Vokab(){}

    public void sortVal(){
        int[] betaSortVal = {};
        alphSortVal = new int[]{};
        for(int i = 0; i< getCount(); i++){
            alphSortVal = arrayAdd(alphSortVal, i);
            betaSortVal = arrayAdd(betaSortVal, getVokValue(i));
        }
        for(int i = 1; i< betaSortVal.length; i++){
            int a = 0;
            int c = 0;
            for(int b = 0; b < i; b++){
                a = getVokValue(i- 1- b);
                c = getVokValue(i-b);
                if (a < c){
                    alphSortVal=  moveUp(alphSortVal, i);
                    betaSortVal = moveUp(betaSortVal, i);
                } else { break; }
            }
        }
    }

    public int[] arrayAdd(int[] array, int a)
    {
        int[] intArray = array;
        int o = intArray.length;
        int[] SecondArray = new int[o+1];

        System.arraycopy(intArray, 0, SecondArray, 0, o);

        SecondArray[o] = a;

        intArray = SecondArray;

        return intArray;
    }

        public int[] moveUp(int[] arr,int index){
            int value;
            int arrayLength = arr.length;
            if (arrayLength > index && index > 0){
                value = arr[index];
                arr[index] = arr[index-1];
                arr[index-1] = value;
            }
        return arr;
        }



    public void liesVokabelnEin() {
        try(FileReader reader = new FileReader("VokList.csv")){

            BufferedReader in = new BufferedReader(reader);
            String zeile = null;
            while ((zeile = in.readLine()) != null) {
                String[] vok = zeile.split(",");
                String dt = vok[0];
                String en = vok[1];  
                // Vokabel erstellen und in die List einfügen


                System.out.println("dt:" + dt + " eng:" + en);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int getCount(){
        int Anzahl = 0;
        try(FileReader reader = new FileReader("VokList.csv")){

            BufferedReader in = new BufferedReader(reader);
            String zeile = null;
            while ((zeile = in.readLine()) != null) {
                Anzahl ++;
            }
            return Anzahl;
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //für die Zukunft, soll random Vokabel liefern
    public int randomVok(){
        Random rand = new Random();
        return rand.nextInt(getCount());
    }

    //sortieren nach Alphabet
    public void getNextAlp(){
        int v[] = {};
        int anzahl = getCount();
        for(int i = 0; i < anzahl; i++){
            if (alphSortEN == v) {
                alphSortEN[0] = 0;
            } else {
            }
        }
    }
    //sortieren nach Schwierigkeit
    public void getNextVal(){}

    //Funktion um von spezifischer Vokabel die Value zu bekommen 
    public int getVokValue(int Nr){
        String VALvok = "";
        int aktuelNr = 0;
        try(FileReader reader = new FileReader("VokList.csv")){

            BufferedReader in = new BufferedReader(reader);
            String zeile = null;
            while ((zeile = in.readLine()) != null) {
                if (Nr == aktuelNr){
                    String[] vok = zeile.split(",");
                    VALvok = vok[2];
                }
                aktuelNr += 1;
            }
            return Integer.parseInt(VALvok);
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }   


    public String getVokDE(int Nr){
        String DEvok = "";
        int aktuelNr = 0;
        try(FileReader reader = new FileReader("VokList.csv")){

            BufferedReader in = new BufferedReader(reader);
            String zeile = null;
            while ((zeile = in.readLine()) != null) {
                if (Nr == aktuelNr){
                    String[] vok = zeile.split(",");
                    DEvok = vok[0];
                }
                aktuelNr += 1;
            }
            return DEvok;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }   

    public String getVokEN(int Nr){
        String ENvok = "";
        int aktuelNr = 0;
        try(FileReader reader = new FileReader("VokList.csv")){

            BufferedReader in = new BufferedReader(reader);
            String zeile = null;
            while ((zeile = in.readLine()) != null) {
                if (Nr == aktuelNr){
                    String[] vok = zeile.split(",");
                    ENvok = vok[1];
                }
                aktuelNr += 1;
            }
            return ENvok;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }   
    public void delete(String DeutscheVokabel, String EnglischeVokabel){
        File oldFile = new File("VokList.csv");
        File newFile = new File("temp.csv");
        String vDE = ""; String vEN = ""; String vVa = "";


        try (FileWriter fw = new FileWriter("temp.csv", true)) {

            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Scanner x = new Scanner(new File("VokList.csv"));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                vDE = x.next();
                vEN = x.next();
                vVa = x.next();
                if(!vDE.equals(DeutscheVokabel) && !vEN.equals(EnglischeVokabel) ){
                    pw.println(vDE +","+ vEN +","+vVa);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File("VokList.csv");
            newFile.renameTo(dump);

        } catch (Exception e) {}

    }
    //change a Vok Val
    public void setVal(String VDGWDe, String VDGWEn, int NewVal) throws IOException {
        File oldFile = new File("VokList.csv");
        File newFile = new File("temp.csv");
        String vDE = ""; String vEN = ""; String vVa = ""; 
        
        
        try (FileWriter fw = new FileWriter("temp.csv", true)) {

            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Scanner x = new Scanner(new File("VokList.csv"));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                vDE = x.next();
                vEN = x.next();          
                vVa = x.next();          
                if(vDE.equals(VDGWDe) && vEN.equals(VDGWEn)){
                    pw.println(vDE +","+ vEN +","+NewVal);
                } else{
                    pw.println(vDE +","+ vEN +","+vVa);
                } 
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File("VokList.csv");
            newFile.renameTo(dump);
            
        } catch (Exception e) {}  
    }

    public void setVok(String VDGWDe, String VDGWEn, String newDe,String newEn ) throws IOException {
        File oldFile = new File("VokList.csv");
        File newFile = new File("temp.csv");
        String vDE = ""; String vEN = ""; String vVa = "";


        try (FileWriter fw = new FileWriter("temp.csv", true)) {

            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Scanner x = new Scanner(new File("VokList.csv"));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                vDE = x.next();
                vEN = x.next();
                vVa = x.next();
                if(vDE.equals(VDGWDe) && vEN.equals(VDGWEn)){
                    pw.println(newDe +","+ newEn +","+vVa);
                } else{
                    pw.println(vDE +","+ vEN +","+vVa);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File("VokList.csv");
            newFile.renameTo(dump);

        } catch (Exception e) {}
    }

    //add a Vok 
    public void add(String vDE, String vEN) throws IOException {

        // first create file object for file placed at location
        // specified by filepath
        BufferedReader in;
   
        try (FileWriter writer = new FileWriter("VokList.csv", true)) {

            StringBuilder sb = new StringBuilder();
            
            sb.append(vDE);
            sb.append(',');
            sb.append(vEN);
            sb.append(',');
            sb.append(0);
            sb.append('\n');

            writer.write(sb.toString());
            writer.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
