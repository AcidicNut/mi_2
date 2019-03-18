import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final int Test = 20000;
    public static final int Minta = 80000;
    public static Sentence[] sentences = new Sentence[Minta];
    public static ArrayList<Word> words = new ArrayList<>();
    public static int posRes = 0;
    public static String[] tesztek = new String[Test];
    static BufferedReader br;

    static {
        try {
            br = new BufferedReader(new FileReader("mi.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        InputHandler.readInput();
        InputHandler.setAllRates();

        PrintWriter pw = new PrintWriter("mi_out.txt");

        for (int i = 0; i < Test; ++i){
            tesztek[i] = br.readLine();
        }

        for (int i = 0; i < Test; ++i) {
            double positivity = 0;
            double db;
            Word tmp;
            try {
                if (/*!voltmar(tesztek[i]) && */tesztek[i] != null){
                    StringTokenizer st = new StringTokenizer(tesztek[i], "\t");
                    db = st.countTokens();
                    while ( st.hasMoreElements()){
                        tmp = InputHandler.findWord(Integer.valueOf(st.nextToken()));
                        if (tmp != null ){
                            positivity += tmp.rate;
                        }else{
                            db--;
                        }
                    }
                    if (db>0)
                        //System.out.println((positivity/db >= 0.5 ? 1 : 0));
                        pw.println((positivity/db >= 0.5 ? "\"1\\n\" + " : "\"0\\n\" + "));

                    else
                        //System.out.println(1);  //db == 0 ismeretlen szavak
                        pw.println("\"1\\n\" + ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        pw.close();
    }

    public static boolean voltmar(String str) {
        for (int i = 0; i < Minta; i++) {
            if (sentences[i] != null && sentences[i].sentence.equals(str)) {
               //System.out.println(sentences[i].result);
                return true;
            }
        }
        return false;
    }
}