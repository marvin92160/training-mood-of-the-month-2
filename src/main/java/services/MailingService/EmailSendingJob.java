package services.MailingService;

import dao.MemberDao;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class EmailSendingJob implements Job {
    MemberDao memberDao;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {/*
        // Récupérez la période sélectionnée depuis la configuration
        int mailingDateOption = 1; // À remplacer par la récupération réelle depuis la configuration

        // Utilisez MemberPreferencesDao pour récupérer les membres à contacter en fonction de la période
        List<Member> membersToContact = null;
        try {
            membersToContact = memberDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }

        // Pour chaque membre, envoyez un e-mail
        assert membersToContact != null;
        for (Member member : membersToContact) {
            // Envoyez l'e-mail à ce membre
            EmailSender.sendEmail(member.getEmail(), "Sujet de l'e-mail", "Corps de l'e-mail");
        }*/
    }
}

