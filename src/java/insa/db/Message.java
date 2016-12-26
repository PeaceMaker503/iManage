/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.db;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.CascadeType;
import javax.persistence.TemporalType;

/**
 *
 * @author jordycabannes
 */

@Entity
public class Message implements Serializable  {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String objectMail;
    
    @Column
    private String content;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateMail;
    
    @Column
    private Boolean readMail;
    
    @OneToOne
    @JoinColumn(referencedColumnName="id")
    private UserAccount sender;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy="messages")
    private Collection<UserAccount> receiver = new ArrayList<UserAccount>();

    public Message() {
    }
    
    public Message(String object, String content, Date date, Boolean read){
        this.objectMail=object;
        this.content=content;
        this.dateMail=date;
        this.readMail=read;
    }
    
        /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the object
     */
    public String getObject() {
        return objectMail;
    }

    /**
     * @param object the object to set
     */
    public void setObject(String object) {
        this.objectMail = object;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return dateMail;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.dateMail = date;
    }

    /**
     * @return the read
     */
    public Boolean getRead() {
        return readMail;
    }

    /**
     * @param read the read to set
     */
    public void setRead(Boolean read) {
        this.readMail = read;
    }

    /**
     * @return the sender
     */
    public UserAccount getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    /**
     * @return the receiver
     */
    public Collection<UserAccount> getReceiver() {
        return receiver;
    }

    /**
     * @param receiver the receiver to set
     */
    public void setReceiver(Collection<UserAccount> receiver) {
        this.receiver = receiver;
    }
}