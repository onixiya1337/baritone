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

package baritone.command.defaults;
import baritone.Baritone;
import baritone.api.IBaritone;
import baritone.api.command.datatypes.RelativeGoal;
import baritone.api.pathing.goals.Goal;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.IPlayerContext;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Goto2Command implements ICommand {

    protected IBaritone baritone;
    protected IPlayerContext ctx;
    public static ArrayList<String> aliases = new ArrayList<>(Arrays.asList("fh", "farmhelper", "farmhelpermod", "farmhelper-mod"));

    @Override
    public String getCommandName() {
        return "fh";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/fh";
    }

    @Override
    public List<String> getCommandAliases() {
        return aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(@NotNull ICommand o) {
        return 0;
    }
}
