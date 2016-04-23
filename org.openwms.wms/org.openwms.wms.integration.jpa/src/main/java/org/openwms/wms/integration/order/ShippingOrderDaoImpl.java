/*
 * openwms.org, the Open Warehouse Management System.
 * Copyright (C) 2014 Heiko Scherrer
 *
 * This file is part of openwms.org.
 *
 * openwms.org is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * openwms.org is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this software. If not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.openwms.wms.integration.order;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.openwms.wms.domain.order.AbstractOrder;
import org.openwms.wms.domain.order.OrderState;
import org.openwms.wms.domain.shipping.ShippingOrder;
import org.openwms.wms.integration.shipping.ShippingOrderDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * A ShippingOrderDaoImpl.
 * 
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 * @version $Revision: $
 * @since 0.1
 */
@Transactional(propagation = Propagation.MANDATORY)
@Repository(ShippingOrderDaoImpl.COMPONENT_NAME)
public class ShippingOrderDaoImpl implements ShippingOrderDao {

    /** Springs component name. */
    public static final String COMPONENT_NAME = "shippingOrderDao";

    @PersistenceContext
    private EntityManager em;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ShippingOrder> findInState(OrderState... state) {
        Query query = em.createNamedQuery(AbstractOrder.NQ_FIND_WITH_STATE).setParameter(
                AbstractOrder.QP_FIND_WITH_STATE_STATE, Arrays.asList(state));
        @SuppressWarnings("unchecked")
        List<ShippingOrder> result = query.getResultList();
        return result == null ? Collections.<ShippingOrder> emptyList() : result;
    }
}