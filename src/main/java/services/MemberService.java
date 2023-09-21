package services;

import dao.MemberDao;
import modele.Member;
import Exception.ServiceException;
import modele.Member;
import Exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MemberService {

    private MemberDao memberDao;

    public MemberService(MemberDao memberDao){
        this.memberDao  = memberDao ;
    }
    private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);

    public long create(Member membre) throws ServiceException {
        try{
            return this.memberDao.create(membre);
        }catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }
    }

    public long delete(int Id_member) throws ServiceException {
        try{
            return this.memberDao.delete(Id_member);
        }catch(DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }
    }
    public List<Member> findAll(int page) throws ServiceException {
        try{
            return this.memberDao.findAll(page);
        }catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }
    }

    public List<Member> findAll() throws ServiceException {
        try{
            return this.memberDao.findAll();
        }catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }
    }

    public Member findById(int id) throws ServiceException {
        try{
            return this.memberDao.findById(id);
        }catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }
    }
    public int count() throws ServiceException {
        return findAll().size();
    }

    public  ArrayList countPage() throws ServiceException {
        int nbrM = findAll().size();
        int nbrpage =(int) nbrM / 10 ;
        int rest = nbrM % 10;
        if(rest > 0 ){
            nbrpage++;
        }
        ArrayList listePages = new ArrayList<>();
        for (int i = 1; i <= nbrpage; i++) {
            listePages.add(i);
        }
        return listePages;
    }

    public long update(Member member) throws ServiceException {
        try{
            logger.error("dans le service"+member);
            return this.memberDao.update(member);
        }catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }
    }
}
