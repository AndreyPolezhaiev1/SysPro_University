package com.polezhaiev.notes.filemanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ManagerTest {
    Manager manager = new Manager();

    @Test
    public void makeReverseListTest1(){
        String [] notes = new String[]{"1", "2", "3"};
        List<String> reverseList = List.of("3", "2", "1");

        Assertions.assertEquals(reverseList, manager.makeReverseList(notes));
    }

    @Test
    public void makeReverseListTest2(){
        String [] notes = new String[]{};
        List<String> reverseList = null;

        Assertions.assertEquals(reverseList, manager.makeReverseList(notes));
    }

    @Test
    public void makeReverseListTest3(){
        String [] notes = new String[]{"1"};
        List<String> reverseList = List.of("1");

        Assertions.assertEquals(reverseList, manager.makeReverseList(notes));
    }

    @Test
    public void cleanFileTest1() throws IOException {
        File file = new File("text.txt");
        boolean result = false;

        Assertions.assertEquals(result, manager.cleanFile(file));
    }

    @Test
    public void cleanFileTest2() throws IOException {
        File file = new File("text.txt");
        boolean result = true;
        if(!file.exists()){
            file.createNewFile();
        }

        FileWriter writer = new FileWriter(file);
        writer.write("cleanFileTest2");
        writer.flush();
        writer.close();

        Assertions.assertEquals(result, manager.cleanFile(file));
    }
}
