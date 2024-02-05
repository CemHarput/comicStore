package com.comicStore.characterService.model;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Character")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private int id;
    private String name;
    private String description;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    private String resourceURI;

    @Lob
    @Column(name = "thumbnail", length = 1000)
    private byte[] thumbnail;




    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character character)) return false;
        return getId() == character.getId() && Objects.equals(getUuid(), character.getUuid()) && Objects.equals(getName(), character.getName()) && Objects.equals(getDescription(), character.getDescription()) && Objects.equals(getModified(), character.getModified()) && Objects.equals(getResourceURI(), character.getResourceURI()) && Arrays.equals(getThumbnail(), character.getThumbnail());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getUuid(), getId(), getName(), getDescription(), getModified(), getResourceURI());
        result = 31 * result + Arrays.hashCode(getThumbnail());
        return result;
    }


}
