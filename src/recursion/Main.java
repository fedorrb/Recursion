package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter full name of the folder to delete...");
			String folder = input.readLine().trim();
			if (folder.length() == 0)
				throw new IllegalArgumentException("Folder doesn't exist.");
			System.out.println("Do you really want to delete the folder '" + folder + "'");
			System.out.println("and all subfolders with files (y/n)?");
			if (input.readLine().equalsIgnoreCase("y")) {
				try {
					FileOperation.deleteDirectoryNIO(folder);
				} catch (DeleteException e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Delete problem.");
		}
	}

}