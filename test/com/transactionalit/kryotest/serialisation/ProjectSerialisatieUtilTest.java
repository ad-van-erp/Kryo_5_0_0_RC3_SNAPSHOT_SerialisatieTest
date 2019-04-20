package com.transactionalit.kryotest.serialisation;

import com.transactionalit.kryotest.objects.MainSerializableObject;
import com.transactionalit.kryotest.objects.Project;
import com.transactionalit.kryotest.objects.SubSerializableObject1;
import com.transactionalit.kryotest.objects.SubSerializableObject2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ad van Erp.
 */
class ProjectSerialisatieUtilTest {

    private Project project;

    @BeforeEach
    void setUp() {

        project = new Project("Project1", new MainSerializableObject(new SubSerializableObject1(), new SubSerializableObject2()));

    }

    @Test
    void serialiseerNaarProjectfile() throws FileNotFoundException {

        ProjectSerialisatieUtil.serialiseerNaarProjectfile(project);
        Project project1 = ProjectSerialisatieUtil.deserialiseerUitProjectfile(project.getName());

        assertEquals(project.getName(), project1.getName());
        assertEquals(project.getMainSerializableObject().getName(), project1.getMainSerializableObject().getName());

    }
}
