package directionhud;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class DirectionHUD extends LabyAddon<DirectionHUDConfig> {

  @Override
  protected void enable() {
    this.registerSettingCategory();
    labyAPI().hudWidgetRegistry().register(new DirectionHUDWidget("directionhud"));
  }

  @Override
  protected Class<DirectionHUDConfig> configurationClass() {
    return DirectionHUDConfig.class;
  }
}
