import java.io.IOException;
import java.util.StringTokenizer;

public class InputHandler {

    public static void readInput() throws IOException {
        String thisLine;
        for (int i = 0; i < Main.Minta; ++i) {
            thisLine = Main.br.readLine();
            if (!thisLine.equals("")) {
                Main.sentences[i] = new Sentence(thisLine);
                StringTokenizer st = new StringTokenizer(thisLine, "\t");

                while (st.hasMoreElements()) {
                    addWord(Integer.valueOf(st.nextToken()));
                }
            }
        }

        for (int i = 0; i < Main.Minta; i++) {
            thisLine = Main.br.readLine();
            if (Main.sentences[i] != null) {
                if (thisLine.equals("")) {
                    Main.sentences[i].result = 0;
                } else {
                    Main.sentences[i].result = Integer.valueOf(thisLine);
                }
                StringTokenizer st = new StringTokenizer(Main.sentences[i].sentence, "\t");
                while (st.hasMoreElements()) {
                    findWord(Integer.valueOf(st.nextToken())).adjustPosNeg(Main.sentences[i].result==1);
                    if (Main.sentences[i].result==1)
                        Main.posRes++;
                }
            }
        }
    }

    public static void addWord(int str) {
        for (Word w :
                Main.words) {
            if (w.word == str)
                return;
        }
        Main.words.add(new Word(str));
    }

    public static Word findWord(int str) {
        for (Word w :
                Main.words) {
            if (w.word == str)
                return w;
        }
        return null;
    }

    public static void setAllRates() {
        for (Word w :
                Main.words) {
            w.rate = ((float) w.pos / (float)(w.pos + w.neg));
        }
    }
}
