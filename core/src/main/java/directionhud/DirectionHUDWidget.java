// Created by Torben R.
package directionhud;

import net.labymod.api.client.gui.hud.hudwidget.SimpleHudWidget;
import net.labymod.api.client.gui.hud.position.HudSize;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.gui.mouse.MutableMouse;
import net.labymod.api.client.render.batch.ResourceRenderContext;
import net.labymod.api.client.render.matrix.Stack;
import net.labymod.api.client.resources.ResourceLocation;
import net.labymod.api.util.bounds.Rectangle;
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
      "textures/hud.png");

  Icon nadle = Icon.texture(ResourceLocation.create("directionhud", "textures/nadle.png"));

  @Override
  public void render(@Nullable Stack stack, MutableMouse mouse, float partialTicks,
      boolean isEditorContext, HudSize size) {
    int widthHeight = 38;
    size.set(widthHeight, widthHeight);
    if (stack == null) {
      return;
    }
    labyAPI.renderPipeline().resourceRenderer()
        .size(widthHeight, widthHeight)
        .pos(0, 0)
        .texture(hudPng)
        .sprite(0, 0, 256)
        .render(stack);
    nadle.render(stack, 0, 0, widthHeight);
  }
}
