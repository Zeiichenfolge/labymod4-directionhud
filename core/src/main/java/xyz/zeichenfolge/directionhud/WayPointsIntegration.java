// Created by Torben R.
package xyz.zeichenfolge.directionhud;

import java.util.Collection;
import net.labymod.addons.waypoints.WaypointService;
import net.labymod.addons.waypoints.Waypoints;
import net.labymod.addons.waypoints.waypoint.Waypoint;
import net.labymod.api.addon.integration.AddonIntegration;

public class WayPointsIntegration implements AddonIntegration {

  private WaypointService waypointService;

  public Collection<Waypoint> waypoints() {
    return waypointService.getAllWaypoints();
  }

  @Override
  public void load() {
    waypointService = Waypoints.getReferences().waypointService();
  }

  @Override
  public void onIntegratedAddonEnable() {

  }
}
