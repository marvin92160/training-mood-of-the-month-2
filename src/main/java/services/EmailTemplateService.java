package services;

import dao.EmailTemplateDao;
import dao.MemberDao;
import modele.Member;
import Exception.ServiceException;
import Exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmailTemplateService {

    private EmailTemplateDao emailTemplateDao;

    public EmailTemplateService(EmailTemplateDao emailTemplateDao){
        this.emailTemplateDao  = emailTemplateDao ;
    }
    private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);

    public void update(String subject, String template) throws ServiceException {
        try{
            this.emailTemplateDao.update(subject, template);
        }catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }
    }
    public List<String> find() throws ServiceException {
        try{
            return this.emailTemplateDao.find();
        }catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }
    }
}
