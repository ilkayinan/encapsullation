// ilkay inan s26128
/* 
1)
sum = 0;
for(int i = 0; i < N; i++) --> bu satir icin 0 dan N-1 e kadar donecek bu nedenle karmasiklik faktoru 0(N)
    for(int j = 0; j < N; j+=2) --> bu satir icin j 2 ser artiyor her donuste N/2 islem yapacak karmasiklik faktoru 0(N)
        sum+=2;--> burada tek bir islem yapıyor bu nedenle karmasiklik faktoru 0(1)
icice(nested) oldugu icin carpma kuralini uyguluyoruz. N*N*1
kodun karmasiklik faktoru O(n kare) oluyor yani quadratic algoritmadir.
*/
/* 
sum = 0;
for(int i = 0; i < N; i++)--> bu satir icin 0 dan N-1 e kadar donecek bu nedenle karmasiklik faktoru 0(N)
    sum*=2; --> burada tek bir islem yapıyor bu nedenle karmasiklik faktoru 0(1)
carpma kurali sebebiyle N*1 den, algoritma O(N) karmasiklik faktorune sahip oluyor.
*/
public class Calisan {
    private String isim;
    private String departman;
    private double maas;
    private int seviye;
    
    Calisan(String isim,String departman,double maas,int seviye){
        if (maas<0) throw new RuntimeException("Maaş negatif olamaz.");
        this.isim = isim;
        this.departman = departman;
        this.maas = maas;
        this.seviye = seviye;
    }
    String get_isim(){
        return isim;
    }
    String get_departman(){
        return departman;
    }
    double get_maas(){
        return maas;
    }
    int get_seviye(){
        return seviye;
    }
    private void set_departman(String dep){
        this.departman=dep;
    }
    
    private void set_maas(double maas){
        this.maas= maas;
    }
    private void set_seviye(int seviye){
        this.seviye = seviye;
    }
    double zamYap(int oran){
        if(oran==0) throw new RuntimeException("Zam 0 olamaz.");
        double zam=0;
        zam=(maas/100)*oran;
        set_maas((maas/100)*(100+oran));
        return zam;
    }
    
    double promosyonYap(){
        double zam2=0;
        if (seviye==5) throw new RuntimeException("Daha fazla promosyon yapılamaz.");
        set_seviye(seviye+1);
        zam2=(maas/100)*(seviye*5);
        set_maas((maas/100)*(100+(seviye*5)));
        return zam2;      
    }
    
    int toplamZam(int[ ] zamDizisi, int index){
        if (index==zamDizisi.length) return 0;
        return zamDizisi[index]+toplamZam(zamDizisi,index+1);    
    }
    public String toString(){
        return isim+", "+departman+", "+maas;
    }

    
}
