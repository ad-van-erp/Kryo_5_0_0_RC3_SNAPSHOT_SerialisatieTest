package com.transactionalit.kryotest.objects;

/**
 * @author Ad van Erp.
 */
public class Project {

    private final String name;
    private final MainSerializableObject mainSerializableObject;

    public Project(final String name, final MainSerializableObject mainSerializableObject) {

        this.name = name;
        this.mainSerializableObject = mainSerializableObject;
    }


    public String getName() {

        return name;
    }

    public MainSerializableObject getMainSerializableObject() {

        return mainSerializableObject;
    }
}
