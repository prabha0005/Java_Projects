package Task_management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public  class Taskmanager {
    Scanner sc=new Scanner(System.in);
    private Map<Integer,Task>map=new HashMap<>();
    int idcount=0;
    void addTask(){
        System.out.println("Enter the task name: ");
        String name=sc.nextLine();
        System.out.println("Enter task Discription: ");
        String disc=sc.nextLine();
        Date duedate=null;
        while (duedate==null) {
            duedate=getdate();
            
        }
        Priority priority=getpriority();
        System.out.println("Enter the Catagories: ");
        Set<String> catagories=getcatagorie();
        map.put(++idcount,new Task(idcount, name,disc,duedate,priority,catagories));
        System.out.println("<<<<<Succesfull>>>");   
    }

    private Set<String> getcatagorie() {
        String str=sc.nextLine();
        String[] parts=str.split(",");
        Set<String> cata=new HashSet<>();
        for(String s:parts){
            String trimmed=s.trim();
            cata.add(trimmed);
        }
     return cata;   
    }

    private Priority getpriority(){
    System.out.println("Enter the Priority: ");
    String str=sc.nextLine().toUpperCase();
    try {
        return Priority.valueOf(str);
        
    } catch (Exception e) {
        System.out.println("INVALID PRIORITY...DEFAULT TO MEDIUM");
        return Priority.MEDIUM;
    }
    }

    private Date getdate(){
        System.out.print("Enter the Date:(dd-mm-yyyy) ");
        String str=sc.nextLine(); 
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date= dateFormat.parse(str);
            if(date.before(new Date())){
                System.out.println("Enter the future date");
                return null;
            }
            return date;
        } catch (ParseException e) {
            System.out.println("Invalid Date");
        }
        return null;
    }

    private String datetostring(Date duedate) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
         String date=dateFormat.format(duedate);
         return date;
       
    }

    void display(){
        System.out.println("------showing------");
        for(Map.Entry<Integer,Task> en:map.entrySet()){
            System.out.println("Task Id :"+ en.getKey()+" | "+"Task Name :"+en.getValue().getname()+
           " | "+" Task Discripion: "+en.getValue().getDisc()+" | "+"Task DueDate: "+
           datetostring(en.getValue().getDuedate())+" | "+"Task priority: "+en.getValue().getPriority()+" | "+"Task Catagories: "+settoString(en.getValue().getCatagories()));
        }
    }

    private String settoString(Set<String> catagories) {
      return String.join(", ", catagories);
    }

    void viewbypriority(){
        Map<Priority,List<Task>>tasks=new HashMap<>();
        for(Priority p:Priority.values()){
            tasks.put(p,new ArrayList<>());
        }
        for(Task task:map.values()){
            tasks.get(task.getPriority()).add(task);
        }
       viewTask("HIGH", tasks.get(Priority.HIGH));
       viewTask("MEDIUM", tasks.get(Priority. MEDIUM));
       viewTask("LOW", tasks.get(Priority.LOW));
        
    } 
   

    void viewTask(String s,List<Task>tasks){
        if(!tasks.isEmpty()){
            System.out.println("----------- "+s+" Priority Tasks");
        }
        for(Task task:tasks){
            System.out.println("Task Id :"+ task.getIdcount()+" | "+"Task Name :"+task.getname()+
           " | "+" Task Discripion: "+task.getDisc()+" | "+"Task DueDate: "+
           datetostring(task.getDuedate())+" | "+"Task priority: "+task.getPriority());
        }
    }
}
