package SQL.Tablolar;

import java.sql.Statement;
import java.util.ArrayList;
import Omer.MessageBox;

public class Urun extends Tablolar{
    public Urun()
    {
        super(Sutünler, isim, Olustur, KayitOlustur);
    }
    //Urun(int ID,String Kategori,String Marka, String İsim, String Fotograf, double Fiyat, String FiyatBirimi, String Aciklama)

    public static String[] Sutünler = {"ID", "Kategori", "Marka", "İsim", "Fotograf", "Fiyat", "FiyatBirimi", "Aciklama"};
    public static String AdminAd = Sutünler[1], AdminSifre = Sutünler[2];
    public static String 
    isim = "Urun"
    ,Olustur = "CREATE TABLE "+isim+" (ID int NOT NULL, Kategori varchar(100), Marka varchar(100), İsim varchar(100), Fotograf varchar(100), Fiyat NUMERIC(7,2), FiyatBirimi varchar(20), Aciklama varchar(1000))"
    ,KayitOlustur = "INSERT INTO "+isim+" (ID, Kategori, Marka, İsim, Fotograf, Fiyat, FiyatBirimi, Aciklama) VALUES";


    @Override
    public void kayitOlustur(Statement stmt)
    {
        ArrayList<String> values = new ArrayList<String>();
        for (int i=0;i<WinForms.Config.AnasayfaDesigner.Urunler.Moda.length;i++)
        {
            WinForms.Items.AnasayfaDesigner.Urun urun = WinForms.Config.AnasayfaDesigner.Urunler.Moda[i];
            values.add("("+urun.getID()+ ",'"+urun.getKategori()+"','"+urun.getMarka()+"','"+urun.getİsim()+"','"+urun.getFotograf()+"',"+urun.getFiyat()+",'"+urun.getFiyatBirimi()+"','"+urun.getAciklama()+"')");;
        }
        for (int i=0;i<WinForms.Config.AnasayfaDesigner.Urunler.Ev.length;i++)
        {
            WinForms.Items.AnasayfaDesigner.Urun urun = WinForms.Config.AnasayfaDesigner.Urunler.Ev[i];
            values.add("("+urun.getID()+ ",'"+urun.getKategori()+"','"+urun.getMarka()+"','"+urun.getİsim()+"','"+urun.getFotograf()+"',"+urun.getFiyat()+",'"+urun.getFiyatBirimi()+"','"+urun.getAciklama()+"')");;
        }
        for (int i=0;i<WinForms.Config.AnasayfaDesigner.Urunler.Mobilya.length;i++)
        {
            WinForms.Items.AnasayfaDesigner.Urun urun = WinForms.Config.AnasayfaDesigner.Urunler.Mobilya[i];
            values.add("("+urun.getID()+ ",'"+urun.getKategori()+"','"+urun.getMarka()+"','"+urun.getİsim()+"','"+urun.getFotograf()+"',"+urun.getFiyat()+",'"+urun.getFiyatBirimi()+"','"+urun.getAciklama()+"')");;
        }
        for (int i=0;i<WinForms.Config.AnasayfaDesigner.Urunler.Kozmetik.length;i++)
        {
            WinForms.Items.AnasayfaDesigner.Urun urun = WinForms.Config.AnasayfaDesigner.Urunler.Kozmetik[i];
            values.add("("+urun.getID()+ ",'"+urun.getKategori()+"','"+urun.getMarka()+"','"+urun.getİsim()+"','"+urun.getFotograf()+"',"+urun.getFiyat()+",'"+urun.getFiyatBirimi()+"','"+urun.getAciklama()+"')");;
        }
        for (int i=0;i<WinForms.Config.AnasayfaDesigner.Urunler.Teknoloji.length;i++)
        {
            WinForms.Items.AnasayfaDesigner.Urun urun = WinForms.Config.AnasayfaDesigner.Urunler.Teknoloji[i];
            values.add("("+urun.getID()+ ",'"+urun.getKategori()+"','"+urun.getMarka()+"','"+urun.getİsim()+"','"+urun.getFotograf()+"',"+urun.getFiyat()+",'"+urun.getFiyatBirimi()+"','"+urun.getAciklama()+"')");;
        }
        for (int i=0;i<WinForms.Config.AnasayfaDesigner.Urunler.Teknoloji.length;i++)
        {
            WinForms.Items.AnasayfaDesigner.Urun urun = WinForms.Config.AnasayfaDesigner.Urunler.Teknoloji[i];
            values.add("("+urun.getID()+ ",'"+urun.getKategori()+"','"+urun.getMarka()+"','"+urun.getİsim()+"','"+urun.getFotograf()+"',"+urun.getFiyat()+",'"+urun.getFiyatBirimi()+"','"+urun.getAciklama()+"')");;
        }
        try 
        {
            for (int i=0;i<values.size();i++)
            {
                String sqlcode = KayitOlustur+"\n";
                sqlcode += values.get(i);
                stmt.executeUpdate(sqlcode);
                //if (i!= values.size()-1)
                //{
                //    sqlcode += ",\n";
                //}
            }
        } catch (Exception e) {
            MessageBox.Show(e.getMessage(), "Tablolar.kayitOlustur() hatası", MessageBox.Error);
        }
        
    }
}
