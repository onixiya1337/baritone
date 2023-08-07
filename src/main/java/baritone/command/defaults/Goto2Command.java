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
import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.command.datatypes.RelativeGoal;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.process.ICustomGoalProcess;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.IPlayerContext;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;

/**
 * An example command implementing the Command api of OneConfig.
 * Registered in ExampleMod.java with `CommandManager.INSTANCE.registerCommand(new ExampleCommand());`
 *
 * @see Command
 * @see Main
 * @see ExampleMod
 */
@Command(value = "goto2", description = "Access the GUI.")
public class Goto2Command {
    protected IBaritone baritone;
    protected IPlayerContext ctx;
    @Main
    private void handle() {
        baritone = BaritoneAPI.getProvider().getPrimaryBaritone();
        ICustomGoalProcess goalProcess = baritone.getCustomGoalProcess();
//        Goal goal = new GoalBlock(25, 4, 10);
//        goalProcess.setGoal(goal);
//        goalProcess.path();
        baritone.getLookBehavior().updateTarget(baritone.getPlayerContext().playerRotations(), false);
    }
}