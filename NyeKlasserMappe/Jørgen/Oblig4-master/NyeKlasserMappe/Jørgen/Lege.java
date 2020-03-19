class Lege implements Comparable<Lege> {
  protected String navn;
  private Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<Resept>();


  public Lege(String navn){
    this.navn = navn;
  }
  public String hentNavn(){  //Metode for å hente navn
    return navn;
  }

  public String toString(){  //Metode for enklere utskrift av objektet
    return "Navn: " + navn;
  }

  public int compareTo(Lege lege){
    return navn.compareTo(lege.hentNavn());
  }

  public void hentReseptListe(){
    for(Resept resept : utskrevedeResepter){
      System.out.println(resept + "\n");
    }
  }

  public boolean sjekkLege(){
    if (this instanceof Spesialist){
      return true;
    }
    return false;
  }

  public boolean sjekkLovlighet(Legemiddel legemiddel){
    if(legemiddel instanceof Narkotisk){
      if(this.sjekkLege() == true){
        return true;
      }else{
        return false;
      }
    }
    return true;
  }

  public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit)
  throws UlovligUtskrift {
    if(sjekkLovlighet(legemiddel) == true){
      HvitResept nyResept = new HvitResept(legemiddel, this, pasient, reit);
      utskrevedeResepter.leggTil(nyResept);
      return nyResept;
    }else{
      throw new UlovligUtskrift(this, legemiddel);
    }
  }

  public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit)
  throws UlovligUtskrift{
    if(sjekkLovlighet(legemiddel) == true){
      MilitaerResept nyResept = new MilitaerResept(legemiddel, this, pasient, reit);
      utskrevedeResepter.leggTil(nyResept);
      return nyResept;
    }else{
      throw new UlovligUtskrift(this, legemiddel);
    }
  }

  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit)
  throws UlovligUtskrift {
    if(sjekkLovlighet(legemiddel) == true){
      BlaaResept nyResept = new BlaaResept(legemiddel, this, pasient, reit);
      utskrevedeResepter.leggTil(nyResept);
      return nyResept;
    }else{
      throw new UlovligUtskrift(this, legemiddel);
    }
  }

  public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient)
  throws UlovligUtskrift {
    if(sjekkLovlighet(legemiddel) == true){
      PResept nyResept = new PResept(legemiddel, this, pasient);
      utskrevedeResepter.leggTil(nyResept);
      return nyResept;
    }else{
      throw new UlovligUtskrift(this, legemiddel);
    }
  }
}
