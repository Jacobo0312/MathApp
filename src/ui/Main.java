/**
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * A00368502
 * Universidad Icesi (Cali-Colombia)
 * @Author: Jacobo Garcia
 * @Date: 13 noviembre 2020
 *
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  */

  package ui;
  import java.util.Scanner;
  import model.MathApp;
  public class Main{

private  Scanner lector;
private MathApp app;

public Main(){
		lector=new Scanner(System.in);
  		app= new MathApp();
}

public static void main(String [] args) {
	Main ppal=new Main();
int option=0;	
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);		
		}while (option!=0);	
}

	public int showMenu() {
		int option=0;

		System.out.println(
				"MathApp\n"+
				"Ingrese una opcion\n" +
				"(1) Agregar un nuevo conjunto\n" +
				"(2) Eliminar un conjunto existente\n"+
				"(3) Agregar un elemento a un conjunto\n"+
				"(4) Eliminar un elemento de un conjunto\n"+
				"(5) Aplicar la union entre 2 conjuntos\n"+
				"(6) Aplicar la interseccion entre 2 conjuntos\n" +
				"(7) Aplicar la diferencia entre 2 conjuntos\n" +
				"(8) Aplicar la diferencia simetrica entre 2 conjuntos\n" +
				"(9) Mostrar los elementos de un conjunto\n" +
				"(10) Mostrar todos los conjuntos\n" +
				"(0) salir"
				);
		option= lector.nextInt();
		lector.nextLine();
		return option;
	}

		public void executeOperation(int operation) {
		
			switch(operation) {
			case 1:
				addSet();
				break;
			case 2:
				removeSet();
				break;
			case 3:
				addElementToSet();
				break;
			case 4:
				removeElementFromSet();
				break;
			case 5:
				union();
				break;
			case 6:
				intersection();
				break;
			case 7:
				difference();
				break;
			case 8:
				symmetricDifference();
				break;
			case 9:
				System.out.println(showInfoSet());
				break;
			case 10:
				System.out.println(app.showInfoSets());				
				break;
			case 0:
				break;
			default:
				System.out.println("Error");
		}
	}

public void addSet(){
		System.out.println("Ingrese el nombre del conjunto");
		String name = lector.nextLine();
		System.out.println(app.addSet(name));
	}
	public void removeSet(){
		System.out.println("Ingrese el nombre del conjunto");
		String nameSet = lector.nextLine();
		System.out.println(app.removeSet(nameSet));
	}
	public void addElementToSet(){
		System.out.println("Ingrese el nombre del conjunto");
		String name = lector.nextLine();
		System.out.println("Ingrese el elemento a agregar");
		int element = lector.nextInt();lector.nextLine();
		System.out.println(app.addElementToSet(name, element));
	}
	public void removeElementFromSet(){
		System.out.println("Ingrese el nombre del conjunto");
		String name = lector.nextLine();
		System.out.println("Ingrese el elemento a eliminar");
		int element = lector.nextInt();
		lector.nextLine();
		System.out.println(app.removeElementFromSet(name, element));
	}
	public void union(){
		System.out.println("Ingrese el nombre del conjunto 1");
		String name1 = lector.nextLine();
		System.out.println("Ingrese el nombre del conjunto 2");
		String name2 = lector.nextLine();
		System.out.println("Ingrese el nombre del conjunto union");
		String newName = lector.nextLine();
		app.union (name1, name2, newName);
	}
	public void difference(){
		System.out.println("Ingrese el nombre del conjunto 1");
		String name1 = lector.nextLine();
		System.out.println("Ingrese el nombre del conjunto 2");
		String name2 = lector.nextLine();
		System.out.println("Ingrese el nombre del conjunto diferencia");
		String newName = lector.nextLine();
		app.difference (name1, name2, newName);
	}
	public void intersection(){
		System.out.println("Ingrese el nombre del conjunto 1");
		String name1 = lector.nextLine();
		System.out.println("Ingrese el nombre del conjunto 2");
		String name2 = lector.nextLine();
		System.out.println("Ingrese el nombre del conjunto interseccion");
		String newName = lector.nextLine();
		app.intersection (name1, name2, newName);
	}
	public void symmetricDifference(){
		System.out.println("Ingrese el nombre del conjunto 1");
		String name1 = lector.nextLine();
		System.out.println("Ingrese el nombre del conjunto 2");
		String name2 = lector.nextLine();
		System.out.println("Ingrese el nombre del conjunto diferencia simetrica");
		String newName = lector.nextLine();
		app.symmetricDifference(name1, name2, newName);
	}
	public String showInfoSet(){
		String message ="";
		System.out.println("Ingrese el nombre del conjunto");
		String name = lector.nextLine();
		message = app.showInfoSet(name);
		return message;
	}







  }