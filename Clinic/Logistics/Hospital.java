package Logistics;
import java.util.ArrayList;

import ServicesFactory.Service;
import ServicesFactory.ServicesFactory;

public class Hospital{
    private static ArrayList<Service> services;
	private static Hospital inst = new Hospital();
	private static ArrayList<Location> loc;
	private ArrayList<User> userList;
	private ServicesFactory app = new ServicesFactory();

        

    private Hospital() {
		services = new ArrayList<Service>();
		loc = new ArrayList<Location>();
		userList=new ArrayList<>();

		// // Creating services
		Service s1 = app.createService("Vaccination");
		Service s2 = app.createService("Checkup");
		Service s3 = app.createService("Physical Test");

		// Creating locations
		Location l1 = new Location("Treatment Solutions Kowloon Tong", 10,
				new Doctor("Dr Asrani", new Time(9, 0), new Time(18, 0)));
		Location l2 = new Location("Treatment Solutions Central", 10,
				new Doctor("Dr Kumar", new Time(9, 0), new Time(18, 0)));
		Location l3 = new Location("Treatment Solutions Keneddy Town", 10,
				new Doctor("Dr Navale", new Time(9, 0), new Time(18, 0)));

		// Adding locations
		this.addLocation(l1);
		this.addLocation(l2);
		this.addLocation(l3);

		// Adding Services
		this.addService(s1);
		this.addService(s2);
		this.addService(s3);
	}

	public static Hospital getinstance() {
		return inst;
	}

	public void initHospital(){

	}
	public void addLocation(Location l){
		loc.add(l);
	}

	public void printLocations() {
		int i=1;
		for (Location l:loc)
		{
			System.out.println("Press "+ i+" for "+l);
			i+=1;
		}
	}

	public static Location getLocByIndex(int locationIndex) {
		int i=1;
		for (Location l: loc)
		{
			if (i==locationIndex)
			{
				return l;
			}
			i+=1;
		}
		return null;
	}

	public void addService(Service s) {
		if(s!=null)
			services.add(s);
	}

	public void printServices() {
		int i=1;
		for (Service s:services)
		{
			System.out.println("Press "+ i+" for "+ s);
			i+=1;
		}
	}

	public static Service getServiceByIndex(int serviceIndex) {
		int i=1;
		for (Service s: services)
		{
			if (i==serviceIndex)
			{
				return s;
			}
			i+=1;
		}
		return null;
	}

	public User findUserByHKID(String HKID)
	{
		for(User u:userList)
		{
			if(u.getHKID().equals(HKID))
			{
				return u;
			}
		}
		return null;
	}

	public void addUser(User u)
	{
		userList.add(u);
	}

}