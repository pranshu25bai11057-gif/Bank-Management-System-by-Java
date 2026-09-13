import java.io.File;
import java.io.IOException;
import java.util.Scanner;

interface Authentication {
    void loginAuth(int accountNo, String pass) throws IOException;
}

public class Login {
    void loginFun() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Account Number: ");
        int accountNo = sc.nextInt();
        System.out.print("Enter your Password: ");
        String pass = sc.next();
        loginAuth(accountNo, pass);
    }

    public void loginAuth(int accountNo, String pass) throws IOException {
        File file = new File("db/credentials.txt");
        Scanner scanner = new Scanner(file);
        boolean cpass = false;
        boolean incPass = false;
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] subLine = line.split(" ");
            if (accountNo == Integer.parseInt(subLine[0]) && pass.equals(subLine[1])) {
                cpass = true;
                break;
            } else if (accountNo == Integer.parseInt(subLine[0])) {
                incPass = true;
            }
        }
        if (cpass) {
            System.out.println("Login Successful!!\n");
            Main.menu(accountNo);
        } else if (incPass) {
            System.out.println("\nIncorrect Password!");
            System.out.println("Please enter again.\n");
            loginFun();
        } else {
            System.out.println("\nAccount doesn't exists!");
            System.out.println("Please enter again.\n");
            loginFun();
        }
    }

}
