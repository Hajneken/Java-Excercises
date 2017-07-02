package cz.cvut.fel.pjv;

public class BruteForceAttacker extends Thief {

    /*private char[] pole = getCharacters(); 
     private int index = 0;
     private int znaky;    
     */
    private boolean konec = false;

    public void Funkce(char[] pole, int index) {
        if (!konec) {
            if (index >= pole.length) {
                konec = tryOpen(pole);

            } else {
                for (int i = 0; i < getCharacters().length; i++) {
                    pole[index] = getCharacters()[i];
                    Funkce((char[]) pole.clone(), index + 1); // naklonuj mi pole a pretypuj ho na chars
                }
            }
        }
    }

    @Override
    public void breakPassword(int sizeOfPassword) {
        // write your code
        char[] pole = new char[sizeOfPassword]; //prazdny pole velikosti siofpas
        int index = 0;
        Funkce(pole, index);

    }

}
