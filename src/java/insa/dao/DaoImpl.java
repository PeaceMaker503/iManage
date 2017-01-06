/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.dao;

import insa.db.Candidature;
import insa.db.Category;
import insa.db.Company;
import insa.db.Internship;
import insa.db.Message;
import insa.db.UserAccount;
import insa.db.UserProfile;
import insa.utils.HibernateManager;
import java.util.*;
/**
 *
 * @author Halim
 */

public class DaoImpl implements IDao {
    
    private HibernateManager hibernateManager;

    public HibernateManager getHibernateManager() {
        return hibernateManager;
    }

    public void setHibernateManager(HibernateManager hibernateManager) {
        this.hibernateManager = hibernateManager;
    }
    
    @Override
    public UserAccount getUserAccountById(Long id)
    {
        return hibernateManager.getObjectFromDatabase(UserAccount.class, id);
    }
    
    @Override
    public UserAccount addUserAccount(UserAccount userAccount)
    {
        Long id = hibernateManager.addObjectToDatabase(userAccount);
        if(id != null)
        {
            //System.out.println("C'est pas nul");
            userAccount.setId(id);
            return userAccount;
        }
        else{
            //System.out.println("C'est nul");
            return null;
        }
    }
    
    @Override
    public UserProfile addUserProfile(UserProfile userProfile)
    {
        Long id = hibernateManager.addObjectToDatabase(userProfile);
        if(id != null)
        {
            userProfile.setId(id);
            return userProfile;
        }
        else
            return null;
    }
     
    @Override
    public Internship addInternship(Internship internship)
    {
        Long id = hibernateManager.addObjectToDatabase(internship);
        if(id != null)
        {
            internship.setId(id);
            return internship;
        }
        else
            return null; 
    }
    
    @Override
    public Company addCompany(Company company)
    {
        //System.out.println("+++++++++++++++++ Valeur de id avant ");
        Long id = hibernateManager.addObjectToDatabase(company);
        //System.out.println("+++++++++++++++++ Valeur de id après" + id.toString());
        if(id != null)
        {
            company.setId(id);
            return company;
        }
        else
            return null; 
    }

    @Override
    public UserAccount deleteUserAccountById(Long id) {
        UserAccount userAccount = hibernateManager.getObjectFromDatabase(UserAccount.class, id);
        boolean res = hibernateManager.deleteObjectFromDatabase(userAccount);
        if(res)
            return userAccount;
        else
            return null;
    }

    @Override
    public UserAccount updateUserAccount(UserAccount userAccount) {
        boolean res = hibernateManager.updateObjectInDatabase(userAccount);
        if(res)
            return userAccount;
        else
            return null;
    }

    @Override
    public UserProfile getUserProfileById(Long id) {
        return hibernateManager.getObjectFromDatabase(UserProfile.class, id);
    }
    
	@Override
     public UserProfile getUserProfileUsingAccountLogin(String login)
     {
         UserAccount ua= this.getUserAccountByLogin(login);
         return hibernateManager.getObjectFromDatabase(UserProfile.class, ua.getId_profile().getId());
     }

    @Override
    public UserProfile deleteUserProfileById(Long id) {
        UserProfile userProfile = hibernateManager.getObjectFromDatabase(UserProfile.class, id);
        boolean res = hibernateManager.deleteObjectFromDatabase(userProfile);
        if(res)
            return userProfile;
        else
            return null;
    }

    @Override
    public UserProfile updateUserProfile(UserProfile userProfile) {
        boolean res = hibernateManager.updateObjectInDatabase(userProfile);
        if(res)
            return userProfile;
        else
            return null;
    }

    @Override
    public Internship getInternshipById(Long id) {
        return hibernateManager.getObjectFromDatabase(Internship.class, id);
    }

    @Override
    public Boolean deleteInternshipById(Long id) {
        Internship internship = hibernateManager.getObjectFromDatabase(Internship.class, id);
        boolean res = hibernateManager.deleteObjectFromDatabase(internship);
		return res;
    }

    @Override
    public Internship updateInternship(Internship internship) {
        boolean res = hibernateManager.updateObjectInDatabase(internship);
        if(res)
            return internship;
        else
            return null;
    }

    @Override
    public Company getCompanyById(Long id) {
        return hibernateManager.getObjectFromDatabase(Company.class, id);
    }

    @Override
    public Company deleteCompanyById(Long id) {
        Company company = hibernateManager.getObjectFromDatabase(Company.class, id);
        boolean res = hibernateManager.deleteObjectFromDatabase(company);
        if(res)
            return company;
        else
            return null;
    }

    @Override
    public Company updateCompany(Company company) {
        boolean res = hibernateManager.updateObjectInDatabase(company);
        if(res)
            return company;
        else
            return null;
    }
    
