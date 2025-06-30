package Task_management;

import java.util.Date;
import java.util.Set;

public class Task {
    private int task_id;
    private String task_name;
    private String Discription;
    private Date duedate;
    private Priority priority;
    private Set<String> catagories;
    
    Task(int task_id,String task_name,String Discription,Date duedate,Priority priority,Set<String>catagories){
        this.task_id=task_id;
        this.task_name=task_name;
        this.Discription=Discription;
        this.duedate=duedate;
        this.priority=priority;
        this.catagories=catagories;
    }
    public String getname(){
        return task_name;
    }
    public String getDisc(){
        return Discription;
    }
    public Date getDuedate() {
        return duedate;
    }
    public Priority getPriority(){
        return priority;
    }
     public int getIdcount() {
    return task_id;
}
public Set<String>getCatagories(){
    return catagories;
}

}
