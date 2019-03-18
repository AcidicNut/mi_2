public class Word {
    public int word;
    public int pos = 0, neg = 0;
    public double rate = 0.0;

    public Word(int str){
        word = str;
    }

    public void adjustPosNeg(boolean pos) {
        if (pos)
            this.pos++;
        else
            this.neg++;
    }
}