    @Override
    public UserAccount getUserAccountByLogin(String login)
    {
       String query = "from UserAccount as u where u.login= :login";
       HashMap<String, Object> params = new HashMap<>();
       params.put("login", login);
       List<UserAccount> list = hibernateManager.execute(query, params, UserAccount.class);
       
       if(list != null && list.size() == 1){
           return list.get(0);
        }
       else{
           return null;
       }
    }
    
    @Override
    public UserAccount getUserAccountByEmail(String mail){
        String query = "from UserAccount as u where u.mail= :mail";
       HashMap<String, Object> params = new HashMap<>();
       params.put("mail", mail);
       List<UserAccount> list = hibernateManager.execute(query, params, UserAccount.class);
       
       if(list != null && list.size() == 1){
           return list.get(0);
        }
       else{
           return null;
       }
    }

    
    @Override
    public List<Internship> getInternshipByCategory(Category category)
    {
        String query = "from Internship as i where i.id_category = :category";
        HashMap<String, Object> params = new HashMap<>();
        params.put("category", category);
        List<Internship> list = hibernateManager.execute(query, params, Internship.class);
        return list;
    }
    
    @Override
    public List<Internship> getInternshipByCompany(Company company)
    {
        String query = "from Internship as i where i.id_company = :company";
        HashMap<String, Object> params = new HashMap<>();
        params.put("company", company);
        List<Internship> list = hibernateManager.execute(query, params, Internship.class);
        return list;
    }

    @Override
    public Category getCategoryById(Long id) {
        return hibernateManager.getObjectFromDatabase(Category.class, id);
    }

    @Override
    public Category addCategory(Category category) {
        
        Long id = hibernateManager.addObjectToDatabase(category);
        if(id != null)
        {
            category.setId(id);
            return category;
        }
        else
            return null; 
    }

    @Override
    public Category deleteCategoryById(Long id) {
        Category category = hibernateManager.getObjectFromDatabase(Category.class, id);
        boolean res = hibernateManager.deleteObjectFromDatabase(category);
        if(res)
            return category;
        else
            return null;
    }

    @Override
    public Category updateCategory(Category category) {
        boolean res = hibernateManager.updateObjectInDatabase(category);
        if(res)
            return category;
        else
            return null;
    }
	
	@Override
	public Candidature getCandidatureById(Long id) {
		return hibernateManager.getObjectFromDatabase(Candidature.class, id);
	}
	
	@Override
    public Candidature addCandidature(Candidature candidature) {
		Long id = hibernateManager.addObjectToDatabase(candidature);
        if(id != null)
        {
            candidature.setId(id);
            return candidature;
        }
        else
            return null; 
	
	}
	
	@Override
    public Boolean deleteCandidatureById(Long cand_id) {
        Candidature cand = hibernateManager.getObjectFromDatabase(Candidature.class, cand_id);
        Boolean deleted = hibernateManager.deleteObjectFromDatabase(cand);
		return deleted;
	}
	
	@Override
    public Candidature updateCandidature(Candidature candidature) {
		boolean res = hibernateManager.updateObjectInDatabase(candidature);
        if(res)
            return candidature;
        else
            return null;
	}	
	
    @Override
    public List<Internship> getInternshipByCategoryName(String name)
    {
        Category ca = this.getCategoryByName(name);
        if(ca != null)
            return this.getInternshipByCategory(ca);
        else
            return null;
    }
    
    @Override
    public List<Internship> getInternshipByCompanyName(String name)
    {
        Company co = this.getCompanyByName(name);
        if(co != null)
            return this.getInternshipByCompany(co);
        else
            return null;
    }

    @Override
    public Company getCompanyByName(String name) {
        String query = "from Company as co where co.name = :company";
        HashMap<String, Object> params = new HashMap<>();
        params.put("company", name);
        List<Company> list = hibernateManager.execute(query, params, Company.class);
        if(list != null)
            return list.get(0);
        else
            return null;
    }

    @Override
    public Category getCategoryByName(String name) {
        String query = "from Category as ca where ca.name = :category";
        HashMap<String, Object> params = new HashMap<>();
        params.put("category", name);
        List<Category> list = hibernateManager.execute(query, params, Category.class);
        if(list != null)
            return list.get(0);
        else
            return null;
    }

    @Override
    public List<Company> getAllCompanies() {
        
        String query = "from Company";
        List<Company> list = hibernateManager.execute(query, Company.class);
        if(list != null)
            return list;
        else
            return null;
    }

    @Override
    public List<Internship> getAllInternships() {
        
        String query = "from Internship";
        List<Internship> list = hibernateManager.execute(query, Internship.class);
        if(list != null)
            return list;
        else
            return null;
    }

    @Override
    public List<Category> getAllCategories() {
        
        String query = "from Category";
        List<Category> list = hibernateManager.execute(query, Category.class);
        if(list != null)
            return list;
        else
            return null;
    }

