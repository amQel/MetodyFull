package changer;

import java.math.BigDecimal;
import java.util.Scanner;


public class Interpolacja {


	Interpolacja(double[] funkcja, double[] wartosci){
		FunctionChanger changer = new FunctionChanger();

		double[] fOdx = funkcja;
		double[] war = wartosci;
		for (int i = 0; i < war.length; i++) {
			System.out.print(" " + war[i]);
		}
		System.out.println("\n\n");
		for (int i = 0; i < fOdx.length; i++) {
			System.out.print(" " + fOdx[i]);
		}
		System.out.println("\n\n");
		double[] po = changer.normalForm(fOdx,war);
		Calka calka = new Calka(po);
		
		
		String wzor = wypiszWynik(po, false);
		wypiszWynik(calka.getPoCalkowo(),true);
		System.out.println("wyswietlic plot ?");
		Scanner in = new Scanner(System.in);
		String c;
		c=in.nextLine();
		int i = in.nextInt();
		if(c.toLowerCase().contains("t")) new Rysownik(po,wzor,i);
		
	}

	
	
public static String wypiszWynik(double[] tablicaWFormieNormalnej, boolean cons) {
				
		String postacOgolna = "";
		
		for (int i=tablicaWFormieNormalnej.length-1;i>1;i--){
			
			if(tablicaWFormieNormalnej[i]!=1.0) 
				{
				Double normalnaSkrocona=new BigDecimal(tablicaWFormieNormalnej[i]).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
				postacOgolna += normalnaSkrocona;
				}
			if(tablicaWFormieNormalnej[i-1]<0)
				postacOgolna +=  "x^{" + i + "} ";
			else
				postacOgolna +=  "x^{" + i +  "} + " ;
			
		}
		if(tablicaWFormieNormalnej[1]!=1.0) postacOgolna += tablicaWFormieNormalnej[1];
		postacOgolna +=  "x";
		if(tablicaWFormieNormalnej[0]!=0.0) postacOgolna += " + " + tablicaWFormieNormalnej[0];
		if(cons) postacOgolna += " + Const";
		postacOgolna += "\n";
		System.out.print(postacOgolna);
		return postacOgolna;
	}
}
