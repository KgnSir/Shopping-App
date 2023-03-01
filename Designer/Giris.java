package WinForms.Designer;


import Omer.MessageBox;
import SQL.*;
import SQL.Tablolar.Tablolar.TabloVerisi;

public class Giris
{
    Giris()
    {
        if (VeritabanIslemleri.vt == null)
            VeritabanIslemleri.vt = new VeritabanIslemleri();
    }
    public boolean GirisYap(String kullanici, String Sifre)
    {
        Boolean girisyaptimi = VeritabanIslemleri.vt.GirisYap(kullanici, Sifre);
        if (!girisyaptimi)
        {
            MessageBox.Show("Kullanıcı yada şifre yanlış", "Başarısız", MessageBox.Error);
            return false;
        }
        else
        {
            MessageBox.Show("Giriş yaptı!", "Başarılı", MessageBox.Information);
            return true;
        }
    }
    public Hesabim getHesabim(String kullanici)
    {
        TabloVerisi veri = Veritaban.Musteri.SorguTabloVerisi(VeritabanIslemleri.vt.stmt);
        Hesabim hesabi;
        for (int i = 0; i < veri.Satirlar.length; i++)
        {
            if (!veri.Satirlar[i][2].contains(kullanici))
                continue;
            hesabi = new Hesabim(
                veri.Satirlar[i][0],
                veri.Satirlar[i][1],
                veri.Satirlar[i][2], 
                veri.Satirlar[i][3], 
                veri.Satirlar[i][4], 
                veri.Satirlar[i][5], 
                veri.Satirlar[i][6]);
            return hesabi;
        }
        return null;
    }
   
}