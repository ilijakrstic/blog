package com.blog.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "topic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Topic.findAll", query = "SELECT t FROM Topic t")
    , @NamedQuery(name = "Topic.findById", query = "SELECT t FROM Topic t WHERE t.id = :id")
    , @NamedQuery(name = "Topic.findByName", query = "SELECT t FROM Topic t WHERE t.name = :name")
    , @NamedQuery(name = "Topic.findByTitle", query = "SELECT t FROM Topic t WHERE t.title = :title")
    , @NamedQuery(name = "Topic.findByContent", query = "SELECT t FROM Topic t WHERE t.content = :content")
    , @NamedQuery(name = "Topic.findByDescription", query = "SELECT t FROM Topic t WHERE t.description = :description")
    , @NamedQuery(name = "Topic.findByAuthor", query = "SELECT t FROM Topic t WHERE t.author = :author")
    , @NamedQuery(name = "Topic.findByDate", query = "SELECT t FROM Topic t WHERE t.publish_date = :publish_date")
    , @NamedQuery(name = "Topic.findByCategory", query = "SELECT t FROM Topic t WHERE t.category = :category")
    , @NamedQuery(name = "Topic.findBySubCategory", query = "SELECT t FROM Topic t WHERE t.subCategory = :subCategory order by t.publish_date DESC")
    , @NamedQuery(name = "Topic.findByTopicPhoto", query = "SELECT t FROM Topic t WHERE t.topicPhoto = :topicPhoto")})
public class Topic implements Serializable {

    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topicId",fetch = FetchType.EAGER)
    private Collection<Likes> likesCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30000)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "author")
    private String author;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publish_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publish_date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "category")
    private String category;
    @Size(max = 50)
    @NotNull
    @Column(name = "sub_category")
    private String subCategory;
    @NotNull
    @Column(name = "topic_photo")
    private String topicPhoto;
    
    @OneToMany(mappedBy = "topic",fetch = FetchType.LAZY)
    private List<Comments> comments;
    
    public Topic() {
    }

    public Topic(Integer id) {
        this.id = id;
    }

    public Topic(Integer id, String name, String title, String content, String description, String author, Date date, String category, String topicPhoto) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.description = description;
        this.author = author;
        this.publish_date = date;
        this.category = category;
        this.topicPhoto = topicPhoto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

 

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getTopicPhoto() {
        return topicPhoto;
    }

    public void setTopicPhoto(String topicPhoto) {
        this.topicPhoto = topicPhoto;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topic)) {
            return false;
        }
        Topic other = (Topic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.blog.model.Topic[ id=" + id + " ]";
    }

  

    @XmlTransient
    public Collection<Likes> getLikesCollection() {
        return likesCollection;
    }

    public void setLikesCollection(Collection<Likes> likesCollection) {
        this.likesCollection = likesCollection;
    }
    
}
