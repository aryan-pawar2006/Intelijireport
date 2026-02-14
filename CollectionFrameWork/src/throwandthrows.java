import java.io.IOException;
import java.util.Scanner;

public class throwandthrows {
    //create the exception for validet user:
    static class Validuser extends RuntimeException {
        Validuser(String message) {
            super(message);
        }
    }

    //create the class for the users:
    static class userinfo {
        String username;
        String email;

        userinfo(String username, String email) {
            this.username = username;
            this.email = email;
        }

        void validetuserinfo() {
            if (username.isEmpty() || username == null || username.equals(" ")) {
                throw new Validuser("user name is invalid!");
            } else if (email.equals(" ") || email.isEmpty() || email == null) {
                throw new Validuser("email is not valid!");
            } else {
                System.out.println("the given user info is totally valid!");
            }
        }
    }

    //create the insuffiecient balance exception trow the exception when the widraw amount is greater  than balance:
    static class Insufficient extends RuntimeException {
        Insufficient(String message) {
            super(message);
        }
    }

    //we can create the account which has balance with customer name and method to withdraws the money:
    static class bankaccount {
        String name;
        double balance;

        bankaccount(String name, double balance) {
            this.name = name;
            this.balance = balance;
        }

        void withdraws(double amount) {
            if (amount > balance) {
                throw new Insufficient("withdraw amount is more than balance!");
            } else {
                System.out.println("after withdrawing the amount remains is: " + (balance - amount));
            }
        }
    }

    static class InvalidetuserException extends RuntimeException {
        InvalidetuserException(String message) {
            super(message);
        }
    }

    //create the method that need file readingwhich is not business logic its checked exception
    static void readfile(String filename) throws IOException {
        if (filename == null || filename.isEmpty()) {
            throw new IOException("the given file is not readable!");
        }
    }

    static void takeusername(String username) {
        if (username == null || username.isEmpty()) {
            throw new InvalidetuserException("input username is wrong !");
        }
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            takeusername("aryan");
        } catch (InvalidetuserException e) {
            System.out.println(e.getMessage());
        }

        //handle the checked exception:
        try {
            readfile(null);
        } catch (IOException e) {
            System.out.println("this is :" + e.getMessage() + "error");
        }
        bankaccount account1 = new bankaccount("aryan", 20000);
        try {
            account1.withdraws(22000);
        } catch (Insufficient e)
        {
                System.out.println("error is : " + e.getMessage());
        }

        //handle the validity of user:
        userinfo user2 = new userinfo("araynpawar", " ");
        userinfo user1 = new userinfo("araynpawar", "aryanpawar03022006@gmail.com");
        try {
            user1.validetuserinfo();
            user2.validetuserinfo();
        } catch (Validuser e) {
            System.out.println("error is 3.02:/*" + e.getMessage());
        }
    }
}

