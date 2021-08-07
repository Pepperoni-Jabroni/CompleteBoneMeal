package pepjebs.complete_bone_meal;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import pepjebs.complete_bone_meal.config.CompleteBoneMealConfig;

public class CompleteBoneMealMod implements ModInitializer {

    public static final String MOD_ID = "complete_bone_meal";

    public static CompleteBoneMealConfig CONFIG = null;

    @Override
    public void onInitialize() {
        AutoConfig.register(CompleteBoneMealConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(CompleteBoneMealConfig.class).getConfig();
    }
}
