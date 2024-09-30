package se.kth.olof.beyar.labb3.delb.model;

import se.kth.olof.beyar.labb3.delb.model.exceptions.TitleNotUniqueException;

import java.util.ArrayList;
import java.util.List;

public class ProjectsManager {
    private int nextProjectId;
    private final ArrayList<Project> projects;

    /**
     * Constructs a new ProjectsManager.
     * Initializes an empty list of projects and sets the next project ID to 0.
     */
    public ProjectsManager() {
        this.projects = new ArrayList<>();
        this.nextProjectId = 0;
    }

    /**
     * Sets the list of projects to a new collection.
     *
     * @param incomingProjects The new list of projects to set.
     */
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

    /**
     * Gets a copy of the list of all projects.
     *
     * @return A new ArrayList containing all projects.
     */
    public List<Project> getProjects() {
        return new ArrayList<>(projects);
    }

    /**
     * Checks if a given project title is unique.
     *
     * @param title The title to check for uniqueness.
     * @return true if the title is unique, false otherwise.
     * @throws TitleNotUniqueException if the title is not unique.
     */
    public boolean isTitleUnique(String title) throws TitleNotUniqueException {
        List<Project> projects = findProjects(title);

        for (Project project : projects)
            if ((project.getTitle()).equals(title))
                return false;

        return true;
    }

    /**
     * Adds a new project to the manager.
     *
     * @param title The title of the new project.
     * @param description The description of the new project.
     * @return The newly created Project object.
     * @throws TitleNotUniqueException if the title is not unique.
     */
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

    /**
     * Removes a project from the manager.
     *
     * @param project The project to be removed.
     */
    public void removeProject(Project project) {
        projects.remove(project);
    }

    /**
     * Retrieves a project based on its ID.
     *
     * @param id The ID of the project to retrieve.
     * @return The Project object with the specified ID.
     */
    public Project getProjectById(int id) {
        return projects.get(id);
    }

    /**
     * Finds projects whose titles contain the given string (case-insensitive).
     *
     * @param titleStr The string to search for in project titles.
     * @return A list of projects whose titles contain the search string.
     */
    public List<Project> findProjects(String titleStr) {
        ArrayList<Project> filteredProjects = new ArrayList<>();

        for (Project project : projects) {
            // toLowerCase() för att vi söker med case-insensitive
            if (project.getTitle().toLowerCase().contains(titleStr.toLowerCase())) {
                filteredProjects.add(project);
            }
        }

        return filteredProjects;
    }

    /**
     * Gets the highest project ID currently in use.
     *
     * @return The highest project ID.
     */
    private int getHighestId() {
        return projects.getLast().getId();
    }

    @Override
    public String toString() {
        return "ProjectsManager {" + "nextProjectId=" + nextProjectId + '}';
    }
}
