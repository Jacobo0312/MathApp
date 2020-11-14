package model;
import java.util.*;
public class IntegerSet{

//Attributes
private String name;
private int cardinality;
private ArrayList <Integer> elements;

public IntegerSet (String name){
	this.name=name;
	this.cardinality=0;
	this.elements = new ArrayList <Integer>();
}

public String getName (){
	return name;
}

public int getCardinality(){
	return cardinality;
}

public ArrayList<Integer> getElements(){
		return elements;
	}


public String addElement (int element){
	String message="";
	boolean exit = false;
		for(int i=0;i<cardinality&& !exit;i++){
			if(elements.get(i)==element){
				exit = true;
				message= "El elemento ya existe";
			}
		}
		if(exit == false){
			elements.add(element);
			cardinality++;
			message= "Se agrego el elemento";
		}
		return message;
}


public void removeElement(int element){
		boolean exit = false;		
		for(int i=0;i<cardinality&& !exit;i++){
			if(elements.get(i)==element){
				elements.remove(i);
				cardinality--;
				exit = true;
			}
		}
}
 

public IntegerSet union (IntegerSet conj, String name){
	IntegerSet newConj = new IntegerSet(name);
		ArrayList<Integer> conjElements = conj.getElements();
		for(int i=0;i<cardinality;i++){
			newConj.addElement(elements.get(i));
		}
		for(int i=0;i<cardinality;i++){
			for(int j=0 ; j<conj.getCardinality() ; j++){
				if(elements.get(i) != conjElements.get(j)){
					newConj.addElement(conjElements.get(j));
				}
			}
		}		
		return newConj;

}

public IntegerSet difference(IntegerSet conj, String name){
		IntegerSet newConj = new IntegerSet(name);
		for(int i=0;i<cardinality;i++){
			newConj.addElement(elements.get(i));
		}
		ArrayList<Integer> conjElements = conj.getElements();
		for(int i=0;i<conj.getCardinality();i++){
			newConj.removeElement(conjElements.get(i));
		}
		return newConj;
	}


	public IntegerSet intersection(IntegerSet conj, String name){
		IntegerSet newConj = new IntegerSet(name);
		ArrayList<Integer> conjElements = conj.getElements();
		for(int i=0;i<cardinality;i++){
			for(int j=0 ; j<conj.getCardinality() ; j++){
				if(elements.get(i) == conjElements.get(j)){
					newConj.addElement(conjElements.get(j));
				}
			}
		}
		return newConj;
	}

public IntegerSet symmetricDifference(IntegerSet conj, String name){
		IntegerSet conj1 = union(conj,name);
		IntegerSet conj2 = intersection(conj,name);
		IntegerSet newConj = new IntegerSet(name);
		for(int i=0 ; i<conj2.getCardinality() ; i++){
			conj1.removeElement(conj2.getElements().get(i));
		}
		for(int i=0 ; i<conj1.getCardinality() ; i++){
			newConj.addElement(conj1.getElements().get(i));
		}
		return newConj;
	}	


	public String showContents(){
		String message = "****************Conjunto****************"+"\n"
		+ "Nombre : "+getName()+"\n"
		+ "Elementos : "+"\n";
		for(int i=0; i<cardinality; i++){
			message += elements.get(i) + ", ";
		}
		message += "\n"+"****************************************"+"\n";
		return message;
	}	







}