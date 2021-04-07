package pkg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

//Authored by Nicholas Foster
//4-6-2021 2am

public class DatabaseII<T extends Profile>{
	protected Class<T> dataType;
	protected Vector<T> dao;
	private String dataLocation;
	
	DatabaseII(Class<T> dt, String s){
		this.dataType = dt;
		dao = new Vector<T>();
		dataLocation = s;
		loadData();
	}

	@SuppressWarnings("unchecked")
	private void loadData() {
		DataReader reader = new DataReader(dataLocation);
		try {
			Vector<String[]> tempData = reader.readFile();
			for(String[] data : tempData){
				dao.add((T) ProfileFactory.makeProfile(dataType.getSimpleName(), data));
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("fileNotFound - " + dataLocation);
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println("IOException in Database");
			System.out.println(e.getMessage());
		}
	}
	
	public Vector<T> getData(){
		return dao;
	}
	
	public Class<T> getClassName(){
		return dataType;
	}
}