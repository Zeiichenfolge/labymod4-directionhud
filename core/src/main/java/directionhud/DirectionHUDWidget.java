// Created by Torben R.
package directionhud;

import net.labymod.api.client.gui.hud.hudwidget.SimpleHudWidget;
import net.labymod.api.client.gui.hud.position.HudSize;
import net.labymod.api.client.gui.icon.Icon;
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
      "textures/hud.png");

  final Icon needleIcon = Icon.texture(
      ResourceLocation.create("directionhud", "textures/needle.png"));

  @Override
  public void render(@Nullable Stack stack, MutableMouse mouse, float partialTicks,
      boolean isEditorContext, HudSize size) {
    size.set(38, 38);
    if (stack == null) {
      return;
    }
    float yaw = labyAPI.minecraft().clientPlayer().getRotationHeadYaw();
    stack.push();
    if (yaw >= 360) {
      yaw -= 360;
    }
    labyAPI.renderPipeline().resourceRenderer()
        .size(size.getWidth(), size.getHeight())
        .pos(0, 0)
        .texture(hudPng)
        .sprite(0, 0, 256)
        .render(stack);
    stack.push();
    float centerX = size.getWidth() / 2F;
    float centerY = size.getHeight() / 2F;
    stack.translate(centerX, centerY, 0);
    stack.rotate(yaw, 0, 0, 1);
    stack.translate(-centerX, -centerY, 0);
    needleIcon.render(stack, 0, 0, size.getWidth(), size.getHeight());
    stack.pop();
  }
}
