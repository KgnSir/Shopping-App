package WinForms.Items.AnasayfaDesigner;
import java.awt.Dimension;
public class Urun 
{

    int ID;
    String Kategori, Marka, İsim, Fotograf,FiyatBirimi, Aciklama;
    Double Fiyat;
    Dimension FotografBoyutu = new Dimension(150,150);
    public Urun(int ID,String Kategori,String Marka, String İsim, String Fotograf, double Fiyat, String FiyatBirimi, String Aciklama)
    {
        this.ID = ID;
        this.Kategori = Kategori;
        this.Marka = Marka;
        this.İsim = İsim;
        this.Fotograf = Fotograf;
        this.Fiyat = Fiyat;
        this.FiyatBirimi = FiyatBirimi;
        this.Aciklama = Aciklama;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getKategori() {
        return Kategori;
    }
    public void setKategori(String kategori) {
        Kategori = kategori;
    }
    public String getMarka() {
        return Marka;
    }
    public void setMarka(String marka) {
        Marka = marka;
    }
    public String getİsim() {
        return İsim;
    }
    public void setİsim(String isim) {
        İsim = isim;
    }
    public String getFotograf() {
        return Fotograf;
    }
    public void setFotograf(String fotograf) {
        Fotograf = fotograf;
    }
    public double getFiyat() {
        return Fiyat;
    }
    public void setFiyat(Double fiyat) {
        Fiyat = fiyat;
    }
    public String getFiyatBirimi() {
        return FiyatBirimi;
    }
    public void setFiyatBirimi(String fiyatBirimi) {
        FiyatBirimi = fiyatBirimi;
    }
    public String getFiyatt()
    {
        return String.valueOf(Fiyat + " " + FiyatBirimi);
    }   
    public String getAciklama() {
        return Aciklama;
    }
    public void setAciklama(String aciklama) {
        Aciklama = aciklama;
    }
    public Dimension getFotografBoyutu() {
        return FotografBoyutu;
    }
    public void setFotografBoyutu(Dimension fotografBoyutu) {
        FotografBoyutu = fotografBoyutu;
    }
    @Override
    public String toString() {
        return "Urun{" +
        "Kategori='" + Kategori + '\'' +
        ", Marka='" + Marka + '\'' +
        ", İsim='" + İsim + '\'' +
        ", Fotograf='" + Fotograf + '\'' +
        ", Fiyat=" + Fiyat +
        ", FiyatBirimi='" + FiyatBirimi + '\'' +
        ", Aciklama='" + Aciklama + '\'' +
        '}';
    }
}
