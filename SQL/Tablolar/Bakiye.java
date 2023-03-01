package SQL.Tablolar;


public class Bakiye extends Tablolar
{

    public Bakiye()
    {
        super(Sutünler, isim, Olustur, KayitOlustur);
    }
    static String[] Sutünler = {"kullaniciAd", "bakiye","HarcananBakiye", "kredikartino", "krediadsoyad", "ay","yil","cvv"};
    public static String isim = "bakiye";
    static String Olustur = "CREATE TABLE "+isim+"(musteriid int NOT NULL, bakiye NUMERIC(15,2), HarcananBakiye NUMERIC(7,2), kredikartino varchar(50), krediadsoyad varchar(50), ay int, yil int, cvv int)";
    static String KayitOlustur = "INSERT INTO "+isim+" (musteriid, bakiye, HarcananBakiye, kredikartino, krediadsoyad, ay, yil, cvv) VALUES "+
    "(1, 5000, 0, '5654 4568 7567 5697', 'Enes ÇalıntıKarti', 10,25,548)";
    
}
