import java.util.Scanner;
import java.util.InputMismatchException;

class App{
  public static void main(String[] args) throws InputMismatchException{
    int menyValg = 0;
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
  private static void skrivUtAlt(){  //Metode for innvalg 1 - DELOPPGAVE E3
      ;}

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
              }else{
                 System.out.println("Går videre....");
              }
            }catch(InputMismatchException e){
               System.out.println("\nUgyldig input! Prøv igjen.");
               oppretterScanner.next();  //Pusher scanner forbi den ugyldige linja.
             }
        }


    // LEGE
    if(oppretteValg==1){ //metode eller kode for å opprette lege
        System.out.print("\nVennligst skriv navn på legen du vil opprette.\n>");
        Scanner nyLegeScanner = new Scanner(System.in);

        String nyLegeNavn = nyLegeScanner.next();
        System.out.print("\nVennligst oppgi legens kontrollID.\n>");
        try{
            int kontrollId = nyLegeScanner.nextInt();
            if(kontrollId != 0){
                Spesialist nySpesialist = new Spesialist(nyLegeNavn, kontrollId);
                //Legeliste.leggTil(nySpesialist);
            }else{
                Lege nyLege = new Lege(nyLegeNavn);
                //Legeliste.leggTil(nylege);
            }
        }catch(InputMismatchException e){
            System.out.println("\nUgyldig input! KontrollID må være et heltall.\n");
            System.out.println("Vennligst oppgi legens kontrollID.\n>");
            }

    // LEGEMIDDEL
    }else if(oppretteValg==2){; //metode eller kode for å opprette legemiddel
    //RESEPT
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
}
