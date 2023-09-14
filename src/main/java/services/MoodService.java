package services;

import dao.MoodDao;
import modele.Mood;
import Exception.ServiceException;
import Exception.DaoException;
import java.util.List;

public class MoodService {
    private final MoodDao moodDao;

    private MoodService(MoodDao moodDao){
        this.moodDao = moodDao;
    }

    public List<Mood> findAll() throws ServiceException {
        try {
            return moodDao.findALl();
        }catch (DaoException e){
            throw new ServiceException();
        }
    }

    public int count() throws ServiceException {
        return findAll().size();
    }
}
