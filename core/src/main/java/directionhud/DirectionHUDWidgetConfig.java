// Created by Torben R.
package directionhud;

import net.labymod.api.client.gui.hud.hudwidget.HudWidgetConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.annotation.ConfigName;
import net.labymod.api.configuration.loader.property.ConfigProperty;

@ConfigName("hudwidget")
public class DirectionHUDWidgetConfig extends HudWidgetConfig {

  @SwitchSetting
  private final ConfigProperty<Boolean> showText = new ConfigProperty<>(true);

}
