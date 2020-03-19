import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Legesystem{
    String filnavn;
    Lenkeliste<Pasient> pasientListe = new Lenkeliste<Pasient>();
    Lenkeliste<Legemiddel> legemiddelListe = new Lenkeliste<Legemiddel>();
    Lenkeliste<Resept> resepterListe = new Lenkeliste<Resept>();
    Lenkeliste<Lege> legeListe = new SortertLenkeliste<Lege>();

    public Legesystem(String filnavn) throws FileNotFoundException, UlovligUtskrift{
        this.filnavn = filnavn;

        File fil = new File(filnavn);
        Scanner seksjonScanner = new Scanner(fil).useDelimiter("\\s*#\\s*");
        String seksjon1pasienter = seksjonScanner.next();
        String seksjon2legemidler = seksjonScanner.next();
        String seksjon3leger = seksjonScanner.next();
        String seksjon4resepter = seksjonScanner.next();

        // Håndtere seksjon1: Pasienter
        Scanner scan1 = new Scanner(seksjon1pasienter);
        scan1.nextLine();
        while(scan1.hasNextLine()){
          String linje = scan1.nextLine();
          Scanner linjeScanner = new Scanner(linje).useDelimiter("\\s*,\\s*");
          ArrayList<String> linjeOrd = new ArrayList<String>();
          while(linjeScanner.hasNext()){
            linjeOrd.add(linjeScanner.next()); // index 0=navn, 1=fnr
          }
          Pasient nyPasient = new Pasient(linjeOrd.get(0), linjeOrd.get(1));
          pasientListe.leggTil(nyPasient);
        }

        // Håndtere Seksjon2: Legemidler
        Scanner scan2 = new Scanner(seksjon2legemidler);
        scan2.nextLine();
        while(scan2.hasNextLine()){
          String linje = scan2.nextLine();
          Scanner linjeScanner = new Scanner(linje).useDelimiter("\\s*,\\s*");
          ArrayList<String> linjeOrd = new ArrayList<String>();


          while(linjeScanner.hasNext()){
            linjeOrd.add(linjeScanner.next()); // index 0=navn, 1=fnr
          }
          if (linjeOrd.size()>5){
              System.out.println("Ugyldig Linje");
          }else{
                try{
                  Double pris = Double.parseDouble(linjeOrd.get(2));
                  Double virkestoff = Double.parseDouble(linjeOrd.get(3));


              String navn = linjeOrd.get(0);

              if(linjeOrd.get(1).equals("vanlig")){
                  Legemiddel nyttLegemiddel = new Vanlig(navn, pris, virkestoff);
                  legemiddelListe.leggTil(nyttLegemiddel);
              }
              else if(linjeOrd.get(1).equals("narkotisk")){
                  int styrke = Integer.parseInt(linjeOrd.get(4));
                  Legemiddel nyttLegemiddel = new Narkotisk(navn, pris, virkestoff, styrke);
                  legemiddelListe.leggTil(nyttLegemiddel);
              }
              else if(linjeOrd.get(1).equals("vanedannende")){

                  int styrke = Integer.parseInt(linjeOrd.get(4));
                  Legemiddel nyttLegemiddel = new Vanedannende(navn, pris, virkestoff, styrke);
                  legemiddelListe.leggTil(nyttLegemiddel);
              }
          }catch(Exception e){
          System.out.println("Det går ikke");
           }
          }
        }

        // Håndtere Seksjon3: Leger
        Scanner scan3 = new Scanner(seksjon3leger);
        scan3.nextLine();
        while(scan3.hasNextLine()){
          String linje = scan3.nextLine();
          Scanner linjeScanner = new Scanner(linje).useDelimiter("\\s*,\\s*");
          ArrayList<String> linjeOrd = new ArrayList<String>();


          while(linjeScanner.hasNext()){
            linjeOrd.add(linjeScanner.next()); // index 0=navn, 1= (0= vanlig lege, else = spesialist)
          }
          if (linjeOrd.size()>2){
              System.out.println("Ugyldig Linje");
          }else{
            try{
              String navn = linjeOrd.get(0);
              int kontrollid = Integer.parseInt(linjeOrd.get(1));
              if (kontrollid==0){
                Lege nyLege = new Lege(navn);
                legeListe.leggTil(nyLege);
              }else{
                Lege nySpesialist = new Spesialist(navn, kontrollid);
                legeListe.leggTil(nySpesialist);
              }
          }catch(Exception e){
              System.out.println("Det går ikke");
           }
          }
       }
       Scanner scan4 = new Scanner(seksjon4resepter);
       scan4.nextLine();
       while(scan4.hasNextLine()){
         String linje = scan4.nextLine();
         Scanner linjeScanner = new Scanner(linje).useDelimiter("\\s*,\\s*");
         ArrayList<String> linjeOrd = new ArrayList<String>();


         int lm = 0;
         int l = 0;
         int p = 0;
         int r = 0;
        // Legemiddel legemiddel;
        // Lege lege;
        // Pasient pasient;
        // int reit;

         while(linjeScanner.hasNext()){
           linjeOrd.add(linjeScanner.next()); // index 0=navn, 1= (0= vanlig lege, else = spesialist)
         }


           int legemiddelNummer = Integer.parseInt(linjeOrd.get(0));
           String legeNavn = linjeOrd.get(1);
           int pasientId = Integer.parseInt(linjeOrd.get(2));
           String reseptType = linjeOrd.get(3);

           for(int i=0;i<legemiddelListe.stoerrelse();i++){
               if(legemiddelListe.hent(i).hentId() == legemiddelNummer){
                   lm = i; //legemiddelListe.hent(i);
               }
             }
              for(int i=0;i<legeListe.stoerrelse();i++){
                  if(legeListe.hent(i).hentNavn().equals(legeNavn)){
                      l = i;
                  }
                }
            for(int i=0;i<pasientListe.stoerrelse();i++){
                if(pasientListe.hent(i).hentId() == pasientId){
                    p = i;
                }
              }


          // for(Legemiddel l : legemiddelListe){
          //     Legemiddel legemiddel;
          //     if(l.hentId() == legemiddelNummer){
          //       legemiddel = l;
          //     }


          if(reseptType.equals("blaa")){
            int reseptReit = Integer.parseInt(linjeOrd.get(4));
              try{
                  legeListe.hent(l).skrivBlaaResept(legemiddelListe.hent(lm), pasientListe.hent(p), reseptReit);
              }catch(UlovligUtskrift e){}

            }else if(reseptType.equals("militaer")){
              int reseptReit = Integer.parseInt(linjeOrd.get(4));
            try{
                legeListe.hent(l).skrivMilitaerResept(legemiddelListe.hent(lm), pasientListe.hent(p), reseptReit);
            }catch(UlovligUtskrift e){}

          }else if(reseptType.equals("hvit")){
            int reseptReit = Integer.parseInt(linjeOrd.get(4));
            try{
                legeListe.hent(l).skrivHvitResept(legemiddelListe.hent(lm), pasientListe.hent(p), reseptReit);
            }catch(UlovligUtskrift e){}

          }else if(reseptType.equals("p")){
            try{
                legeListe.hent(l).skrivPResept(legemiddelListe.hent(lm), pasientListe.hent(p));
            }catch(UlovligUtskrift e){}
          }
      }
    }
}

class Test{
    public static void main(String[] args) throws FileNotFoundException, UlovligUtskrift{
        Legesystem les = new Legesystem("testfil.txt");
        //Test Pasientseksjon
        for(Pasient p : les.pasientListe){
            System.out.println(p.fodselsnummer);
        }
        //Test Legemiddelseksjon
        for(Legemiddel l : les.legemiddelListe){
            System.out.println(l.navn);
        }
        //Test Legeseksjonen
        for(Lege leg : les.legeListe){
            System.out.println(leg);
        }
        //Test Reseptseksjon
        for(Lege leg : les.legeListe){
            leg.hentReseptListe();
        }
    }
}
