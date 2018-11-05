package seeder.job;

import business.jobs.Job;
import business.payment.BonusPayment;
import business.payment.PaymentStrategy;
import business.payment.StandardPayment;
import business.payment.TestPeriodPayment;
import business.locators.JobsServiceLocator;
import logic.money.Money;
import org.json.JSONObject;
import seeder.SeederFileReader;

import java.lang.reflect.Constructor;
import java.util.Currency;
import java.util.List;
import java.util.Vector;

public class JobFileReader extends SeederFileReader {
    private static JobFileReader ourInstance = new JobFileReader();

    public static JobFileReader getInstance() {
        return ourInstance;
    }

    private JobFileReader() {
        super("/seeders-data/joblist.json");
    }

    private Job createJob(String jobName, long payment, String paymentStrategyString) throws Exception {
        PaymentStrategy paymentStrategy;
        Job result;

        switch(paymentStrategyString) {
            default:
            case "Standard":
                paymentStrategy = new StandardPayment();
                break;
            case "Bonus":
                paymentStrategy = new BonusPayment();
                break;
            case "TestPeriod":
                paymentStrategy = new TestPeriodPayment();
                break;
        }

        paymentStrategy.setNetEmploymentCost(new Money(payment, Currency.getInstance("PLN")));

        Constructor<Job> construct = JobsServiceLocator
                .getInstance()
                .getMatching(jobName)
                .getClassRef()
                .getConstructor(PaymentStrategy.class);

        return construct.newInstance(paymentStrategy);
    }

    public List<Job> getList() throws Exception {

        Vector<Job> result = new Vector<>();

        for(Object obj: super.getJSON().getJSONArray("Job")) {
            JSONObject object = (JSONObject)obj;

            String jobName = object.getString("JobName");
            long payment = object.getLong("NetEmploymentCost");
            String paymentStrategy = object.getString("PaymentStrategy");

            result.add(this.createJob(jobName, payment, paymentStrategy));
        }

        return result;
    }
}
