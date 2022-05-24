package me.redstoyn33.worklist;

import java.io.*;

public class FileManager<T> {
    File path;

    public FileManager(String path) {
        this.path = new File(path);
    }

    public void save(T obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean exists() {
        return path.exists();
    }

    public void createFile() throws IOException {
        path.createNewFile();
    }

    public void mkdir() {
        path.mkdirs();
    }
}
