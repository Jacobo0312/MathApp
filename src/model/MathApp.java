package model;
import java.util.*;
public class MathApp{

//Attributes
private int amount;

//Relations
private ArrayList <IntegerSet> sets;

//Constructor

public MathApp(){
	this.amount=0;
	this.sets= new ArrayList<IntegerSet>();
}

//Methods

public IntegerSet findSet(String name){
	IntegerSet objSearch=null;
	boolean exist=false;
	for(int i=0;i<sets.size() && !exist;i++){
		if(sets.get(i).getName().equalsIgnoreCase(name)){
			objSearch=sets.get(i);
			exist=true;
		}
	}
	return objSearch;
}

public String addSet(String name){
	String message="";
	IntegerSet obj=findSet(name);
	if (obj!=null){
			message="Error.El conjunto ya existe";
	}else{
		sets.add(new IntegerSet(name));	
		amount++;		
			message="Se ha creado el conjunto";
	}
	return message;
}


public String removeSet(String name){
	String message="";
	IntegerSet obj=findSet(name);
	if (obj!=null){
      sets.remove(obj);
      amount--;	
      message= "Se elimino el conjunto";	
	}
	else {
		message="No existe ningun conjunto con ese nombre";
	}
	return message;
} 


public String addElementToSet(String name, int element){
	String message="";
	IntegerSet obj=findSet(name);
	if(obj!=null){
		message=obj.addElement(element);

	}
	return message;
}

public String removeElementFromSet(String name, int element){
	String message="";
	IntegerSet obj=findSet(name);
	if(obj!=null){
		obj.removeElement(element);
		message="Se elimino el elemento";
	}
	return message;
}


public void union(String name1, String name2, String newName){
	IntegerSet obj1=findSet(name1);
	IntegerSet obj2=findSet(name2);
	if (obj1!=null && obj2 !=null){
		sets.add(obj1.union(obj2,newName));
		amount++;
	}

}


public void difference (String name1, String name2, String newName){
		IntegerSet obj1=findSet(name1);
	IntegerSet obj2=findSet(name2);
	if (obj1 !=null && obj2 !=null){
		sets.add(obj1.difference(obj2,newName));
		amount++;
	}

}

public void intersection (String name1, String name2, String newName){
			IntegerSet obj1=findSet(name1);
	IntegerSet obj2=findSet(name2);
	if (obj1 !=null && obj2 !=null){
		sets.add(obj1.intersection(obj2,newName));
		amount++;
	}
}


public void symmetricDifference(String name1, String name2, String newName){
				IntegerSet obj1=findSet(name1);
	IntegerSet obj2=findSet(name2);
	if (obj1 !=null && obj2 !=null){
		sets.add(obj1.symmetricDifference(obj2,newName));
		amount++;
	}
}

	public String showInfoSet (String name){
	IntegerSet conj=findSet(name);
	String message= "";
	
   if (conj !=null){
   		message=conj.showContents();
   }
	return message;
	}

		public String showInfoSets(){
		String message= "**************Conjuntos*************"+"\n";
		for(int i = 0;i<amount; i++){
			message += sets.get(i).showContents()+"\n";
		}
		return message;
	}

}
