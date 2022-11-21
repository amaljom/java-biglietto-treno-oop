package org.ragionevole.it;

import java.io.FileWriter;
import java.io.IOException;
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
		
		Biglietto[] biglietto = new Biglietto[1];
		try {
			
			Biglietto ticket = new Biglietto(km, age, flessibile);
			System.out.println(ticket.toString());
			biglietto[0] = ticket;
		} catch(Exception e) {
			
			System.err.println(e.getMessage());
		}
		
		FileWriter myWriter = null;
		
		try {
			
			myWriter = new FileWriter("./testfile.txt");
			Biglietto ticket = biglietto[0];
			myWriter.write(ticket.toString());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			
			try {
				myWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
 