package pepjebs.complete_bone_meal.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.VineBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pepjebs.complete_bone_meal.CompleteBoneMealMod;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mixin(VineBlock.class)
@Implements(@Interface(iface= Fertilizable.class, prefix = "fertilizable$"))
public class VineBlockMixin {

    private final VineBlock vineBlock = ((VineBlock) (Object) this);

    public boolean fertilizable$isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return CompleteBoneMealMod.CONFIG == null || CompleteBoneMealMod.CONFIG.enableVineBoneMeal;
    }

    public boolean fertilizable$canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void fertilizable$grow(ServerWorld world, Random random, BlockPos pos, BlockState state){
        state = state
                .with(VineBlock.NORTH, true)
                .with(VineBlock.EAST, true)
                .with(VineBlock.SOUTH, true)
                .with(VineBlock.WEST, true).with(VineBlock.UP, true);
        Set<BlockPos> targetPositions = getGrowableLocations(world, pos, state, new HashSet<>(), 0);
        int newGrowth = random.nextInt(4) + 1;
        targetPositions = targetPositions.stream().limit(newGrowth).collect(Collectors.toSet());
        for (BlockPos target : targetPositions) {
            world.setBlockState(target, this.getPlacementShape(state, world, target));
        }
    }

    private Set<BlockPos> getGrowableLocations(
            ServerWorld world,
            BlockPos currentPos,
            BlockState state,
            Set<BlockPos> visited,
            int depth) {
        Set<BlockPos> growableLocs = new HashSet<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    BlockPos testing = currentPos.add(i, j, k);
                    if (testing.equals(currentPos))
                        continue;
                    if (world.getBlockState(testing).isAir() && vineBlock.canPlaceAt(state,world, testing)
                            && !visited.contains(testing)) {
                        growableLocs.add(testing);
                    }
                }
            }
        }
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    BlockPos testing = currentPos.add(i, j, k);
                    if (testing.equals(currentPos) || visited.contains(testing))
                        continue;
                    if (world.getBlockState(testing).getBlock() instanceof VineBlock) {
                        visited.add(testing);
                        if (depth + 1 <= 3)
                            growableLocs.addAll(getGrowableLocations(world, testing, state, visited, depth + 1));
                    }
                }
            }
        }
        return growableLocs;
    }

    @Shadow
    private BlockState getPlacementShape(BlockState state, BlockView world, BlockPos pos) {
        return null;
    }

}
