// Created by Torben R.
package directionhud;

import net.labymod.api.Laby;
import net.labymod.api.client.gui.hud.hudwidget.SimpleHudWidget;
import net.labymod.api.client.gui.hud.position.HudSize;
import net.labymod.api.client.gui.mouse.MutableMouse;
import net.labymod.api.client.render.matrix.Stack;
import net.labymod.api.client.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unchecked")
public class DirectionHUDWidget extends SimpleHudWidget<DirectionHUDWidgetConfig> {

  public DirectionHUDWidget(String id) {
    super(id, DirectionHUDWidgetConfig.class);
  }

  @Override
  public boolean isVisibleInGame() {
    return true;
  }

  ResourceLocation hudPng = ResourceLocation.create("directionhud",
      "/assets/directionhud/i18n/hud.png");

  @Override
  public void render(@Nullable Stack stack, MutableMouse mouse, float partialTicks,
      boolean isEditorContext, HudSize size) {
    int widthHeight = 32;
    size.set(widthHeight, widthHeight);
    if (stack == null) {
      return;
    }
    size.set(widthHeight, widthHeight);
    Laby.labyAPI().renderPipeline().resourceRenderer()
        .size(widthHeight, widthHeight)
        .pos(0, 0)
        .texture(hudPng)
        .render(stack);
  }
}
