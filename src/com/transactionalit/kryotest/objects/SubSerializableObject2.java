package com.transactionalit.kryotest.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ad van Erp.
 */
public class SubSerializableObject2 {

    private final String name = "SubSerializableObject2";
    private final List<SerializableListItem> items = new ArrayList<>();


    public SubSerializableObject2() {

        this.items.add(new SerializableListItem("Item1"));
        this.items.add(new SerializableListItem("Item2"));
        this.items.add(new SerializableListItem("Item3"));
    }


    public String getName() {

        return name;
    }

    public List<SerializableListItem> getItems() {

        return items;
    }
}
