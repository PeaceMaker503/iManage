/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author prmm95
 */
@Entity
@Table(name="Candidature")
public class Candidature implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/*@Column
	private String title;*/
	
	/*@Column
	private String content;*/
	
	@Column
	private String coverLetterPath;
	
	@OneToOne
	@JoinColumn(referencedColumnName="id")
	private Internship id_internship;
	
	@OneToOne
	@JoinColumn(referencedColumnName="id")
	private UserAccount id_userAccount;
	
	@OneToOne
	@JoinColumn(referencedColumnName="id")
	private Company id_company;

	@Column 
	private String status;
	
	// Autogeneration
	@Column
	private Date createdAt;
	
	public Candidature(){}

	public Candidature(/*String title, String content,*/ String coverLetterPath, /*Internship id_internship, UserAccount id_userAccount,*/ String status) {
		//this.title = title;
		//this.content = content;
		this.coverLetterPath = coverLetterPath;
		//this.id_internship = id_internship;
		//this.id_userAccount = id_userAccount;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	/*public String getTitle() {
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
	}*/

	public String getCoverLetterPath() {
		return coverLetterPath;
	}

	public void setCoverLetterPath(String coverLetterPath) {
		this.coverLetterPath = coverLetterPath;
	}

	public Internship getId_internship() {
		return id_internship;
	}

	public void setId_internship(Internship id_internship) {
		this.id_internship = id_internship;
	}

	public UserAccount getId_userAccount() {
		return id_userAccount;
	}

	public void setId_userAccount(UserAccount id_userAccount) {
		this.id_userAccount = id_userAccount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Company getId_company() {
		return id_company;
	}

	public void setId_company(Company id_company) {
		this.id_company = id_company;
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
		if (!(object instanceof Candidature)) {
			return false;
		}
		Candidature other = (Candidature) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "insa.db.Candidature[ id=" + id + " ]";
	}
	
}
