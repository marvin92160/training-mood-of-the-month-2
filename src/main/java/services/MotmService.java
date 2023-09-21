package services;

import dao.EmailTemplateDao;
import dao.MemberDao;
import dao.MotmDao;
import modele.Member;
import Exception.ServiceException;
import Exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MotmService {

    private MotmDao motmDao;

    public MotmService(MotmDao motmDao){
        this.motmDao  = motmDao ;
    }
    private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);

    public void update(String template) throws ServiceException {
        try{
            this.motmDao.update(template);
        }catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }
    }
    public String find() throws ServiceException {
        try{
            return this.motmDao.find();
        }catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }
    }
}
