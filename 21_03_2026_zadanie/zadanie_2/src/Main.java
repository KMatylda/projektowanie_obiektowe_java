import st.Student;

public class Main {
    public static void main(String[] args) {

        // Obiekt 1 - konstruktor bezargumentowy i test ponieżej 50% obecności
        Student p1 = new Student();
        p1.setNumerIndeksu(12345);
        p1.setObecnosc(0.4f); // mniej niż 50%
        p1.setOcenaPoj(5);
        System.out.println(p1.getImie() + " " + p1.getNazwisko()
                + " | Indeks: " + p1.getNumerIndeksu()
                + " | Ocena POJ: " + p1.getOcenaPoj());

        // Obiekt 2 - konstruktor z danymi
        Student p2 = new Student("Damian", "Kowalski");
        p2.setNumerIndeksu(54321);
        p2.setObecnosc(0.7f);
        p2.setOcenaPoj(5);
        System.out.println(p2.getImie() + " " + p2.getNazwisko()
                + " | Indeks: " + p2.getNumerIndeksu()
                + " | Ocena POJ: " + p2.getOcenaPoj());
        // Obiekt 3 - puste stringi > Unknown
        Student p3 = new Student("", null);
        p3.setNumerIndeksu(14381);
        p3.setObecnosc(0.7f);
        p3.setOcenaPoj(4);
        System.out.println(p3.getImie() + " " + p3.getNazwisko()
                + " | Indeks: " + p3.getNumerIndeksu()
                + " | Ocena POJ: " + p3.getOcenaPoj());

        // Obiekt 4 - bezwarunkowy konstruktor > test setter
        Student p4 = new Student();
        p4.setImie("");
        p4.setNazwisko(null);
        p4.setNumerIndeksu(24881);
        p4.setObecnosc(0.7f);
        p4.setOcenaPoj(5);
        System.out.println(p3.getImie() + " " + p4.getNazwisko()
                + " | Indeks: " + p4.getNumerIndeksu()
                + " | Ocena POJ: " + p4.getOcenaPoj());
    }
}

