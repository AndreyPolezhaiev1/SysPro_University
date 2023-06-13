package com.polezhaiev.notes.filemanager;

import com.polezhaiev.notes.repo.Repo;
import com.polezhaiev.notes.repo.RepoInFile;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager {
    private static Repo repo = new RepoInFile();

    public void sortFileByDate() throws IOException {

        String line = repo.readNoteFromLocalFile();
        String [] notes = line.split("\n@245ds#@_-:FU3g1dwe\n\n");
        cleanFile(repo.getFile());

        try (FileWriter writer = new FileWriter(repo.getFile(), true)){
            List<String> reverseNotes = makeReverseList(notes);
            StringBuffer stringBuffer = new StringBuffer();

            for (String note: reverseNotes) {
                stringBuffer.append(note + "\n@245ds#@_-:FU3g1dwe\n\n");
            }
            writer.write(stringBuffer.toString());
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public List<String> makeReverseList(String[]notes){
        if(notes.length == 0 || notes == null){
            return null;
        }
        List<String> list = new ArrayList<>();
        for (String note: notes) {
            list.add(note);
        }

        Collections.reverse(list);
        return list;
    }

    public boolean cleanFile(File file) throws IOException {
        if(file.length() == 0 || file == null){
            return false;
        }
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.close();
        return true;
    }

    public String readFromFile() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        try (FileReader fileReader = new FileReader(repo.getFile());
             BufferedReader reader = new BufferedReader(fileReader)) {

            String line = "";
            while ((line = reader.readLine()) != null){
                stringBuffer.append(line);
            }
            return stringBuffer.toString();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
