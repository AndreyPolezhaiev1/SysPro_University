package com.polezhaiev.notes.repo;

import com.polezhaiev.notes.filemanager.Manager;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepoInFile implements Repo{
    private Manager manager = new Manager();
    private final String identifier = "\n@245ds#@_-:FU3g1dwe\n\n";
    private final File file = new File("NOTES/src/main/java/com/polezhaiev/notes/repo/notes.txt");
    private File localFileFromRepo = new File("NOTES/src/main/java/com/polezhaiev/notes/repo/tempInfoFile.txt");

    @Override
    public void writeNote(String noteTitleId, String noteTextId) throws IOException {
        if((noteTextId.equals("") || noteTextId == null) && (noteTitleId.equals(null) || noteTitleId.equals(""))){
            return;
        }

        if(noteTitleId.equals("") || noteTitleId == null){
            noteTitleId = "Untitled:";
        }

        try (FileWriter writer = new FileWriter(localFileFromRepo, true)){
            String note = noteTitleId + "\n" + noteTextId + "\n" + LocalDateTime.now() + identifier;
            writer.write(note);
            writer.flush();
            manager.sortFileByDate();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String readNoteFromLocalFile() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        try (FileReader fileReader = new FileReader(localFileFromRepo);
             BufferedReader reader = new BufferedReader(fileReader)) {

            String line = "";
            while ((line = reader.readLine()) != null){
                stringBuffer.append(line + "\n");
            }
            return stringBuffer.toString();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public File getLocalFileFromRepo() {
        return localFileFromRepo;
    }
}
