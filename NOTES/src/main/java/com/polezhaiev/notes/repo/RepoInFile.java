package com.polezhaiev.notes.repo;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class RepoInFile implements Repo{
    private final String identifier = "\n@$245ds#@_+-:FU3g$dwe\n\n";
    @Override
    public void writeNote(String noteTitleId, String noteTextId) throws IOException {
        Path file = Paths.get("C:/Users/Andrey Polezhaiev/IdeaProjects/SysPro/NOTES/src/main/java/com/polezhaiev/notes/repo/notes.txt");

        if((noteTextId.equals("") || noteTextId == null) && (noteTitleId.equals(null) || noteTitleId.equals(""))){
            return;
        }

        if(noteTitleId.equals("") || noteTitleId == null){
            noteTitleId = "Untitled:";
        }

        try (FileWriter writer = new FileWriter(file.toFile(), true)){
            String note = noteTitleId + "\n" + noteTextId + "\n" + LocalDateTime.now() + identifier;
            writer.write(note);

            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String readNote() throws IOException {
        Path file = Paths.get("C:/Users/Andrey Polezhaiev/IdeaProjects/SysPro/NOTES/src/main/java/com/polezhaiev/notes/repo/notes.txt");

        StringBuffer stringBuffer = new StringBuffer();
        try (FileReader fileReader = new FileReader(file.toFile());
             BufferedReader reader = new BufferedReader(fileReader)) {

            while(reader.read() != -1){
                stringBuffer.append(reader.readLine());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return stringBuffer.toString();
    }
}
