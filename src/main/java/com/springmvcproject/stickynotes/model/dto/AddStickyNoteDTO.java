package com.springmvcproject.stickynotes.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddStickyNoteDTO {
    private String description;
    private String name;
    private String color;
}
