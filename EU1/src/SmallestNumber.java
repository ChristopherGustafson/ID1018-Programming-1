
public class SmallestNumber {
	
	public static void main(String[] args){
		
		
		int[] array = {2,9,4,3,8,7,5,5,11,14,3,9,6,5,10,3,1,4,11};
	
		int min = min(array);
		 
		System.out.println(min);
		
	}
	
	// min returnerar det minsta elementet i en sekventiellsamling.
	// Om samlingen är tom, kastas ett undantagav typen IllegalArgumentException.
	public static int min (int[] element)throws IllegalArgumentException{
		
		if (element.length == 0)
			throw new IllegalArgumentException ("tom samling");
		
		// hör ihop med spårutskriften 2:
		int    antalVarv = 1;
		
		int[] sekvens = element;
		int antaletPar = sekvens.length / 2;
		
		int antaletOparadeElement = sekvens.length % 2;
		int antaletTankbaraElement = antaletPar +antaletOparadeElement;
		int[] delsekvens = new int[antaletTankbaraElement];
		int i = 0;
		int j = 0;
		
		while (antaletPar > 0){
			// skilj ur en delsekvens med de tänkbara elementen
			i = 0;
			j = 0;
			
			while (j < antaletPar){
				
				delsekvens[j++] = (sekvens[i] < sekvens[i + 1])? sekvens[i] : sekvens[i + 1];
				i += 2;
				
				}
			
				if (antaletOparadeElement == 1)
					delsekvens[j] = sekvens[antaletPar*2];
				
				// utgå nu ifrån delsekvensen
				sekvens = delsekvens;
				antaletPar = antaletTankbaraElement /2;
				antaletOparadeElement = antaletTankbaraElement % 2;
				antaletTankbaraElement = antaletPar +antaletOparadeElement;
				
		
				
				
				//spårutskrift 1 –för att följasekvensen
				//System.out.println (java.util.Arrays.toString (sekvens));
				
				//spårutskrift 2 -för att avsluta loopen i förväg
				// (för att kunna se vad som händer i början)
				if (antalVarv++ == 10)
				System.exit (0);
				
				
			
		}
		
		// sekvens[0] är det enda återstående tänkbara elementet
		//-det är det minsta elementet
		
		return sekvens[0];
	}
	
	public static int min2(int[] numbers){
		
		int min = numbers[0];
		
		for(int i = 1; i < numbers.length; i++){
			if(numbers[i] < min)
				min = numbers[i];
		}
		
		return min;
		
	}
	
}
	
	


