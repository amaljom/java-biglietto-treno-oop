package org.ragionevole.it;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Biglietto {
	private double km;
	private int age;
	private LocalDate data;
	private boolean flessibile;
	private static final BigDecimal COST_PER_KM = new BigDecimal(0.21); 
    private static final BigDecimal OVER_65_DISCOUNT = new BigDecimal(0.40);
    private static final BigDecimal UNDER_18_DISCOUNT = new BigDecimal(0.20);
    private static final int standard = 30;
    private static final int flexible = 90;
    // costruttore
    public Biglietto(int km, int age, int flessibile) throws Exception {
    	setKm(km);
    	setAge(age);
		this.data= java.time.LocalDate.now();
		setFlessibile(flessibile);
    }
    
    // getter and setter
    
	// km
	public double getKm() {
		return km;
	}

	public void setKm(int km) throws Exception{
		
		if(!(isValidKm(km))) {
			
			throw new Exception("km cannot be 0");
		}
		
		this.km = km;
	}
	// age
	public int getAge() {
		return age;
	}

	public void setAge(int age) throws Exception {
		if(isValidAge(age)){
			throw new Exception("age cannot be negative");
		}
		this.age = age;
		
	}
	
	// flessibile
	public boolean isFlessibile() {
		return flessibile;
	}

	public void setFlessibile(int flessibile) throws Exception {
		if(flessibile == 0) {
			this.flessibile = false;
		}else if(flessibile == 1) {
			this.flessibile = true;
		}else {
			throw new Exception("inserire 0 o 1");
		}
	}

	
	
	// validation 
	
    public boolean isValidKm(int km) {
    	
    		return km > 0;
    
    }
    
    public boolean isValidAge(int age) {
 
    		return age < 0;
    }
    // calcolo del prezzo
	public double calcolaPrezzo() {
		double totPrice = COST_PER_KM.doubleValue() * km;
		
		if(!(flessibile)) {
			totPrice += totPrice * 0.10;
		}
		
		final double totPriceDiscounted = totPrice - calcolaSconto(totPrice, age);
		
		
		return totPriceDiscounted;
	}
	// calcolo dello sconto
	private double calcolaSconto(double n, int age) {
		
		
			
			if(age < 18) {
				return n * UNDER_18_DISCOUNT.doubleValue();
			}else if(age >= 65) {
				return n * OVER_65_DISCOUNT.doubleValue(); 
			}else {
				return 0;
			}
		
		
	}
	/*
	// calcolo del costo da aggiungere
	public double totPriceToAdd(double price) {
		if(!(flessibile)){
			return price * 10 / 100;
		}
	}
	*/
	private int getDays(boolean flessibile){
		if(flessibile){
			return standard;
		}
		return flexible;
	}
	
	public String toString() {
		return " Numero km da percorrere: " + getKm() 
		+ "\n Età del passeggero: " + getAge() 
		+ "\n Tot biglietto: " + calcolaPrezzo() + "€"
		+ "\n Data di scadenza: " + data.plusDays(getDays(flessibile));
	}

}
		
	
	


    

