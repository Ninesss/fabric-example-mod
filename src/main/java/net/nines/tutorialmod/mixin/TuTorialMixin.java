package net.nines.tutorialmod.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.nines.tutorialmod.TutorialMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TuTorialMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		TutorialMod.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
