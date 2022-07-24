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
    @Comment("If 'true', Corals will be Bone-Meal-able")
    public boolean enableCoralBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Dead Bushes will be Bone-Meal-able")
    public boolean enableDeadBushBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Flowers will be Bone-Meal-able")
    public boolean enableFlowerBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Hanging Roots will be Bone-Meal-able")
    public boolean enableHangingRootsMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Leaves will be Bone-Meal-able")
    public boolean enableLeavesBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Lily Pads will be Bone-Meal-able")
    public boolean enableLilyPadsBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Mycelium will be Bone-Meal-able")
    public boolean enableMyceliumBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Nether Warts will be Bone-Meal-able")
    public boolean enableNetherWartBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Nether Roots will be Bone-Meal-able")
    public boolean enableRootsBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Sponge will be Bone-Meal-able")
    public boolean enableSpongeBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Spore Blossoms will be Bone-Meal-able")
    public boolean enableSporeBlossomsBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Nether Sprouts will be Bone-Meal-able")
    public boolean enableSproutsBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Sugar Canes will be Bone-Meal-able")
    public boolean enableSugarCaneBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Tall Plants will be Bone-Meal-able")
    public boolean enableTallPlantsBoneMeal = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If 'true', Vines will be Bone-Meal-able")
    public boolean enableVineBoneMeal = true;
}
