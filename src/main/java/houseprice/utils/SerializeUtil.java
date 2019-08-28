package houseprice.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {
    /**
     * 序列化对象
     * @param obj
     * @return
     */
    public static byte[] serialize(Object obj) {
        ObjectOutputStream oos;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(byteArrayOutputStream);

            oos.writeObject(obj);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return byteArray;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化对象
     * @param byteArray
     * @return
     */
    public static Object unSerialize(byte[] byteArray) {
        ByteArrayInputStream byteArrayInputStream;
        try {
            //反序列化为对象
            byteArrayInputStream = new ByteArrayInputStream(byteArray);
            ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
            return ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
