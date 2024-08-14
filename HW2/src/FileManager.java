import java.io.File;  
import java.io.FileWriter;
import java.io.IOException;  

public class FileManager {

	boolean fileCreated;
	static boolean isFileWritable;
	static String fileName;
	static FileWriter myWriter;
	
	public FileManager(String fileName) {
		fileCreated = false;
		FileManager.fileName = fileName;
		createFile();
		writeHeadline();
	}

	public void closeFile() {
		closingFile();
	}
	
	private void writeHeadline() {
		String line1 = getSpacedLine("Vehicle");
		String line2 = getSpacedLine("Passenger");
		String line3 = getSpacedLine("From");
		String line4 = getSpacedLine("To");
		
		String line = line1 +"|"+ line2 +"|"+line3+"|"+line4;
		append(line);
		String headline = "---------------|---------------|---------------|---------------";
		append(headline);
	}

	private void createFile() {
		if (fileCreated) {
			return;
		}
		try {
			File myFile = new File("src\\" + fileName);
			if (myFile.createNewFile()) {
				fileCreated = true;
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		openFileForWriting();
	}
	
	private void openFileForWriting() {
		try {
		      myWriter = new FileWriter("src\\" + fileName);
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		isFileWritable = true;
	}
	
	private void closingFile() {
		if(!isFileWritable) {
			return;
		}
		try {
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	
	private static void append(String line) {
		if(FileManager.isFileWritable) {
			try {
				myWriter.write(line + "\n");
		    } catch (IOException e) {
		    	System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
	}

	public static void writeToFile(Passenger passenger, Vehicle vehicle) {
		String line1 = getSpacedLine(vehicle.toString());
		String line2 = getSpacedLine(passenger.toString());
		String line3 = getSpacedLine(passenger.getPath().get(0).getStart().toString());
		String line4 = getSpacedLine(passenger.getPath().get(passenger.getPath().size() - 1).getEnd().toString());
		
		String line = line1 +"|"+ line2 +"|"+line3+"|"+line4;
		append(line);
	}

	public static String getSpacedLine(String val) {
		String result = "";
		String gottenString = val;
		int spaceCounter = 15 - gottenString.length();
		while(spaceCounter > 1) {
			result = result + " ";
			gottenString = gottenString + " ";
			spaceCounter = spaceCounter - 2;
		}
		result = result + gottenString;
		if (spaceCounter > 0) {
			result = result + " ";
		}
		return result;
	}
}
