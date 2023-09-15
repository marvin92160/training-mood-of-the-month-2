package services;

import dao.MemberDao;
import modele.Member;
import Exception.ServiceException;
import modele.Member;
import Exception.DaoException;

import java.util.List;

public class MemberService {

    private MemberDao memberDao;

    public MemberService(MemberDao memberDao){
        this.memberDao  = memberDao ;
    }

    public long create(Member membre) throws ServiceException {
        try{
            return this.memberDao.create(membre);
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
}
