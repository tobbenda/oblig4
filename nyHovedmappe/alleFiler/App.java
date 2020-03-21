import java.util.Scanner;
import java.util.InputMismatchException;

class App{
  static Legesystem nyttSystem = new Legesystem();
  public static void main(String[] args) throws InputMismatchException{
    int menyValg = 0;

    //Legesystem nyttSystem = new Legesystem();
    while(menyValg!=6){                    //Innvalg 6 er Exit, så programmet kjører til 6 blir valgt i hovedmenyen.
      int valg = hovedmeny();              //Metoden hovedmeny ligger under, og tar seg av utskrift til, og input fra, bruker.
      if (valg==1){
        skrivUtAlt();  //kjør Metode for innvalg 1 IKKE FERDIG
      }else if (valg==2){
        opprett();     //kjør Metode for innvalg 2 IKKE FERDIG
      }else if (valg==3){
        brukResept();  //kjør Metode for innvalg 3 IKKE FERDIG
      }else if (valg==4){
        skrivStatistikk();//kjør Metode for innvalg 4 IKKE FERDIG
      }else if (valg==5){
        skrivTilFil();//kjør metode for innvalg 5 IKKE FERDIG
      }
      menyValg=valg;
    }
  }
  // private static void filLesing(String filnavn) throws FileNotFoundException{
  //     nyttSystem.lesFil(filnavn);
  // }

  private static void skrivUtAlt(){  //Metode for innvalg 1 Skriver ut alle
       System.out.println("Oversikt over alle elementer.");
       System.out.println("Alle registrerte leger:");
       for(Lege l : nyttSystem.hentLegeListe()){
          System.out.println(l);
       }

       System.out.println("\nAlle registrerte pasienter:");
       for(Pasient p : nyttSystem.hentPasientListe()){
           System.out.println(p);
       }
       System.out.println("\nAlle registrerte legemidler:");
       for(Legemiddel m : nyttSystem.hentLegemiddelListe()){
           System.out.println(m);
       }

       System.out.println("\nAlle registrerte resepter:");
       for(Resept r : nyttSystem.hentReseptListe()){
           System.out.println(r);
       }
   }

  private static void opprett() throws InputMismatchException{  //Metode for innvalg 2 - DELOPPGAVE E4
    Scanner oppretterScanner = new Scanner(System.in);
    int oppretteValg = 0;
    while(oppretteValg<1||oppretteValg>4){
        System.out.println("\nHva ønsker du å opprette? ");
        System.out.printf("%-12s" + "Tast 1","Lege?");
        System.out.printf("\n%-12s" + "Tast 2","Legemiddel?");
        System.out.printf("\n%-12s" + "Tast 3","Resept? ");
        System.out.printf("\n%-12s" + "Tast 4\n>","Pasient? ");
        try{  //Prøver om bruker oppgir gyldig input.
            oppretteValg = oppretterScanner.nextInt();  //Sjekker etter int fra bruker.
            if(oppretteValg<1||oppretteValg>4){
               System.out.println("\nUgyldig input! Prøv igjen\n");
              }
            }catch(InputMismatchException e){
               System.out.println("\nUgyldig input! Prøv igjen.");
               oppretterScanner.next();  //Pusher scanner forbi den ugyldige linja.
             }
        }



    if(oppretteValg==1){ //metode for å opprette lege
        opprettNyLege();
    }
    else if(oppretteValg==2){ //metode for å opprette legemiddel
        opprettNyttLegemiddel();


    }else if(oppretteValg==3){; //metode eller kode for å opprette resept
      Scanner typeReseptScanner = new Scanner(System.in);
      int typeReseptValg=0;
      while(typeReseptValg<1||typeReseptValg>4){    //DELOPPGAVE E7
        System.out.println("\n Hvilken type resept?");
        System.out.printf("\n%-17s" + " Tast 1", "Hvit resept?");
        System.out.printf("\n%-17s" + " Tast 2", "Blå resept?");
        System.out.printf("\n%-17s" + " Tast 3", "P-resept?");
        System.out.printf("\n%-17s" + " Tast 4", "Militær-resept?");
        typeReseptValg = typeReseptScanner.nextInt();
        if(typeReseptValg<1||typeReseptValg>4){
          System.out.println("\n\nUgyldig input! Prøv igjen\n");
        }
      }

      //HVIT RESEPT
      if(typeReseptValg==1){;} //Metode eller kode for å opprette hvit resept
      //BLÅ RESEPT
      else if(typeReseptValg==2){;} //Metode eller kode for å opprette Blå resept
      //P-RESEPT
      else if(typeReseptValg==3){;} //Metode eller kode for å opprette P-resept
      //MIL-RESEPT
      else if(typeReseptValg==4){;} //Metode eller kode for å opprette Militær-resept
    //PASIENT
    }else if(oppretteValg==4){;}  //metode eller kode for å opprette pasient

  } // Slutten på metoden for innvalget "OPPRETT"


