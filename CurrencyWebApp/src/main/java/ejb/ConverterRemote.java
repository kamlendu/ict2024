package ejb;

import java.math.BigDecimal;
import javax.ejb.Remote;

@Remote
public interface ConverterRemote
{
 double convert(String from, String to, double amount);

}
