package com.company;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        //creates a String array
        Scanner txtfile = new Scanner(new File("Imports.txt"));
        int maxIndx = -1;
        String lines[] = new String[1000];
        while(txtfile.hasNext()){
            maxIndx++;
            lines[maxIndx] = txtfile.nextLine();
        }
        //instantiates an object array. It starts at 1 cuz  line[0] is the title
        parts persons[] = new parts[maxIndx+1];
        for(int i=1; i<persons.length;i++){
            persons[i] = new parts(lines[i]);
        }
        txtfile.close();
        int acount=0, bcount=0, ccount=0, dcount=0, fcount=0;
        double avg =0;
        for(int j=1; j<persons.length;j++){
            avg += persons[j].grade;
            if(persons[j].grade>= 89.5)
                acount++;
            else if(persons[j].grade>= 79.5)
                bcount++;
            else if(persons[j].grade>= 69.5)
                ccount++;
            else if(persons[j].grade>= 59.5)
                dcount++;
            else
                fcount++;
        }
        //its minus 1 since the length counts the topics
        avg /= persons.length-1;
        System.out.println("Average: " + avg);
        System.out.println("There are "+acount+" A's, "+bcount+" B's, "+ccount+" C's, "+dcount+" D's, and "+fcount+" F's.");
        Scanner input = new Scanner(System.in);
        String choice;

        while(true){
            System.out.println("Type in a First AND Last Name to seach. If your done type EXIT.");
            choice = new String(input.nextLine());
            if(choice.equals("EXIT"))
                break;
            for(int j=1; j<persons.length;j++){
                if(choice.replaceAll("\\s","").equals(persons[j].name.replaceAll("\\s", ""))){
                    System.out.println("Name: "+persons[j].name);
                    System.out.println("Grade: "+persons[j].grade+"%");
                    System.out.println("Absenses: "+persons[j].absences);
                    if(persons[j].grade<69.5 && persons[j].absences >= 3)
                        System.out.println(persons[j].name+" needs to show up more to get a better grade.");
                }
            }


        }
    }
}
