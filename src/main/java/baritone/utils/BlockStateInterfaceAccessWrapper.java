/*
 * This file is part of Baritone.
 *
 * Baritone is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Baritone is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Baritone.  If not, see <https://www.gnu.org/licenses/>.
 */

package baritone.utils;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;

import javax.annotation.Nullable;

/**
 * @author Brady
 * @since 11/5/2019
 */
@SuppressWarnings("NullableProblems")
public final class BlockStateInterfaceAccessWrapper implements IBlockAccess {

    private final BlockStateInterface bsi;
    private final IBlockAccess world;

    BlockStateInterfaceAccessWrapper(BlockStateInterface bsi, IBlockAccess world) {
        this.bsi = bsi;
        this.world = world;
    }

    @Nullable
    @Override
    public TileEntity getTileEntity(BlockPos pos) {
        return null;
    }

    @Override
    public int getCombinedLight(BlockPos pos, int lightValue) {
        return 0;
    }

    @Override
    public IBlockState getBlockState(BlockPos pos) {
        // BlockStateInterface#get0(BlockPos) btfo!
        return this.bsi.get0(pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public boolean isAirBlock(BlockPos pos) {
        return this.bsi.get0(pos.getX(), pos.getY(), pos.getZ()).getBlock().equals(Blocks.air);
    }

    @Override
    public BiomeGenBase getBiomeGenForCoords(BlockPos pos) {
        return null;
    }

    @Override
    public boolean extendedLevelsInChunkCache() {
        return false;
    }

//    @Override
//    public Biome getBiome(BlockPos pos) {
//        return Biomes.FOREST;
//    }

    @Override
    public int getStrongPower(BlockPos pos, EnumFacing direction) {
        return 0;
    }

    @Override
    public WorldType getWorldType() {
        return this.world.getWorldType();
    }

    @Override
    public boolean isSideSolid(BlockPos pos, EnumFacing side, boolean _default) {
        return false;
    }
}
