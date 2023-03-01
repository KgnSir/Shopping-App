package SQL;

import Omer.MessageBox;
import SQL.Tablolar.Tablolar.TabloVerisi;

public class Hesabim 
{
    String MusteriID, AdSoyad, KullaniciAd, Sifre, Adres, Mail, TelNo;
    String KrediKartiNo,krediadsoyad, Ay, Yil, CVV;
    double Bakiye, HarcananBakiye;
    public Hesabim(String MusteriID, String AdSoyad, String KullaniciAd,String Sifre, String Adres, String Mail, String TelNo)
    {
        this.MusteriID = MusteriID;
        this.AdSoyad = AdSoyad;
        this.KullaniciAd = KullaniciAd;
        this.Sifre = Sifre;
        this.Adres = Adres;
        this.Mail = Mail;
        this.TelNo = TelNo;
    }
    @Override
    public String toString() {
        return "Hesabim{" +
        "MusteriID=" + MusteriID +
        ", AdSoyad=" + AdSoyad +
        ", KullaniciAd=" + KullaniciAd +
        ", Sifre=" + Sifre +
        ", Adres=" + Adres +
        ", Mail=" + Mail +
        ", TelNo=" + TelNo +
        '}';
    }
    public String getMusteriID() {
        return MusteriID;
    }
    public String getAdSoyad() {
        return AdSoyad;
    }
    public String getKullaniciAd() {
        return KullaniciAd;
    }
    public String getSifre() {
        return Sifre;
    }
    public String getAdres() {
        return Adres;
    }
    public String getMail() {
        return Mail;
    }
    public String getTelNo() {
        return TelNo;
    }
    public String getKrediKartiNo() {
        return KrediKartiNo;
    }
    public void setKrediKartiNo(String krediKartiNo) {
        KrediKartiNo = krediKartiNo;
    }
    public String getKrediadsoyad() {
        return krediadsoyad;
    }
    public void setKrediadsoyad(String krediadsoyad) {
        this.krediadsoyad = krediadsoyad;
    }
    public String getAy() {
        return Ay;
    }
    public void setAy(String ay) {
        Ay = ay;
    }
    public String getYil() {
        return Yil;
    }
    public void setYil(String yil) {
        Yil = yil;
    }
    public String getCVV() {
        return CVV;
    }
    public void setCVV(String cVV) {
        CVV = cVV;
    }
    public double getBakiye() {
        BakiyeGuncelle();
        return Bakiye;
    }
    public void setBakiye(double bakiye) {
        Bakiye = bakiye;
    }
    public double getHarcananBakiye() {
        BakiyeGuncelle();
        return HarcananBakiye;
    }
    public void setHarcananBakiye(double harcananBakiye) {
        HarcananBakiye = harcananBakiye;
    }
    public boolean setPassword(String mevcutSifre,String newPassword) 
    {
        if (VeritabanIslemleri.vt == null) {
            VeritabanIslemleri.vt = new VeritabanIslemleri();
        }

        boolean girisyaptimi = VeritabanIslemleri.vt.GirisYap(getKullaniciAd(), mevcutSifre);
        if (!girisyaptimi) {
            MessageBox.Show("Şifre yanlış.", "Uyarı", MessageBox.Warning);
            return false;
        }
        Boolean sonuc = VeritabanIslemleri.vt.MusteriSifreDegistir(newPassword, getKullaniciAd());
        if (sonuc)
            MessageBox.Show("Müşteri şifre başarılya değiştirildi. Lütfen tekrar yapın.", "Başarılı", MessageBox.Information);
        else
            MessageBox.Show("Müşteri şifre değiştirme başarısız.", "Hesabi.SetPassword()", MessageBox.Error);
        return sonuc;
    }
    public boolean guncelle(String adSoyad, String kullaniciAdi, String adres, String mail, String telNo) 
    {
        Hesabim yeniHesabi = new Hesabim(getMusteriID(), adSoyad, kullaniciAdi, getSifre(), adres, mail, telNo);
        Boolean sonuc = VeritabanIslemleri.vt.MusteriBilgileriGuncelle(this, yeniHesabi);
        if (sonuc)
        MessageBox.Show("Müşteri bilgileri başarılya güncellendi. Lütfen tekrar yapın.", "Başarılı", MessageBox.Information);
        else
            MessageBox.Show("Müşteri bilgileri başarısız.", "Hesabi.SetPassword()", MessageBox.Error);
        return sonuc;
    }
    public void updateKrediKarti()
    {
        if (VeritabanIslemleri.vt == null)
            VeritabanIslemleri.vt = new VeritabanIslemleri();
        TabloVerisi veri = Veritaban.Bakiye.SorguTabloVerisi(VeritabanIslemleri.vt.stmt);
        for (int i = 0; i < veri.Satirlar.length; i++)
        {
            if (veri.Satirlar[i][0].contains(getMusteriID()))
            {
                setKrediKartiNo(veri.Satirlar[i][3]);
                setKrediadsoyad(veri.Satirlar[i][4]);
                setAy(veri.Satirlar[i][5]);
                setYil(veri.Satirlar[i][6]);
                setCVV(veri.Satirlar[i][7]);
                break;
            }
            
        }
    }
    public String toStringKredi()
    {
        return "Hesabim{" +
        "KrediKartiNo=" + KrediKartiNo +
        ", Krediadsoyad=" + krediadsoyad +
        ", Ay=" + Ay +
        ", Yil=" + Yil +
        ", CVV=" + CVV +
        '}';
    }
    public boolean KrediKartiGuncelle(String no,String adsoy,String ay,String yil,String cvv)
    {

        setKrediKartiNo(no);
        setKrediadsoyad(adsoy);
        setAy(ay);
        setYil(yil);
        setCVV(cvv);
        VeritabanIslemleri.vt.MusteriKrediKartGuncelle(this);
        return true;
    }
    public void BakiyeGuncelle()
    {
        if (VeritabanIslemleri.vt == null)
            VeritabanIslemleri.vt = new VeritabanIslemleri();
        TabloVerisi veri = Veritaban.Bakiye.SorguTabloVerisi(VeritabanIslemleri.vt.stmt);
        for (int i = 0; i < veri.Satirlar.length; i++)
        {
            if (veri.Satirlar[i][0].contains(getMusteriID()))
            {
                String bakiye = veri.Satirlar[i][1], harcananbakiye = veri.Satirlar[i][2];
                setBakiye(Double.valueOf(bakiye));
                setHarcananBakiye(Double.valueOf(harcananbakiye));
                break;
            }
            
        }
    }
    public boolean Harca(double harcaMiktari)
    {
        if (VeritabanIslemleri.vt == null)
            VeritabanIslemleri.vt = new VeritabanIslemleri();
        Boolean harcadimi = VeritabanIslemleri.vt.Harca(getMusteriID(), harcaMiktari);
        return harcadimi;

    }
    public boolean BakiyeYukle(String text) {
        if (VeritabanIslemleri.vt == null)
            VeritabanIslemleri.vt = new VeritabanIslemleri();

        Boolean yükledimi =  VeritabanIslemleri.vt.BakiyeYukle(getMusteriID(), text);
        return yükledimi;
    }

}
