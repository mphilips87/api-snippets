// Install the Java helper library from twilio.com/docs/java/install
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.incomingphonenumber.TollFreeCreator;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.availablephonenumbercountry.TollFree;
import com.twilio.type.PhoneNumber;

public class Example {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
  public static final String AUTH_TOKEN = "your_auth_token";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    ResourceSet<TollFree> numbers =
        TollFree.read("US").byContains("KYLO").byAreaCode(800).execute();
    PhoneNumber availableNumber = numbers.iterator().next().getPhoneNumber();

    new TollFreeCreator(availableNumber).execute();
  }
}
