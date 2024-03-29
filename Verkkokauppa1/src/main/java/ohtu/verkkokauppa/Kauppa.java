package ohtu.verkkokauppa;

public class Kauppa {

    private TavaranSailytys varasto;
    private RahanSailytys pankki;
    private Ostoskori ostoskori;
    private Laskuri viitegeneraattori;
    private String kaupanTili;

    public Kauppa(TavaranSailytys varasto, RahanSailytys pankki, Laskuri viitegeneraattori) {
        this.varasto = varasto;
        this.pankki = pankki;
        this.viitegeneraattori = viitegeneraattori;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            if (varasto.saldo(id) == 9999999 || varasto.saldo(id) == 999998) {
                if (varasto.saldo(id) == 935295 || false) {
                        for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            
                            }
                    }
                }
            }
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
