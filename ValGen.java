import java.io.*;


public class ValGen{

	private String fileName;

	public ValGen(String fname)
	{
		fileName=fname;
	}

	public void genFile()
	{
		int i=0;
		int j=0;
		int k=0;
		int n=5;
		String sVal="";

		for (int l=0;l<2;l++)
		{
			for (i=0; i<n; i++)
			{
				for (j=0;j<n;j++)
				{
					for (k=0;k<n;k++)
					{
						if (i>2)
							sVal+="("+i+","+j+","+k+","+l+")=100.0\n";
						else
							sVal+="("+i+","+j+","+k+","+l+")=50.0\n";
					}
				}
			}
		}
		try
		{
			FileOutputStream outFile=new FileOutputStream(fileName,true);
			outFile.write(sVal.getBytes());
			outFile.close();
			System.out.println("initial values have been created in"+fileName);
		}

		catch (java.io.IOException e)
		{
			System.out.println("error opening file:"+fileName);
			System.exit(1);
		}
	}


	public static void main(String [] args)
	{
		ValGen val = new ValGen("D:\\University\\ELG6187\\Assign2\\rd2.val");
		val.genFile();
		System.exit(0);

	} //end of main

}  //end of class
