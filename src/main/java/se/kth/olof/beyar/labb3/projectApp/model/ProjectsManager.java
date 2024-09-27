package se.kth.olof.beyar.labb3.projectApp.model;

import se.kth.olof.beyar.labb3.projectApp.model.exceptions.TitleNotUniqueException;

import java.util.List;

public class ProjectsManager {
    private int nextProjectId;

    public ProjectsManager() {}

    public void setProjects(List<Project> incomingProjects) {
        //TODO implement
    }

    public List<Project> getProjects() {
        //TODO implement
        return null;
    }

    public boolean isTitleUnique(String title) {
        //TODO implement
        /*List<Project> projects = findProjects(title);
        for(int i=0; i<projects.size();i++)
        {
            if((projects.get(i)).equals(title)){
                throw new TitleNotUniqueException(title+" is not unique");
            }
        }*/

        return false;
    }

    public Project addProject(String title, String descr) throws TitleNotUniqueException
    {
        //TODO implement
        return null;
    }

    public void removeProject(Project project) {
        //TODO implement
    }

    public Project getProjectById(int id) {
        //TODO implement
        return null;
    }

    public List<Project> findProjects(String titleStr) {
        //TODO implement

        return null;
    }

    private int getHighestId() {
        //TODO implement
        return 0;
    }

    @Override
    public String toString() {
        return "ProjectsManager {" + "nextProjectId=" + nextProjectId + '}';
    }
}
