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

package org.xwiki.rendering.internal.transformation;

import org.xwiki.rendering.block.Block;
import org.xwiki.rendering.block.XDOM;
import org.xwiki.rendering.syntax.Syntax;
import org.xwiki.rendering.transformation.RenderingContext;
import org.xwiki.rendering.transformation.Transformation;
import org.xwiki.rendering.transformation.TransformationContext;
import org.xwiki.rendering.transformation.TransformationException;

/**
 * An interface to update the rendering context internally during transformations.
 *
 * @version $Id$
 * @since 6.0RC1
 */
public interface MutableRenderingContext extends RenderingContext
{
    /**
     * Push a new rendering context.
     *
     * @param transformation the transformation being performed.
     * @param context the transformation context.
     * @param block the block being transformed.
     */
    void push(Transformation transformation, TransformationContext context, Block block);

    /**
     * Push a new rendering context.
     *
     * @param transformation the transformation being performed.
     * @param xdom the complete XDOM being processed.
     * @param block the block being transformed.
     * @param syntax the current syntax.
     * @param id the id of the transformation.
     * @param restricted true if the transformation is restricted.
     */
    void push(Transformation transformation, XDOM xdom, Block block, Syntax syntax, String id, boolean restricted);

    /**
     * Pop the rendering context.
     */
    void pop();

    /**
     * Helper to run a transformation while properly updating the rendering context.
     *
     * @param transformation the transformation to apply.
     * @param context the transformation context.
     * @param block the block to apply the transformation on.
     * @throws TransformationException see {@link Transformation#transform(Block, TransformationContext)}.
     */
    void transformInContext(Transformation transformation, TransformationContext context, Block block)
        throws TransformationException;
}
