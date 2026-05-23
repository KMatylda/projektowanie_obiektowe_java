package e;

public class Main {
    public static void main(String[] args) {
        ChemicalElement hydrogen  = new ChemicalElement("Hydrogen",  "H",  1,  null);
        ChemicalElement potassium = new ChemicalElement("Potassium", "K",  19, "alkali metal");
        ChemicalElement zinc      = new ChemicalElement("Zinc",      "Zn", 30, "transition metal");
        ChemicalElement gallium   = new ChemicalElement("Gallium",   "Ga", 31, "metal");

        System.out.println(hydrogen);
        System.out.println(potassium);
        System.out.println(zinc);
        System.out.println(gallium);
    }
}

