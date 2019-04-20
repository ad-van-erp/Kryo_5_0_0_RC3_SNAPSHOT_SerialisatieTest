package com.transactionalit.kryotest.objects;

/**
 * @author Ad van Erp.
 */
public class SerializableListItem {

    private final String name;

    public SerializableListItem(final String name) {

        this.name = name;
    }


    public String getName() {

        return name;
    }
}
