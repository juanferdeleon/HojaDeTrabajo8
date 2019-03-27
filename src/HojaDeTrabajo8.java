import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Hoja de trabajo 8
 * @author Juanfer De Leon
 */
public class HojaDeTrabajo8{

    public static void main(String[] args) throws IOException{

        System.out.print("\nIngrese path del archivo: ");
        Scanner input = new Scanner(System.in);
        String path = input.next();
        Vector patients = readPatients(path);

        VectorHeap vectorHeapPatients = new VectorHeap(patients);

        boolean wantsToContinue = true;

        while (wantsToContinue){

            System.out.println(mainMenu());
            System.out.print("\nIngrese una opcion: ");
            Scanner input2 = new Scanner(System.in);
            String op = input2.next();

            switch (op){
                case "1":
                    if (vectorHeapPatients.size() > 0){
                        System.out.println(vectorHeapPatients.remove());
                    } else {
                        System.out.println("\nERROR: No hay pacientes por atender.");
                    }
                    break;
                case "2":
                    wantsToContinue = false;
                    break;
                default:
                    System.out.println("\nERROR: Opcion ingresada no es valida.");
                    break;
            }

        }

    }

    public static String mainMenu(){
        return "\n\tMenu" +
                "\n1. Siguiente paciente" +
                "\n2. Salir";

    }

    /**
     * Reads txt file with patients
     * @param path
     * @return
     * @throws IOException
     */
    public static Vector readPatients(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        Vector patients = new Vector();

        while ((line = bufferedReader.readLine()) != null) {

            String[] info = line.split(", ");
            String name = info[0];
            String symptoms = info[1];
            String eCode = info[2];

            Patient patient = new Patient(name, symptoms, eCode);

            patients.add(patient);

        }

        System.out.println(patients);
        return patients;
    }
}