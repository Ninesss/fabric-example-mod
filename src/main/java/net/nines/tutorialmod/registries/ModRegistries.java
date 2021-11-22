package net.nines.tutorialmod.registries;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.nines.tutorialmod.TutorialMod;
import net.nines.tutorialmod.item.ModItems;

/**
 * @Auther:Nines
 * @Date：2021/11/22 11:18
 */
public class ModRegistries {
    public static void registerModFuels(){
        System.out.println("Now registering Fuels for " + TutorialMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.IRON_WOOL, 300); //seconds: x / 20
        registry.add(ModItems.PEPPER, 60);
    }
}
