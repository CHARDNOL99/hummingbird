package best.reich.ingros.module.modules.combat;

import me.xenforu.kelo.module.ModuleCategory;
import me.xenforu.kelo.module.annotation.ModuleManifest;
import me.xenforu.kelo.module.type.ToggleableModule;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import org.lwjgl.input.Mouse;
import net.minecraftforge.fml.common.gameevent.InputEvent;

/**
 * dont remember who made this might have been a 12 yo doxxer idk
 */

@ModuleManifest(label = "Multitask", category = ModuleCategory.COMBAT, color = 0x4BF7FF)

public class Multitask extends ToggleableModule {
    @SubscribeEvent
    public void onMouseInput(final InputEvent.MouseInputEvent event) {
        if (Mouse.getEventButtonState() && mc.player != null && mc.objectMouseOver.typeOfHit.equals((Object)RayTraceResult.Type.ENTITY) && mc.player.isHandActive() && (mc.gameSettings.keyBindAttack.isPressed() || Mouse.getEventButton() == mc.gameSettings.keyBindAttack.getKeyCode())) {
            mc.playerController.attackEntity((EntityPlayer) mc.player, mc.objectMouseOver.entityHit);
            mc.player.swingArm(EnumHand.MAIN_HAND);
        }
    }
}