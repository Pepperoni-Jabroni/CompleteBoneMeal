package pepjebs.complete_bone_meal.mixin;

import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import pepjebs.complete_bone_meal.CompleteBoneMealMod;

@Mixin(LilyPadBlock.class)
@Implements(@Interface(iface= Fertilizable.class, prefix = "fertilizable$"))
public class LilyPadBlockMixin extends Block {
    public LilyPadBlockMixin(AbstractBlock.Settings settings) {
        super(settings);
    }

    public boolean fertilizable$isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return CompleteBoneMealMod.CONFIG == null || CompleteBoneMealMod.CONFIG.enableLilyPadsBoneMeal;
    }

    public boolean fertilizable$canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void fertilizable$grow(ServerWorld world, Random random, BlockPos pos, BlockState state){
        Block.dropStack(world, pos, new ItemStack(this));
    }
}
