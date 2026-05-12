public class Zahlenspeicher
{
    private int[] a;
    private int n,m;
    
    public Zahlenspeicher(int np, int mp){
        //n = 1000;
        //m = 1000;
        
        n = np;
        m = mp;
        a = new int[n+1];
        
        for (int i=1; i<=n; i++){
            a[i] = (int) (Math.random()*m+1);
        }
    }
    
    public long sortiere(){
        long zeit1, zeit2;
        zeit1 = System.currentTimeMillis();
        
        quickSort();
        
        zeit2 = System.currentTimeMillis();
        long zeitdifferenz = zeit2 - zeit1;
        System.out.println("Zeit: "+zeitdifferenz);
        return zeitdifferenz;
    }
    
    public void heapsort() {
        //Phase Aufbau
        for (int i = 1; i<=n; i++) {
            int x = i;
            if(i > 1) {
                int vergleichszahl = 0;
                if(i % 2 == 1) {
                    vergleichszahl = (i-1)/2;
                }
                else{
                    vergleichszahl = i/2;
                }
                while (a [x] < a [vergleichszahl] ) {
                    int speicher = a[vergleichszahl];
                    a[vergleichszahl] = a[x];
                    a[x] = speicher;
                    x = vergleichszahl;
                    if(i % 2 == x) {
                        vergleichszahl = (x-1)/2;
                    }
                    else{
                        vergleichszahl = x/2;
                    }
                }
            }
        }
        int[] feld = new int[n+1];
        int last = n;
        for(int i = 1; i<=n; i++){
            feld[i] = a[1];
            a[1] = a[last];
            int akt = 1;
            while(akt*2+1 <= last && (a[akt] > a[akt*2] || a[akt] > a[akt*2+1])){
                if(a[akt*2] <= a[akt*2+1]){
                    int speicher2 = a[akt*2];
                    a[akt*2] = a[akt];
                    a[akt] = speicher2;
                    akt = akt*2;
                } else{
                    int speicher2 = a[akt*2+1];
                    a[akt*2+1] = a[akt];
                    a[akt] = speicher2;
                    akt = akt*2+1;
                }
            }
            last -= 1;
        }
        for(int i = 1; i<=n; i++)
            a[i] = feld[i];
    }
    
    public int[] QuicksortV1(int[] feld2sort, int n) {
        //int pivotIndex = (int) (Math.random() * n + 1);
        int pivotIndex = 1;
        int pivotWert = feld2sort[pivotIndex];
    
        int l = 0;
        int m = 0;
        int r = 0;
    
        int[] links = new int[n + 1];
        int[] rechts = new int[n + 1];
    
        for (int i = 1; i <= n; i++) {
            if (feld2sort[i] < pivotWert) {
                l++;
                links[l] = feld2sort[i];
            }
            else if (feld2sort[i] > pivotWert) {
                r++;
                rechts[r] = feld2sort[i];
            }
            else {
                m++;
            }
        }
    
        if (l > 1)
            links = QuicksortV1(links, l);
        if (r > 1)
            rechts = QuicksortV1(rechts, r);
    
        for (int i = 1; i <= l; i++)
            feld2sort[i] = links[i];
    
        for (int i = 1; i <= m; i++)
            feld2sort[i + l] = pivotWert;
    
        for (int i = 1; i <= r; i++)
            feld2sort[i + m + l] = rechts[i];
    
        return feld2sort;
    }

    
    public void quickSort(){
        a = QuicksortV1(a, n);
        //int pivot = 1;
        //this.quickTeilen(pivot, n);
    }
    
    public void quickTeilen(int pivot, int ende){
        int z = pivot;
        int[] b = new int[n+1];
        b=a;
        
        for(int i = pivot; i <= ende; i++){
            if (a[i] < a[pivot] && i!=pivot){
                b[z] = a[i];
                z++;
                
                System.out.println("in schleife1: "+z);
                for (int l=1; l<=n; l++){
                    System.out.println(l+"_: " +  b[l]);
                }
            }
        }
        b[z] = a[pivot];
        z++;
        System.out.println("bei pivot"+z);
        int neuPivot = z;
        
        
        for (int l=1; l<=n; l++){
                    System.out.println(l+"_: " +  b[l]);
                }
        for(int i = pivot; i <= ende; i++){
            if (a[i] >= a[pivot] && i!=pivot){
                System.out.println("in schl"+z);
                b[z] = a[i];//z wird groesser als das array
                z++;
            }
        }
        
        druckeDich();
        a = b;
        /**
        for (int i = pivot; i <= ende; i++){
            a[i] = b[i];
        }**/
        
        
        
        if (pivot < ende || neuPivot < n)
            this.quickTeilen(neuPivot, ende);
        if (pivot < ende)
            this.quickTeilen(pivot, neuPivot-1);
    }
    
    public void sorsorSort(){
        for (int i = 1; i < a.length-1; i++){
            int min = minimum(i);
            
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
    
    public void bubbleSort(){
        boolean sortiert = false;
        while (!sortiert){
            sortiert = true;
            for (int i = 0; i < a.length-1; i++){
                if (a[i] > a[i+1]){
                    sortiert = false;
                    
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
        }
    }

    public void druckeDich(){
        for (int i=1; i<=n; i++){
            System.out.println(i+": " +  a[i]);
        }
    }

    public int maximum(){
        int max=0;
        
        for (int i=1; i<=n; i++){
            if(a[i]>a[max]){
                max=i; 

            }
        }
        return a[max];
    }

    public int minimum(int p){
        int min=p;
        for (int i=p; i<=n; i++){
            if(a[i]<a[min]){
                min=i;
            }
        }
        return min;
    }
    
    public boolean checkSortiert(){
        boolean sortiert = true;
        for (int i = 0; i < a.length-1; i++){
            if (a[i] > a[i+1]){
                sortiert = false;
            }
        }
        return sortiert;
    }

    public double durchschnitt(){  
        double sum = 0;
        for (int i=1; i<=n; i++){
            sum += a[i];
        }
        // System.out.println("summe " + sum);
        //System.out.println("schniitt " + sum/n);

        return sum/n;
    }
}
