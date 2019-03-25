package controller;

import java.io.FileReader;
import java.time.LocalDate; 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.opencsv.CSVReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.data_structures.Queue;
import model.data_structures.Stack;
import model.utils.Sort;
import model.vo.VODaylyStatistic;
import model.vo.VOMovingViolations;
import model.vo.VOViolationCode;
import view.MovingViolationsManagerView;

public class Controller 
{

	private MovingViolationsManagerView view;

	private Stack <VOViolationCode> pilaCodigos;

	private ArregloDinamico<VOMovingViolations> datos;

	private int cuatrimestre;


	public enum Meses
	{
		JANUARY(0), 
		FEBRUARY(0),
		MARCH(0), 
		APRIL(0), 
		MAY(0),
		JUNE(0),
		JULY(0), 
		AUGUST(0), 
		SEPTEMBER(0), 
		OCTOBER(0), 
		NOVEMBER(0), 
		DECEMBER(0);

		private int infracciones;

		private Meses(int cantidad)
		{ 
			this.infracciones = cantidad;
		}

		private int darInfracciones()
		{ 
			return infracciones; 
		}

		private void contarInfracciones()
		{ 
			this.infracciones++; 
		}
	}


	public Controller() 
	{
		view = new MovingViolationsManagerView();
		pilaCodigos = new Stack<VOViolationCode>();
		datos = new ArregloDinamico<VOMovingViolations>(500000);
	}

	public void run() 
	{
		Scanner sc = new Scanner(System.in);
		boolean fin=false;
		Controller controller = new Controller();

		while(!fin)
		{
			view.printMenu();

			int option = sc.nextInt();

			switch(option)
			{
			case 0:
				view.printMessage("Ingrese el cuatrimestre (1, 2 o 3)");
				int numeroCuatrimestre = sc.nextInt();
				controller.loadMovingViolations(numeroCuatrimestre);
				break;

			case 1:	
				fin=true;
				sc.close();
				break;
			}
		}

	}



	public void loadMovingViolations(int numeroCuatrimestre) 
	{	
		cuatrimestre = numeroCuatrimestre;
		int streetID = 0;
		boolean hayAccidente = false;
		CSVReader reader;
		String[] lineas ;


		try
		{
			if(numeroCuatrimestre != 3)
			{
				for(Meses meses : Meses.values())
				{
					if(meses.ordinal() >= (numeroCuatrimestre-1)*4 && meses.ordinal() < numeroCuatrimestre*4)
					{
						reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_"+meses+"_2018.csv"));

						lineas = reader.readNext();  

						while ((lineas = reader.readNext()) != null) 
						{				

							if(!lineas[4].equals(""))
							{
								streetID = Integer.parseInt(lineas [4]);
							}

							if(lineas[12].equalsIgnoreCase("YES"))
							{
								hayAccidente = true;
							}

							datos.agregar(new VOMovingViolations(Integer.parseInt(lineas[0]), lineas[2], Integer.parseInt(lineas[8]) ,hayAccidente ,
									lineas[13] , Double.parseDouble(lineas[9] ),lineas[12] , lineas[15] ,lineas [14] , lineas [3] ,streetID));

							meses.contarInfracciones();
						}

						view.printMessage("Número de infracciones del mes: " + (meses.ordinal()+1) + " es: " + meses.darInfracciones());
						reader.close();
					}
				}

				view.printMessage("\nNúmero de infracciones del cuatrimestre es: " + datos.darTamanio() + "\n");
			}
			else
			{
				for(Meses meses : Meses.values())
				{
					if(meses.ordinal() >= 8 && meses.ordinal() < 12)
					{

						if(meses.ordinal() != 8) 
						{
							reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_" + meses + "_2018.csv"));

							lineas =reader.readNext();  

							while ((lineas  = reader.readNext()) != null) 
							{	

								if(!lineas[4].equals(""))
								{
									streetID=Integer.parseInt(lineas[4]);
								}

								if(lineas[12].equalsIgnoreCase("YES"))
								{
									hayAccidente=true;
								}

								datos.agregar(new VOMovingViolations(Integer.parseInt(lineas[0]), lineas[2], Integer.parseInt(lineas[8]), hayAccidente , 
										lineas[14], Double.parseDouble(lineas[9]), lineas[12], lineas[16], lineas[15], lineas [3],streetID));

								meses.contarInfracciones();
							}

							view.printMessage("Numero de infracciones del mes " + (meses.ordinal()+1) + " es: " + meses.darInfracciones());
							reader.close();
						}
						else
						{
							reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_"+meses+"_2018.csv"));

							lineas =reader.readNext();

							while ((lineas  = reader.readNext()) != null) 
							{		

								if(!lineas[4].equals(""))
								{
									streetID=Integer.parseInt(lineas[4]);
								}

								if(lineas[12].equalsIgnoreCase("YES"))
								{
									hayAccidente = true;
								}

								datos.agregar(new VOMovingViolations(Integer.parseInt(lineas[0]), lineas[2], Integer.parseInt(lineas[8]), hayAccidente,
										lineas[13], Double.parseDouble(lineas[9]), lineas[12], lineas[15], lineas[14], lineas[3],streetID));


								meses.contarInfracciones();
							}

							view.printMessage("Numero de infracciones del mes " + (meses.ordinal()+1) + " es: " + meses.darInfracciones());
							reader.close();
						}
					}
				}

				view.printMessage("\nNúmero de infracciones en el cuatrimestre es: " + datos.darTamanio() + "\n");
			}
			
		}

		catch(Exception e)
		{ 
			e.printStackTrace(); 
		}

	}

	




	public IQueue <VODaylyStatistic> getDailyStatistics () 
	{
		return null;
	}

	public IStack <VOMovingViolations> nLastAccidents(int n) 
	{
		return null;
	}


}
