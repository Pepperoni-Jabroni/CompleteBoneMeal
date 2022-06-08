package pepjebs.complete_bone_meal.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.CoralBlockBlock;
import net.minecraft.block.Fertilizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pepjebs.complete_bone_meal.CompleteBoneMealMod;
import pepjebs.complete_bone_meal.interfc.CoralFeatureMixinInterface;

import java.util.Arrays;

@Mixin(CoralBlockBlock.class)
@Implements(@Interface(iface= Fertilizable.class, prefix = "fertilizable$"))
public class CoralBlockBlockMixin {

    @Shadow
    protected boolean isInWater(BlockView world, BlockPos pos) { return false; }

    public boolean fertilizable$isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return CompleteBoneMealMod.CONFIG == null || CompleteBoneMealMod.CONFIG.enableCoralBoneMeal;
    }

    public boolean fertilizable$canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return isInWater(world, pos);
    }

    public void fertilizable$grow(ServerWorld world, Random random, BlockPos pos, BlockState state){
        Feature<DefaultFeatureConfig> choice =
                Arrays.asList(Feature.CORAL_CLAW, Feature.CORAL_TREE, Feature.CORAL_MUSHROOM)
                        .get(random.nextInt(3));
        ((CoralFeatureMixinInterface) choice).generateForBlockState(world, random, pos, world.getBlockState(pos));
    }

}
