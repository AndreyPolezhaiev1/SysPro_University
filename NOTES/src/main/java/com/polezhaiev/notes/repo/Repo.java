package com.polezhaiev.notes.repo;

import java.io.File;
import java.io.IOException;

public interface Repo {
    void writeNote(String noteTitleId, String noteTextId) throws IOException;
    String readNoteFromLocalFile() throws IOException;
    File getFile();
    File getLocalFileFromRepo();
}
