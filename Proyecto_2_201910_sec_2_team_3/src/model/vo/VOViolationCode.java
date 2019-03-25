package model.vo;


public class VOViolationCode  implements Comparable<VOViolationCode> 
{

	private String ViolationCode; 
	
	private int fineAmt;
	
	private int total;
	
	public String getViolationCode() 
	{
		return ViolationCode;
	}

	public int darFineAtm()
	{
		return fineAmt;
	}

	public VOViolationCode( String pViolationCode , int pFineAmt )
	{
		ViolationCode = pViolationCode;
		fineAmt = pFineAmt;
		total = 1;
	}

	public void registrarNueva(int pFineAmt)
	{
		fineAmt += pFineAmt;
		total++;
	}
	
	public double getAvgFineAmt() 
	{
		return (fineAmt / total);
	}

	@Override
	public int compareTo(VOViolationCode o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
