package Project;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public  class GarageSystem {
    public static Vector<Slot> slot = new Vector<Slot>();
    public static Vector<Vehicle>vehicle = new Vector<Vehicle>();
    private int TotalIncome;//***
    private int sizeOfSlot=0;
    public final int HourPrice =5;
    private String slotConfiguration;//**
    public void mainMethod() {//**

        Scanner in = new Scanner(System.in);
        System.out.println("Hello Welcome to Parking Garage application");
        System.out.println("Please enter how many slot do you have in Garage: ");
        sizeOfSlot = in.nextInt();
        for (int i = 0; i < sizeOfSlot; i++) {
            Slot object = new Slot();
            object.setSlotNum(i+1);
            System.out.println("Slot "+object.getSlotNum());
            System.out.println("Enter width of slot:");
            object.setWidth(in.nextInt());
            System.out.println("Enter depth of slot:");
            object.setDepth(in.nextInt());
            object.setSlotNum(i+1);
            slot.add(object);
        }
        while (true) {
            System.out.println("which type of slot configuration do you want to choose?:");
            System.out.println("1- first come first served slots");
            System.out.println("2- best-fit approach");
            System.out.println(" Enter 3 if you want to now more info abut configuration type");
            int x;
            x = in.nextInt();
            if (x == 1) {
                slotConfiguration = "firstCome";
                break;
            } else if (x == 2) {
                slotConfiguration = "bestFit";
                break;
            } else if (x == 3) {
                System.out.println("1- first come first served slots:the system will use the first free slot available from the parking garage slots.");
                System.out.println("2-best-fit best-fit approach where you need to find the slot with the minimum dimension to hold the vehicle");

            } else {
                System.out.println("Wrong input");
            }
        }

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("1-Add new vehicle");
            System.out.println("2-parking vehicle");
            System.out.println("3-park out vehicle");
            System.out.println("4-Display the available parking slots ");
            System.out.println("5-Display Slot");
            System.out.println("6-Display vehicle");
            System.out.println("7-Total income");
            System.out.println("8-Exit");

            int x;
            x = input.nextInt();
            if (x == 1) {
                addVehicle();
            } else if (x == 2) {
                Scanner inn = new Scanner(System.in);
                System.out.println("Enter Identification of vehicle to park in");
                String n= inn.nextLine();

                boolean check=false;
                for (int i=0;i<vehicle.size();i++){
                    if (Objects.equals(vehicle.get(i).getIdentification(), n)){
                        park_in(vehicle.get(i));
                        check=true;
                        break;
                    }
                }
                if (!check) {
                    System.out.println("Failed to find this identification");
                    int m;
                    System.out.println("Did you want to add new vehicle?");
                    System.out.println("1-YES ");
                    System.out.println("2-NO ");
                    m = input.nextInt();
                    if (m == 1) {
                        addVehicle();
                    } else if (m == 2)
                        continue;
                    else
                        System.out.println("Wrong input");
                }
            } else if (x == 3) {
                Scanner inn = new Scanner(System.in);
                System.out.println("Enter Identification of vehicle to park in");
                String n= inn.nextLine();
                boolean check=false;
                for (int i=0;i<vehicle.size();i++){
                    if (Objects.equals(vehicle.get(i).getIdentification(), n)){
                        for (int j=0;j<slot.size();j++){
                            if (slot.get(j).getContainer()==vehicle.get(i)){
                                park_out(vehicle.get(i));
                                check=true;
                                break;
                            }
                        }
                      break;
                    }
                }
                if (!check)
                    System.out.println("Failed to find this identification");
            }
            else if (x == 4) {
                displayAvailableParking(slot);
            }
            else if (x == 5) {
                displaySlot(slot);
            }
            else if (x == 6) {
                displayVehicles(vehicle);
            }
            else if (x == 7) {
                System.out.println("Total income : " +TotalIncome+" EGP");
            }
            else if (x == 8) {
                int n;
                System.out.println("Are you sure?");
                System.out.println("if you exit for application you will lost all data!!");
                System.out.println("1-Exit any way ");
                System.out.println("2-cancel ");
                n=input.nextInt();
                if (n==1){
                    System.out.println("Thank you for using this application");
                break;}
                else if(n==2)
                    continue;
                else
                    System.out.println("Wrong input");
            }
            else {
                System.out.println("Wrong input");
            }
        }
    }
