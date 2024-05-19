package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
	
		List<Employee> list = new ArrayList<>();
		int n;
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.printf("\nEmplyoee #%d:%n", i + 1);
			System.out.print("Id: ");
			int id = sc.nextInt();
			while(hasId(list, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			list.add(new Employee(id, name, salary));
		}
		
		System.out.print("\nEnter the employee id that will have salary increase: ");
		int id = sc.nextInt();
	    Employee e = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	    if(e != null) {
	    	System.out.print("Enter the percentage: ");
	    	double percentage = sc.nextDouble();
	    	e.increaseSalary(percentage);
	    }
	    else { 
	    	System.out.println("This id does not exist!");
	    }
	    
	    System.out.println("\nList of employees:");
	    for(Employee emp : list) { 
	    	System.out.println(emp);
	    }
	    
		sc.close();
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
