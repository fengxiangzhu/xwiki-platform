/**
 * ===================================================================
 *
 * Copyright (c) 2005 Artem Melentev, All rights reserved.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details, published at
 * http://www.gnu.org/copyleft/gpl.html or in gpl.txt in the
 * root folder of this distribution.

 * Created by
 * User: Artem Melentev
 * Date: 16.08.2005
 * Time: 04:58
 */
package com.xpn.xwiki.plugin.query;

import java.util.List;

import org.apache.jackrabbit.core.query.QueryRootNode;

import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.XWikiException;
import com.xpn.xwiki.cache.api.XWikiCache;
import com.xpn.xwiki.store.XWikiStoreInterface;

public class DefaultQuery implements IQuery {
	protected IQueryFactory _queryFactory;
	protected QueryRootNode _querytree;
	
	public DefaultQuery(QueryRootNode tree, IQueryFactory qf) {
		_querytree = tree;
		_queryFactory = qf;
	}
	
	public List list() throws XWikiException {
		return null;
	}

	protected int _fetchSize=-1;
	protected int _firstResult=-1;
	protected boolean _isdistinct=false;
	public IQuery setMaxResults(int fs)		{ _fetchSize = fs; return this; }
	public IQuery setFirstResult(int fr)	{ _firstResult = fr; return this; }	
	public IQuery setDistinct(boolean d)	{ _isdistinct = d; return this; }
	
	
	protected XWikiCache getCache() {
		return _queryFactory.getCache();
	}
	protected XWikiContext getContext() {
		return _queryFactory.getContext();
	}
	protected XWikiStoreInterface getStore() {
		return _queryFactory.getStore();
	}
	protected QueryRootNode getQueryTree() { return _querytree; }
	
	public String toString() {
		try {
			return list().toString();
		} catch (XWikiException e) {}
		return "";
	}
}
