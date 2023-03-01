package SQL;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import Omer.*;
import SQL.Tablolar.*;

public class VeritabanIslemleri 
{
    public static VeritabanIslemleri vt;
    // pgAdmin veritabanı bağlama
    static String db_type = "postgresql";
    static String db_host="localhost";
    static int    db_port=5432;
    static String db_user="postgres";
    static String db_pass="omerserver1";
    static String db_name="Uygulama".toLowerCase();
    static boolean SSLmode = false;

    VeritabanIslemleri(String programType, String host,int port, String username, String password, String databaseName, Boolean SSLmode)
    {
        db_type = programType;
        db_host = host;
        db_port = port;
        db_user = username;
        db_pass = password;
        Veritaban.isim = Omer.Util.IsNullOrEmpty(databaseName) ? "" : databaseName; //databaseName boş yada null olup olmadığı kontrol et
        Calistir();
    }
    VeritabanIslemleri(String programType, String host,int port, String username, String password, Boolean SSLmode)
    {
        db_type = programType;
        db_host = host;
        db_port = port;
        db_user = username;
        db_pass = password;
        Calistir();
    }
    public VeritabanIslemleri()
    {
        Calistir();
    }
    public Connection con;
    public Statement stmt;
    private boolean IsClosed = false;
    private void Calistir() // Tamamalandı
    {
        String url = "jdbc:"+db_type+"://"+db_host+":"+db_port+"/";
        Properties props = new Properties();
        props.setProperty("user", db_user);
        props.setProperty("password", db_pass);
        props.setProperty("sslmode", SSLmode ? "enable" : "disable");
        try 
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, props);
            IsClosed = SQL.IsConnected(con);
            stmt = con.createStatement();
            System.out.println("SQL bağlantı durumu: "+ (IsClosed ? "Bağlandı." : "Bağlama başarısız oldu."));
            VeritabanKontrol();
        } catch (Exception e) 
        {
            MessageBox.Show(e.getMessage(), "SQL ile igili hata var.", MessageBox.Error);
        }
    }
    public void Kapat() //Tamamlandı
    {
        try {
            if (!SQL.IsConnected(con))
                System.out.println("Veritaban bağlantısı zaten kesildi.");
            else
            {
                con.close();
                System.out.println("Veritaban bağlantısı başarıyla kesildi.");
                IsClosed = true;
            }

        } catch (Exception e) {
            MessageBox.Show("Connection kapatılmadı: " + e.getMessage(), "Kapat()", MessageBox.Error);
        }
    }
    private void VeritabanKontrol() // Tamamlandı
    {
        try 
        {
            String[] VeriListesi = SQL.ListDatabase(stmt);
            boolean VeritabanVarmi = false;
            for (int i=0;i<VeriListesi.length;i++) // Veritaban var mı kontrol et.
                VeritabanVarmi = VeriListesi[i].equals(db_name.toLowerCase()) ?  true : VeritabanVarmi;
            if (!VeritabanVarmi) // Yok. Yeni veritaban oluştur
            {
                stmt.executeUpdate(Veritaban.Olustur);
                YenidenCalistir(true);
                System.out.println("Veritaban ve tablo oluşturuldu. Veritaban bağlı: " + SQL.GetDatabase(con));
            }
            else
                System.out.println("Veritaban mevcut. Veritaban bağlı: " + SQL.GetDatabase(con));
            if (SQL.GetDatabase(con) != db_name)
            {
                System.out.println("Veritaban eşt değil. con: " + SQL.GetDatabase(con) + " static: " + db_name);
                YenidenCalistir(true);
            }
            else
                System.out.println("Veritaban eşittir. con: " + SQL.GetDatabase(con) + " static: " + db_name);
            System.out.println("Tablo Gereksinimleri kontrol ediliyor...");
            for (int i=0;i<Veritaban.TabloGereksinimleri.length;i++)
            {
                Tablolar tablo = Veritaban.TabloGereksinimleri[i];
                String Tabloisim = tablo.getİsim();
                System.out.print(i+") " + Tabloisim);
                boolean TabloVarmi = SQL.FindTable(stmt, Tabloisim);
              

                if (!TabloVarmi)
                {
                    tablo.olustur(stmt);
                    tablo.kayitOlustur(stmt);
                    System.out.print(" oluşturuldu.");
                }
                else
                    System.out.print(" OK");
            }

        } 
        catch (Exception e) 
        {
            MessageBox.Show(e.getMessage(), "VeritabanKontrol() hatası", MessageBox.Error);
        }
    }
    private void YenidenCalistir(boolean VeritabanKullan) //Tamamlandı
    {
        try 
        {
            if (SQL.IsConnected(con))
                Kapat();
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:"+db_type+"://"+db_host+":"+db_port+"/" +(VeritabanKullan ? db_name : "");
            String username = db_user;
            String password = db_pass;
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            IsClosed = con.isClosed();
            System.out.println("Yeniden SQL bağlantı çalıştırıldı. Bağlı DB: " + con.getCatalog());
        } catch (Exception e) 
        {
            MessageBox.Show(e);
        }
    }
    public Boolean GirisYap(String Kullanici,String Sifre)
    {
        String sorgu = "SELECT * FROM " + Admin.isim +" WHERE " + Admin.AdminAd +"='"+Kullanici+"' AND "+ Admin.AdminSifre+"='"+Sifre+"' ";
        String sorgu2 = "SELECT * FROM " + Musteri.isim +" WHERE " + Musteri.KullaniciAd +"='"+Kullanici+"' AND "+ Musteri.Sifre+"='"+Sifre+"' ";
        try 
        {
            PreparedStatement prep = con.prepareStatement(sorgu);
            ResultSet rs = prep.executeQuery();
            Boolean sonuc = rs.next();
            if (sonuc)
                return true;
            prep = con.prepareStatement(sorgu2);
            rs = prep.executeQuery();
            return rs.next();
        } catch (Exception e) 
        {
            return false;
        }
    }
    public void TableToSysout()
    {
        JTable table = new JTable();
        table.setModel(Veritaban.Musteri.Sorgu(stmt));
        JFrame win = new JFrame();
        JScrollPane scrollPane = new JScrollPane(table);
        win.setSize(500,500);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.add(scrollPane);
        win.setVisible(true);

        /*Tablolar.TabloVerisi veri = Veritaban.Musteri.SorguTabloVerisi(stmt);
        System.out.println("-----------------------");
        for (String sutun : veri.Sutunler) {
            System.out.print(sutun+" ");
        }
        System.out.println("-----------------------");
        for (String[] satirler : veri.Satirlar )
        {
            for (String satir : satirler) 
            {
                System.out.print(satir +" ");
            }
            System.out.println("");
        }*/

    }
    public boolean UyeOl(String adSoyad,String kullaniciAd, String Sifre, String SifreTekrar, String adres, String mail, String telNo)
    {
        String sorgu = "SELECT * FROM " + Musteri.isim +" WHERE " + Musteri.KullaniciAd +"='"+kullaniciAd+"'";
        String sorgu2 = "INSERT INTO " + Musteri.isim + " (AdSoyad, Adres,KullaniciAd,Sifre, Mail, TelNo) VALUES "+
        "('"+adSoyad+"','"+adres+"','"+kullaniciAd+"','"+Sifre+"','"+mail+"','"+telNo+"')";
        String sorgu3 = "INSERT INTO " + Bakiye.isim + " (musteriid, bakiye, harcananbakiye) VALUES ";
        try 
        { 
            //Üye mevcut olup olmadığı kontrol edilecektir.
            PreparedStatement prep = con.prepareStatement(sorgu);
            ResultSet rs = prep.executeQuery();
            //rs.next()'in returnu bir boolean'dir.
            if (rs.next()) //Eğer zaten üye mevcut ise mesaji kutusu gösterecek. 
            {
                MessageBox.Show("Zaten üye var.", "Veritaban", MessageBox.Information);
                return false;
            }
            //üye oluşturuluyor.
            prep = con.prepareStatement(sorgu2);
            prep.executeUpdate();

            //Oluşturulan üye müşteri id bilgisi al ve alınan müşteri id ile bakiye oluşturacak
            // Sütunler ve Satırlar müşteri bilgisi al
            Tablolar.TabloVerisi veri = Veritaban.Musteri.SorguTabloVerisi(stmt);
            for (int i = 0; i <veri.Satirlar.length;i++)
            {
                // 2 sıralı sütun adı kullaniciad'dir.
                if (veri.Satirlar[i][2].trim().equals(kullaniciAd.trim())) // Satırdaki kullanici adı eşitse
                {
                    String musteriid=  veri.Satirlar[i][0];// Müşteriid değeri al
                    // Yeni bakiye satırı oluşturacak sorgu değişkeni atanacak
                    sorgu3 += " ("+musteriid + ",0,0)";
                    break;
                }
            }
            System.out.println(sorgu3);
            // Yeni bakiye satırı oluşturacak
            prep = con.prepareStatement(sorgu3);
            prep.executeUpdate();
            // Bitti. 
            return true;
        } 
        catch (Exception e) 
        {
            MessageBox.Show(e.getMessage(), "Üye olma başarısız", MessageBox.Error);
            return false;
        }
    }
    public boolean MusteriSifreDegistir(String YeniSifre, String kullaniciAd)
    {
        String sorgu = "UPDATE " + Musteri.isim + " SET sifre='"+YeniSifre+"' WHERE kullaniciad='" + kullaniciAd + "'";

        try 
        { PreparedStatement prep = con.prepareStatement(sorgu);
            prep.executeUpdate();
            return true;}
            catch (Exception e) 
            {
                MessageBox.Show(e.getMessage(), "Veritaban", MessageBox.Error);
                return false;
            }
    }
    public boolean MusteriBilgileriGuncelle(Hesabim EskiHesabi, Hesabim YeniHesabi )
    {
        String sorgu = "UPDATE " + Musteri.isim + 
        " SET adsoyad='"+YeniHesabi.getAdSoyad()+"',"+
        "Kullaniciad='"+YeniHesabi.getKullaniciAd()+"',"+
        "adres='"+YeniHesabi.getAdres()+"',"+
        "mail='"+YeniHesabi.getMail()+"',"+
        "telno='"+YeniHesabi.getTelNo()+"'"+

        "WHERE musteriid='" + EskiHesabi.getMusteriID() + "'";
        try 
        { PreparedStatement prep = con.prepareStatement(sorgu);
            prep.executeUpdate();
            return true;}
            catch (Exception e) 
            {
                MessageBox.Show(e.getMessage(), "Veritaban", MessageBox.Error);
                return false;
            }
    }
    public boolean MusteriKrediKartGuncelle(Hesabim YeniHesabi )
    {
        // xtAdsoyad, txtKullaniciad, txtAdres, txtMail, txtTelno;
        String sorgu = "UPDATE " + Bakiye.isim + 
        " SET kredikartino='"+YeniHesabi.getKrediKartiNo()+"',"+
        "krediadsoyad='"+YeniHesabi.getKrediadsoyad()+"',"+
        "ay="+YeniHesabi.getAy()+","+
        "yil="+YeniHesabi.getYil()+","+
        "cvv="+YeniHesabi.getCVV()+" "+

        "WHERE musteriid='" + YeniHesabi.getMusteriID() + "'";
        try 
        { PreparedStatement prep = con.prepareStatement(sorgu);
            prep.executeUpdate();
            return true;}
            catch (Exception e) 
            {
                MessageBox.Show(e.getMessage(), "Veritaban", MessageBox.Error);
                return false;
            }
    }
    public boolean Update(String From, String SutunAdi, String setValue, String WhereDegisken, String WhereValue)
    {
        String sorgu = "UPDATE " + From + " SET " + SutunAdi +"='"+setValue+"' WHERE " + WhereDegisken + "='" + WhereValue + "'";
        try 
        { PreparedStatement prep = con.prepareStatement(sorgu);
            prep.executeUpdate();
            return true;}
            catch (Exception e) 
            {
                MessageBox.Show(e.getMessage(), "Veritaban", MessageBox.Error);
                return false;
            }
    }
    public boolean Harca(String musteriid, double harcanacakMiktari)
    {
        String sorgu = "UPDATE " + Bakiye.isim + " SET bakiye = (bakiye-"+harcanacakMiktari+") WHERE musteriid=" + musteriid + "";
        try 
        { PreparedStatement prep = con.prepareStatement(sorgu);
            prep.executeUpdate();
            return true;}
            catch (Exception e) 
            {
                MessageBox.Show(e.getMessage(), "Veritaban", MessageBox.Error);
                return false;
            }
    }
    public Boolean BakiyeYukle(String musteriid, String miktari) 
    {
        String sorgu = "UPDATE " + Bakiye.isim + " SET bakiye = (bakiye+"+miktari+") WHERE musteriid=" + musteriid + "";
        try 
        {   PreparedStatement prep = con.prepareStatement(sorgu);
            prep.executeUpdate();
            return true;}
        catch (Exception e) 
        {
            MessageBox.Show(e.getMessage(), "Veritaban", MessageBox.Error);
            return false;
        }
    }
    public Boolean VeritabanSifirla()
    {
        try 
        { 
            Kapat();
            YenidenCalistir(false);
            Statement st = con.createStatement();
            st.executeUpdate("DROP DATABASE "+VeritabanIslemleri.db_name+" WITH (FORCE);");
            return true;
        }
        catch (Exception e) 
        {
            MessageBox.Show(e.getMessage(), "Veritaban sıfırlarken hata oluştu.", MessageBox.Error);
            return false;
        }
    }

}
