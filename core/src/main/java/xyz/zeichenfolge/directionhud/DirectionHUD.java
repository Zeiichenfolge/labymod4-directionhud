package xyz.zeichenfolge.directionhud;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;
import xyz.zeichenfolge.directionhud.widget.DirectionHUDWidget;
import xyz.zeichenfolge.directionhud.widget.DirectionHudBarWidget;

@AddonMain
public class DirectionHUD extends LabyAddon<DirectionHUDConfig> {

  //private final WayPointsIntegration wayPointsIntegration = new WayPointsIntegration();

  @Override
  protected void enable() {
    this.registerSettingCategory();
    //wayPointsIntegration.load();
    labyAPI().hudWidgetRegistry().register(new DirectionHUDWidget("directionhud", this));
    labyAPI().hudWidgetRegistry().register(new DirectionHudBarWidget("directionhudbar", this));
  }

  @Override
  protected Class<DirectionHUDConfig> configurationClass() {
    return DirectionHUDConfig.class;
  }

  /*
  public WayPointsIntegration getWayPointsIntegration() {
    return wayPointsIntegration;
  }

   */
}
