/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.db;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Halim
 */
@Entity
public class UserAccount implements Serializable {

    /**
     * @return the id_Company_profile
     */
   
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique=true)
    @NotNull
    private String login;
    @NotNull
    @Pattern(regexp="[0-9A-Za-z_]+[@][0-9A-Za-z_]+[.][0-9A-Za-z_]+")
    @Column(unique=true)
    private String mail;
    @NotNull
    private String password;
    
    @NotNull
    private String userCategory;
	
    @OneToOne
    @JoinColumn(referencedColumnName="id")
	@Cascade(CascadeType.DELETE)
    private UserProfile id_profile;
    
    @OneToOne
    @JoinColumn(referencedColumnName="id")
    @Cascade(CascadeType.DELETE)
    private Company id_Company_profile;
	
	@OneToOne
    @JoinColumn(referencedColumnName="id")
    @Cascade(CascadeType.DELETE)
    private Category type_staff;
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="messages_account",
                joinColumns={@JoinColumn(name="userAccount_id", referencedColumnName="id")},
                inverseJoinColumns={@JoinColumn(name="message_id", referencedColumnName="id")})
    private Collection<Message> messages=new ArrayList<Message>();
    
    public UserAccount() {}
    
    public UserAccount(String login,  String mail , String password, String userCategory) {
        this.login = login;
        this.mail=mail;
        this.password = password;
        this.userCategory = userCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserProfile getId_profile() {
        return id_profile;
    }

    public void setId_profile(UserProfile id_profile) {
        this.id_profile = id_profile;
    }
    
     public Company getId_Company_profile() {
        return id_Company_profile;
    }

    /**
     * @param id_Company_profile the id_Company_profile to set
     */
    public void setId_Company_profile(Company id_Company_profile) {
        this.id_Company_profile = id_Company_profile;
    }

	public Category getType_staff() {
		return type_staff;
	}

	public void setType_staff(Category type_staff) {
		this.type_staff = type_staff;
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
        if (!(object instanceof UserAccount)) {
            return false;
        }
        UserAccount other = (UserAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the userCategory
     */
    public String getUserCategory() {
        return userCategory;
    }

    /**
     * @param userCategory the userCategory to set
     */
    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }
    
        /**
     * @return the messages
     */
    public Collection<Message> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(Collection<Message> messages) {
        this.messages = messages;
    }
    
}
