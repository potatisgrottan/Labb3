package se.kth.olof.beyar.labb3.projectApp.model;

import java.util.List;

public class ProjectsManager {
    private int nextProjectId;

    public ProjectsManager() {}

    public List<Project> setProjects(List<Project> incomingProjects) {
        //TODO implement
    }

    public boolean isTitleUnique(String title) {
        //TODO implement
        return false;
    }

    public Project addProject(String title, String descr) throws TitleNotUniqueException {
        //TODO implement
    }

    public void removeProject(Project project) {
        //TODO implement
    }

    public Project getProjectById(int id) {
        //TODO implement
    }

    public List<Project> findProjects(String titleStr) {
        //TODO implement
    }

    private int getHighestId() {
        //TODO implement
    }

    @Override
    public String toString() {
        return "ProjectsManager {" + "nextProjectId=" + nextProjectId + '}';
    }
}
