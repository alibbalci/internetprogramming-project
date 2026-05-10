package bean;

import entity.Meeting;
import facadeLocal.MeetingFacadeLocal;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class MeetingBean implements Serializable {

    private Meeting meeting = new Meeting();

    @EJB
    private MeetingFacadeLocal meetingFacade;

    public void createMeeting() {
        meetingFacade.create(meeting);
        meeting = new Meeting();
    }

    public void updateMeeting() {
        meetingFacade.edit(meeting);
        meeting = new Meeting();
    }

    public void deleteMeeting(Meeting selectedMeeting) {
        meetingFacade.remove(selectedMeeting);
    }

    public void selectMeeting(Meeting selectedMeeting) {
        this.meeting = selectedMeeting;
    }

    public void clearForm() {
        this.meeting = new Meeting();
    }

    public List<Meeting> getMeetings() {
        return meetingFacade.findAll();
    }

    public Meeting getMeeting() {
        if (meeting == null) {
            meeting = new Meeting();
        }
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }
}
