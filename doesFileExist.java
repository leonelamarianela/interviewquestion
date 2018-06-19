package framework.InterviewTasks;

import java.io.*;

/**
 * Created by Leonela on 6/09/2018.
 * * Question 1:

 There is a file containing a word and its possible meanings (like a Dictionary). The contents of the file look like this:

 Apple – a fruit, a tech firm
 Table – an object, contains rows and columns when used in context of computers
 Orange – a fruit

 Given a path to the file, do the following:

 Create a method called doesFileExist(String path) which takes the path of the file and tells the user if the file exists at that path or not. Assume all paths are relative to your project structure. If the file does not exist, catch the requisite exception.
 Read each word and its possible meanings and print them out. Your output should look like this:

 Word1
 Meaning 1
 Meaning 2
 Word2
 Meaning1
 Meaning2
 */
public class doesFileExist {


        public static void main (String[] args){
            System.out.println(doesFileExist("/Users/Leonela/Desktop/dictionary.txt"));
        }

        public static boolean doesFileExist(String path){
            FileInputStream inputStream = null;
            boolean flag = false ;

            try {
                inputStream = new FileInputStream("/Users/Leonela/Desktop/dictionary.txt");
                flag = true;
            } catch (FileNotFoundException e) {
                System.out.println("file does not exist");
                e.printStackTrace();
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line = null;
                while((line = br.readLine()) != null) {
                    String[] word = line.split("-");
                    System.out.println(word[0]);
                    String[] meaning = word[1].split(",");

                    for (String s : meaning) {

                        System.out.println(s.trim());
                    }
                    System.out.println("  ");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return flag;
        }





}
