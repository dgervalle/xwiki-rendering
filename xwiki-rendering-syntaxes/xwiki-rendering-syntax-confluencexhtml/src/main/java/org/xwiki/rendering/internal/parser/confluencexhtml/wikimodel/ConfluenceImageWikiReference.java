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
package org.xwiki.rendering.internal.parser.confluencexhtml.wikimodel;

import org.xwiki.rendering.internal.parser.confluencexhtml.wikimodel.AttachmentTagHandler.ConfluenceAttachment;
import org.xwiki.rendering.wikimodel.WikiReference;

/**
 * @version $Id$
 * @since 5.3M2
 */
public class ConfluenceImageWikiReference extends WikiReference implements AttachmentContainer, URLContainer
{
    private ConfluenceAttachment attachment;

    private String url;

    public ConfluenceImageWikiReference()
    {
        super("");
    }

    public ConfluenceAttachment getAttachment()
    {
        return this.attachment;
    }

    @Override
    public void setAttachment(ConfluenceAttachment attachment)
    {
        this.attachment = attachment;
    }

    public String getURL()
    {
        return this.url;
    }

    @Override
    public void setURL(String url)
    {
        this.url = url;
    }
}
