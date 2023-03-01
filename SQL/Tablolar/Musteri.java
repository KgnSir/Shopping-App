package SQL.Tablolar;
public class Musteri extends Tablolar
{
    public Musteri()
    {
        super(Sutünler, isim, Olustur, KayitOlustur);
    }
    static String[] Sutünler = {"MusteriID", "AdSoyad","KullaniciAd","Sifre","Adres", "Mail", "TelNo"};
    public static String KullaniciAd = "KullaniciAd";
    public static String Sifre = "Sifre";
    public static String isim = "musteri";
    static String Olustur = "CREATE TABLE "+isim+"(MusteriID int NOT NULL GENERATED ALWAYS AS IDENTITY, AdSoyad varchar(50), KullaniciAd varchar(16), Sifre varchar(16), Adres varchar(255), Mail varchar(50), TelNo varchar(30))";
    static String KayitOlustur = "INSERT INTO "+isim+" (AdSoyad, KullaniciAd,Sifre,Adres, Mail, TelNo) VALUES "+
    "('Enes Kellaş','enes24','enes1', 'Aşkın Sokak 157 06307 Balıkesir', 'emrel5.kellas@gmail.com', '0540 936 74 37')";

    ;
    /*public JTable Sorgu(Connection con, Tablolar sqltablosu)
    {
        try 
        {
            // Bir JTable ve DefaultTableModel oluşturun
            JTable table = new JTable();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Modelle sütunlar ekleyin
            for (String sutun : sutunler) 
                model.addColumn(sutun);

            // Sorgu çalıştır.
            ResultSet resultSet = con.createStatement().executeQuery("SELECT * FROM " + sqltablosu.getName());

            // ResultSet'i döndürün ve her satır verisini model'e ekleyin

            while (resultSet.next()) 
            {
                
                int id = resultSet.getInt("id");
                String ad = resultSet.getString("ad");
                int yaş = resultSet.getInt("yaş");
                model.addRow(new Object[] { id, ad, yaş });
            }
            return table;
        } catch (Exception e) 
        {
            MessageBox.Show(e);
            return null;
        }
        
    }*/
}
