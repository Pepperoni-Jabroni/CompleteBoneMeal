package pepjebs.complete_bone_meal.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CactusBlock;
import net.minecraft.block.Fertilizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import pepjebs.complete_bone_meal.CompleteBoneMealMod;

@Mixin(CactusBlock.class)
@Implements(@Interface(iface= Fertilizable.class, prefix = "fertilizable$"))
public class CactusBlockMixin {

    public boolean fertilizable$isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return CompleteBoneMealMod.CONFIG == null || CompleteBoneMealMod.CONFIG.enableCactusBoneMeal;
    }

    public boolean fertilizable$canGrow(World world, Random random, BlockPos pos, BlockState state) {
        BlockPos topMostCactus = getTopMostCactus(world, pos);
        return world.getBlockState(topMostCactus.add(0,1,0)).isAir() &&
                world.getBlockState(topMostCactus.add(0,2,0)).isAir();
    }

    public void fertilizable$grow(ServerWorld world, Random random, BlockPos pos, BlockState state){
        BlockPos topMostCactus = getTopMostCactus(world, pos);
        for (int i = 1; i < 3; i++) {
            world.setBlockState(topMostCactus.add(0,i,0), Blocks.CACTUS.getDefaultState());
        }
    }

    private BlockPos getTopMostCactus(World world, BlockPos currentCactus) {
        if (world.getBlockState(currentCactus.add(0,1,0)).isAir()) {
            return currentCactus;
        }
        BlockPos topMostCactus = null;
        while (topMostCactus == null) {
            BlockPos oneAbove = currentCactus.add(0,1,0);
            if (world.getBlockState(oneAbove).getBlock() instanceof CactusBlock) {
                currentCactus = oneAbove;
            } else {
                topMostCactus = currentCactus;
            }
        }
        return topMostCactus;
    }
}
