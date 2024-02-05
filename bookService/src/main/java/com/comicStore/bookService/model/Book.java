package com.comicStore.bookService.model;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private int id;
    private int digitalId;
    private String title;
    private int issueNumber;
    private String variantDescription;
    private String description;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    private String isbn;
    private String upc;
    private String diamondCode;
    private String ean;
    private String issn;
    private String format;
    private int pageCount;

    public Book() {
    }

    public Book(int id, int digitalId, String title, int issueNumber, String variantDescription, String description, Date modified, String isbn, String upc, String diamondCode, String ean, String issn, String format, int pageCount) {
        this.id = id;
        this.digitalId = digitalId;
        this.title = title;
        this.issueNumber = issueNumber;
        this.variantDescription = variantDescription;
        this.description = description;
        this.modified = modified;
        this.isbn = isbn;
        this.upc = upc;
        this.diamondCode = diamondCode;
        this.ean = ean;
        this.issn = issn;
        this.format = format;
        this.pageCount = pageCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return getId() == book.getId() && getDigitalId() == book.getDigitalId() && getIssueNumber() == book.getIssueNumber() && getPageCount() == book.getPageCount() && Objects.equals(getUuid(), book.getUuid()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getVariantDescription(), book.getVariantDescription()) && Objects.equals(getDescription(), book.getDescription()) && Objects.equals(getModified(), book.getModified()) && Objects.equals(getIsbn(), book.getIsbn()) && Objects.equals(getUpc(), book.getUpc()) && Objects.equals(getDiamondCode(), book.getDiamondCode()) && Objects.equals(getEan(), book.getEan()) && Objects.equals(getIssn(), book.getIssn()) && Objects.equals(getFormat(), book.getFormat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getId(), getDigitalId(), getTitle(), getIssueNumber(), getVariantDescription(), getDescription(), getModified(), getIsbn(), getUpc(), getDiamondCode(), getEan(), getIssn(), getFormat(), getPageCount());
    }

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

    public int getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(int digitalId) {
        this.digitalId = digitalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
