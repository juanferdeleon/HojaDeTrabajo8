import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class VectorHeapTest {

    @Test
    public void add() {

        PriorityQueue<Patient> patients = new VectorHeap<>();

        Patient patient1 = new Patient("Juan", "Dolor en el estomago", "E");
        Patient patient2 = new Patient("Maria", "Dolores de parto", "A");
        Patient patient3 = new Patient("Pedro", "Herido de bala", "A");

        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);

        Vector<Patient> patients2 = new Vector<>();
        patients2.add(patient1);
        patients2.add(patient2);
        patients2.add(patient3);

        PriorityQueue<Patient> expected = new VectorHeap<>(patients2);

        assertEquals(expected, patients);

    }

    @Test
    public void remove() {

        PriorityQueue<Patient> patients = new VectorHeap<>();
        Patient patient1 = new Patient("Juan", "Dolor en el estomago", "E");
        Patient patient2 = new Patient("Maria", "Dolores de parto", "A");
        Patient patient3 = new Patient("Pedro", "Herido de bala", "A");

        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);

        assertEquals(patient2, patients.remove());

    }
}