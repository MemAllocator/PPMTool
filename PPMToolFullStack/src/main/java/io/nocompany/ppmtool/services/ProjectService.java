package io.nocompany.ppmtool.services;

import io.nocompany.ppmtool.domain.Project;
import io.nocompany.ppmtool.exceptions.ProjectIdException;
import io.nocompany.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID " + project.getProjectIdentifier().toUpperCase() + " already exists");
        }

    }
}
