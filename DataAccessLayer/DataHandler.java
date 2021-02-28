package DataAccessLayer;
import BusinessLogicLayer.*;
import java.io.*;
import java.util.*;

public class DataHandler {
    String filepath = "C:\\Users\\Aura\\Desktop\\PRG381 Project\\Clients.txt";
    public List<Clients> GetClients() throws FileNotFoundException{
        List<Clients> clist = new ArrayList<Clients>();
        
        File file = new File(filepath);
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String[] line = sc.nextLine().split(",");
            clist.add(new Clients(Integer.parseInt(line[0]),line[1],line[2],Integer.parseInt(line[3]),line[4],line[5],line[6]));

        }
        sc.close();
        return clist;
    }

    Clients client = new Clients();
    
    public void AddClient() throws IOException {
        File file = new File("C:\\Users\\Aura\\Desktop\\PRG381 Project\\Clients.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        
        try (Scanner scan = new Scanner(System.in)) {
            if(file.exists()){
                FileReader fr = new FileReader(file);
                LineNumberReader lr = new LineNumberReader(fr);
                int linecount = 0;
                while(lr.readLine()!=null){
                    linecount++;
                }
                client.setClientID(linecount+1);
                lr.close();
            }

            System.out.print(" Enter firstName => ");
            String firstName = scan.nextLine();
            client.setFirstname(firstName);

            System.out.print(" Enter lastName => ");
            String lastName = scan.nextLine();
            client.setLastname(lastName);

            System.out.print(" How old are you? => ");
            int age = scan.nextInt();
            client.setAge(age);

           System.out.print(" Enter email address => ");
           String email = scan.nextLine();
           client.setEmail(email);

           System.out.print(" Enter phone number => ");
           String phoneNo = scan.nextLine();
           client.setPhoneNo(phoneNo);

           System.out.print(" Enter a new password => ");
           String password = scan.nextLine();
           client.setPassword(password);

           pw.println(client.toString());
           pw.close();

        }
    }
    Employees employee = new Employees();

    public void AddEmployee() throws IOException {
        File file = new File("C:\\Users\\Aura\\Desktop\\PRG381 Project\\Employees.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        try (Scanner scan = new Scanner(System.in)) {
            if(file.exists()){
                FileReader fr = new FileReader(file);
                LineNumberReader lr = new LineNumberReader(fr);
                int linecount = 0;
                while(lr.readLine()!=null){
                    linecount++;
                }
                employee.setEmployeeID(linecount+1);
                lr.close();
            }

            System.out.print(" Enter firstName => ");
            String firstName = scan.nextLine();
            employee.setFirstname(firstName);

            System.out.print(" Enter lastName => ");
            String lastName = scan.nextLine();
            employee.setLastname(lastName);

           System.out.print(" Enter your password => ");
           String password = scan.nextLine();
           employee.setPassword(password);

           pw.println(employee.toString());
           pw.close();

        }
    }

    public static Scanner x;
    public void VerifyClientLogin(String email,String password){
        boolean accepted = false;
        while (accepted = false){
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter email => ");
            email = scan.nextLine();

            System.out.print(" Enter password => ");
            password = scan.nextLine();

            scan.close();

            boolean found = false;
            int tempclientID =0;
            String tempname="";
            String tempsurname="";
            int tempage = 0;
            String tempEmail = "";
            String tempPhoneNo="";
            String tempPassword = "";

            try {
                x = new Scanner(new File(filepath));
                x.useDelimiter("[,\n]");
                while(x.hasNext()&& !found){
                    tempclientID = Integer.parseInt(x.next());
                    tempname = x.next();
                    tempsurname = x.next();
                    tempage = Integer.parseInt(x.next());
                    tempEmail = x.next();
                    tempPhoneNo = x.next();
                    tempPassword = x.next();

                    if(tempEmail.trim().equals(email.trim()) && tempPassword.trim().equals(password)){
                        found = true;
                        accepted = true;
                    }
                }
                x.close();
                System.out.println("User is Found: Welcome "+ tempname +" "+tempsurname);
                
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Error:User not Found");
            }
        }
        
    }
    public void VerifyEmployeeLogin(String name, String surname, String password){
        boolean accepted = false;
        while (accepted = false){
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter Name => ");
            name = scan.nextLine();

            System.out.print("Enter Surname => ");
            surname = scan.nextLine();

            System.out.print(" Enter Password => ");
            password = scan.nextLine();

            scan.close();

            boolean found = false;

            int tempempID =0;
            String tempname="";
            String tempsurname="";
            String tempPassword = "";

            try {
                x = new Scanner(new File(filepath));
                x.useDelimiter("[,\n]");
                while(x.hasNext()&& !found){
                    tempempID = Integer.parseInt(x.next());
                    tempname = x.next();
                    tempsurname = x.next();
                    tempPassword = x.next();

                    if(tempname.trim().equals(name.trim()) && tempsurname.trim().equals(surname.trim()) && tempPassword.trim().equals(password)){
                        found = true;
                        accepted = true;
                    }
                }
                x.close();
                System.out.println("User is Found: Welcome "+ tempname +" "+tempsurname);
                
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Error:User not Found");
            }
        }
    }
    public class reader {

    public List<EventDetails> Geteventdeatils() throws FileNotFoundException {

        List<EventDetails> evendetails = new ArrayList<EventDetails>();
       // List<Clients> clientlist = new ArrayList<Clients>();
        File file = new File("C:\\Users\\Aura\\Desktop\\PRG381 Project\\EventDetails.txt");
        Scanner scann = new Scanner(file);
        int linecount = 0;
        if (file.exists()) {
            while (scann.hasNextLine()) {
                String[] line = scann.nextLine().split("#");
                evendetails.add(new EventDetails(Integer.parseInt(line[0]), Integer.parseInt(line[1]), line[2],
                        Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), line[6],
                        line[7]));
                scann.close();
                linecount++;
            }
            EventDetails oo = new EventDetails();
            oo.setbookingnr(linecount + 121);
           

        }
        return evendetails;

    }

    public List<PaymentInfo> Getpaymentinfo() throws FileNotFoundException {
        List<PaymentInfo> payinfor = new ArrayList<PaymentInfo>();
        File file = new File("C:\\Users\\Aura\\Desktop\\PRG381 Project\\PaymentInfor.txt");
        Scanner scann = new Scanner(file);
        int linecount = 0;
        if (file.exists()) {
            while (scann.hasNextLine()) {
                String[] line = scann.nextLine().split("#");
                payinfor.add(
                        new PaymentInfo(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                                Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5])));
                scann.close();
                linecount++;
            }
            PaymentInfo cc = new PaymentInfo();
            cc.setpayid(linecount + 11);
            EventDetails oo = new EventDetails();
            List<EventDetails> evendetails = new ArrayList<EventDetails>();
            for (EventDetails eventDetails : evendetails) {
                for (PaymentInfo paymentInfo : payinfor) {
                    if (paymentInfo.Getbookingnr() == eventDetails.getbookingnr()) {
                        cc.setbooking(oo.getbookingnr());
                    }
                }
            }
        }
        return payinfor;

    }

    public void writereventdeatails(int bookindnr,int clieintid,String eventype,int addressid,int noofadults,int noofkids,String foodselection,String decoration ) {

        try {
            FileWriter writer = new FileWriter("EventDetails.txt", true);
            writer.write(bookindnr+ clieintid+ eventype+ addressid+ noofadults+noofkids+foodselection+decoration);
            List<EventDetails> evendetails = new ArrayList<EventDetails>();
              List<Clients> clientlist = new ArrayList<Clients>();
              int linecount = 0;
              linecount++;
              EventDetails oo = new EventDetails();
              Clients cc = new Clients();
              for (EventDetails eventDetails : evendetails) {
                  for (Clients clients : clientlist) {
                      if (clients.getClientID() == eventDetails.getclientid()) {
                          oo.setclientid(cc.getClientID());
                          oo.setbookingnr(linecount + 121);
           
                      }
                  }
              }
            writer.close();
        } catch (IOException e)
        {
            // 
            e.printStackTrace();
        }


     }
      public void WritePayementinfor(int payid,int bookingno, int totalprice,int noofguest,int discount)
      {
        try {
            FileWriter writer = new FileWriter("PaymentInfor.txt", true);
            writer.write(payid + bookingno+ totalprice+ noofguest+ discount);
            writer.close();
        } catch (IOException e)
        {
            // 
            e.printStackTrace();
        }
      }



}}

