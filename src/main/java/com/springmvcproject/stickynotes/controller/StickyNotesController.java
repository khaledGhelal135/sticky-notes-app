package com.springmvcproject.stickynotes.controller;

import com.springmvcproject.stickynotes.model.dto.AddStickyNoteDTO;
import com.springmvcproject.stickynotes.model.dto.NoteDTO;
import com.springmvcproject.stickynotes.model.dto.StickyNoteDTO;
import com.springmvcproject.stickynotes.model.dto.UpdateStickyNoteDTO;
import com.springmvcproject.stickynotes.service.NoteService;
import com.springmvcproject.stickynotes.service.StickyNoteService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StickyNotesController {
    private final StickyNoteService stickyNoteService;
    private final NoteService noteService;
    @GetMapping("/")
    public String home(Model model){
        List<StickyNoteDTO> stickyNoteDTOS=this.stickyNoteService.allStickyNotes();
        model.addAttribute("stickyNotes",stickyNoteDTOS);
        return "home";
    }

    @GetMapping("/sticky-note/{id}")
    public String stickyNotes(@PathVariable(name = "id") Long id,Model model){
        StickyNoteDTO stickyNote=this.stickyNoteService.findById(id);
        List<NoteDTO> notes=this.noteService.getAllNotes(id);
        model.addAttribute("stickyNote",stickyNote);
        model.addAttribute("notes",notes);
        return "sticky-note";
    }
    @GetMapping("/edit-sticky-note/{id}")
    public String editStickyNotes(@PathVariable(name = "id") Long id,Model model){
        StickyNoteDTO stickyNote=this.stickyNoteService.findById(id);
        model.addAttribute("stickyNote",stickyNote);
        return "edit-sticky-note";
    }
    @PostMapping("/save")
    public String addNewStickyNote(@ModelAttribute("dto") AddStickyNoteDTO dto){
 this.stickyNoteService.addSticktNote(dto);
 return "redirect:/";
    }
    @PostMapping("/update/{id}")
    public String updateStickyNote(@ModelAttribute("dto") UpdateStickyNoteDTO dto,
                                   @PathVariable("id") long id){
        this.stickyNoteService.update(dto,id);
        return "redirect:/edit-sticky-note/" +id;
    }

}
