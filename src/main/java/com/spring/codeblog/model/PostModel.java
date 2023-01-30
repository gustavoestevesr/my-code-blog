package com.spring.codeblog.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TB_POST")
public class PostModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;
    
    @NotBlank
    private String author;
    
    @Lob // permite salvar texto muito longos no banco
    @NotBlank
    private String text;
    
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate createdAt;

}
