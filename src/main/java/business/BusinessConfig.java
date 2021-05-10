package business;

import business.BusinessConfig.Decryptor;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.DecryptorClass;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.crypto.AbstractDecryptor;
import util.CryptoUtil;

@DecryptorClass(Decryptor.class)
@Sources("classpath:${env}/business.properties")
public interface BusinessConfig extends Config {

  @Key("registered.account.firstname")
  String registeredAccountFirstName();

  @Key("registered.account.lastname")
  String registeredAccountLastName();

  @Key("registered.account.email")
  String registeredAccountEmail();

  @EncryptedValue
  @Key("registered.account.password")
  String registeredAccountPassword();

  BusinessConfig config = ConfigFactory
      .create(BusinessConfig.class, System.getProperties(), System.getenv());

  final class Decryptor extends AbstractDecryptor {

    @Override
    public String decrypt(String value) {
      return CryptoUtil.decrypt(value);
    }
  }
}
