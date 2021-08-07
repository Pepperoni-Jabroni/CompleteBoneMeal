package pepjebs.complete_bone_meal.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import pepjebs.complete_bone_meal.CompleteBoneMealMod;

@Config(name = CompleteBoneMealMod.MOD_ID)
public class CompleteBoneMealConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Cactuses will be Bone-Meal-able")
    public boolean enableCactusBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Chorus Flowers will be Bone-Meal-able")
    public boolean enableChorusFlowerBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Nether Warts will be Bone-Meal-able")
    public boolean enableNetherWartBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Sugar Canes will be Bone-Meal-able")
    public boolean enableSugarCaneBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Vines will be Bone-Meal-able")
    public boolean enableVineBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Corals will be Bone-Meal-able")
    public boolean enableCoralBoneMeal = true;
}
