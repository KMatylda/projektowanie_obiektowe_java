package e;

public class ChemicalElement {
    private String name;
    private String symbolicName;
    private int atomicNumber;
    private String typeOfMetal;



    public ChemicalElement(String name, String symbolicName, int atomicNumber, String typeOfMetal) {
        this.name = name;
        this.symbolicName = symbolicName;
        this.atomicNumber = atomicNumber;
        this.typeOfMetal = typeOfMetal;
    }

    public String getName() {
        return name;
    }

    public String getSymbolicName() {
        return symbolicName;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public boolean isAlkaliMetal() {
        return atomicNumber == 3  || atomicNumber == 11 || atomicNumber == 19 ||
                atomicNumber == 37 || atomicNumber == 55 || atomicNumber == 87;
    }

    public boolean isTransitionMetal() {
        return (atomicNumber >= 21  && atomicNumber <= 31)  ||
                (atomicNumber >= 39  && atomicNumber <= 48)  ||
                (atomicNumber >= 72  && atomicNumber <= 80)  ||
                (atomicNumber >= 104 && atomicNumber <= 112);
    }

    public boolean isMetal() {
        return atomicNumber == 13  || atomicNumber == 49  || atomicNumber == 50  ||
                atomicNumber == 81  || atomicNumber == 82  || atomicNumber == 83  ||
                atomicNumber == 113 || atomicNumber == 114 || atomicNumber == 115 ||
                atomicNumber == 116;
    }

    @Override
    public String toString() {
        String metalType = "none";
        if (isAlkaliMetal())     metalType = "alkali metal";
        else if (isTransitionMetal()) metalType = "transition metal";
        else if (isMetal())      metalType = "metal";

        return symbolicName + " (" + name + "), atomic number: " + atomicNumber +
                ", series: " + metalType;
    }

}
