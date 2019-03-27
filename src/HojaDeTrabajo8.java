import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Hoja de trabajo 8
 * @author Juanfer De Leon
 */
public class HojaDeTrabajo8 {

    public static void main(String[] args) {

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