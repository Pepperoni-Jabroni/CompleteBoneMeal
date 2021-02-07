package pepjebs.complete_bone_meal.mixin;

import net.minecraft.block.*;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BoneMealItem.class)
public class BoneMealItemMixin {

    @Inject(method = "useOnBlock", at = @At("INVOKE"))
    public void doCompleteBoneMealAction(ItemUsageContext context, CallbackInfo ci) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        Block block = world.getBlockState(blockPos).getBlock();
        if (block instanceof CactusBlock) {

        } else if (block instanceof SugarCaneBlock) {

        } else if (block instanceof VineBlock) {

        } else if (block instanceof NetherWartBlock) {

        } else if (block instanceof ChorusFlowerBlock) {

        }
    }
}
