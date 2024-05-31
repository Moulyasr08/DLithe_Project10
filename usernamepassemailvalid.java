import java.util.Scanner;
public class usernamepassemailvalid {
    public static boolean isValidUsername(String username) {
        if (username.length() < 5 || username.length() > 20)
            return false;
        if (Character.isDigit(username.charAt(0)))
            return false;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '_')
                return false;
        }
        return true;
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 8)
            return false;
        boolean hasDigit = false, hasUpperCase = false, hasLowerCase = false, hasSpecialChar = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c))
                hasDigit = true;
            else if (Character.isUpperCase(c))
                hasUpperCase = true;
            else if (Character.isLowerCase(c))
                hasLowerCase = true;
            else
                hasSpecialChar = true;

            if (hasDigit && hasUpperCase && hasLowerCase && hasSpecialChar)
                return true;
        }

        return false;
    }

    public static boolean isValidEmail(String email) {
        if (!email.endsWith("@gmail.com"))
            return false;
        String usernamePart = email.substring(0, email.indexOf('@'));
        if (usernamePart.isEmpty() || !Character.isLowerCase(usernamePart.charAt(0)) || Character.isDigit(usernamePart.charAt(0)))
            return false;
        for (int i = 0; i < usernamePart.length(); i++) {
            char c = usernamePart.charAt(i);
            if (Character.isUpperCase(c))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        if (!isValidUsername(username)) {
            System.out.println("Invalid username.");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (!isValidPassword(password)) {
            System.out.println("Invalid password.");
            return;
        }
        System.out.print("Enter email ID: ");
        String email = scanner.nextLine();
        if (!isValidEmail(email)) {
            System.out.println("Invalid email ID.");
            return;
        }
        System.out.println("Valid username, password, and email ID.");
    }
}
