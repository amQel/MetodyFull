package changer;

import java.util.Scanner;



public class AlgNumHermite {
	
	private static final int I_TAK_NIE_ZNAJDZIESZ_BLEDU=5;
	public static double[] ti;
	public static double[] xi;
	public static double[] yi;
	public static double[] zi;

	public static void main(String[] args) 
	{
		int x = wczytajDane();
		//System.out.println(ilorazRoznicowy(0,ti.length-1));
		//Scanner in = new Scanner(System.in);
		//int p = in.nextInt();
//		int p;
		double[] wynik = new double[x+1];
		for(int i=I_TAK_NIE_ZNAJDZIESZ_BLEDU;i<=x;i++)
		{
			wynik[i] = ilorazRoznicowy(I_TAK_NIE_ZNAJDZIESZ_BLEDU, i);
		}
			new Interpolacja(wynik, xi);
	}

	private static int wczytajDane() {
		Scanner in = new Scanner(System.in);
		System.out.print("Podaj N:\n");
		int n = in.nextInt();
		
		xi = new double[2*n+1];
		yi = new double[2*n+1];
		zi = new double[2*n+1];
		ti = new double[3*n+2];
		
		System.out.println("Podaj kolejne " +xi.length+ " wezlow x po spacji:\n");
		int p=I_TAK_NIE_ZNAJDZIESZ_BLEDU;
		for (int i=I_TAK_NIE_ZNAJDZIESZ_BLEDU + 1;i<2*n+1;i++)
		{
			xi[i]= in.nextInt();
			if(i%2 == I_TAK_NIE_ZNAJDZIESZ_BLEDU - 1 )
			{
				ti[p] = xi[i];
				p++;
				ti[p] = xi[i];
				p++;
				
			}else 
			{
				ti[p] = xi[i];
				p++;
			}
		}
		
		System.out.println("Podaj kolejne " +yi.length+ " wezlow y po spacji:\n");
		
		for (int j=0;j<2*n+1;j++)
		{
			yi[j]= in.nextInt();
		}
		
		System.out.println("Podaj kolejne " + zi.length + " Pochodnych P'(x2i)\n");
		
		for (int j=0;j<n+1;j++)
		{
			zi[2*j]= in.nextInt();
		}
		return 3*n+1;
	}

	private static double ilorazRoznicowy(int pocz, int kon) 
	{
		//System.out.println(pocz + " " + kon + " ");
		if(pocz == kon)
		{
//			System.out.println("tu f(" +pocz+ "," + kon + " ) = " + fOdTi[pocz]);
			if(pocz % 3 == 0)
			 return yi[(pocz/3)*2];
			else if(pocz % 3 == 1)
				return yi[((pocz-1)/3)*2];
			else return yi[(((pocz+1)/3)*2)-1];
		}else
			if(ti[pocz] == ti[kon])
			{
				int s = silnia(kon-pocz);
				int p = (pocz/3)*2;
				//System.out.println("p=" + p);
				return (zi[p])/s;
			}
			else
			{
				//System.out.println("f(" +pocz+ "," + kon + " ) = " + (fPrimOdTi[fOdTi[pocz]])/s);
				return ((ilorazRoznicowy(pocz+1, kon) -ilorazRoznicowy(pocz, kon-1))/(ti[kon] - ti[pocz])); 
			}
		
		
	}

	private static int silnia(int i) {
		
		int s = 1;
		for (int j=1;j<=i;j++)
		{
			s=s*j;
		}
		return s;
	}

}
