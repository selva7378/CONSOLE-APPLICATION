package com.selva7378.interviewpannel.datalayer;

import com.selva7378.interviewpannel.model.Admin;
import com.selva7378.interviewpannel.model.Interviewee;
import com.selva7378.interviewpannel.model.Receptionist;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class InterviewPannelDatabase {
    private static InterviewPannelDatabase interviewPannel;
    private static final String FILE_PATH = "/Users/selvaganesh/Downloads/zoho/zoho_tasks/consoleApplication/InterviewPannel/src/com/selva7378/interviewpannel/datalayer/data.json";
    private static Gson gson = new Gson();
    private Queue<Interviewee> interviewees = new LinkedList<Interviewee>();
    private Queue<Interviewee> completedInterviewees = new LinkedList<Interviewee>();
    private Receptionist receptionist;
    private Admin admin;

    private InterviewPannelDatabase(){

    }

    public void saveData() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean loadData() {
        File file=new File(FILE_PATH);
        if (file.length()==0)
            return false;
        try (FileReader reader = new FileReader(FILE_PATH)) {
            InterviewPannelDatabase database = gson.fromJson(reader, InterviewPannelDatabase.class);
//			System.out.println("Data loaded successfully.");
            interviewees = database.interviewees;
            receptionist = database.receptionist;
            completedInterviewees = database.completedInterviewees;
            admin = database.admin;
        } catch (IOException e) {
            e.printStackTrace();
//			System.err.println("Failed to load data: " + e.getMessage());
        }
        return false;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void addAdmin(Admin admin){
        this.admin = admin;
    }
    public void addReceptionist(Receptionist receptionist){
        this.receptionist = receptionist;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public static InterviewPannelDatabase getInstance(){
        if(interviewPannel == null){
            interviewPannel = new InterviewPannelDatabase();
        }
        return interviewPannel;
    }

    public boolean insertInterviewees(Interviewee interviewee){
        boolean hasInterviewee = false;
        for(Interviewee intervieweel: interviewees){
            if(intervieweel.getName().equals(interviewee.getName())){
                hasInterviewee = true;
            }
        }
        if(hasInterviewee){
            return false;
        }else{
            interviewees.add(interviewee);
            return true;
        }
    }

    public boolean isIntervieweesListEmpty(){
        return interviewees.isEmpty();
    }
    public boolean isCompletedIntervieweesListEmpty(){
        return completedInterviewees.isEmpty();
    }

    public Queue<Interviewee> getInterviewees(){
        return interviewees;
    }

    public Queue<Interviewee> getCompletedInterviewees(){
        return completedInterviewees;
    }

    public String  markOnGoingInterviewCompleted(){
        Interviewee interviewee = interviewees.remove();
        completedInterviewees.add(interviewee);
        return interviewee.getName();
    }

}
