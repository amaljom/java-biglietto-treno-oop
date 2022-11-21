package org.ragionevole.it;

import java.util.Scanner;

public class Biglietteria {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		// km da percorrere
		System.out.print("Inserisci quanti km vuoi percorrere: ");
		int km = sc.nextInt();
		// età
		System.out.print("Inserisci l'età del passeggero: ");
		int age = sc.nextInt();
		
		// durata 30 o 90 giorni
		
		System.out.print("Inserire: \n 1 --> 30 giorni \n 0 --> 90 giorni ");
		int flessibile = sc.nextInt();
		
		try {
			
			Biglietto ticket = new Biglietto(km, age, flessibile);
			System.out.println(ticket.toString());
		} catch(Exception e) {
			
			System.err.println(e.getMessage());
		}
		
		
	}
}
 