package SQL.Tablolar;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.*;
import Omer.*;

public class Tablolar 
{
    public class TabloVerisi
    {
        public String[] Sutunler;
        public String[][] Satirlar;
        TabloVerisi(String[][] Satirlar, String[] Sutunler)
        {
            this.Satirlar = Satirlar;
            this.Sutunler = Sutunler;
        }
    }
    private String isim, Olustur, KayitOlustur;
    private String[] Sütunler;
    public String[] getSütunler() {return Sütunler;}
    public String getİsim() {return isim;}
    public String getOlustur() {return Olustur;}
    public String getKayitOlustur() {return KayitOlustur;}

    public void setSütunler(String[] Sütunler) {this.Sütunler = Sütunler;}
    public void setİsim(String isim) {this.isim = isim;}
    public void setOlustur(String Olustur) {this.Olustur = Olustur;}
    public void setKayitOlustur(String KayitOlustur) {this.KayitOlustur = KayitOlustur;}
    public String getName()
    {
        return getİsim();
    }
    public void olustur(Statement stmt)
    {
        try {stmt.executeUpdate(getOlustur());
        } catch (Exception e) {
            MessageBox.Show(e.getMessage(), "Tablolar.olustur() hatası", MessageBox.Error);
        }
    }
    public void kayitOlustur(Statement stmt)
    {
        try {stmt.executeUpdate(getKayitOlustur());
        } catch (Exception e) {
            MessageBox.Show(e.getMessage(), "Tablolar.kayitOlustur() hatası", MessageBox.Error);
        }

    } 
    Tablolar(String[] Sütunler, String isim,String Olustur,String KayitOlustur)
    {
        this.Sütunler = Sütunler;
        this.isim = isim;
        this.Olustur = Olustur;
        this.KayitOlustur = KayitOlustur;
    }
    public DefaultTableModel Sorgu(Statement stmt) {
        TabloVerisi veri = SorguTabloVerisi(stmt);
        return new DefaultTableModel(veri.Satirlar, veri.Sutunler);
    }
    public TabloVerisi SorguTabloVerisi(Statement stmt) {
        try 
        {
            ArrayList<String []> satırlar = new ArrayList<>();
            String[] Sutunler = this.getSütunler();
            // Sorgu çalıştır.
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + this.getİsim());
            // ResultSet'i döndürün ve her satır verisini Satırlar'a ekleyin
            while (resultSet.next()) 
            {
                String[] teksatir = new String[Sutunler.length];
                for (int i=1;i<=Sutunler.length;i++)
                    teksatir[i-1] = resultSet.getString(i);
                satırlar.add(teksatir);
            }
            return new TabloVerisi(Util.ArrayStringToString(satırlar),Sutunler);
        } catch (Exception e) 
        {
            MessageBox.Show(e);
            return null;
        }
    }
   
}