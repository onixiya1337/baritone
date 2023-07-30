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

package baritone.api.utils;

import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;

public class ChunkPos
{
    /** The X position of this Chunk Coordinate Pair */
    public final int x;
    /** The Z position of this Chunk Coordinate Pair */
    public final int z;

    public ChunkPos(int x, int z)
    {
        this.x = x;
        this.z = z;
    }

    public ChunkPos(BlockPos pos)
    {
        this.x = pos.getX() >> 4;
        this.z = pos.getZ() >> 4;
    }

    /**
     * Converts the chunk coordinate pair to a long
     */
    public static long asLong(int x, int z)
    {
//        return (long)x & 4294967295L | ((long)z & 4294967295L) << 32;
        return (long)x & 0xFFFFFFFFL | ((long)z & 0xFFFFFFFFL) << 32;
    }

    public int hashCode()
    {
        int i = 1664525 * this.x + 1013904223;
        int j = 1664525 * (this.z ^ -559038737) + 1013904223;
        return i ^ j;
    }

    public boolean equals(Object p_equals_1_)
    {
        if (this == p_equals_1_)
        {
            return true;
        }
        else if (!(p_equals_1_ instanceof ChunkPos))
        {
            return false;
        }
        else
        {
            ChunkPos chunkpos = (ChunkPos)p_equals_1_;
            return this.x == chunkpos.x && this.z == chunkpos.z;
        }
    }

    public double getDistanceSq(Entity entityIn)
    {
        double d0 = (double)(this.x * 16 + 8);
        double d1 = (double)(this.z * 16 + 8);
        double d2 = d0 - entityIn.posX;
        double d3 = d1 - entityIn.posZ;
        return d2 * d2 + d3 * d3;
    }

    /**
     * Get the first world X coordinate that belongs to this Chunk
     */
    public int getXStart()
    {
        return this.x << 4;
    }

    /**
     * Get the first world Z coordinate that belongs to this Chunk
     */
    public int getZStart()
    {
        return this.z << 4;
    }

    /**
     * Get the last world X coordinate that belongs to this Chunk
     */
    public int getXEnd()
    {
        return (this.x << 4) + 15;
    }

    /**
     * Get the last world Z coordinate that belongs to this Chunk
     */
    public int getZEnd()
    {
        return (this.z << 4) + 15;
    }

    /**
     * Get the World coordinates of the Block with the given Chunk coordinates relative to this chunk
     */
    public BlockPos getBlock(int x, int y, int z)
    {
        return new BlockPos((this.x << 4) + x, y, (this.z << 4) + z);
    }

    public String toString()
    {
        return "[" + this.x + ", " + this.z + "]";
    }
}