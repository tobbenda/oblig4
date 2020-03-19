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

    public Legesystem(String filnavn) throws FileNotFoundException{
        this.filnavn = filnavn;

        File fil = new File(filnavn);
        Scanner seksjonScanner = new Scanner(fil).useDelimiter("\\s*#\\s*");
        String seksjon1pasienter = seksjonScanner.next();
        String seksjon2legemidler = seksjonScanner.next();
        String seksjon3leger = seksjonScanner.next();
        String seksjon4resepter = seksjonScanner.next();

        // Håndtere seksjon1
        while(seksjon1pasienter.hasNextLine()){
          Scanner seksjon1Scanner = new Scanner(seksjon1pasienter).useDelimiter("\\s*,\\s*");
          while(seksjon1Scanner.hasNextLine()){
            String linje = seksjon1Scanner.nextLine();
            while(linje.hasNext())
          }
        }

        }

        int teller = 0;
        while(scanner.hasNextLine()){
            if(scanner.next().equals("#")){
                System.out.println("#");
                scanner.nextLine();
                teller ++;
            }


            /*
            FIL
              Seksjoner delt med # .next()useDelimiter((""\\s*#\\s*""))
                Deles inn i linjer med nextLine()
                  Deles inn i parametre med .next().useDelimiter(komma)
                  legges inn i en ArrayList.
                  ArrayListnavn.get(index)


            Scanner scanner = new Scanner(fil).useDelimiter("\\s*#\\s*");
            String seksjon = scanner.next();

            String streng = scanner.next();
            while (streng.hasNextLine()){
              Scanner linje = New Scanner(streng).useDelimiter("\\s*,\\s*");
              while(linje.hasNext()){


            }

          }
            System.out.println(scanner.next());




            */
            String linje = seksjonScanner.nextLine();
            Scanner linjeScanner = new Scanner(linje).useDelimiter("\\s*#\\s*")); //Deler opp neste linje til en liste

            if (teller == 1){//
                Pasient nyPasient = new Pasient(liste[0], liste[1]);
                System.out.println(nyPasient);
                pasientListe.leggTil(nyPasient);

            } else if(teller == 2){//legemiddel

                if (liste[1].equals("narkotisk")){
                    Double pris = Double.parseDouble(liste[2]);
                    Double virkestoff = Double.parseDouble(liste[3]);
                    Integer styrke = Integer.parseInt(liste[4]);
                    Legemiddel nyttLegemiddel = new Narkotisk(liste[0], pris, virkestoff, styrke);
                    System.out.println(nyttLegemiddel);
                    legemiddelListe.leggTil(nyttLegemiddel);
                }
                else if (liste[1].equals("vanedannende")){
                    Double pris = Double.parseDouble(liste[2]);
                    Double virkestoff = Double.parseDouble(liste[3]);
                    Integer styrke = Integer.parseInt(liste[4]);
                    Legemiddel nyttLegemiddel = new Vanedannende(liste[0],  pris, virkestoff, styrke);
                    System.out.println(nyttLegemiddel);
                    legemiddelListe.leggTil(nyttLegemiddel);
                }

                else if (liste[1].equals("vanlig")){
                    Double pris = Double.parseDouble(liste[2]);
                    Double virkestoff = Double.parseDouble(liste[3]);
                    Legemiddel nyttLegemiddel = new Vanlig(liste[0],  pris, virkestoff);
                    System.out.println(nyttLegemiddel);
                    legemiddelListe.leggTil(nyttLegemiddel);
                }

            } else if (teller == 3){//lege
                Integer type = Integer.parseInt(liste[1]);
                Lege nyLege;
                if (type > 0){
                    nyLege = new Spesialist(liste[0], type);
                } else {
                    nyLege = new Lege(liste[0]);
                }
                System.out.println(nyLege);
                legeListe.leggTil(nyLege);
            } else {//resepter
                //Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit]) <--- sånn det står i myeInndata.txt

            }
        }
      }
}


class Test{
    public static void main(String[] args) throws FileNotFoundException{
        Legesystem les = new Legesystem("myeInndata.txt");
    }
}