    @Override
    public List<Internship> getInternshipsWhereTitleContains(String title) {
        String query = "from Internship as i where i.name like :condition";
        HashMap<String, Object> params = new HashMap<>();
        params.put("condition", "%" + title + "%");
        List<Internship> list = hibernateManager.execute(query, params, Internship.class);
        if(list != null)
            return list;
        else
            return null;
    }
    
    @Override
    public List<Internship> getInternshipByCompanyNameCategoryNameWhereTitleContains(String companyName, String categoryName, String keywords) {
        String query = "from Internship as i";
        
        System.out.println("QUERY : " + query);
        HashMap<String, Object> params = new HashMap<>();
        if (!(companyName.equals("All")) || !(categoryName.equals("All")) || !(keywords.equals(""))) {
            query += " where ";
            if (!(keywords.equals(""))) {
                query += "i.name like :condition";
                params.put("condition", "%" + keywords + "%");
            }
            if (!companyName.equals("All")) {
                if (!(keywords.equals(""))) {
                    query += " and i.id_company = :company";
                } else {
                    query += "i.id_company = :company";
                }
                params.put("company", this.getCompanyByName(companyName));
               
            }
            if (!categoryName.equals("All")) {
                if (!(keywords.equals("")) || !(companyName.equals("All"))) {
                    query += " and i.id_category = :category";
                } else {
                    query += "i.id_category = :category";
                }
                params.put("category", this.getCategoryByName(categoryName));
            }
        }
        System.out.println("=============================QUERY : " + query);
        List<Internship> list = hibernateManager.execute(query, params, Internship.class);
        if(list != null)
            return list;
        else
            return null;
    }


	
	@Override
    public Message getMessageById(Long id){
        return hibernateManager.getObjectFromDatabase(Message.class, id);
    }
    
	@Override
    public Message addMessage(Message message){
        Long id = hibernateManager.addObjectToDatabase(message);
        if(id != null)
        {
            message.setId(id);
            return message;
        }
        else
            return null;
    }

	@Override
    public Message deleteMessageById(Long id){
        Message message = hibernateManager.getObjectFromDatabase(Message.class, id);
        boolean res = hibernateManager.deleteObjectFromDatabase(message);
        if(res)
            return message;
        else
            return null;	
	}
    
	@Override
    public Message updateMessage(Message message){
        boolean res = hibernateManager.updateObjectInDatabase(message);
        if(res)
            return message;
        else
            return null;
    }
    
    @Override
    public List<Message> getAllMessages(UserAccount ua){
        //String query = "SELECT Message.id, Message.content, Message.dateMail, Message.objectMail, Message.readMail, Message.sender_id FROM messages_account LEFT JOIN Message ON messages_account.message_id=Message.id WHERE messages_account.userAccount_id= :id_send";
        String query ="from Message as m where :user_account MEMBER OF receiver";

        HashMap<String, Object> params = new HashMap<>();
        params.put("user_account", ua);
        List<Message> list = hibernateManager.execute(query, params, Message.class);
        if(list != null){
            return list;
        }
        else{
            return null;
        }
    }
    
	@Override
    public List<Message> getAllSentMessages(Long id){
        //String query = "SELECT Message.id, Message.content, Message.dateMail, Message.objectMail, Message.readMail, Message.sender_id FROM messages_account LEFT JOIN Message ON messages_account.message_id=Message.id WHERE messages_account.userAccount_id= :id_send";
        String query ="from Message as m where m.sender.id= :id";

        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        List<Message> list = hibernateManager.execute(query, params, Message.class);
        if(list != null){
            return list;
        }
        else{
            return null;
        }
    }

	@Override
    public List<UserAccount> getAllUserAccount(){
        String query ="from UserAccount";
        List<UserAccount> list = hibernateManager.execute(query, UserAccount.class);
        if(list != null){
            return list;
        }
        else{
            return null;
        }
    }
    
	@Override
    public List<UserAccount> getAllReceiverAccount(Message message){
        String query = "from UserAccount as ua where :message MEMBER OF messages";
        HashMap<String, Object> params = new HashMap<>();
        params.put("message", message);
        List<UserAccount> list = hibernateManager.execute(query, params, UserAccount.class);
        /*for(Iterator<UserAccount> i = list.iterator(); i.hasNext(); ){
            UserAccount item = i.next();
            System.out.println("////////////// voilà le log : "+item.getLogin());
        }*/

        if(list != null)
            return list;
        else
            return null;
    }


	@Override
	public List<Candidature> getCandidaturesByUserID(long user_id) {
		String query = "from Candidature as cand where cand.id_userAccount.id = :user_id";
		HashMap<String, Object> params = new HashMap<>();
        params.put("user_id", user_id);
        List<Candidature> list = hibernateManager.execute(query, params, Candidature.class);
        if(list != null)
            return list;
        else
            return null;	
	}
	
}
