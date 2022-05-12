import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String vvod = sc.nextLine();
        vvod = vvod.replaceAll("\\s+", "");
        Main otvet = new Main();
        String znak = znak(vvod);
        boolean res = isThatArab(vvod, znak);

        if(res == true){
            otvet.arabian(vvod, znak);

        }else {
            otvet.romanian(vvod, znak);

        }


    }


    //вы€сн€ет состоит ли выражение из арабских цифр и соответствует ли длине
    static boolean isThatArab(String vvod, String znak) {
        String[] examp = vvod.split("\\"+znak);

        boolean f1 = false;
        boolean f2 = false;
        String[] arab = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (int i = 0; i < 10; i++) {
            if (examp[0].equals(arab[i]) && examp.length == 2) {
                f1 = true;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (examp[1].equals(arab[i])) {
                f2 = true;
            }
        }

        if (f1 == true && f2 == true) {
            return true;
        } else {
            return false;
        }

    }

    //вычлен€ет из выражени€ знак действи€
   static String znak(String vvod) throws IOException {
        String result = "";

        if (vvod.contains("*")) {
            result = "*";
        } else if (vvod.contains("/")) {
            result = "/";
        } else if (vvod.contains("+")) {
            result = "+";
        } else if (vvod.contains("-")) {
            result = "-";
        } else {
            throw new IOException();
        }
        return result;
    }

    //делает операции с арабскими цифрами
    void arabian(String vvod, String znak) throws IOException {
        String[] examp = vvod.split("\\"+znak);
        String[] arab = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        boolean f1 = false;
        boolean f2 = false;
        for (int i = 0; i < 10; i++) {
            if (examp[0].equals(arab[i]) && examp.length == 2) {
                f1 = true;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (examp[1].equals(arab[i])) {
                f2 = true;
            }
        }

        if (f1 == true && f2 == true) {

            int a = Integer.parseInt(examp[0]);
            int b = Integer.parseInt(examp[1]);
            if (znak.equals("*")) {
                System.out.println(a * b);
            } else if (znak.equals("/")) {
                System.out.println(a / b);
            } else if (znak.equals("+")) {
                System.out.println(a + b);
            } else if (znak.equals("-")) {
                System.out.println(a - b);
            }
        } else {
            throw new IOException();
        }


    }

    //делает операции с римскими цифрами
    void romanian(String vvod, String znak) throws IOException {
        String[] examp = vvod.split("\\"+znak);
        String[] rome = new String[]{"I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX", "X"};
        boolean f1 = false;
        boolean f2 = false;
        for (int i = 0; i < 10; i++) {
            if (examp[0].equals(rome[i]) && examp.length == 2) {
                f1 = true;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (examp[1].equals(rome[i])) {
                f2 = true;
            }
        }

        if (f1 == true && f2 == true) {
            int a = Arrays.asList(rome).indexOf(examp[0]) + 1;
            int b = Arrays.asList(rome).indexOf(examp[1]) + 1;

            if (znak.equals("*")) {
                int result = a * b;
                if (result < 1) {
                    throw new IOException();
                }
                String resultat = convertToRoman(result);
                System.out.println(resultat);
            } else if (znak.equals("/")) {
                int result = a / b;
                if (result < 1) {
                    throw new IOException();
                }
                String resultat = convertToRoman(result);
                System.out.println(resultat);
            } else if (znak.equals("+")) {
                int result = a + b;
                if (result < 1) {
                    throw new IOException();

                }
                String resultat = convertToRoman(result);
                System.out.println(resultat);
            } else if (znak.equals("-")) {
                int result = a - b;
                if (result < 1) {
                    throw new IOException();
                }
                String resultat = convertToRoman(result);
                System.out.println(resultat);
            }

        } else {
            throw new IOException();
        }

    }

    //конвертирует арабские в римские
    String convertToRoman(int result) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
                "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX",
                "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII",
                "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII",
                "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII",
                "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII",
                "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII",
                "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII",
                "XCIX", "C"
        };
        String s = roman[result];
        return s;
    }


}



