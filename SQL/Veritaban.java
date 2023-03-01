package SQL;
import SQL.Tablolar.*;
public class Veritaban 
{

    //Eksiksiz veritaban oluşturacak
    public static String
      isim = VeritabanIslemleri.db_name
      ,Olustur = "CREATE DATABASE " + isim
      ,ErisimKaldir = "REVOKE CONNECT ON DATABASE "+isim+" FROM public;"
      ,Sil = "DROP DATABASE " + isim;
    //Eksiksiz tablolar kontrol edilecektir.
    public static Tablolar Musteri = new Musteri();
    public static Tablolar Admin = new Admin();
    public static Tablolar Urun = new Urun();
    public static Tablolar Bakiye = new Bakiye();
    public static Tablolar[] TabloGereksinimleri = {Musteri, Admin, Urun,Bakiye};


    
      
    
}
