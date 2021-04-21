package pkg;

//Authored by Nicholas Foster

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class DataReader {
	//This class's purpose in life is to read our text data files into the system and export changed in those text files.
	private File file;
	
	DataReader(String fileName){
		file = new File(fileName);
	}
	
	public Vector<String[]> readFile() throws IOException, FileNotFoundException{
		//create our container to be returned
		Vector<String[]> vec = new Vector<String[]>();
    	FileReader myFile = new FileReader(file);
    	String line;
    	
    	//create a buffer for our file reading
    	BufferedReader reader = new BufferedReader(myFile);
    	
		do {
			//read a line from our file
			line = reader.readLine();
			
			//if the line isn't empty
			if(line != null) {
				//split the line by tabular delimination and put it into a string array
				String[] data = line.split("\t");
				//add our string array to our return vector
				vec.add(data);
			}
		}while(line != null);
		//close all open readers and objects
		reader.close();
		myFile.close();
		
		//returns a vector containing our now broken string arrays
		return vec;
	}
	
	public <E> void writeFile(Vector<E> data) throws IOException{
		//make a filewriter object opened to our current file, file will be overwritten with all contents of data vector
		FileWriter author = new FileWriter(file, false);
		
		for(E obj : data) {
			//all objects that intend to use this method will require an overridden toString method
			author.write(obj.toString());
		}
		author.close();
	}
}
