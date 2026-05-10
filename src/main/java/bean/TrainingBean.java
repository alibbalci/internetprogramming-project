package bean;

import entity.Training;
import facadeLocal.TrainingFacadeLocal;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class TrainingBean implements Serializable {

    private Training training = new Training();

    @EJB
    private TrainingFacadeLocal trainingFacade;

    public void createTraining() {
        trainingFacade.create(training);
        training = new Training();
    }

    public void updateTraining() {
        trainingFacade.edit(training);
        training = new Training();
    }

    public void deleteTraining(Training selectedTraining) {
        trainingFacade.remove(selectedTraining);
    }

    public void selectTraining(Training selectedTraining) {
        this.training = selectedTraining;
    }

    public void clearForm() {
        this.training = new Training();
    }

    public List<Training> getTrainings() {
        return trainingFacade.findAll();
    }

    public Training getTraining() {
        if (training == null) {
            training = new Training();
        }
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}
