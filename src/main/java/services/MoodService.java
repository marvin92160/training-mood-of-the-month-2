package services;

import dao.MoodDao;
import Exception.ServiceException;
import Exception.DaoException;
import modele.Mood;

import java.util.List;


public class MoodService {
    private final MoodDao moodDao;

    public MoodService(MoodDao moodDao){
        this.moodDao = moodDao;
    }

    public List<Mood> findAll() throws ServiceException {
        try {
            return moodDao.findALl();
        }catch (DaoException e){
            throw new ServiceException();
        }
    }

    public List<Mood> findAllByMonth(int month, int year) throws ServiceException {
        try {
            return moodDao.findALlByMonth(month, year);
        }catch (DaoException e){
            throw new ServiceException();
        }
    }

    public int count() throws ServiceException {
        return findAll().size();
    }
}
