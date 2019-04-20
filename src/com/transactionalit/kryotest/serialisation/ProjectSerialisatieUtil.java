package com.transactionalit.kryotest.serialisation;


import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.transactionalit.kryotest.objects.MainSerializableObject;
import com.transactionalit.kryotest.objects.Project;
import com.transactionalit.kryotest.objects.SerializableListItem;
import com.transactionalit.kryotest.objects.SubSerializableObject1;
import com.transactionalit.kryotest.objects.SubSerializableObject2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author Ad van Erp.
 */
public interface ProjectSerialisatieUtil {


    static void serialiseerNaarProjectfile(Project project) {

        try {
            String projectnaam = project.getName();

            String filenaam = projectnaam + ".ser";
            File file = new File(filenaam);

            serialseerObject(project, file);

        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }
    static Project deserialiseerUitProjectfile(final String nameProject) throws FileNotFoundException {

        Project project = null;

        project = deserialiseerProject(nameProject);


        return project;
    }

    private static Project deserialiseerProject(final String nameProject) throws FileNotFoundException {

        final FileInputStream fi;

        fi = new FileInputStream(nameProject + ".ser");
        Input input = new Input(fi);

        Kryo kryo = new Kryo();
        registreerKlassen(kryo);

        Project project = (Project) kryo.readClassAndObject(input);
        input.close();
        return project;
    }


    private static void serialseerObject(final Project actueelProject, final File file) throws IOException {

        FileOutputStream fo = new FileOutputStream(file);
        Output output = new Output(fo);
        ObjectOutputStream so = new ObjectOutputStream(fo);

        Kryo kryo = new Kryo();

        registreerKlassen(kryo);

        kryo.writeClassAndObject(output, actueelProject);
        output.close();
    }


    private static void registreerKlassen(final Kryo kryo) {

        kryo.register(java.util.ArrayList.class,                10);
        kryo.register(java.util.HashMap.class,                  11);
        kryo.register(java.util.TreeSet.class,                  12);
        kryo.register(java.util.TreeMap.class,                  13);
        kryo.register(Project.class,                            14);
        kryo.register(MainSerializableObject.class,             15);
        kryo.register(SubSerializableObject1.class,             16);
        kryo.register(SubSerializableObject2.class,             17);
        kryo.register(SerializableListItem.class,               18);
    }


}
