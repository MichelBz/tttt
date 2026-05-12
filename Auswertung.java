public class Auswertung
{
    Zahlenspeicher sp;
    public Auswertung()
    {

    }

    public void mach(int n, int m, int p){
        long summe = 0;
        for(int i = 0; i<p; i++){
            sp = new Zahlenspeicher(n, m);
            summe += sp.sortiere();
        }
        long schnitt = summe/p;
        System.out.println("Anz. Zahlen: "+n+"       Zahlenbereich: "+m);
        System.out.println("Durchschnittliche Zeit: "+schnitt);
    }
}
