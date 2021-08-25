package com.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Logic {

	public static void main(String[] args) throws IOException {

		Scanner scan=new Scanner(System.in);

		System.out.print("Please enter the option "
				+"\n"+ "\n 1:Retrieving the file names in an ascending order"
				+"\n"+ " \n 2:For CRUD operation "
				+"\n"+ "\n 3:Close the application" );

		int z=0;
		int n;
		int listFile=0;

		do
		{
			n=scan.nextInt();
			switch(n)
			{
			case 1:
			{

				try {

					File dir=new File("D:\\Online-test-application-main\\Phase2");

					File[] files=dir.listFiles();

					Arrays.sort(files, (f1, f2) -> f1.compareTo(f2));

					for( File file:files)
					{
						if(!file.isHidden())
						{
							if(!file.isDirectory())
							{
								System.out.println("FILE\t" + file.getName());
							}

						}
					}
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}



			}break;


			case 2:
			{
				System.out.println("\n please select the option\n");
                              

				System.out.println("\n 1:Add file \n\n 2:Delete file \n\n 3:Search file \n\n 4:Go to main menu");

				int k=scan.nextInt();
				switch(k)
				{
				case 1:
				{
					System.out.println("Enter the file name to create");
					String name=scan.nextLine();


					try
					{
						String n1=scan.nextLine();
						File myObj=new File("D:\\Online-test-application-main\\Phase2\\"+n1+".txt");

						if(myObj.createNewFile())
						{
							System.out.println("file created "+myObj.getName());
						}
						else
						{
							System.out.println("file alredy exist");
						}


					}catch (Exception e) {
						// TODO: handle exception
					}


				}break;



				case 2:{

					System.out.println("Enter the file name to delete");
					String name=scan.nextLine();


					try
					{
						String n1=scan.nextLine();
						File myObj=new File("D:\\Online-test-application-main\\Phase2\\"+n1+".txt");

						if(myObj.delete())
						{
							System.out.println("file deleted "+myObj.getName());
						}
						else
						{
							System.out.println("file alredy deleted or file is not present");
						}


					}catch (Exception e) {
						// TODO: handle exception
					}
				}break;
				case 3:
				{
					System.out.println("enter file name to search");
					String name=scan.next();
					File directory=new File("D:\\Online-test-application-main\\Phase2\\");

					String[] flist=directory.list();
					int flag=0;

					if(flist==null)
					{
						System.out.println("Empty directory.");
					}else
					{
						for(int i=0;i<flist.length;i++)
						{
							String filename=flist[i];

							if(filename.equalsIgnoreCase(name+".txt"))
							{
								System.out.println(filename+ " Found");
								flag=1;
							}
						}
					}

					if(flag ==0)
					{
						System.out.println("File not found");
					}




				}break;

				case 4:
				{
					System.out.print("Please enter the option "
							+ "\n 1:Retrieving the file names in an ascending order"
							+ " \n 2:For CRUD operation "
							+ "\n 3:Close the application" );


				}break;

				default:
				{
					System.out.println("Enter the correct option");
				}
				}
			}break;

			case 3:
			{
				System.out.println("Application close");
				System.exit(z);

			}break;

			default:
			{
				System.out.println("please select correct option");
			}

			}
		}while(z<100);
	}



}
