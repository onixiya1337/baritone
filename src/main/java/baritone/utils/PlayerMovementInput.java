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

import baritone.api.utils.input.Input;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MovementInput;

public class PlayerMovementInput extends MovementInput {

    private final InputOverrideHandler handler;

    PlayerMovementInput(InputOverrideHandler handler) {
        this.handler = handler;
    }

    public void updatePlayerMoveState() {
        Minecraft mc = Minecraft.getMinecraft();

        this.moveStrafe = 0.0F;
        this.moveForward = 0.0F;

        this.jump = handler.isInputForcedDown(Input.JUMP);

        if (mc.gameSettings.keyBindForward.isKeyDown()) {
            this.moveForward++;
        }

        if (mc.gameSettings.keyBindBack.isKeyDown()) {
            this.moveForward--;
        }

        if (mc.gameSettings.keyBindLeft.isKeyDown()) {
            this.moveStrafe++;
        }

        if (mc.gameSettings.keyBindRight.isKeyDown()) {
            this.moveStrafe--;
        }

        if (mc.gameSettings.keyBindSneak.isKeyDown()) {
            this.moveStrafe *= 0.3F;
            this.moveForward *= 0.3F;
        }
    }
}
