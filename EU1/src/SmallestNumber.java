
public class SmallestNumber {
	
	public static void main(String[] args){
		
		
		int[] array = {2,9,4,3,8,7,5,5,11,14,3,9,6,5,10,3,1,4,11};
	
		int min = min(array);
		 
		System.out.println(min);
		
	}
	
	// min returnerar det minsta elementet i en sekventiellsamling.
	// Om samlingen �r tom, kastas ett undantagav typen IllegalArgumentException.
	public static int min (int[] element)throws IllegalArgumentException{
		
		if (element.length == 0)
			throw new IllegalArgumentException ("tom samling");
		
		// h�r ihop med sp�rutskriften 2:
		int    antalVarv = 1;
		
		int[] sekvens = element;
		int antaletPar = sekvens.length / 2;
		
		int antaletOparadeElement = sekvens.length % 2;
		int antaletTankbaraElement = antaletPar +antaletOparadeElement;
		int[] delsekvens = new int[antaletTankbaraElement];
		int i = 0;
		int j = 0;
		
		while (antaletPar > 0){
			// skilj ur en delsekvens med de t�nkbara elementen
			i = 0;
			j = 0;
			
			while (j < antaletPar){
				
				delsekvens[j++] = (sekvens[i] < sekvens[i + 1])? sekvens[i] : sekvens[i + 1];
				i += 2;
				
				}
			
				if (antaletOparadeElement == 1)
					delsekvens[j] = sekvens[antaletPar*2];
				
				// utg� nu ifr�n delsekvensen
				sekvens = delsekvens;
				antaletPar = antaletTankbaraElement /2;
				antaletOparadeElement = antaletTankbaraElement % 2;
				antaletTankbaraElement = antaletPar +antaletOparadeElement;
				
		
				
				
				//sp�rutskrift 1 �f�r att f�ljasekvensen
				//System.out.println (java.util.Arrays.toString (sekvens));
				
				//sp�rutskrift 2 -f�r att avsluta loopen i f�rv�g
				// (f�r att kunna se vad som h�nder i b�rjan)
				if (antalVarv++ == 10)
				System.exit (0);
				
				
			
		}
		
		// sekvens[0] �r det enda �terst�ende t�nkbara elementet
		//-det �r det minsta elementet
		
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
	
	


