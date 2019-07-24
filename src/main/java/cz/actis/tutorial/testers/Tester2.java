package cz.actis.tutorial.testers;

public class Tester2 {
    /**
     * Naimplementuj public metodu join, ktera vezme 2 Stringy a spoji je.
     * Vraci string
     */
    public String join(String a, String b) {

        return a + b;
    }


    /**
     * Naimplementuj metodu count, ktera spocita, kolikrat se dany znak vyskytuje v retezci.
     * Argument je String (prohledavany retezec) a char (hledany znak)
     * Vraci int
     */
    public int count(String a, char letter) {
        int count = 0;
        for (int i = 0; i <a.length(); i++){
            if(letter == a.charAt(i)){
                count++;
            }
        }
        return count;
    }


}
