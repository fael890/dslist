package com.rafa.dslist.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier value of the game", example = "1")
    private Long id;
    @Schema(description = "Game title", example = "Baldur's Gate 3")
    private String title;
    @Column(name = "game_year")
    @Schema(description = "Game release year", example = "2023")
    private Integer year;
    @Schema(description = "Game genre", example = "RPG")
    private String genre;
    @Schema(description = "Game platforms", example = "xbox, pc, playstation")
    private String platforms;
    @Schema(description = "Game evaluation score", example = "4.5")
    private Double score;
    @Schema(description = "Game image URL", example = "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/8.png")
    private String imgUrl;
    @Column(columnDefinition = "TEXT")
    @Schema(description = "Game short description", example = "Explore the world defeating enemies")
    private String shortDescription;
    @Column(columnDefinition = "TEXT")
    @Schema(description = "Game long description", example = "The sea is your best friend! on this journey you're a pirate searching for the rarest relic in the world.")
    private String longDescription;

    public Game() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platform) {
        this.platforms = platform;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(String score) {
        this.platforms = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
