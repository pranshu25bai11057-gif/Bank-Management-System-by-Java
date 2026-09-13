import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Transaction {
    void transactionFun(int accountNo) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Receiver's Account Number: ");
        int rAccNo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Amount: ");
        int tAmount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Remarks: ");
        String tRemarks = scanner.nextLine();
        System.out.println("\n");
        allTransaction(accountNo, rAccNo, tAmount, tRemarks);
    }

    void allTransaction(int accountNo, int rAccNo, int tAmount, String tRemarks) throws IOException {
        if (rAccCheck(rAccNo)) {
            // rAcc Validated
            if (sAccBalCheck(accountNo, tAmount)) {
                // sBalance ok
                transaction(accountNo, rAccNo, tAmount); // actual transaction
                writeTransaction(accountNo, rAccNo, tAmount, tRemarks); // write transaction to file
                System.out.println("Transaction Successful!");
                System.out.println("Press any key to continue...");
                Scanner tscanner = new Scanner(System.in);
                tscanner.nextLine();
                Main.menu(accountNo);
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Incorrect Account Number!");
        }
    }

    boolean rAccCheck(int rAccNo) throws FileNotFoundException {
        File file = new File("db/balanceDB.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] subLine = line.split(" ");
            int a = Integer.parseInt(subLine[0]);
            if (rAccNo == a)
                return true;
        }
        return false;
    }

    boolean sAccBalCheck(int accountNo, int tAmount) throws FileNotFoundException {
        File file = new File("db/balanceDB.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] subLine = line.split(" ");
            int a = Integer.parseInt(subLine[0]);
            int b = Integer.parseInt(subLine[1]);
            if (accountNo == a) {
                if (tAmount <= b)
                    return true;
            }
        }
        return false;
    }

    void transaction(int accountNo, int rAccNo, int tAmount) throws IOException {
        File file = new File("db/balanceDB.txt");
        Scanner scanner = new Scanner(file);
        String newInfo = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] subLine = line.split(" ");
            int a = Integer.parseInt(subLine[0]);
            int b = Integer.parseInt(subLine[1]);
            if (accountNo == a) {
                b = b - tAmount;
            } else if (rAccNo == a) {
                b = b + tAmount;
            }
            String newLine = a + " " + b;
            newInfo += newLine + "\n";
        }
        Writer writer = new FileWriter("db/balanceDB.txt");
        writer.write(newInfo);
        writer.close();
    }

    void writeTransaction(int accountNo, int rAccNo, int tAmount, String tRemarks) throws IOException {
        debitWrite(accountNo, rAccNo, tAmount, tRemarks);
        creditWrite(accountNo, rAccNo, tAmount, tRemarks);
    }

    void debitWrite(int accountNo, int rAccNo, int tAmount, String tRemarks) throws IOException {
        String description = ("Transferred to " + rAccNo);
        String type = "Debited";
        String date = java.time.LocalDate.now().toString();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = formatter.format(now);
        Writer writer = new FileWriter("db/Bank Statement/acc_" + accountNo + ".txt", true);
        writer.write(description + " " + type + " " + tAmount + " " + tRemarks + " " + date + " " + time + "\n");
        writer.close();
    }

    void creditWrite(int accountNo, int rAccNo, int tAmount, String tRemarks) throws IOException {
        String description = ("Transferred from " + accountNo);
        String type = "Credited";
        String date = java.time.LocalDate.now().toString();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = formatter.format(now);
        Writer writer = new FileWriter("db/Bank Statement/acc_" + rAccNo + ".txt", true);
        writer.write(description + " " + type + " " + tAmount + " " + tRemarks + " " + date + " " + time + "\n");
        writer.close();
    }

}