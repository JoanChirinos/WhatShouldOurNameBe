/*
       __                     ________    _      _
      / /___  ____ _____     / ____/ /_  (_)____(_)___  ____  _____
 __  / / __ \/ __ `/ __ \   / /   / __ \/ / ___/ / __ \/ __ \/ ___/
/ /_/ / /_/ / /_/ / / / /  / /___/ / / / / /  / / / / / /_/ (__  )
\____/\____/\__,_/_/ /_/   \____/_/ /_/_/_/  /_/_/ /_/\____/____/

~Joan Chirinos, December 25, 2017
*/

/***************************************************************************
* Generic File Reader/Writer
* Use read(fileName) to read a text file. Returns a String
* Use write(toWrite, fileName) to write a String to a file
* Methods:
*    read(String)
*    write(String, String)
***************************************************************************/

import java.io.*;

public class FileRW {

  /**
  * Reads contents of file fileName
  * @param  fileName The String name of the file you're reading
  * @return String with file contents
  * @throws IllegalArgumentException File does not exists
  * @throws IllegalArgumentException Unable to read file
  */

  public static String read(String fileName) {
    File f = new File("./" + fileName);
    if (!(f.exists()))
    throw new IllegalArgumentException("\n\tFile does not exist");
    String ret = "";
    try {
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);
      String toAdd;
      while ((toAdd = br.readLine()) != null)
      ret += toAdd + "\n";
    }
    catch (IOException e) {
      throw new IllegalArgumentException("\n\tUnable to read file");
    }
    return ret;
  }//end read

  /**
  * Writes String toWrite to file fileName
  * @param toWrite  String containing what you want to write
  * @param fileName String name of file to write to
  * @return String toWrite;
  */
  public static String write(String toWrite, String fileName) {
    File f = new File(fileName);
    f.delete();
    try {
      FileWriter fw = new FileWriter(fileName);
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(toWrite);
      bw.close();
    }
    catch (IOException e) {
      throw new IllegalArgumentException("\n\tCannot write to file");
    }
    return toWrite;
  }//end write

}//end class
