package com.springmvcproject.stickynotes.service;

import com.springmvcproject.stickynotes.model.dto.AddNoteDTO;
import com.springmvcproject.stickynotes.model.dto.NoteDTO;
import com.springmvcproject.stickynotes.model.entity.NoteEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {
    NoteDTO add(AddNoteDTO dto,Long stickyNoteID);
    List<NoteDTO> getAllNotes(Long stickyNoteId);
    void delete(Long id);
    List<NoteDTO> getAllNotes();
}