  // METODE FOR Å BRUKE RESEPT:
  private static void brukResept(){;} //Metode for innvalg 3 - DELOPPGAVE E5
  // METODE FOR Å SKRIVE DIV STATISTIKK:
  private static void skrivStatistikk(){;} //Metode for innvalg 4 - DELOPPGAVE E6
  // METODE FOR Å SKRIVE TIL FIL:
  private static void skrivTilFil(){;}  //Metode for innvalg 5 - DELOPPGAVE E8

  static private int hovedmeny() throws InputMismatchException{
    int status = 0;
    int input1 = 0;
    while(status != 1){
      Scanner inputScanner1 = new Scanner(System.in);
      System.out.printf("%s"+"%-80s"+"%s", "\nHva ønsker du å gjøre?", "\nSkrive ut fullstendig oversikt over pasienter, leger, legemidler og resepter?", "Tast 1");
      System.out.printf("%-80s"+"%s", "\nOpprette og legge til nye elementer i systemet?", "Tast 2");
      System.out.printf("%-80s"+"%s", "\nBruke en gitt resept fra listen til en pasient?","Tast 3");
      System.out.printf("%-80s"+"%s", "\nSkrive ut forskjellige former for statistikk?","Tast 4");
      System.out.printf("%-80s"+"%s", "\nSkrive alle data til fil?","Tast 5");
      System.out.printf("%-80s"+"%s", "\nAvslutt","Tast 6\n>");
      try{  //Prøver lese brukers input.
          input1 = inputScanner1.nextInt();
          if (input1>0 && input1<7){
            return input1;
          }else{
            System.out.println("\nUgyldig Input! Prøv igjen\n");
          }
      }catch(InputMismatchException e){  //Kaster exception om bruker skriver noe annet enn int.
          System.out.println("\nUgyldig Input! Prøv igjen\n");
      }
    }
    return 0;
  }



  private static void opprettNyttLegemiddel(){  //Metode for å legge til legemiddel.
      System.out.print("\nVennligst skriv hvilken type legemiddel du vil opprette.\n>");
      String type = navnSjekk();  //Sjekker om bruker oppgir gyldig input.
      int styrke = 0;
      boolean finsTypen = typeLegemiddelSjekk(type);  //Sjekker at typen oppgitt er en legemiddeltype.
      while(finsTypen != true){
          System.out.print("\nUgyldig type oppgitt! Typene kan være vanedannende, vanlig eller narkotisk.\n");
          System.out.print("\nVennligst skriv hvilken type legemiddel du vil opprette.\n>");
          type = navnSjekk();
          finsTypen = typeLegemiddelSjekk(type);  //Sjekker brukers nye input.
      }
      if(type.equals("vanlig")){  //Hopper over spørsmål om styrke om typen er vanlig.

      }else{  //Sjekker styrken til de to andre typene.
          System.out.print("\nHva er legemiddelets styrke?\n>");
          styrke = intSjekk();
      }

      System.out.print("\nVennligst skriv navnet på legemiddelet du vil opprette.\n>");
      String navn = navnSjekk();  //Ber om og sjekker at navnet er gyldig input.

      System.out.print("\nVennligst skriv prisen på legemiddelet.\n>");
      double pris = doubleSjekk();  //Ber om og sjekker at prisen er gyldig input.

      System.out.print("\nVennligst oppgi mengde virkestoff til legemiddelet.\n>");
      double virkestoff = doubleSjekk();  //Ber om og sjekker at virkestoff er gyldig input.


      if(styrke == 0){  //Sjekker type legemiddel og oppretter det riktige.
          Legemiddel nyttLegemiddel = new Vanlig(navn, pris, virkestoff);  //Oppretter vanlig om styrke = 0.
          nyttSystem.hentLegemiddelListe().leggTil(nyttLegemiddel);
          System.out.println("Opprettet nytt vanlig legemiddel.");  //Kontrollutskrift, FJERN FØR LEVERING!
      }
      else if(type.equals("narkotisk")){  //Sjekker om oppgitt type er narkotisk.
          Legemiddel nyttLegemiddel = new Narkotisk(navn, pris, virkestoff, styrke);
          nyttSystem.hentLegemiddelListe().leggTil(nyttLegemiddel);
          System.out.println("Opprettet nytt narkotisk legemiddel");    //Kontrollutskrift, FJERN FØR LEVERING!
      }
      else if(type.equals("vanedannende")){  //Sjekker om oppgitt type er vanedannende.
          Legemiddel nyttLegemiddel = new Vanedannende(navn, pris, virkestoff, styrke);
          nyttSystem.hentLegemiddelListe().leggTil(nyttLegemiddel);
          System.out.println("Opprettet nytt vanedannende legemiddel");  //Kontrollutskrift, FJERN FØR LEVERING!
      }
  }


