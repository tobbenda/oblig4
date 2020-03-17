class Pasient {
  static int idTeller;
  String navn, fodselsnummer;
  int id;
  Stabel<Resept> reseptStabel;

  public Pasient(String navn, String fodselsnummer){
    this.navn = navn;
    this.fodselsnummer = fodselsnummer;
    id = idTeller;
    idTeller++;
  }

  public void leggTilResept(Resept nyResept){
    reseptStabel.leggPaa(nyResept);
  }

  public Stabel<Resept> hentAlleResept(){
    return reseptStabel;
  }
}
