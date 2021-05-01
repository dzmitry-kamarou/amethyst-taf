package ui;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigFactory;

@Sources("classpath:${env}/amethyst.properties")
public interface AmethystConfig extends Config {

  @Key("uri")
  String uri();

  AmethystConfig config = ConfigFactory
      .create(AmethystConfig.class, System.getProperties(), System.getenv());
}
