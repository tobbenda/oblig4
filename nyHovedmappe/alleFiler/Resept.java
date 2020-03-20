abstract class Resept {
  static int idTeller;  //Teller for å skille de ulike reseptene.
  protected int id, reit;
  protected Legemiddel legemiddel;
  protected Lege utskrivendeLege;
  protected Pasient pasient;

  public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
    this.legemiddel = legemiddel;
    this.utskrivendeLege = utskrivendeLege;
    this.pasient = pasient;
    this.reit = reit;
    id = idTeller;  //Gir nåværende tellerverdi som id til resepten, før telleren økes.
    idTeller++;   //Øker telleren.
  }

  public int hentId(){  //Metode for å hente reseptens id
    return id;
  }

  public Legemiddel hentLegemiddel(){   //Metode for å hente legemiddelinfo.
    return legemiddel;
  }

  public Lege hentLege(){  //Metode for å hente info om lege.
    return utskrivendeLege;
  }

  public Pasient hentPasient(){  //Metode for å hente pasient.
    return pasient;
  }

  public int hentReit(){   //Metode for å hente reseptens reit.
    return reit;
  }

  public boolean bruk(){  //Metode som bruker resepten om den ikke er oppbrukt.
    if (reit == 0){
      return false;
    }else{
      reit -=1;
      return true;
    }
  }

  public String toString(){  //toString for å få enklere output av objektet.
    return "Legemiddel: " + legemiddel + "\nLege: " + utskrivendeLege +
     "\nPasient: Navn: " + pasient.navn + "\tFodselsnummer: " + pasient.fodselsnummer +
     "\nReit: " + reit;
  }

  abstract public String farge();  //Abstract-metode for å hente reseptens farge..

  abstract public double prisAaBetale();  //Abstract-metode for å hente pris.
}
