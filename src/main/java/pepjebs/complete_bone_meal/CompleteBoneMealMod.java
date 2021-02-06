package pepjebs.complete_bone_meal;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
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
