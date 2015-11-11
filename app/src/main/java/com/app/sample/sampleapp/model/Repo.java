package com.app.sample.sampleapp.model;

/**
 * Created by thibaud.bourgeois on 10/11/2015.
 * Movie model
 */
public class Repo {

    private String name;

    private String description;

    private String language;

    private String html_url;

    private Owner owner;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Repo() {}

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Repo repo = (Repo) o;

        if (name != null ? !name.equals(repo.name) : repo.name != null) return false;
        if (description != null ? !description.equals(repo.description) : repo.description != null)
            return false;
        if (language != null ? !language.equals(repo.language) : repo.language != null)
            return false;
        if (html_url != null ? !html_url.equals(repo.html_url) : repo.html_url != null)
            return false;
        return !(owner != null ? !owner.equals(repo.owner) : repo.owner != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (html_url != null ? html_url.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Repo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", html_url='" + html_url + '\'' +
                ", owner=" + owner +
                '}';
    }
}
