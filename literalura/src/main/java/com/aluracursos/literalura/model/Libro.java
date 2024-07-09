package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "libros")
public class Libro {

    private String title;
    private String author;
    private String language;
    private int downloadCount;
    @OneToOne
    private Autor autor;


    public Libro() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonAlias("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonAlias("authors")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonAlias("languages")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonAlias("download_count")
    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", downloadCount=" + downloadCount +
                '}';
    }
}
