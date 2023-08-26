// Created by Torben R.
package xyz.zeichenfolge.directionhud.widget;

import java.awt.*;
import net.labymod.api.client.gui.hud.hudwidget.SimpleHudWidget;
import net.labymod.api.client.gui.hud.position.HudSize;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.gui.mouse.MutableMouse;
import net.labymod.api.client.render.matrix.Stack;
import net.labymod.api.client.resources.ResourceLocation;
import xyz.zeichenfolge.directionhud.widget.config.DirectionHudBarWidgetConfig;

public class DirectionHudBarWidget extends SimpleHudWidget<DirectionHudBarWidgetConfig> {

  final ResourceLocation hudPng = ResourceLocation.create("directionhud",
      "textures/compass-raw.png");
  final ResourceLocation compass = ResourceLocation.create("directionhud",
      "textures/compass-fixed.png");

  public DirectionHudBarWidget(String id) {
    super(id, DirectionHudBarWidgetConfig.class);
    this.setIcon(Icon.texture(hudPng));
  }

  @Override
  public void render(Stack stack, MutableMouse mouse, float partialTicks, boolean isEditorContext,
      HudSize size) {
    size.set(65, 12);
    if (stack == null) {
      return;
    }
    double yaw = 0;
    if (labyAPI.minecraft().getClientPlayer() != null) {
      yaw = (float) (((labyAPI.minecraft().getClientPlayer().getRotationHeadYaw() * 256F) / 360F));
    }
    if (yaw > 256) {
      yaw -= 256;
    }
    if (yaw < 0) {
      yaw += 256;
    }
    if (yaw < 128) {
      labyAPI.renderPipeline().resourceRenderer().texture(compass).size(65, 12)
          .sprite((float) yaw, 0, 65, 12).render(stack);
    } else {
      labyAPI.renderPipeline().resourceRenderer().texture(compass).size(65, 12)
          .sprite((float) (yaw - 128), 12, 65, 12).render(stack);
    }
    labyAPI.renderPipeline().textRenderer().text("|").pos((float) size.getWidth() / 2, 1)
        .color(Color.RED.getRGB()).render(stack);
    labyAPI.renderPipeline().textRenderer().text("|\247r").pos((float) size.getWidth() / 2, 5)
        .color(Color.RED.getRGB()).render(stack);
  }

  @Override
  public boolean isVisibleInGame() {
    return true;
  }
}
