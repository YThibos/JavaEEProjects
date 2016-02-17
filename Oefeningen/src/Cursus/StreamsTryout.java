
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamsTryout {

    public StreamsTryout() {
    }

    public static void main(String[] args) {
        byte[] lottocijfers = {2, 13, 14, -128, -127, 0, -56, -1, 32};
        int min1 = -1;
       // Byte.

        System.out.println("Wegschrijven");
        FileOutputStream deLijst = null;
        try {
            //een nieuwe file aanmaken 
            deLijst = new FileOutputStream("lotto.dat");
            //alle lottocijfers wegschrijven 
            
            for (byte lottocijfer : lottocijfers) {
                System.out.println(lottocijfer);
            }
            for (byte lottocijfer : lottocijfers) {
                deLijst.write(lottocijfer);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            //de file sluiten 
            if (deLijst != null) {
                try {
                    deLijst.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        
        System.out.println("");
        System.out.println("Terug uitlezen");
        
        FileInputStream deInputLijst = null;
        try {
            //een nieuwe inputfile aanmaken
            deInputLijst = new FileInputStream("lotto.dat");
            //alle lottocijfers inlezen
            int getal;
            while ((getal = deInputLijst.read()) != -1) {
                System.out.println(getal);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            //de file sluiten
            try {
                if (deInputLijst != null) {
                    deInputLijst.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        
        File nieuweMap = new File("c:\\windows");
        File eenLeegBestand = new File(nieuweMap, "win.ini");
        
        System.out.println(eenLeegBestand.getName() + " exists = " + eenLeegBestand.exists());
        
        File lottoFile = new File(".", "lotto.dat");
        File nieuweFile = new File(".." ,"lottocijfers.dat");
        System.out.println("Hernoeming gelukt: " + lottoFile.renameTo(nieuweFile));
        
        System.out.println("lottocijfers.dat terug verwijderd: " + nieuweFile.delete());
        
        try {
            File testDir = new File("testdir");
            File testfile = new File("testfile");
            System.out.println("Creatie testfile in tempdir gelukt: " + (testDir.mkdir() && testfile.createNewFile()));
        } catch (Exception e) {
            System.out.println("exc");
        }
        
    }
}