  private static void opprettNyLege(){  //Metode for å opprette ny lege.
      System.out.print("\nVennligst skriv navn på legen du vil opprette.\n>");
      String nyLegeNavn = navnSjekk();  //Sjekker om brukers input er gyldig.

      System.out.print("\nVennligst oppgi legens kontrollID.\n>");
      int kontrollId = intSjekk();  //Sjekker om brukers input er gyldig.

      if(kontrollId != 0){  //Sjekker om spesialist eller vanlig lege skal opprettes.
          Spesialist nySpesialist = new Spesialist(nyLegeNavn, kontrollId);
          nyttSystem.hentLegeListe().leggTil(nySpesialist);
      }else{
          Lege nyLege = new Lege(nyLegeNavn);
          nyttSystem.hentLegeListe().leggTil(nyLege);
      }
  }

  private static boolean typeLegemiddelSjekk(String type){  //Metode for å sjekke at bruker
                                                            //oppgir en av tre typer legemiddel.
      if (type.equals("narkotisk")){
          return true;
      }else if(type.equals("vanedannende")){
          return true;
      }else if (type.equals("vanlig")){
          return true;
      }
      return false;  //Om bruker ikke har oppgitt en gyldig type returnes false.
  }

  private static String navnSjekk(){  //Metode for å sjekke brukers input hvor det blir spurt om navn/tekst.
      Scanner nyttNavnScanner = new Scanner(System.in);
      String navn = nyttNavnScanner.next();
      boolean sjekk = false;
      while(!sjekk){
          try{
              int ikkeFunk = Integer.parseInt(navn);  //Får vi tall som input gir vi feilmelding.
              System.out.print("\nUgyldig input! Prøv igjen.\n>");
              navn = nyttNavnScanner.next();
          }catch(Exception e){
              sjekk = true;
          }
      }
      return navn;   //Returnerer det lovlige navnet
  }

  private static double doubleSjekk(){  //Metode for å sjekke brukers double-inputs.
      Scanner doubleScanner = new Scanner(System.in);
      boolean sjekk = true;
      double doubleTall = 0;
      while(sjekk){
          try{
              double nyDouble = doubleScanner.nextDouble();
              doubleTall = nyDouble;
              sjekk = false;
          }catch(InputMismatchException e){
              System.out.print("\nUgyldig input! Prøv igjen.\n>");
              doubleScanner.next();  //Pusher scanner til å be om ny input.
              }
      }
      return doubleTall;   //Returnerer den gyldige inputen.
  }

  private static int intSjekk(){   //Metode for å sjekke brukers int-inputs.
      Scanner intScanner = new Scanner(System.in);
      boolean sjekk = true;
      int intTall = 0;
      while(sjekk){
          try{
              int nyttTall = intScanner.nextInt();
              intTall = nyttTall;
              sjekk = false;
          }catch(InputMismatchException e){
              System.out.print("\nUgyldig input! Prøv igjen.\n>");
              intScanner.next();  //Pusher scanner til å be om ny input.
              }
      }
      return intTall;  //Returnerer den gyldige inputen.
  }
}
