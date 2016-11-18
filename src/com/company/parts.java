package com.company;

/**
 * Created by dpennebacker on 11/14/16.
 */
public class parts {
        public parts(String a){
            String cut[] = a.split("\\s");
            absences = Integer.parseInt(cut[cut.length-1]);
            grade = Double.parseDouble(cut[cut.length-2].substring(0, 2));
            //cuz Van Winkle makes things difficult
            name = "";
            for(int i=0; i<=cut.length-3; i++){
                name += cut[i] + " ";
            }

        }
        public String name;
        public double grade;
        public int absences;

    }

