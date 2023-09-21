package services.MailingService;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class EmailScheduler {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // Récupérez la fréquence sélectionnée depuis le formulaire (à partir du champ caché)
        String selectedFrequency = "1"; // À remplacer par la valeur réelle récupérée depuis le formulaire

        // Configurez le déclencheur en fonction de la fréquence sélectionnée
        Trigger trigger = null;
        switch (selectedFrequency) {
            case "1":
                trigger = TriggerBuilder.newTrigger()
                        .withIdentity("monthlyEmailTrigger", "emailGroup")
                        .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 ? * 6L")) // Dernier vendredi de chaque mois
                        .build();
                break;
            case "2":
                // Configurez pour la dernière journée de travail de chaque mois
                // ...
                break;
            // Gérez les autres options ici...
        }

        // Créez une instance de la classe de tâche d'envoi d'e-mails
        JobDetail job = JobBuilder.newJob(EmailSendingJob.class)
                .withIdentity("emailSendingJob", "emailGroup")
                .build();

        // Planifiez la tâche avec le déclencheur
        scheduler.scheduleJob(job, trigger);

        // Démarrez le planificateur
        scheduler.start();
    }
}

