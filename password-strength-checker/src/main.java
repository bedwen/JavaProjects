import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
        //get password from user
        //check every character in password
        //create an algorithm based on the number of special characters, numbers, or letters required.
        //print the result to the screen. it could be a score.
        Scanner scan = new Scanner(System.in);
        System.out.println("[>] Enter a password: ");
        //regex part - check the special characthers, upper and lowers characters, and numbers
        //give scors for characthers
        //example: if special characters > 0 -> scors is mid, sc > 3 -> power

        String password = scan.next();
        System.out.println("[i] Password checking..."); //fix the sentence!
        System.out.println(password);

        String regex = "(?<lower>[a-z])|(?<upper>[A-Z])|(?<num>\\d)|(?>special>[^a-zA-Z0-9\\s])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        int lower = 0;
        int upper = 0;
        int num = 0;
        int special = 0;
        int pwdLength = password.length();

        while (matcher.find()) {
            if (matcher.group("lower") != null) { //if not null, char is matched.
                lower++;
            } else if (matcher.group("upper") != null) {
                upper++;
            } else if (matcher.group("num") != null) {
                num++;
            } else if (matcher.group("special") != null) {
                special++;
            }
        }


        int pwdscore = 0;

        if (pwdLength < 8) {
            System.out.println("[!] Your password must be longer than 8 characters.");
        }
        else {
            pwdscore = (pwdLength-8)*10;
            System.out.println(pwdscore);
            if (lower > 0) {
                pwdscore += 5;
                System.out.println(pwdscore);
            }
            else {
                pwdscore -= 5;
            }
            if (upper > 0) {
                pwdscore += 5;
                System.out.println(pwdscore);
            }
            else {
                pwdscore -= 5;
            }
            if (num > 0) {
                pwdscore += 5;
                System.out.println(pwdscore);
            }
            else {
                pwdscore -= 5;
            }
            if (special > 0) {
                pwdscore += 5;
                System.out.println(pwdscore);
            }
            else {
                pwdscore -= 5;
            }

        }


        System.out.println(pwdscore);


        //password enntropy
        //E = L x log2^(R)
        //E (entropy)
        //L (length)
        //R (pool size)
        //entropy algorithm not enough for scores



    }
}
