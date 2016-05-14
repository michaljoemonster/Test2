import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Test2
{
	public  static void main (String [] args) throws IOException
{
		
		FileOutputStream FOS = new FileOutputStream ("przykladowy.zip");
		ZipOutputStream ZOS = new ZipOutputStream (FOS);
		ZOS.setLevel(9);
	
		String testowy = "Hello world this is Micha³ czy uda mi siê napisaæ d³u¿szy tekst?! \r\nco ??";
		byte [] bajty = testowy.getBytes();
			ZipEntry ZE = new ZipEntry("TAKIpliczek.txt");
			ZOS.putNextEntry(ZE);
			ZOS.write(bajty);
			ZOS.closeEntry();
	ZOS.close();

 ZipInputStream ZIS = new ZipInputStream (new FileInputStream("przykladowy.zip"));

ZipEntry ZE2 = ZIS.getNextEntry();

//System.out.println(ZE2.getName() + " dostepne bity dla ZIS: " + ZIS.available());
//System.out.println("rozmiar ZipEntry: " + ZE2.getSize());
int j = 0;

ArrayList<Byte> odbior = new ArrayList<Byte>();
boolean kontynuacja = true;
byte b = 0;

try{
while (kontynuacja)
{	j++;
	int ii = ZIS.read();
	b = (byte) ii;
if (b == -1)
	{kontynuacja = false ; }
else
{
odbior.add(b);
// System.out.println(b);
}
}
}
catch (EOFException e)
{
	System.out.println("Iteracja: " + j + " rozmiar ZipEntry: " + ZE2.getSize());
	e.printStackTrace();
}
ZIS.closeEntry();
ZIS.close();
byte [] odebraneBajty = new byte[odbior.size()];
int licznik = 0;
for (byte bajt : odbior)
{	
odebraneBajty[licznik] = bajt;
licznik++;
}


 System.out.println(new String(odebraneBajty)); 
 ZipFile plikZip = new ZipFile ("przykladowy.zip");
 Enumeration pozycje = plikZip.entries();
 ZipEntry pozycja = (ZipEntry) pozycje.nextElement();
 System.out.println(pozycja.getName());
 InputStream strumien = plikZip.getInputStream(pozycja);
 FilterInputStream strumienFiltrowy = new DataInputStream(strumien);
ArrayList <Byte> tablica = new ArrayList<Byte>();
while (true)
{	
 byte bbb = (byte) strumienFiltrowy.read();
// System.out.println(bbb);
if (bbb == -1) break;
 tablica.add(bbb);
}
Byte [] tablicaB;
tablicaB = tablica.toArray(new Byte [0]);
byte [] tablicaBB = new byte [tablicaB.length]; 
for (int i = 0; i < tablicaB.length; i++)
{
	tablicaBB[i] = tablicaB[i];
}

 System.out.println(new String(tablicaBB));
 File DyskD = new File ("D://");
 String [] pliki = DyskD.list();
 ArrayList <String>plikiA = new ArrayList<String>(Arrays.asList(pliki));
 ArrayList<File> sciezkiD = new ArrayList<File>();
 int i = 0;
 for (String a : plikiA)
 {
	 sciezkiD.add(new File(DyskD + a));
	
 }
 
 for (File p : sciezkiD)
 {
	 i++;
	 try {
	if (p.canRead() && p.isDirectory() && p.list().length == 0)
	{
		System.out.println(p + " to pusty folder");
		
	}
	 }
	 catch (NullPointerException e)
	 {
		 e.printStackTrace();
		 System.out.println(i + " " + p.getAbsolutePath() );
	 }
 }
 Path DyskDPath = DyskD.toPath();
}

}