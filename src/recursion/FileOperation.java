package recursion;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperation {

	public static void deleteDirectoryNIO(String path) throws DeleteException{
		try {
			Path dirToDelete = Paths.get(path);
			DirectoryStream<Path> dir = Files.newDirectoryStream(dirToDelete);
			for (Path file : dir) {
				if (Files.isDirectory(file)) {
					deleteDirectoryNIO(file.toString());
				} else {
					Files.deleteIfExists(file);
				}
			}
			dir.close();
			Files.delete(dirToDelete);
			System.out.println("Folder " + dirToDelete.toString().toUpperCase() + " deleted");
		} catch (InvalidPathException e) {
			throw new DeleteException("InvalidPathException " + e.getMessage());
		} catch (NoSuchFileException e) {
			throw new DeleteException("Folder doesn't exist. " + e.getMessage());
		} catch (DirectoryNotEmptyException e) {
			throw new DeleteException("DirectoryNotEmptyException " + e.getMessage());
		} catch (NotDirectoryException e) {
			throw new DeleteException("NotDirectoryException " + e.getMessage());
		} catch (IOException e) {
			throw new DeleteException("IOException " + e.getMessage());
		}
	}

	public static boolean deleteDirectoryIO(String dir) {
		File path = new File(dir);
		if (path.exists()) {
			File[] files = path.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					deleteDirectoryIO(file.getPath());
				} else {
					file.delete();
				}
			}
		}
		System.out.println("Folder " + path + " deleted");
		return (path.delete());
	}
}
