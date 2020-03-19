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

    public void leggTilResept(Resept nyResept){  //Metodefor å legge til resept
        reseptStabel.leggPaa(nyResept);
    }

    public Stabel<Resept> hentAlleResept(){  //Metode for å hente alle resepter.
        return reseptStabel;
    }

    public int hentId(){  //Metode for å hente id.
        return id;
    }

    public String toString(){  //Metode for penere utskrift
        return "Navn: " + navn + "   Fodselsnummer: " + fodselsnummer;
    }

}
