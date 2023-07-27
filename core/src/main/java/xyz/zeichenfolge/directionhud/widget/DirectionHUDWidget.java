// Created by Torben R.
package xyz.zeichenfolge.directionhud.widget;

import net.labymod.api.client.gui.hud.hudwidget.SimpleHudWidget;
import net.labymod.api.client.gui.hud.position.HudSize;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.gui.mouse.MutableMouse;
import net.labymod.api.client.render.matrix.Stack;
import net.labymod.api.client.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import xyz.zeichenfolge.directionhud.widget.config.DirectionHUDWidgetConfig;

public class DirectionHUDWidget extends SimpleHudWidget<DirectionHUDWidgetConfig> {

  final ResourceLocation hudPng = ResourceLocation.create("directionhud",
      "textures/hud.png");

  final Icon needleIcon = Icon.texture(
      ResourceLocation.create("directionhud", "textures/needle.png"));

  public DirectionHUDWidget(String id) {
    super(id, DirectionHUDWidgetConfig.class);
    this.setIcon(Icon.texture(hudPng));
  }

  @Override
  public boolean isVisibleInGame() {
    return true;
  }

  @Override
  public void render(@Nullable Stack stack, MutableMouse mouse, float partialTicks,
      boolean isEditorContext, HudSize size) {
    size.set(4 * 8, 4 * 8);
    if (stack == null) {
      return;
    }
    float yaw = 0;
    if (labyAPI.minecraft().clientPlayer() != null) {
      yaw = labyAPI.minecraft().clientPlayer().getRotationHeadYaw();
    }
    yaw = (yaw + 180) % 360;
    if (config.rotateNeedle()) {
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
    } else {
      stack.push();
      float centerX = size.getWidth() / 2F;
      float centerY = size.getHeight() / 2F;
      stack.translate(centerX, centerY, 0);
      stack.rotate(-yaw, 0, 0, 1);
      stack.translate(-centerX, -centerY, 0);
      labyAPI.renderPipeline().resourceRenderer()
          .size(size.getWidth(), size.getHeight())
          .pos(0, 0)
          .texture(hudPng)
          .sprite(0, 0, 256)
          .render(stack);
      stack.pop();
      needleIcon.render(stack, 0, 0, size.getWidth(), size.getHeight());
    }
  }
}
