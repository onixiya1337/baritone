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

package baritone.api.command.datatypes;

import baritone.api.command.exception.CommandException;
import baritone.api.command.helpers.TabCompleteHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public enum BlockById implements IDatatypeFor<Block> {
    INSTANCE;

    /**
     * Matches (domain:)?name? where domain and name are [a-z0-9_.-]+ and [a-z0-9/_.-]+ respectively.
     */
    private static Pattern PATTERN = Pattern.compile("(?:[a-z0-9_.-]+:)?[a-z0-9/_.-]*");

    @Override
    public Block get(IDatatypeContext ctx) throws CommandException {
        ResourceLocation id = new ResourceLocation(ctx.getConsumer().getString());
        Block block;
        if ((block = Block.blockRegistry.getObject(id)) == Blocks.air) {
            throw new IllegalArgumentException("no block found by that id");
        }
        return block;
    }

    @Override
    public Stream<String> tabComplete(IDatatypeContext ctx) throws CommandException {
        String arg = ctx.getConsumer().getString();

        if (!PATTERN.matcher(arg).matches()) {
            return Stream.empty();
        }

        return new TabCompleteHelper()
                .append(
                        Block.blockRegistry.getKeys()
                                .stream()
                                .map(Object::toString)
                )
                .filterPrefixNamespaced(arg)
                .sortAlphabetically()
                .stream();
    }
}
