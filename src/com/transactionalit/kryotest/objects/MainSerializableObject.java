package com.transactionalit.kryotest.objects;

/**
 * @author Ad van Erp.
 */
public class MainSerializableObject {

    private final String name = "MainSerializableObject";
    private final SubSerializableObject1 subSerializableObject1;
    private final SubSerializableObject2 subSerializableObject2;

    public MainSerializableObject(final SubSerializableObject1 subSerializableObject1, final SubSerializableObject2 subSerializableObject2) {

        this.subSerializableObject1 = subSerializableObject1;
        this.subSerializableObject2 = subSerializableObject2;
    }



    public String getName() {

        return name;
    }

    public SubSerializableObject1 getSubSerializableObject1() {

        return subSerializableObject1;
    }

    public SubSerializableObject2 getSubSerializableObject2() {

        return subSerializableObject2;
    }
}
