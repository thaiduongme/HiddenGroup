/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thai Duong
 */
public class Problem {
    String ID, createdDate, probName, shortDesc, fullDescLink, category, author;
    double weight;
    
    public Problem() {
        this.ID = "Unknown";
        this.createdDate = "Unknown";
        this.probName = "Unknown";
        this.shortDesc = "Unknown";
        this.fullDescLink = "Unknown";
        this.category = "Unknown";
        this.author = "Unknown";
    }
    
    public Problem(String probName, String shortDesc, String fullDescLink, double weight, String category, String author) {
        this.probName = probName;
        this.shortDesc = shortDesc;
        this.fullDescLink = fullDescLink;
        this.weight = weight;
        this.category = category;
        this.author = author;
    }
    
    public Problem(String ID, String probName, String shortDesc, String fullDescLink, double weight, String category, String author, String createdDate) {
        this.ID = ID;
        this.probName = probName;
        this.shortDesc = shortDesc;
        this.fullDescLink = fullDescLink;
        this.weight = weight;
        this.category = category;
        this.author = author;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Problem{" + "ID=" + ID + ", createdDate=" + createdDate + ", probName=" + probName + ", shortDesc=" + shortDesc + ", fullDescLink=" + fullDescLink + ", category=" + category + ", author=" + author + ", weight=" + weight + '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getProbName() {
        return probName;
    }

    public void setProbName(String probName) {
        this.probName = probName;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getFullDescLink() {
        return fullDescLink;
    }

    public void setFullDescLink(String fullDescLink) {
        this.fullDescLink = fullDescLink;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public void changeInfo() {
        
    }
    
}
