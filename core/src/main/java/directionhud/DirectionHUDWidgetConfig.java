// Created by Torben R.
package directionhud;

import net.labymod.api.client.gui.hud.hudwidget.HudWidgetConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.SliderWidget.SliderSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.annotation.ConfigName;
import net.labymod.api.configuration.loader.property.ConfigProperty;

@ConfigName("hudwidget")
@SuppressWarnings("unused")
public class DirectionHUDWidgetConfig extends HudWidgetConfig {

  @SliderSetting(min = 1, max = 6)
  private final ConfigProperty<Integer> size = new ConfigProperty<>(4);

  public int size() {
    return size.get();
  }

  @SwitchSetting
  private final ConfigProperty<Boolean> rotateNeedle = new ConfigProperty<>(false);

  public boolean rotateNeedle() {
    return rotateNeedle.get();
  }
}
