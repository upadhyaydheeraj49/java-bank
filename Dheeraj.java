import java.util.Scanner;

class Account {
    String name;
    String dob;
    String account_no;
    String username;
    String password;
    float total_amount;
    String transactions;
    
    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your name");
        name = sc.nextLine();
        System.out.println("\nEnter your DOB");
        dob = sc.nextLine();
        System.out.println("\nEnter your account no.");
        account_no = sc.nextLine();
        System.out.println("\nEnter your username");
        username = sc.nextLine();
        System.out.println("\nEnter your password");
        password=sc.nextLine();
        System.err.println("\n");
        total_amount = 100000f;
        transactions = "Account Opening bonus 100000 credited\n";
        
        
    }
    
    public void profile() {
        System.out.println("__________ Profile __________");
        System.out.println("Name: " + name);
        System.out.println("DOB: " + dob);
        System.out.println("Account no: " + account_no);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password + "\n");
        
    }
    
    public void deposit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("_________ Deposit __________");
        System.out.println("Enter the amount you want to deposit:");
        float amount = sc.nextFloat();
        total_amount = total_amount + amount;
        transactions = transactions + "\nRs. " + amount + " credited into your account";
        System.out.println("......Deposit Successfull......");
        System.out.println("Rs. " + amount + " credited into your account\n");
        
    }
    
    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("_________ Withdraw __________");
        System.out.println("Enter the amount you want to withdraw");
        float amount = sc.nextFloat();
        if (amount <=total_amount) {
            total_amount =total_amount - amount;
            transactions = transactions + "\nRs. " + amount + " has been debited from your account";
            System.out.println("...... Withdraw Successfull.......");
            System.out.println("Rs. " + amount + " has been debited from your account\n");
        
        }
        else {
            System.out.println("\t\t Withdraw Unsuccessfull");
            System.out.println("Insufficient Balance\n");
        }
        
    }
    
    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("_________ Transfer __________");
        System.out.println("Enter the name of beneficiary");
        String beneficiary = sc.nextLine();
        System.out.println("\nEnter the amount you want to transfer");
        float amount = sc.nextFloat();
        if (amount <=total_amount) {
            total_amount =total_amount - amount;
            transactions = transactions + "\nRs. " + amount + " has been transferred from your account to " + beneficiary + "'s account";
            System.out.println("......Transfer Successfull......");
            System.out.println("Rs. " + amount + " has been debited from your account");
            System.out.println("Rs. " + amount + " has been transferred from your account to " + beneficiary + "'s account\n");
        
        }
        else {
            System.out.println("\t\t Transfer Unsuccessfull");
            System.out.println("Insufficient Balance\n");
        }
        
    }
    
    public void checkbalance() {
        System.out.println("_________ Balance Check __________");
        System.out.println("Balance: " + total_amount);
        System.out.println("\n......Stay Happy Stay safe.......\n");
    }
    
    public void history() {
        if(!(transactions.equals(""))) {
            System.out.println("_________ Transactions __________");
            System.out.println(transactions);
            System.out.println("\nYour transactions looks awesome");
        }
        else {
            System.out.println("You had not made any transactions yet...");
        }
        
    }
    
    public boolean logout() {
        System.out.println("-----You have been logged out-----");
        return false;
    }
    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your username");
        String usern = sc.nextLine();
        System.out.println("\nEnter your password");
        String passw = sc.nextLine();
        System.err.println("\n");
        if (usern.equals(username) && passw.equals(password)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    
}

class Dheeraj  extends Account {
    
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        Dheeraj obj = new Dheeraj();
        boolean cd = true;
        
        try {
            System.out.println("\n<-------Welcome to JAVA Banking System------->\n");
            while(cd) {
                System.out.println("1.Create a new account");
                System.out.println("2.Know about us");
                System.out.println("3.Exit\n");
                int starting_input = sc.nextInt();
                if(starting_input == 1) {
                    obj.register();
                    System.out.println("Congratulations now you can login");
                    boolean bd = true;
                    while(bd) {
                        System.out.println("1.login");
                        System.out.println("2.exit");
                        int ilg = sc.nextInt();
                        if (ilg == 1) {
                            boolean back=true;
                            boolean log = obj.login();
                            while(back) {
                                
                                if (log) {
                                    System.out.println("1.Profile");
                                    System.out.println("2.Deposit");
                                    System.out.println("3.Withdraw");
                                    System.out.println("4.Transfer");
                                    System.out.println("5.Check Balance");
                                    System.out.println("6.History");
                                    System.out.println("7.Logout");
                                    int p = sc.nextInt();
                                    if (p==1) {
                                        obj.profile();
                                    }
                                    else if (p==2) {
                                        obj.deposit();
                                    }
                                    else if (p==3) {
                                        obj.withdraw();
                                    }
                                    else if (p==4) {
                                        obj.transfer();
                                    }
                                    else if (p==5) {
                                        obj.checkbalance();
                                    }
                                    else if (p==6) {
                                        obj.history();
                                    }
                                    else if (p==7) {
                                        back = obj.logout();
                                    }
                                    else {
                                        System.out.println("Wromg choice");
                                    }
                                        
                                        
                                    }
                                
                                else {
                                    System.out.println("Do you want to continue(Y/N)");
                                    String ab = sc.nextLine();
                                    if (ab.equals("Y")) {
                                        System.out.println("\n");
                                        back = false;
                                    }
                                    else{
                                        bd = false;
                                        back = false;
                                    }
                                }
                            }
                        }
                    
                        else if(ilg == 2) {
                            System.out.println("Do you want to continue(Y/N)");
                            String pta = sc.nextLine();
                            if (pta.equals("Y")) {
                                System.out.println("\n");
                            }
                            else{
                                bd = false;
                            }
                        }
                    }
                }
            
                else if(starting_input == 2) {
                    System.out.println("____________About Us____________");
                    System.out.println("Bank: JAVA Bank\nFounder: Dheeraj Upadhyay\n<-----Contact Details----->\nPhone no: +919528555593\nEmail: upadhyaydheeraj49@gmail.com\n");
                    System.out.println("Do you want to continue(Y/N)");
                    String the = sc.next();
                    if (the.equals("Y")) {
                        System.out.println("\n");
                    }
                    else{
                        cd = false;
                    }
                    
                }
                else if(starting_input == 3) {
                    System.out.println("----Thanks, Visit Again----\n");
                    cd = false;
                }
                else {
                    System.out.println("You entered wrong\n");
                    System.out.println("Do you want to continue(Y/N)");
                    String ct = sc.nextLine();
                    if (ct.equals("Y")) {
                        System.out.println("\n");
                    }
                    else{
                        cd = false;
                        System.out.println("----Thanks, Visit Again----\n");
                    }
                }
            }
        }
        catch(Exception e) {
            System.out.println("Something went wrong, Please try again");
        }
        
        
    }
    
}

