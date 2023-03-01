package SQL.Tablolar;

public class Admin extends Tablolar
{
    public Admin()
    {
        super(Sutünler, isim, Olustur, KayitOlustur);
    }
    public static String[] Sutünler = {"AdminID", "AdminKullanici", "AdminSifre"};
    public static String AdminAd = Sutünler[1], AdminSifre = Sutünler[2];
    public static String 
    isim = "yonetici"
    ,Olustur = "CREATE TABLE "+isim+" (AdminID int NOT NULL GENERATED ALWAYS AS IDENTITY, AdminKullanici varchar(20), AdminSifre varchar(20), MusteriID int)"
    ,KayitOlustur = "INSERT INTO "+isim+" (AdminKullanici, AdminSifre) VALUES"+
        "('admin','admin')";

}