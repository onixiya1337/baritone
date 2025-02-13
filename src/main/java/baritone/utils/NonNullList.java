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

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.Validate;

public class NonNullList<E> extends AbstractList<E>
{
    private final List<E> delegate;
    private final E defaultElement;

    public static <E> NonNullList<E> create()
    {
        return new NonNullList<E>();
    }

    /**
     * Creates a new NonNullList with <i>fixed</i> size, and filled with the object passed.
     */
    public static <E> NonNullList<E> withSize(int size, E fill)
    {
        Validate.notNull(fill);
        Object[] aobject = new Object[size];
        Arrays.fill(aobject, fill);
        return new NonNullList<E>(Arrays.asList((E[])aobject), fill);
    }

    public static <E> NonNullList<E> from(E defaultElementIn, E... elements)
    {
        return new NonNullList<E>(Arrays.asList(elements), defaultElementIn);
    }

    protected NonNullList()
    {
        this(new ArrayList(), null);
    }

    protected NonNullList(List<E> delegateIn, @Nullable E listType)
    {
        this.delegate = delegateIn;
        this.defaultElement = listType;
    }

    @Nonnull
    public E get(int p_get_1_)
    {
        return this.delegate.get(p_get_1_);
    }

    public E set(int p_set_1_, E p_set_2_)
    {
        Validate.notNull(p_set_2_);
        return this.delegate.set(p_set_1_, p_set_2_);
    }

    public void add(int p_add_1_, E p_add_2_)
    {
        Validate.notNull(p_add_2_);
        this.delegate.add(p_add_1_, p_add_2_);
    }

    public E remove(int p_remove_1_)
    {
        return this.delegate.remove(p_remove_1_);
    }

    public int size()
    {
        return this.delegate.size();
    }

    public void clear()
    {
        if (this.defaultElement == null)
        {
            super.clear();
        }
        else
        {
            for (int i = 0; i < this.size(); ++i)
            {
                this.set(i, this.defaultElement);
            }
        }
    }
}