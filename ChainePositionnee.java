public class ChainePositionnee{
    int x,y;
    String c;
    public ChainePositionnee(int a,int b, String d) {
        x=a; 
        y=b; 
        c=d;
    }
    public int getPosX() {
        return this.x;
    }
    public int getPosY() {
        return this.y;
    }
    public String getDessin() {
        return this.c;
    }
}
