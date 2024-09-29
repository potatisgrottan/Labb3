package se.kth.olof.beyar.labb3.projectApp.model;

import se.kth.olof.beyar.labb3.projectApp.model.exceptions.TitleNotUniqueException;

import java.util.ArrayList;
import java.util.List;

public class ProjectsManager {
    private int nextProjectId;
    private final ArrayList<Project> projects;

    public ProjectsManager() {
        this.projects = new ArrayList<>();
        this.nextProjectId = 0;
    }

    public void setProjects(List<Project> incomingProjects) {
        projects.clear();

        if (incomingProjects.isEmpty())
            nextProjectId = 0;
        else
        {
            nextProjectId = incomingProjects.getLast().getId();
            nextProjectId++;
            projects.addAll(incomingProjects);
        }
    }

    public List<Project> getProjects() {
        return new ArrayList<>(projects);
    }

    public boolean isTitleUnique(String title) throws TitleNotUniqueException {
        List<Project> projects = findProjects(title);

        for (Project project : projects)
            if ((project.getTitle()).equals(title))
                return false;

        return true;
    }

    public Project addProject(String title, String description)
    {
        if (!isTitleUnique(title)) {
            throw new TitleNotUniqueException(title + " is not unique");
        }

        Project project = new Project(title, description, nextProjectId);
        projects.add(project);
        nextProjectId++;
        return project;
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    public Project getProjectById(int id) {
        return projects.get(id);
    }

    public List<Project> findProjects(String titleStr) {
        ArrayList<Project> filteredProjects = new ArrayList<>();

        for (Project project : projects) {
            if (project.getTitle().equals(titleStr)) {
                filteredProjects.add(project);
                break;
            }
        }

        return filteredProjects;
    }

    private int getHighestId() {
        return projects.getLast().getId();
    }

    @Override
    public String toString() {
        return "ProjectsManager {" + "nextProjectId=" + nextProjectId + '}';
    }
}
