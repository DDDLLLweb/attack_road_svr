package com.el.serializable;

import org.junit.Test;

import java.io.*;

/**
 * @author Danfeng
 * @since 2018/10/31
 */

public class SerializableTest {

    @Test
    public void testTransient() {
        SerializableDomain serializableDomain = new SerializableDomain();
        serializableDomain.setId(1L);
        serializableDomain.setTest("test");
        serializableDomain.setTestTransient("transient");
        System.out.println("read before Serializable: ");
        System.out.println("test: " + serializableDomain.getTest());
        System.err.println("transient: " + serializableDomain.getTestTransient());

        // serializable obj
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("/Users/diaodanfeng/Documents/cloud_road/attack_road_svr/src/test/java/com/el/serializable/serializable.txt"));
            os.writeObject(serializableDomain);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // deserializable obj

        try {
            // 在反序列化之前改变username的值
            SerializableDomain.test = "new -- test -- de --";

            ObjectInputStream is = new ObjectInputStream(new FileInputStream(
                "/Users/diaodanfeng/Documents/cloud_road/attack_road_svr/src/test/java/com/el/serializable/serializable.txt"));
            serializableDomain = (SerializableDomain) is.readObject(); // 从流中读取User的数据
            is.close();
            System.out.println("read after Serializable: ");
            System.err.println("test: " + serializableDomain.getTest());
            System.out.println("transient: " + serializableDomain.getTestTransient());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