public void addVehicle(){//**
        Vehicle v=new Vehicle();
    Scanner in = new Scanner(System.in);
        System.out.println("Enter identification of vehicle ");
        v.setIdentification(in.nextLine());
        System.out.println("Enter model name of vehicle ");
        v.setModelName(in.nextLine());
        System.out.println("Enter model year of vehicle ");
        v.setModelYear(in.nextLine());
        System.out.println("Enter depth of vehicle ");
        v.setDepth(in.nextInt());
        System.out.println("Enter width of vehicle ");
        v.setWidth(in.nextInt());
        vehicle.add(v);
}
    public int totalTime(Vehicle v) throws ParseException {//**

        int x=v.getParkInTime();
        int y=v.getParkOutTime();
        String time1 =Integer.toString(x);
        String time2 = Integer.toString(y);
        SimpleDateFormat format = new SimpleDateFormat("HH");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        long difference = date1.getTime() - date2.getTime();
        int hours = (int) ((difference / (1000*60*60)) % 24);
        return hours;
    }

    public void displayAvailableParking(Vector<Slot> slot){//**
        for (int i=0;i<slot.size();i++){
            if (slot.get(i).getContainer()==null)

                slot.get(i).print();
        }
    }
    public void displaySlot(Vector<Slot> slot){
        System.out.println("Number of slot is:" + slot.size());
        for (int i=0;i<slot.size();i++){
            System.out.println("Slot "+slot.get(i).getSlotNum() );
            System.out.println("Depth : " +slot.get(i).getDepth());
            System.out.println("Width : " +slot.get(i).getWidth());
        }

    }
    public void displayVehicles(Vector<Vehicle> vehicle){
        System.out.println("Number of vehicle is:" + vehicle.size());
        for (int i=0;i<vehicle.size();i++){
            System.out.println(" vehicle "+ (i+1));
            System.out.println("Identification :" + vehicle.get(i).getIdentification());
            System.out.println("Model name: " +vehicle.get(i).getModelName());
            System.out.println("Model year:" + vehicle.get(i).getModelYear());
            System.out.println("Depth: " +vehicle.get(i).getDepth());
            System.out.println("Width: " + vehicle.get(i).getWidth());

        }
    }
    public int calculateFees(Vehicle vehicle) throws ParseException {
        int x=totalTime(vehicle);
        if (x==0){
            TotalIncome+=5;
            return 5;}
        else {
            TotalIncome+=5*x;
            return 5*x;}
    }




    public boolean park_in(Vehicle vehicle){

        if (slotConfiguration=="firstCome") {
            for (int i = 0; i < slot.size(); i++) {
                if (slot.get(i).getContainer() == null) {
                    vehicle.setParkInTime();
                    slot.get(i).setContainer(vehicle);
                    System.out.println("Parking in slot " + (i + 1) + "successfully! \n");
                    return true;
                }
            }
            System.out.println("There is no available slot in parking garage!!\n");
            return false;
        }
        else {
            for (int i=0;i<slot.size();i++) {
                if (vehicle.getDepth() <= slot.get(i).getDepth() && vehicle.getWidth() <= slot.get(i).getWidth() && slot.get(i).getContainer()==null){
                    vehicle.setParkInTime();
                    slot.get(i).setContainer(vehicle);
                    System.out.println("Parking in slot " + (slot.get(i).getSlotNum()) + " successfully! \n");
                    return true;
                }
            }
            System.out.println("There is no available slot in parking garage!!\n");
            return false;
        }
    }

    public void park_out(Vehicle vehicle){//**
        vehicle.setParkOutTime();
        try {

            for (int i=0;i<slot.size();i++){
                if (slot.get(i).getContainer()==vehicle){
                    slot.get(i).setContainer(null);
                    break;
                }
            }
            System.out.println("You spend "+totalTime(vehicle)+" hours");
            System.out.println("Total fees "+calculateFees(vehicle)+" EGP");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}




