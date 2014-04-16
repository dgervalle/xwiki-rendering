/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.xwiki.rendering.transformation;

import org.xwiki.component.annotation.Role;
import org.xwiki.rendering.block.Block;
import org.xwiki.rendering.block.XDOM;
import org.xwiki.rendering.syntax.Syntax;

/**
 * The context of the rendering engine during transformation.
 *
 * @version $Id$
 * @since 6.0
 */
@Role
public interface RenderingContext extends Cloneable
{
    /**
     * @return an id representing the transformation being evaluated. It's a free form name that may be used to perform
     * some caching based on a key. For example the Velocity Macro is using this id to pass it to the underlying
     * Velocity Engine so that it caches macros using this key.
     */
    String getId();

    /**
     * @return the complete {@link XDOM} of the content currently being transformed.
     */
    XDOM getXDOM();

    /**
     * @return the {@link Block} being transformed.
     */
    Block getBlock();

    /**
     * @return the current {@link Block} being processed by the transformation. This block is manage by the the
     * transformation itself, and reflect the progress of this transformation. For example, the macro transformation
     * report the currently processed macro block.
     */
    Block getCurrentBlock();

    /**
     * Set the currently processed block, showing the progress of a transformation, like macro execution.
     *
     * @param block the current block being processed by the transformation.
     */
    void setCurrentBlock(Block block);

    /**
     * @return the current syntax.
     */
    Syntax getSyntax();

    /**
     * @return true if the current transformation is executed in a restricted context.
     */
    boolean isRestricted();

    /**
     * @return the current Transformation instance being executed. Useful for Macros which need to perform other
     * transformations in turn such as the Include macro which needs to execute the transformation if the included page
     * should be executed in its own context.
     */
    Transformation getTransformation();
}
