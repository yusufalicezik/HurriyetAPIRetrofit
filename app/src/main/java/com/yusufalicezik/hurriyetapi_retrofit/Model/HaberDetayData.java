package com.yusufalicezik.hurriyetapi_retrofit.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HaberDetayData {

    @Expose
    @SerializedName("Writers")
    private List<String> Writers;
    @Expose
    @SerializedName("Url")
    private String Url;
    @Expose
    @SerializedName("Title")
    private String Title;
    @Expose
    @SerializedName("Text")
    private String Text;
    @Expose
    @SerializedName("Tags")
    private List<String> Tags;
    @Expose
    @SerializedName("StartDate")
    private String StartDate;
    @Expose
    @SerializedName("RelatedNews")
    private List<String> RelatedNews;
    @Expose
    @SerializedName("Path")
    private String Path;
    @Expose
    @SerializedName("ModifiedDate")
    private String ModifiedDate;
    @Expose
    @SerializedName("Files")
    private List<Files> Files;
    @Expose
    @SerializedName("Editor")
    private String Editor;
    @Expose
    @SerializedName("Description")
    private String Description;
    @Expose
    @SerializedName("CreatedDate")
    private String CreatedDate;
    @Expose
    @SerializedName("ContentType")
    private String ContentType;
    @Expose
    @SerializedName("Id")
    private String Id;

    public List<String> getWriters() {
        return Writers;
    }

    public void setWriters(List<String> Writers) {
        this.Writers = Writers;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public List<String> getTags() {
        return Tags;
    }

    public void setTags(List<String> Tags) {
        this.Tags = Tags;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public List<String> getRelatedNews() {
        return RelatedNews;
    }

    public void setRelatedNews(List<String> RelatedNews) {
        this.RelatedNews = RelatedNews;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String Path) {
        this.Path = Path;
    }

    public String getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(String ModifiedDate) {
        this.ModifiedDate = ModifiedDate;
    }

    public List<Files> getFiles() {
        return Files;
    }

    public void setFiles(List<Files> Files) {
        this.Files = Files;
    }

    public String getEditor() {
        return Editor;
    }

    public void setEditor(String Editor) {
        this.Editor = Editor;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String ContentType) {
        this.ContentType = ContentType;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public static class Files {
        @Expose
        @SerializedName("Metadata")
        private Metadata Metadata;
        @Expose
        @SerializedName("FileUrl")
        private String FileUrl;

        public Metadata getMetadata() {
            return Metadata;
        }

        public void setMetadata(Metadata Metadata) {
            this.Metadata = Metadata;
        }

        public String getFileUrl() {
            return FileUrl;
        }

        public void setFileUrl(String FileUrl) {
            this.FileUrl = FileUrl;
        }
    }

    public static class Metadata {
        @Expose
        @SerializedName("Description")
        private String Description;
        @Expose
        @SerializedName("Title")
        private String Title;

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }
    }
}
